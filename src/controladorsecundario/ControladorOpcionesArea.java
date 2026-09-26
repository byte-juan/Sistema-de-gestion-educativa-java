//package controladorsecundario;
//
//import alertas.MensajeError;
//import alertas.MensajeInformacion;
//import static controlador.ControladorPrincipal.mostrarPanel;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.SQLException;
//import modelo.Area;
//import dao.AreaDAOimpl;
//import java.awt.Color;
//import java.awt.Frame;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import vista.Areas;
//import vistassecundarias.OpcionesArea;
//
//public class ControladorOpcionesArea implements ActionListener, KeyListener {
//
//    private final OpcionesArea vista;
//    private Area modelo;
//    private int id;
//    private boolean bandera = false;
//
//    @SuppressWarnings("LeakingThisInConstructor")
//    public ControladorOpcionesArea(OpcionesArea vista) throws SQLException {
//        this.vista = vista;
//        this.vista.btnRegistrar.addActionListener(this);
//        this.vista.btnVolver.addActionListener(this);
//        this.vista.txtArea.addKeyListener(this);
//    }
//
//    @SuppressWarnings("LeakingThisInConstructor")
//    public ControladorOpcionesArea(OpcionesArea vista, Area modelo) {
//        this.vista = vista;
//        this.modelo = modelo;
//        this.id = modelo.getId();
//        this.vista.btnRegistrar.setText("Guardar");
//        this.vista.txtArea.setText(modelo.getNombre());
//        this.vista.titulo.setText("Editar area");
//        this.vista.txtArea.requestFocus();
//        this.vista.btnRegistrar.addActionListener(this);
//        this.vista.btnVolver.addActionListener(this);
//        this.vista.txtArea.addKeyListener(this);
//        this.bandera = true;
//        //PONER TEXTOS EN NEGRO
//        this.vista.txtArea.setForeground(Color.BLACK);
//    }
//
//    //<editor-fold defaultstate="collapsed" desc="metodo para mostrar mensaje de confirmacion">
//    public void mostrarConfirmacion(String texto) {
//        MensajeInformacion mensaje = new MensajeInformacion((Frame) vista.getTopLevelAncestor(), true);
//        //mensaje.titulo.setText(texto);
//        mensaje.etiquetaMensaje.setText(texto);
//        mensaje.setSize(vista.getParent().getParent().getSize());
//        mensaje.setLocationRelativeTo(vista.getParent().getParent());
//        mensaje.setBackground(new Color(0, 0, 0, 75));
//        mensaje.fondo.setBackground(new Color(0, 0, 0, 75));
//        mensaje.setVisible(true);
//    }
//    //</editor-fold>
//
//    //<editor-fold defaultstate="collapsed" desc="metodo para mostrar mensaje de error">
//    public void mostrarError(String texto) {
//        MensajeError mensaje = new MensajeError((Frame) vista.getTopLevelAncestor(), true);
//        mensaje.etiquetaMensaje.setText(texto);
//        mensaje.setSize(vista.getParent().getParent().getSize());
//        mensaje.setLocationRelativeTo(vista.getParent().getParent());
//        mensaje.setBackground(new Color(0, 0, 0, 75));
//        mensaje.fondo.setBackground(new Color(0, 0, 0, 75));
//        mensaje.setVisible(true);
//    }
//    //</editor-fold>
//
//    //<editor-fold defaultstate="collapsed" desc="metodo para registrar area">
//    public boolean registrarArea() {
//        AreaDAOimpl dao = new AreaDAOimpl();
//        Area area = new Area();
//
//        try {
//            if (vista.txtArea.getText().isEmpty() || vista.txtArea.getText().equals(vista.txtArea.getUPlaceHolder())) {
//                //JOptionPane.showMessageDialog(null, "No se permiten campos vacios", "Mensaje", JOptionPane.ERROR_MESSAGE);
//                mostrarError("No se permiten campos vacíos.");
//            } else {
//                area.setNombre(vista.txtArea.getText());
//                dao.registrar(area);
//                vista.txtArea.setText(null);
//                vista.txtArea.requestFocus();
//                return true;
//            }
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return false;
//    }
//    //</editor-fold>
//
//    //<editor-fold defaultstate="collapsed" desc="metodo para editar area">
//    public boolean editarArea() {
//        Area area = new Area();
//        AreaDAOimpl dao = new AreaDAOimpl();
//        try {
//            if (vista.txtArea.getText().isEmpty() || vista.txtArea.getText().equals(vista.txtArea.getUPlaceHolder())) {
//                mostrarError("No se permiten campos vacíos.");
//            } else {
//                area.setId(id);
//                area.setNombre(vista.txtArea.getText());
//                dao.modificar(area);
//                vista.txtArea.setText(null);
//                vista.txtArea.requestFocus();
//                return true;
//            }
//        } catch (Exception e) {
//        }
//        return false;
//
//    }
//    //  </editor-fold>
//
//    //<editor-fold defaultstate="collapsed" desc="metodo de ActionEvent">
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//        String opciones = e.getActionCommand();
//        System.out.println(opciones);
//        switch (opciones) {
//            case "Registrar":
//                if (registrarArea() == true) {
//                    mostrarConfirmacion("El area ha sido registrado con éxito.");
//                    //JOptionPane.showMessageDialog(null, "Area registrada con éxito.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
//                }
//                break;
//            case "Guardar":
//                if (editarArea() == true) {
//                    mostrarPanel(new Areas());
//                }
//                break;
//            case "Volver":
//                mostrarPanel(new Areas());
//                break;
//        }
//    }
//    //</editor-fold>
//
//    //<editor-fold defaultstate="collapsed" desc="metodo de KeyEvent">
//    @Override
//    public void keyTyped(KeyEvent ke) {
//        int tecla = ke.getKeyChar();
//        if (tecla == 10 && bandera == false) {
//            if (registrarArea() == true) {
//                //JOptionPane.showMessageDialog(null, "Area registrada con éxito.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
//                mostrarConfirmacion("El area ha sido registrado con éxito. ");
//            }
//        } else if (tecla == 10 && bandera == true) {
//            editarArea();
//            mostrarPanel(new Areas());
//        }
//    }
//
//    @Override
//    public void keyPressed(KeyEvent ke) {
//
//    }
//
//    @Override
//    public void keyReleased(KeyEvent ke) {
//
//    }
//    //</editor-fold>
//
//}
