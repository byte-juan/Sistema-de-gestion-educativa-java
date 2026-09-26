package controladorsecundario;

import alertas.MensajeError;
import alertas.MensajeInformacion;
import controlador.ControladorPrincipal;
import dao.GrupoDAOimpl;
import db.Conexion;
import interfaces.GrupoDAO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import modelo.Grado;
import modelo.Grupo;
import vista.Grupos;
import vistassecundarias.ModalOpcionesGrupo;

public class ControladorModalOpcionesGrupo implements ActionListener, KeyListener {

    private final ModalOpcionesGrupo vista;
    private Grupo modelo;
    private String nombreGrupo;
    private String nombreGrado;
    private boolean editable = false;
    private boolean bandera = false;
    private int indiceFinal = -1;
    private int id;
    private int filaSeleccionada;

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorModalOpcionesGrupo(ModalOpcionesGrupo vista) {
        this.vista = vista;
        this.vista.btnCerrar.addActionListener(this);
        this.vista.btnX.addActionListener(this);
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.btnCerrar.addActionListener(this);
        this.vista.txtGrupo.addKeyListener(this);
        this.vista.comboboxGrado.addKeyListener(this);
        cargarComboboxGrado();
    }

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorModalOpcionesGrupo(ModalOpcionesGrupo vista, Grupo modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.id = modelo.getId();
        this.filaSeleccionada = Grupos.myTable1.getSelectedRow();
        this.nombreGrado = modelo.getNombreGrado();
        this.nombreGrupo = modelo.getNombre();
        this.editable = true;
        this.vista.btnCerrar.addActionListener(this);
        this.vista.btnX.addActionListener(this);
        this.vista.btnCerrar.addActionListener(this);
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.txtGrupo.addKeyListener(this);
        this.vista.comboboxGrado.addKeyListener(this);
        this.vista.txtGrupo.setText(modelo.getNombre());
        this.vista.txtGrupo.setForeground(Color.BLACK);
        this.vista.titulo.setText("Editar grupo");
        this.vista.btnRegistrar.setText("Guardar");
        cargarComboboxGrado();
        for (int i = 0; i < vista.comboboxGrado.getItemCount(); i++) {
            Grado grado = (Grado) vista.comboboxGrado.getItemAt(i);
            if (grado.getId() == modelo.getIdGrado()) {
                vista.comboboxGrado.setSelectedItem(grado);
            }
        }

    }

    //<editor-fold defaultstate="collapsed" desc="metodo seleccionarElementoPorTeclado">
    private void seleccionarElementoPorTeclado(JComboBox combobox, char letra) {
        /* 
             * el indiceInicial va a depender del indiceFinal 
             * si es mayor o igual a 0 y menor al tamañoCombobox entonces inicia con el valor del indiceFinal
             * caso contrario iniciara en 1.
             * el indiceEncontrado iniciara en -1 para indicar que aun no hay ningun elemento selccionado
         */
        //char letra = ke.getKeyChar();

        int indiceEncontrado = -1;
        int tamañoCombobox = combobox.getItemCount();
        int indiceInicial = (indiceFinal >= 0 && indiceFinal < tamañoCombobox - 1) ? indiceFinal + 1 : 1;
        boolean recorridoCompleto = false;

        for (int i = indiceInicial; i < tamañoCombobox; i++) {
            String item = combobox.getItemAt(i).toString();//obtiene el item en la posición i                         
            /*
                 * si existe un item que inicia con la misma letra presionada entonces
                 * el indiceEncontrado va a ser igual al iterador del for i y además finaliza la busqueda                    
             */
            if (Character.toLowerCase(item.charAt(0)) == Character.toLowerCase(letra)) {
                indiceEncontrado = i;
                bandera = true;
                break;
            }

            /*
                 * si el iterador es igual al tamaño del combobox entonces reinicia la busqueda.                                  
             */
            if (i == tamañoCombobox - 1) {

                if (recorridoCompleto) {
                    break;
                } else {
                    i = 0;
                    recorridoCompleto = true;
                }
            }
        }
        /*
             * si el indiceEncontrado es mayor o igual a 0 significa que existe un item que inicia 
             * con la tecla presionada y entonces selecciona ese item 
             * y el indiceFinal va a ser igual al indice encontrado
             * sino resetea la busqueda 
         */
        if (bandera == true && indiceEncontrado >= 0) {
            combobox.setSelectedIndex(indiceEncontrado);
            indiceFinal = indiceEncontrado;
        } else {
            indiceFinal = -1;
            bandera = false;
        }
    }
    //</editor-fold>    

