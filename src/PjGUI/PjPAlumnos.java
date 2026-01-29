package PjGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Importaciones
import PjBL.PjExoMedico;
import PjBL.PjExpertoBioSensor;
import PjDataAcces.PjDAOs.PjIExoBotDAO;
import PjDataAcces.PjDTOs.PjIExobotDTO;
import PjDataAcces.PjDTOs.PjTipoExobotDTO;
import PjInfraestructure.AppMSG;

public class PjPAlumnos extends JFrame {

    // Componentes
    private JComboBox<String> cmbTipoExobot;
    private JTable tblExobots;
    private DefaultTableModel modeloTabla;
    private JButton btnAgregar, btnBuscar, btnEntrenar, btnAccion;

    // Datos
    private List<PjTipoExobotDTO> listaTiposDTO;
    private List<PjIExobotDTO> listaIExobotsTotal;
    private PjIExoBotDAO exobotDAO;

    public PjPAlumnos() {
        setTitle("ExoTrooper - Gestión Exobots");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // 1. Inicializar Listas y DAO
        listaTiposDTO = new ArrayList<>();
        listaIExobotsTotal = new ArrayList<>();
        try {
            exobotDAO = new PjIExoBotDAO();
        } catch (Exception e) {
            AppMSG.showError("Error DAO: " + e.getMessage());
        }

        initUI();

        setupEvents();

        cargarTiposAlCombo();
        recargarDatosDesdeBD();
        mostrarEnTabla(listaIExobotsTotal);
    }

    private void initUI() {
        // --- Panel Superior ---
        JPanel pnlNorth = new JPanel();
        pnlNorth.setLayout(new BoxLayout(pnlNorth, BoxLayout.Y_AXIS));
        pnlNorth.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel pnlAlumno = new JPanel(new GridLayout(3, 1));
        pnlAlumno.setBorder(BorderFactory.createTitledBorder("Alumno:"));
        pnlAlumno.add(new JLabel(" 0941165318   |   JUSTIN PINCAY"));
        pnlAlumno.add(new JLabel(" Cédula           |   Nombre Completo"));
        pnlNorth.add(pnlAlumno);
        pnlNorth.add(Box.createVerticalStrut(10));

        JPanel pnlControles = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cmbTipoExobot = new JComboBox<>();
        cmbTipoExobot.setPreferredSize(new Dimension(150, 25));

        btnAgregar = new JButton("Agregar");
        btnBuscar = new JButton("Buscar"); // Ahora funciona como FILTRO

        pnlControles.add(new JLabel("TipoExobot: "));
        pnlControles.add(cmbTipoExobot);
        pnlControles.add(btnAgregar);
        pnlControles.add(btnBuscar);

        pnlNorth.add(pnlControles);
        add(pnlNorth, BorderLayout.NORTH);

        // --- Panel Central (Tabla) ---
        String[] columnas = { "ID", "Tipo", "Entreno", "Acciones" };
        modeloTabla = new DefaultTableModel(columnas, 0);
        tblExobots = new JTable(modeloTabla);
        tblExobots.getTableHeader().setBackground(new Color(154, 205, 50));
        add(new JScrollPane(tblExobots), BorderLayout.CENTER);

        // --- Panel Inferior ---
        JPanel pnlSouth = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        btnEntrenar = new JButton("Entrenar Asistir");
        btnAccion = new JButton("Asisitir");
        pnlSouth.add(btnEntrenar);
        pnlSouth.add(btnAccion);
        add(pnlSouth, BorderLayout.SOUTH);
    }

    // --- MÉTODOS DE CARGA ---

    private void cargarTiposAlCombo() {
        // Usamos datos quemados para asegurar estabilidad, simulando la BD
        listaTiposDTO.clear();
        agregarTipoManual(1, "ExoAsalto");
        agregarTipoManual(2, "ExoExplorador");
        agregarTipoManual(3, "ExoInfanteria");
        agregarTipoManual(4, "ExoMedico");
        agregarTipoManual(5, "ExoComando");

        cmbTipoExobot.removeAllItems();
        for (PjTipoExobotDTO t : listaTiposDTO) {
            cmbTipoExobot.addItem(t.getPjNombre());
        }
    }

    private void recargarDatosDesdeBD() {
        if (exobotDAO == null)
            return;
        try {
            listaIExobotsTotal = exobotDAO.readAll();
        } catch (Exception e) {
            AppMSG.showError("Error al leer BD: " + e.getMessage());
        }
    }

