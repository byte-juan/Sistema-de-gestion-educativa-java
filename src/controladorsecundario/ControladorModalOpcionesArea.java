package controladorsecundario;

import alertas.MensajeError;
import alertas.MensajeInformacion;
import controlador.ControladorPrincipal;
import dao.AreaDAOimpl;
import interfaces.AreaDAO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import modelo.Area;
import vista.Areas;
import vistassecundarias.ModalOpcionesArea;

public class ControladorModalOpcionesArea implements ActionListener, KeyListener {

    private final ModalOpcionesArea vista;
    private Area modelo;
    private int idArea;
    private boolean editable;

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorModalOpcionesArea(ModalOpcionesArea vista) {
        this.vista = vista;
        this.vista.btnX.addActionListener(this);
        this.vista.btnCerrar.addActionListener(this);
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.txtArea.addKeyListener(this);
        
    }

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorModalOpcionesArea(ModalOpcionesArea vista, Area modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.editable = true;
        this.vista.btnX.addActionListener(this);
        this.vista.btnCerrar.addActionListener(this);
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.txtArea.addKeyListener(this);
        this.vista.txtArea.setText(modelo.getNombre());
        this.vista.txtArea.setForeground(Color.BLACK);
        this.vista.txtArea.requestFocus();
        this.idArea = modelo.getId();
        this.vista.titulo.setText("Editar area");
        this.vista.btnRegistrar.setText("Guardar");
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

    //<editor-fold defaultstate="collapsed" desc="metodo existenCamposVacios">
    private boolean existenCamposVacios() {
        String area = vista.txtArea.getText();
        String placeHolderArea = vista.txtArea.getPlaceHolder();

        if (area.isEmpty() || area.equals(placeHolderArea)) {
            mostrarError("No se permiten campos vacíos.");
            vista.txtArea.setText(vista.txtArea.getPlaceHolder());
            vista.txtArea.setForeground(Color.GRAY);
            return true;
        }

        return false;
    }
    //</editor-fold>   

    //<editor-fold defaultstate="collapsed" desc="metodo registrarArea">
    private boolean registrarArea() {
        try {
            AreaDAO dao = new AreaDAOimpl();
            Area area = new Area();
            area.setNombre(vista.txtArea.getText());
            dao.registrar(area);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al registrar el area.\n"
                    + e.getMessage());
        }
        return false;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo editarArea">
    private boolean editarArea() {
        try {
            AreaDAO dao = new AreaDAOimpl();
            Area area = new Area();
            area.setNombre(vista.txtArea.getText());
            area.setId(idArea);
            dao.modificar(area);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al editar el area.\n"
                    + e.getMessage());
        }
        return false;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo limpiarCampos">
    private void limpiarCampos() {
        vista.txtArea.setText(vista.txtArea.getPlaceHolder());
        vista.txtArea.setForeground(Color.GRAY);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo actionPerformed">
    @Override
    public void actionPerformed(ActionEvent ae) {
        String opcion = ae.getActionCommand();
        switch (opcion) {
            case "X":
                vista.dispose();
                break;
            case "Registrar":
                if (existenCamposVacios() == false) {
                    if (registrarArea() == true) {

                        //obtener la cantidad de filas de la tabla.
                        int fila = Areas.myTable1.getRowCount();
                        ControladorPrincipal.mostrarPanel(new Areas(fila));
                        limpiarCampos();
                        mostrarConfirmacion("Area registrada con éxito.");

                    }
                }
                break;
            case "Guardar":
                if (existenCamposVacios() == false) {
                    if (editarArea() == true) {
                        vista.dispose();
                        ControladorPrincipal.mostrarPanel(new Areas(Areas.myTable1.getSelectedRow()));
                    }
                }
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

        if (ke.getKeyChar() == 10 && ke.getSource() == vista.txtArea && editable == false) {
            if (existenCamposVacios() == false) {
                //System.out.println();
                if (registrarArea() == true) {
                    int fila = Areas.myTable1.getRowCount();
                    ControladorPrincipal.mostrarPanel(new Areas(fila));
                    limpiarCampos();
                    mostrarConfirmacion("Area registrada con éxito.");
                }

            }
        } else if (ke.getKeyChar() == 10 && ke.getSource() == vista.txtArea && editable == true) {
            if (existenCamposVacios() == false) {
                if (editarArea() == true) {
                    vista.dispose();
                    int fila = Areas.myTable1.getSelectedRow();                    
                    ControladorPrincipal.mostrarPanel(new Areas(Areas.myTable1.getSelectedRow()));
                }
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
