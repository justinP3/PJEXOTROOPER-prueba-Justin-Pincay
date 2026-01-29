package PjGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// Importaciones de Negocio y DatosPA
import PjBL.PjExoMedico;
import PjBL.PjExpertoBioSensor;
import PjDataAcces.PjDAOs.PjIExoBotDAO; // Importamos el DAO directamente
import PjDataAcces.PjDTOs.PjIExobotDTO;
import PjDataAcces.PjDTOs.PjTipoExobotDTO;
import PjInfraestructure.AppMSG;

public class PjPAlumnos extends JFrame {

    // Componentes de la GUI
    private JComboBox<String> cmbTipoExobot;
    private JTable tblExobots;
    private DefaultTableModel modeloTabla;
    private JButton btnAgregar, btnBuscar, btnEntrenar, btnAccion;

    // --- Listas y DAO ---
    private List<PjTipoExobotDTO> listaTiposDTO; // Para el ComboBox
    private List<PjIExobotDTO> listaIExobots; // Para la Tabla (Datos de BD)
    private PjIExoBotDAO exobotDAO; // Objeto para acceso a Datos

    public PjPAlumnos() {
        setTitle("ExoTrooper - Gestión Directa");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Inicializar listas y DAO
        listaTiposDTO = new ArrayList<>();
        listaIExobots = new ArrayList<>();
        try {
            exobotDAO = new PjIExoBotDAO(); // Conectamos con la BD
        } catch (Exception e) {
            AppMSG.showError("Error crítico: No se pudo conectar al DAO. " + e.getMessage());
        }

        // --- 1. Panel Superior (Info y Controles) ---
        JPanel pnlNorth = new JPanel();
        pnlNorth.setLayout(new BoxLayout(pnlNorth, BoxLayout.Y_AXIS));
        pnlNorth.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Datos del Alumno
        JPanel pnlAlumno = new JPanel(new GridLayout(3, 1));
        pnlAlumno.setBorder(BorderFactory.createTitledBorder("Alumno:"));
        pnlAlumno.add(new JLabel(" 0941165318   |   JUSTIN PINCAY"));
        pnlAlumno.add(new JLabel(" Cédula           |   Nombre Completo"));
        pnlNorth.add(pnlAlumno);
        pnlNorth.add(Box.createVerticalStrut(10));

        // Controles
        JPanel pnlControles = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cmbTipoExobot = new JComboBox<>();
        cmbTipoExobot.setPreferredSize(new Dimension(150, 25));

        btnAgregar = new JButton("Agregar");
        btnBuscar = new JButton("Buscar"); // Carga el combo

        pnlControles.add(new JLabel("TipoExobot: "));
        pnlControles.add(cmbTipoExobot);
        pnlControles.add(btnAgregar);
        pnlControles.add(btnBuscar);

        pnlNorth.add(pnlControles);
        add(pnlNorth, BorderLayout.NORTH);

        // --- 2. Panel Central (Tabla) ---
        // Columnas de la BD
        String[] columnas = { "ID", "Tipo (BD)", "Entreno", "Acciones" };
        modeloTabla = new DefaultTableModel(columnas, 0);
        tblExobots = new JTable(modeloTabla);
        tblExobots.getTableHeader().setBackground(new Color(154, 205, 50));

        JScrollPane scrollPane = new JScrollPane(tblExobots);
        add(scrollPane, BorderLayout.CENTER);

        // --- 3. Panel Inferior (Botones Acción) ---
        JPanel pnlSouth = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        btnEntrenar = new JButton("Entrenar");
        btnAccion = new JButton("Acción");
        pnlSouth.add(btnEntrenar);
        pnlSouth.add(btnAccion);
        add(pnlSouth, BorderLayout.SOUTH);

        // Configurar Eventos
        setupEvents();

        // Carga inicial automática (LISTAR)
        listarExobotsEnTabla();
    }

    // --- MÉTODOS CRUD INTEGRADOS ---

    /**
     * LISTAR: Lee de la BD y llena la JTable
     */
    private void listarExobotsEnTabla() {
        if (exobotDAO == null)
            return;

        try {
            // 1. Leer todo de la base de datos
            listaIExobots = exobotDAO.readAll();

            // 2. Limpiar la tabla visual
            modeloTabla.setRowCount(0);

            // 3. Llenar con los datos frescos
            for (PjIExobotDTO dto : listaIExobots) {
                // Usamos el método que modificaste en el DTO para obtener el Nombre
                String nombreTipo = dto.getPjIdTipoExoBot();

                modeloTabla.addRow(new Object[] {
                        dto.getPjIdIExoBot(),
                        nombreTipo,
                        dto.getPjEntrenamiento(),
                        dto.getPjNAccion()
                });
            }
        } catch (Exception e) {
            AppMSG.showError("Error al listar: " + e.getMessage());
        }
    }