    private void mostrarEnTabla(List<PjIExobotDTO> listaParaMostrar) {
        modeloTabla.setRowCount(0); // Limpia la tabla visual
        for (PjIExobotDTO dto : listaParaMostrar) {
            modeloTabla.addRow(new Object[] {
                    dto.getPjIdIExoBot(),
                    dto.getPjIdTipoExoBot(),
                    dto.getPjEntrenamiento(),
                    dto.getPjNAccion()
            });
        }
    }

    // --- EVENTOS ---

    private void setupEvents() {

        btnBuscar.addActionListener(e -> {
            String seleccion = (String) cmbTipoExobot.getSelectedItem();
            if (seleccion == null)
                return;

            List<PjIExobotDTO> filtrados = listaIExobotsTotal.stream()
                    .filter(dto -> dto.getPjIdTipoExoBot().equalsIgnoreCase(seleccion))
                    .collect(Collectors.toList());

            mostrarEnTabla(filtrados);
            JOptionPane.showMessageDialog(this, "Mostrando solo: " + seleccion);
        });

        btnAgregar.addActionListener(e -> {
            String seleccion = (String) cmbTipoExobot.getSelectedItem();
            if (seleccion == null)
                return;

            int idTipo = -1;
            for (PjTipoExobotDTO t : listaTiposDTO) {
                if (t.getPjNombre().equals(seleccion)) {
                    idTipo = t.getPjIdTipoExoBot();
                    break;
                }
            }

            if (idTipo != -1 && exobotDAO != null) {
                try {
                    PjIExobotDTO nuevo = new PjIExobotDTO();
                    nuevo.setPjIdTipoExoBot(idTipo);
                    nuevo.setPjEntrenamiento("NO");
                    nuevo.setPjNAccion(0);

                    if (exobotDAO.create(nuevo)) {
                        JOptionPane.showMessageDialog(this, "Agregado correctamente.");

                        recargarDatosDesdeBD();
                        mostrarEnTabla(listaIExobotsTotal);
                    }
                } catch (Exception ex) {
                    AppMSG.showError("Error al crear: " + ex.getMessage());
                }
            }
        });

        btnEntrenar.addActionListener(e -> {
            PjIExobotDTO dto = getDTODeTabla();
            if (dto == null)
                return;

            if (dto.getPjIdTipoExoBotID() == 4) {
                PjExoMedico medico = new PjExoMedico();
                PjExpertoBioSensor experto = new PjExpertoBioSensor();
                JOptionPane.showMessageDialog(this, experto.PjEntrenar(medico));

                dto.setPjEntrenamiento("SI");
                actualizarEnBD(dto);
            } else {
                JOptionPane.showMessageDialog(this, "Entrenamiento no disponible para este tipo.");
            }
        });

        btnAccion.addActionListener(e -> {
            PjIExobotDTO dto = getDTODeTabla();
            if (dto == null)
                return;

            if ("NO".equals(dto.getPjEntrenamiento())) {
                JOptionPane.showMessageDialog(this, "Requiere entrenamiento.");
                return;
            }

            dto.setPjNAccion(dto.getPjNAccion() + 1);
            actualizarEnBD(dto);
            JOptionPane.showMessageDialog(this, "Acción ejecutada +1.");
        });
    }

    // --- Helpers ---

    private void agregarTipoManual(int id, String nombre) {
        PjTipoExobotDTO t = new PjTipoExobotDTO();
        t.setPjIdTipoExoBot(id);
        t.setPjNombre(nombre);
        listaTiposDTO.add(t);
    }

    private PjIExobotDTO getDTODeTabla() {
        int fila = tblExobots.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un robot de la tabla.");
            return null;
        }
        int idRobot = (int) modeloTabla.getValueAt(fila, 0);

        return listaIExobotsTotal.stream()
                .filter(d -> d.getPjIdIExoBot() == idRobot)
                .findFirst().orElse(null);
    }

    private void actualizarEnBD(PjIExobotDTO dto) {
        try {
            if (exobotDAO.update(dto)) {
                recargarDatosDesdeBD();
                mostrarEnTabla(listaIExobotsTotal);
            }
        } catch (Exception e) {
            AppMSG.showError("Error Update: " + e.getMessage());
        }
    }
}