    //<editor-fold defaultstate="collapsed" desc="metodo mostrarConfirmacion">
    private void mostrarConfirmacion(String texto) {
        MensajeInformacion mensaje = new MensajeInformacion(vista, true);
        mensaje.etiquetaMensaje.setText(texto);
        mensaje.setSize(vista.getSize());
        mensaje.setLocationRelativeTo(vista);
        mensaje.setBackground(new Color(0, 0, 0, 75));
        mensaje.fondo.setBackground(new Color(0, 0, 0, 75));
        mensaje.setVisible(true);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo mostrarError">
    private void mostrarError(String texto) {
        MensajeError mensaje = new MensajeError(vista, true);
        mensaje.etiquetaMensaje1.setText(texto);
        mensaje.setSize(vista.getSize());
        mensaje.setLocationRelativeTo(vista);
        mensaje.setBackground(new Color(0, 0, 0, 75));
        mensaje.fondo.setBackground(new Color(0, 0, 0, 75));
        mensaje.setVisible(true);
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
            vista.comboboxGrado.addItem(new Grado(1, "Seleccione el grado escolar"));
            while (rs.next()) {
                vista.comboboxGrado.addItem(new Grado(rs.getInt("id"), rs.getString("nombre")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo existenCamposVacios">
    private boolean existenCamposVacios() {
        String grupo = vista.txtGrupo.getText();
        String placeHolderGrupo = vista.txtGrupo.getPlaceHolder();

        if (vista.comboboxGrado.getSelectedIndex() == 0 || grupo.equals("") || grupo.equals(placeHolderGrupo)) {
            mostrarError("No se permiten campos vacíos.");
            return true;
        }

        return false;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo existeGrupo">
    private boolean existeGrupo(boolean editable) {

        String grupo = vista.txtGrupo.getText();
        Grado grado = (Grado) vista.comboboxGrado.getSelectedItem();
        Grupos vistaGrupo = new Grupos();
        DefaultTableModel modeloTabla = (DefaultTableModel) vistaGrupo.myTable1.getModel();
        int numeroFilas = modeloTabla.getRowCount();

        if (editable == false) {

            for (int i = 0; i <= numeroFilas - 1; i++) {
                String gradoTabla = (String) modeloTabla.getValueAt(i, 1);
                String grupoTabla = (String) modeloTabla.getValueAt(i, 2);
                if (gradoTabla.equals(grado.getNombre()) && grupoTabla.equals(grupo)) {
                    mostrarError("El grupo " + grupoTabla + " ya existe en el grado " + gradoTabla + ".");
                    return true;
                }
            }
        } else {
            for (int i = 0; i <= numeroFilas - 1; i++) {
                String gradoTabla = (String) modeloTabla.getValueAt(i, 1);
                String grupoTabla = (String) modeloTabla.getValueAt(i, 2);
                if (grado.getNombre().equals(nombreGrado) && grupo.equals(nombreGrupo)) {

                    break;
                } else if (gradoTabla.equals(grado.getNombre()) && grupoTabla.equals(grupo)) {
                    mostrarError("El grupo " + grupoTabla + " ya existe en el grado " + gradoTabla + ".");
                    return true;
                }
            }
        }
        return false;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo limpiarCampos">
    private void limpiarCampos() {
        vista.txtGrupo.setText(vista.txtGrupo.getPlaceHolder());
        vista.txtGrupo.setForeground(Color.GRAY);
    }
    //</editor-fold>    

    //<editor-fold defaultstate="collapsed" desc="metodo registrarGrupo">
    private boolean registrarGrupo() {
        if (existeGrupo(editable) == false) {
            try {
                GrupoDAO dao = new GrupoDAOimpl();
                Grupo grupo = new Grupo();
                Grado grado = (Grado) vista.comboboxGrado.getSelectedItem();                
                grupo.setNombre(vista.txtGrupo.getText());
                grupo.setIdGrado(grado.getId());
                vista.txtGrupo.setText(vista.txtGrupo.getPlaceHolder());
                vista.txtGrupo.setForeground(Color.GRAY);
                vista.txtGrupo.requestFocus();
                dao.registrar(grupo);
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        return false;

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo editarGrupo">
    private boolean editarGrupo() {
        if (existeGrupo(editable) == false) {
            try {
                GrupoDAO dao = new GrupoDAOimpl();
                Grupo grupo = new Grupo();
                Grado grado = (Grado) vista.comboboxGrado.getSelectedItem(); 
                grupo.setId(id);
                grupo.setNombre(vista.txtGrupo.getText());
                grupo.setIdGrado(grado.getId());
                dao.modificar(grupo);
                return true;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }
        return false;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo actionEvent">
    @Override
    public void actionPerformed(ActionEvent ae) {
        String opcion = ae.getActionCommand();
        switch (opcion) {
            case "Registrar":
                if (existenCamposVacios() == false) {
                    if (registrarGrupo() == true) {
                        //obtener la cantidad de filas de la tabla.
                        int fila = Grupos.myTable1.getRowCount();
                        ControladorPrincipal.mostrarPanel(new Grupos(fila));
                        limpiarCampos();
                        mostrarConfirmacion("Grupo registrado con éxito.");

                    }
                }
                break;
            case "Guardar":
                if (existenCamposVacios() == false) {
                    if (editarGrupo() == true) {
                        vista.dispose();
                        ControladorPrincipal.mostrarPanel(new Grupos(filaSeleccionada));
                    }
                }
                break;
            case "X":
                vista.dispose();
                break;
            case "Cerrar":
                vista.dispose();
                break;

        }

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo keyEvent">
    @Override
    public void keyTyped(KeyEvent ke) {
        int letra = ke.getKeyChar();
        if (letra == 10 && ke.getSource() == vista.txtGrupo && editable == false) {
            if (existenCamposVacios() == false) {
                if (registrarGrupo() == true) {
                    //obtener la cantidad de filas de la tabla.
                    int fila = Grupos.myTable1.getRowCount();
                    ControladorPrincipal.mostrarPanel(new Grupos(fila));
                    limpiarCampos();
                    mostrarConfirmacion("Grupo registrado con éxito.");
                }
            } else if (vista.txtGrupo.getText().isEmpty() || vista.txtGrupo.getText().equals(vista.txtGrupo.getPlaceHolder())) {
                vista.txtGrupo.setText(vista.txtGrupo.getPlaceHolder());
                vista.txtGrupo.setForeground(Color.GRAY);
            }
        } else if (letra == 10 && ke.getSource() == vista.txtGrupo && editable == true) {
            if (existenCamposVacios() == false) {
                if (editarGrupo() == true) {
                    vista.dispose();
                    ControladorPrincipal.mostrarPanel(new Grupos(filaSeleccionada));
                }
            } else if (vista.txtGrupo.getText().isEmpty() || vista.txtGrupo.getText().equals(vista.txtGrupo.getPlaceHolder())) {
                vista.txtGrupo.setText(vista.txtGrupo.getPlaceHolder());
                vista.txtGrupo.setForeground(Color.GRAY);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

    //</editor-fold>
}
