package controlador;

import alertas.MensajeAdvertencia;
import alertas.MensajeError;
import interfaces.EstudianteDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import dao.EstudianteDAOimpl;
import dao.GrupoDAOimpl;
import db.Conexion;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.Estudiante;
import modelo.Grado;
import modelo.Grupo;
import vista.Estudiantes;
import vistassecundarias.ModalOpcionesEstudiante;

public class ControladorEstudiante implements ActionListener, KeyListener, ItemListener {

    private final Estudiantes vista;

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorEstudiante(Estudiantes vista) {
        this.vista = vista;
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.txtBuscar.addKeyListener(this);
        this.vista.comboboxGrado.addItemListener(this);
        this.vista.comboboxGrupo.addItemListener(this);
        this.vista.btnFiltro.addActionListener(this);

        cargarComboboxGrado();
        cargarDatos();
        this.vista.cantidadEstudiantes.setText("Cantidad de estudiantes: " + this.vista.myTable1.getRowCount());
    }

    //<editor-fold defaultstate="collapsed" desc="metodo mostrarModalOpcionesEstudiante">
    private void mostrarModalOpcionesEstudiante() {
        ModalOpcionesEstudiante modal = new ModalOpcionesEstudiante((Frame) vista.getTopLevelAncestor(), true);
        modal.setSize(vista.getParent().getParent().getSize());
        modal.setBackground(new Color(0, 0, 0, 75));
        modal.fondo.setBackground(new Color(0, 0, 0, 75));
        modal.setLocationRelativeTo(vista.getParent().getParent());
        modal.setVisible(true);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo mostrarModalOpcionesEstudiante(Estudiante estudiante)">
    private void mostrarModalOpionesEstudiante(Estudiante estudiante) {
        ModalOpcionesEstudiante modal = new ModalOpcionesEstudiante((Frame) vista.getTopLevelAncestor(), true, estudiante);
        modal.setSize(vista.getParent().getParent().getSize());
        modal.setBackground(new Color(0, 0, 0, 75));
        modal.fondo.setBackground(new Color(0, 0, 0, 75));
        modal.setLocationRelativeTo(vista.getParent().getParent());
        modal.setVisible(true);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo para mostrar mensaje de error" >
    public void mostrarError(String texto) {
        MensajeError mensaje = new MensajeError((Frame) vista.getTopLevelAncestor(), true);
        mensaje.etiquetaMensaje1.setText(texto);
        mensaje.setSize(vista.getParent().getParent().getSize());
        mensaje.setLocationRelativeTo(vista.getParent().getParent());
        mensaje.setBackground(new Color(0, 0, 0, 75));
        mensaje.fondo.setBackground(new Color(0, 0, 0, 75));
        mensaje.setVisible(true);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo para mostrar advertencia" >
    public void mostrarAdvertencia(String texto) {
        MensajeAdvertencia mensaje = new MensajeAdvertencia((Frame) vista.getTopLevelAncestor(), true);
        mensaje.etiquetaMensaje.setText(texto);
        mensaje.setSize(vista.getParent().getParent().getSize());
        mensaje.setLocationRelativeTo(vista.getParent().getParent());
        mensaje.setBackground(new Color(0, 0, 0, 75));
        mensaje.fondo.setBackground(new Color(0, 0, 0, 75));
        //MensajeAdvertencia.
        mensaje.setVisible(true);
    }
    //</editor-fold>    

    // <editor-fold defaultstate="collapsed" desc="metodo para cargar datos">     
    private void cargarDatos() {
        try {
            EstudianteDAO dao = new EstudianteDAOimpl();
            List<Estudiante> lista = dao.listar();
            DefaultTableModel modelo = (DefaultTableModel) vista.myTable1.getModel();
            for (Estudiante e : lista) {
                modelo.addRow(new Object[]{e.getId(), e.getNombre(), e.getNombre2(), e.getApellido(),
                    e.getApellido2(), e.getSexo(),
                    e.getNombreGrado() == null ? "Sin asignar" : e.getNombreGrado(),
                    e.getNombreGrupo() == null ? "Sin asignar" : e.getNombreGrupo()});
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="metodo para obtener la fila seleccionada" >
    public void obtenerFilaSeleccionada() {

        switch (vista.myTable1.getSelectedRowCount()) {
            case 0:
                mostrarError("Por favor, seleccione el estudiante que desea editar.");
                //JOptionPane.showMessageDialog(null, "Debe seleccionar un estudiante.", "Mensaje", JOptionPane.ERROR_MESSAGE);
                break;
            case 1:
                int id = (int) vista.myTable1.getValueAt(vista.myTable1.getSelectedRow(), 0);
                EstudianteDAO dao = new EstudianteDAOimpl();
                try {
                    //ControladorPrincipal.mostrarPanel(new OpcionesEstudiante(dao.obtenerEstudiantePorId(id)));
                    mostrarModalOpionesEstudiante(dao.obtenerEstudiantePorId(id));
                } catch (Exception ex) {
                    Logger.getLogger(ControladorGrupo.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            default:
                mostrarError("No es posible editar más de 1 estudiante a la vez.");
                //JOptionPane.showMessageDialog(null, "No se puede editar más de 1 estudiante a la vez.");
                break;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo cargarComboboxGrado">
    private void cargarComboboxGrado() {
        Conexion objConexion = new Conexion();
        String sql = "SELECT * FROM GRADO";
        try {
            objConexion.conectar();
            PreparedStatement ps = objConexion.conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            vista.comboboxGrado.addItem(new Grado(0, "Seleccione el grado escolar"));
            while (rs.next()) {
                vista.comboboxGrado.addItem(new Grado(rs.getInt("id"), rs.getString("nombre")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                objConexion.cerrar();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexion " + ex.getMessage());
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodo para llenar el combobox de grupo"> 
    private void cargarGrupos(int id) {
        String sql = "SELECT * FROM grupo WHERE grado_id=?";
        GrupoDAOimpl dao = new GrupoDAOimpl();
        try {

            dao.conectar();
            PreparedStatement ps = dao.conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            vista.comboboxGrupo.removeAllItems();
            vista.comboboxGrupo.addItem(new Grupo(0, "Todos"));
            while (rs.next()) {
                vista.comboboxGrupo.addItem(new Grupo(rs.getInt("id"), rs.getString("nombre")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                dao.cerrar();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexion " + ex.getMessage());
            }
        }
    }
    //</editor-fold>    

    // <editor-fold defaultstate="collapsed" desc="Metodo para filtrar tabla"> 
    public void filtrarTabla() {
        TableModel tm = vista.myTable1.getModel(); // Objeto TableModel que sera igual al modelo de la tabla
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tm); // 
        Grado grado = (Grado) vista.comboboxGrado.getSelectedItem();
        Grupo grupo = (Grupo) vista.comboboxGrupo.getSelectedItem();
        String txtBuscar = vista.txtBuscar.getText();
        String buscarPlaceHolder = vista.txtBuscar.getPlaceHolder();
        vista.myTable1.setRowSorter(sorter);
        List<RowFilter<Object, Object>> filtro = new ArrayList<>();

        if (grado.getId() == 0 && grupo.getId() == 0 && txtBuscar.equals(buscarPlaceHolder)) {
            sorter.setRowFilter(null);
        } else if (txtBuscar.equals(buscarPlaceHolder) || txtBuscar.isEmpty()) {
            filtro.add(RowFilter.regexFilter("^(?i)" + grado.getNombre(), 6));
            filtro.add(RowFilter.regexFilter("^(?i)" + grupo.getNombre() == null ? "" : grupo.getNombre().equals("Todos") ? "" : grupo.getNombre(), 7));
            //filtro.add(RowFilter.regexFilter("^(?i)" + txtBuscar == buscarPlaceHolder ? "" : txtBuscar, 1));
            RowFilter<Object, Object> filtroCombinado = RowFilter.andFilter(filtro);
            sorter.setRowFilter(filtroCombinado);
        } else if (grado.getId() == 0 && grupo.getId() == 0) {
            sorter.setRowFilter(RowFilter.regexFilter("^(?i)" + Pattern.quote(txtBuscar), 1));
        } else {
            filtro.add(RowFilter.regexFilter("^(?i)" + grado.getNombre(), 6));
            filtro.add(RowFilter.regexFilter("^(?i)" + grupo.getNombre() == null ? "" : grupo.getNombre().equals("Todos") ? "" : grupo.getNombre(), 7));
            filtro.add(RowFilter.regexFilter("^(?i)" + txtBuscar, 1));
            RowFilter<Object, Object> filtroCombinado = RowFilter.andFilter(filtro);
            sorter.setRowFilter(filtroCombinado);
        }
        this.vista.cantidadEstudiantes.setText("Cantidad de estudiantes: " + this.vista.myTable1.getRowCount());
    }
    //</editor-fold>   

    // <editor-fold defaultstate="collapsed" desc="metodo para filtar la tabla2" >
    public void filtrarTabla2() {
        int columnaFiltro = 1; //numero de columna que se desea filtrar 
        TableModel tm = vista.myTable1.getModel(); // Objeto TableModel que sera igual al modelo de la tabla
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tm); // 
        vista.myTable1.setRowSorter(sorter);
        if (vista.txtBuscar == null || vista.txtBuscar.getText().equals(vista.txtBuscar.getPlaceHolder())) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("^(?i)" + vista.txtBuscar.getText(), columnaFiltro, 6));
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo para eliminar estudiante" >
    public void eliminarEstudiante() {
        EstudianteDAOimpl dao = new EstudianteDAOimpl();
        DefaultTableModel modelo = (DefaultTableModel) vista.myTable1.getModel();

        if (vista.myTable1.getSelectedRows().length < 1) {

            //JOptionPane.showMessageDialog(null, "Debe seleccionar 1 o más estudiantes para eliminar.", "Mensaje", JOptionPane.ERROR_MESSAGE);
        } else {
            int filasSeleccionadas[] = vista.myTable1.getSelectedRows();

            for (int i = filasSeleccionadas.length - 1; i >= 0; i--) {
                try {
                    //Obtener el nuevo indice luego de filtrar
                    int fila = vista.myTable1.convertRowIndexToModel(filasSeleccionadas[i]);
                    dao.eliminar((int) vista.myTable1.getValueAt(filasSeleccionadas[i], 0));
                    modelo.removeRow(fila);
                } catch (Exception ex) {
                    Logger.getLogger(ControladorGrupo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    //</editor-fold>

    @Override
    public void actionPerformed(ActionEvent e) {
        String opcion = e.getActionCommand();
        switch (opcion) {
            case "Nuevo":
                mostrarModalOpcionesEstudiante();
                break;
            case "Editar":
                obtenerFilaSeleccionada();
                break;
            case "Eliminar":
                if (vista.myTable1.getSelectedRows().length < 1) {
                    mostrarError("Por favor, seleccione el estudiante que desea eliminar.");

                } else if (vista.myTable1.getSelectedRows().length == 1) {
                    String nombre = (String) vista.myTable1.getValueAt(vista.myTable1.getSelectedRow(), 1);
                    String apellido = (String) vista.myTable1.getValueAt(vista.myTable1.getSelectedRow(), 3);
                    mostrarAdvertencia("Se eliminará el estudiante " + nombre + " " + apellido + ".");
                    if (MensajeAdvertencia.ACEPTAR == 1) {
                        eliminarEstudiante();
                        this.vista.cantidadEstudiantes.setText("Cantidad de estudiantes: " + this.vista.myTable1.getRowCount());
                    }
                } else {
                    mostrarAdvertencia("Se eliminarán todos los estudiantes seleccionados.");
                    if (MensajeAdvertencia.ACEPTAR == 1) {
                        eliminarEstudiante();
                        this.vista.cantidadEstudiantes.setText("Cantidad de estudiantes: " + this.vista.myTable1.getRowCount());
                    }
                }

                break;
        }
        if (e.getSource() == vista.btnFiltro) {
            vista.comboboxGrado.setSelectedIndex(0);
            vista.comboboxGrupo.setSelectedIndex(0);
            vista.txtBuscar.setText(vista.txtBuscar.getPlaceHolder());
            vista.txtBuscar.setForeground(Color.GRAY);
            filtrarTabla();
        }

    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if (ke.getSource() == vista.txtBuscar) {

            filtrarTabla();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == vista.comboboxGrado) {
            Grado grado = (Grado) vista.comboboxGrado.getSelectedItem();
            cargarGrupos(grado.getId());
            filtrarTabla();
        } else if (e.getStateChange() == ItemEvent.SELECTED) {
            filtrarTabla();
        }
    }

}
