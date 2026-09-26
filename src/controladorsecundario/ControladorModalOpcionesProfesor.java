package controladorsecundario;

import alertas.MensajeError;
import alertas.MensajeInformacion;
import controlador.ControladorPrincipal;
import dao.ProfesorDAOimpl;
import interfaces.ProfesorDAO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import modelo.Profesor;
import vista.Profesores;
import vistassecundarias.ModalOpcionesProfesor;

public class ControladorModalOpcionesProfesor implements ActionListener {

    private final ModalOpcionesProfesor vista;
    private Profesor modelo;
    private int profesorId;
    private String usuario;
    private boolean edicion = false;
    //private boolean existeUsuario;

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorModalOpcionesProfesor(ModalOpcionesProfesor vista) {
        this.vista = vista;
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.btnCerrar.addActionListener(this);
    }

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorModalOpcionesProfesor(ModalOpcionesProfesor vista, Profesor modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.usuario = modelo.getUsuario();
        this.profesorId = modelo.getId();
        this.edicion = true;
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.btnCerrar.addActionListener(this);

        this.vista.btnRegistrar.setText("Guardar");
        this.vista.titulo.setText("Editar profesor");
        this.vista.txtNombre.setText(modelo.getNombre());
        this.vista.txtNombre2.setText(modelo.getNombre2());
        this.vista.txtApellido.setText(modelo.getApellido());
        this.vista.txtApellido2.setText(modelo.getApellido2());
        this.vista.comboboxSexo.setSelectedItem(modelo.getSexo());
        this.vista.txtUsuario.setText(modelo.getUsuario());
        this.vista.txtContraseña.setText(modelo.getContraseña());
        this.vista.comboboxRol.setSelectedIndex(modelo.getRol_id());

        //PONER TEXTOS EN NEGRO
        this.vista.txtNombre.setForeground(Color.BLACK);
        this.vista.txtNombre2.setForeground(Color.BLACK);
        this.vista.txtApellido.setForeground(Color.BLACK);
        this.vista.txtApellido2.setForeground(Color.BLACK);
        this.vista.txtUsuario.setForeground(Color.BLACK);
        this.vista.txtContraseña.setForeground(Color.BLACK);

    }

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