    /**
     * CREAR: Guarda un nuevo registro en la BD
     */
    private void crearExobotEnBD(int idTipo) {
        if (exobotDAO == null)
            return;

        try {
            PjIExobotDTO nuevoDTO = new PjIExobotDTO();
            nuevoDTO.setPjIdTipoExoBot(idTipo); // Guardamos el ID numérico (ej. 4)
            nuevoDTO.setPjEntrenamiento("NO");
            nuevoDTO.setPjNAccion(0);

            // Llamada al DAO
            if (exobotDAO.create(nuevoDTO)) {
                JOptionPane.showMessageDialog(this, "Exobot creado y guardado en BD.");
                listarExobotsEnTabla(); // Refrescamos la tabla
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo guardar en BD.");
            }
        } catch (Exception e) {
            AppMSG.showError("Error al crear: " + e.getMessage());
        }
    }

    /**
     * ACTUALIZAR: Guarda cambios de Entrenamiento/Acción
     */
    private void actualizarExobotEnBD(PjIExobotDTO dto) {
        if (exobotDAO == null)
            return;
        try {
            if (exobotDAO.update(dto)) {
                // Éxito silencioso o mensaje si prefieres
                listarExobotsEnTabla(); // Refrescar visualmente
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar registro.");
            }
        } catch (Exception e) {
            AppMSG.showError("Error al update: " + e.getMessage());
        }
    }

    // --- EVENTOS DE BOTONES ---

    private void setupEvents() {

        // BOTÓN BUSCAR: Carga los tipos (Hardcoded por seguridad del examen)
        btnBuscar.addActionListener(e -> {
            cmbTipoExobot.removeAllItems();
            listaTiposDTO.clear();

            agregarTipoManual(1, "ExoAsalto");
            agregarTipoManual(2, "ExoExplorador");
            agregarTipoManual(3, "ExoInfanteria");
            agregarTipoManual(4, "ExoMedico");
            agregarTipoManual(5, "ExoComando");

            for (PjTipoExobotDTO t : listaTiposDTO) {
                cmbTipoExobot.addItem(t.getPjNombre());
            }
            JOptionPane.showMessageDialog(this, "Tipos cargados al combo.");
        });

        // BOTÓN AGREGAR: Llama a CREAR
        btnAgregar.addActionListener(e -> {
            String seleccion = (String) cmbTipoExobot.getSelectedItem();
            if (seleccion == null)
                return;

            // Buscamos el ID numérico correspondiente
            for (PjTipoExobotDTO tipo : listaTiposDTO) {
                if (tipo.getPjNombre().equals(seleccion)) {
                    crearExobotEnBD(tipo.getPjIdTipoExoBot()); // ID real (ej. 4)
                    return;
                }
            }
        });

        // BOTÓN ENTRENAR: Lógica de Negocio + ACTUALIZAR BD
        btnEntrenar.addActionListener(e -> {
            int fila = tblExobots.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Selecciona una fila.");
                return;
            }

            // Obtenemos el DTO de la lista en memoria (sincronizada con la tabla)
            PjIExobotDTO dto = listaIExobots.get(fila);

            // Reconstruimos objeto lógico para validar
            if (dto.getPjIdTipoExoBotID() == 4) { // 4 es Médico
                PjExoMedico medico = new PjExoMedico();
                // Usamos experto
                PjExpertoBioSensor experto = new PjExpertoBioSensor();
                String msg = experto.PjEntrenar(medico);
                JOptionPane.showMessageDialog(this, msg);

                // Modificamos DTO y guardamos
                dto.setPjEntrenamiento("SI");
                actualizarExobotEnBD(dto);
            } else {
                JOptionPane.showMessageDialog(this, "Solo ExoMedico tiene entrenamiento implementado hoy.");
            }
        });

        // BOTÓN ACCIÓN: Lógica de Negocio + ACTUALIZAR BD
        btnAccion.addActionListener(e -> {
            int fila = tblExobots.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Selecciona una fila.");
                return;
            }

            PjIExobotDTO dto = listaIExobots.get(fila);

            if ("NO".equals(dto.getPjEntrenamiento())) {
                JOptionPane.showMessageDialog(this, "Requiere entrenamiento previo.");
                return;
            }

            // Simulación de acción
            // Incrementamos contador
            int nuevasAcciones = dto.getPjNAccion() + 1;
            dto.setPjNAccion(nuevasAcciones);

            // Guardamos en BD
            JOptionPane.showMessageDialog(this, "Acción ejecutada. Asistiendo...");
            actualizarExobotEnBD(dto);
        });
    }

    // Helper
    private void agregarTipoManual(int id, String nombre) {
        PjTipoExobotDTO t = new PjTipoExobotDTO();
        t.setPjIdTipoExoBot(id);
        t.setPjNombre(nombre);
        listaTiposDTO.add(t);
    }
}