    //<editor-fold defaultstate="collapsed" desc="metodo existeUsuario">
    private boolean existeUsuario() {
        try {
            ProfesorDAO dao = new ProfesorDAOimpl();
            List<Profesor> lista = dao.listar();
            for (Profesor p : lista) {
                if (p.getUsuario().equals(vista.txtUsuario.getText()) && !vista.txtUsuario.getText().equals(usuario)) {
                    mostrarError("El usuario " + vista.txtUsuario.getText() + " ya existe.");
                    return true;
                }
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo existenCamposVacios">
    public boolean existenCamposVacios() {

        int rol = vista.comboboxRol.getSelectedIndex();
        int sexo = vista.comboboxSexo.getSelectedIndex();

        String[] campos = {
            vista.txtNombre.getText(),
            vista.txtNombre2.getText(),
            vista.txtApellido.getText(),
            vista.txtApellido2.getText(),
            vista.txtUsuario.getText(),
            vista.txtContraseña.getText()
        };

        String[] placeholders = {
            vista.txtNombre.getPlaceHolder(),
            vista.txtNombre2.getPlaceHolder(),
            vista.txtApellido.getPlaceHolder(),
            vista.txtApellido2.getPlaceHolder(),
            vista.txtUsuario.getPlaceHolder(),
            vista.txtContraseña.getPlaceHolder()
        };
        for (int i = 0; i < campos.length; i++) {
            // se coloca i!=1 para permitr que el nombre2 sea nulo
            if (i != 1 && campos[i].isEmpty() || i != 1 && campos[i].equals(placeholders[i])) {
                mostrarError("No se permiten campos vacíos");
                return true;
            }
        }
        if (rol == 0 || sexo == 0) {
            mostrarError("Rol y sexo deben ser seleccionados.");
            return true;
        }

        return false;
    }
    //</editor-fold>

    private void limpiarCampos() {
        vista.txtNombre.setText(vista.txtNombre.getPlaceHolder());
        vista.txtNombre2.setText(vista.txtNombre2.getPlaceHolder());
        vista.txtApellido.setText(vista.txtApellido.getPlaceHolder());
        vista.txtApellido2.setText(vista.txtApellido2.getPlaceHolder());
        vista.txtUsuario.setText(vista.txtUsuario.getPlaceHolder());
        vista.txtContraseña.setText(vista.txtContraseña.getPlaceHolder());
        vista.comboboxSexo.setSelectedIndex(0);
        vista.comboboxRol.setSelectedIndex(0);
        vista.txtNombre.setForeground(Color.GRAY);
        vista.txtNombre2.setForeground(Color.GRAY);
        vista.txtApellido.setForeground(Color.GRAY);
        vista.txtApellido2.setForeground(Color.GRAY);
        vista.txtUsuario.setForeground(Color.GRAY);
        vista.txtContraseña.setForeground(Color.GRAY);
        vista.txtNombre.requestFocus();
    }

    //<editor-fold defaultstate="collapsed" desc="metodo registrarProfesor">
    public boolean registarProfesor() {
        if (!existenCamposVacios()) {
            if (!existeUsuario()) {
                try {
                    Profesor profesor = new Profesor();
                    ProfesorDAO dao = new ProfesorDAOimpl();
                    String nombre2 = vista.txtNombre2.getText();
                    String nombre2PlaceHolder = vista.txtNombre2.getPlaceHolder();
                    profesor.setNombre(vista.txtNombre.getText());
                    profesor.setNombre2((nombre2.equals("") || nombre2.equals(nombre2PlaceHolder)) ? "" : nombre2);
                    profesor.setApellido(vista.txtApellido.getText());
                    profesor.setApellido2(vista.txtApellido2.getText());
                    profesor.setSexo((String) vista.comboboxSexo.getSelectedItem());
                    profesor.setRol_id(vista.comboboxRol.getSelectedIndex());
                    profesor.setUsuario(vista.txtUsuario.getText());
                    profesor.setContraseña(vista.txtContraseña.getText());
                    dao.registrar(profesor);
                    return true;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
        }
        return false;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo editarProfesor">
    private boolean editarProfesor() {
        if (!existenCamposVacios()) {
            if (!existeUsuario()) {
                try {
                    Profesor profesor = new Profesor();
                    ProfesorDAO dao = new ProfesorDAOimpl();
                    String nombre2 = vista.txtNombre2.getText();
                    String nombre2PlaceHolder = vista.txtNombre2.getPlaceHolder();
                    profesor.setId(profesorId);
                    profesor.setNombre(vista.txtNombre.getText());
                    profesor.setNombre2((nombre2.equals("") || nombre2.equals(nombre2PlaceHolder)) ? "" : nombre2);
                    profesor.setApellido(vista.txtApellido.getText());
                    profesor.setApellido2(vista.txtApellido2.getText());
                    profesor.setSexo((String) vista.comboboxSexo.getSelectedItem());
                    profesor.setRol_id(vista.comboboxRol.getSelectedIndex());
                    profesor.setUsuario(vista.txtUsuario.getText());
                    profesor.setContraseña(vista.txtContraseña.getText());
                    dao.modificar(profesor);
                    return true;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return false;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo actionPerformed">
    @Override
    public void actionPerformed(ActionEvent e) {
        String opcion = e.getActionCommand();

        switch (opcion) {
            case "Registrar":
                if (registarProfesor() == true) {
                        int fila = Profesores.myTable1.getRowCount();
                        ControladorPrincipal.mostrarPanel(new Profesores(fila));
                        limpiarCampos();
                        mostrarConfirmacion("Grupo registrado con éxito.");
                }
                break;
            case "Guardar":
                if (editarProfesor() == true) {
                    vista.dispose();
                    ControladorPrincipal.mostrarPanel(new Profesores(Profesores.myTable1.getSelectedRow()));
                }
                break;
            case "Volver":
                ControladorPrincipal.mostrarPanel(new Profesores());
                break;

        }

    }
    //</editor-fold>

}
