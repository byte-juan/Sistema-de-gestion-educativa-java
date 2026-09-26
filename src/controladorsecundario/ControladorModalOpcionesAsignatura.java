package controladorsecundario;

import alertas.MensajeError;
import alertas.MensajeInformacion;
import controlador.ControladorPrincipal;
import dao.AreaDAOimpl;
import dao.AsignaturaDAOimpl;
import interfaces.AsignaturaDAO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import modelo.Area;
import modelo.Asignatura;
import vista.Asignaturas;
import vistassecundarias.ModalOpcionesAsignatura;

public class ControladorModalOpcionesAsignatura implements ActionListener, KeyListener {

    private final ModalOpcionesAsignatura vista;
    private Asignatura modelo;
    private boolean editable;
    private String nombreAsignatura;
    private int idArea;
    private int id;
    private float pesoActual;

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorModalOpcionesAsignatura(ModalOpcionesAsignatura vista) {
        this.vista = vista;
        this.vista.btnX.addActionListener(this);
        this.vista.btnCerrar.addActionListener(this);
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.comboboxArea.addKeyListener(this);
        this.vista.txtPeso.addKeyListener(this);
        this.vista.txtAsignatura.addKeyListener(this);
        cargarComboboxArea();
    }

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorModalOpcionesAsignatura(ModalOpcionesAsignatura vista, Asignatura modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.id = modelo.getId();
        this.editable = true;
        this.idArea = modelo.getArea_id();
        this.nombreAsignatura = modelo.getNombre();
        this.pesoActual = modelo.getPeso();
        this.vista.btnX.addActionListener(this);
        this.vista.btnCerrar.addActionListener(this);
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.txtPeso.addKeyListener(this);
        this.vista.txtAsignatura.addKeyListener(this);
        this.vista.titulo.setText("Editar asignatura");
        this.vista.btnRegistrar.setText("Guardar");
        this.vista.txtAsignatura.requestFocus();
        cargarComboboxArea();

        this.vista.txtPeso.setText(String.valueOf(modelo.getPeso()));
        this.vista.txtAsignatura.setText(modelo.getNombre());
        this.vista.txtAsignatura.setForeground(Color.BLACK);
        this.vista.txtPeso.setForeground(Color.BLACK);

        for (int i = 0; i < vista.comboboxArea.getItemCount(); i++) {
            Area area = (Area) vista.comboboxArea.getItemAt(i);
            if (area.getId() == modelo.getArea_id()) {
                vista.comboboxArea.setSelectedItem(area);
                break;
            }
        }
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
        mensaje.btnAceptar.setLocation(200, 200);
        mensaje.setSize(vista.getSize());
        mensaje.setLocationRelativeTo(vista);
        mensaje.setBackground(new Color(0, 0, 0, 75));
        mensaje.fondo.setBackground(new Color(0, 0, 0, 75));
        mensaje.setVisible(true);

    }
    //</editor-fold> 

    //<editor-fold defaultstate="collapsed" desc="metodo mostrarError">
    private void mostrarError(String texto, String texto2) {
        MensajeError mensaje = new MensajeError(vista, true);
        //mensaje.setLayout(null);
        mensaje.etiquetaMensaje1.setText(texto);
        mensaje.btnAceptar.setLocation(200, 220);
        mensaje.etiquetaMensaje2.setText(texto2);
        mensaje.setSize(vista.getSize());
        mensaje.setLocationRelativeTo(vista);
        mensaje.setBackground(new Color(0, 0, 0, 75));
        mensaje.fondo.setBackground(new Color(0, 0, 0, 75));
        mensaje.setVisible(true);
    }
    //</editor-fold>  

    private void cargarComboboxArea() {
        try {
            AreaDAOimpl dao = new AreaDAOimpl();
            List<Area> lista = dao.listar();
            vista.comboboxArea.addItem(new Area(0, "Seleccione el area"));
            for (Area a : lista) {
                vista.comboboxArea.addItem(a);
            }

        } catch (Exception e) {
        }

    }

    private boolean existenCamposVacios() {
        if (vista.comboboxArea.getSelectedIndex() == 0
                || vista.txtAsignatura.getText().isEmpty()
                || vista.txtAsignatura.getText().equals(vista.txtAsignatura.getPlaceHolder())
                || vista.txtPeso.getText().isEmpty()
                || vista.txtPeso.getText().equals(vista.txtPeso.getPlaceHolder())) {
            mostrarError("No se permiten campos vacios.");
            return true;
        }
        return false;
    }

    private void limpiarCampos() {
        vista.txtAsignatura.setText(vista.txtAsignatura.getPlaceHolder());
        vista.txtAsignatura.setForeground(Color.GRAY);
        //vista.comboboxArea.setSelectedIndex(0);
        vista.txtPeso.setText(vista.txtPeso.getPlaceHolder());
        vista.txtPeso.setForeground(Color.GRAY);
    }

    private float calcularPeso() {
        AsignaturaDAOimpl dao = new AsignaturaDAOimpl();
        try {
            Area area = (Area) vista.comboboxArea.getSelectedItem();
            String sql = "SELECT asignatura.nombre AS asignatura,asignatura.peso,area.nombre AS area, SUM(asignatura.peso) AS totalPeso\n"
                    + "FROM asignatura,area\n"
                    + "WHERE asignatura.area_id = area.id\n"
                    + "AND area.id = ?\n"
                    + "GROUP BY(asignatura.area_id)";
            dao.conectar();
            PreparedStatement ps = dao.conexion.prepareStatement(sql);
            ps.setInt(1, area.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getFloat("totalPeso");
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                dao.cerrar();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return 0;
    }

    private boolean existeAsignatura() {
        AsignaturaDAOimpl dao = new AsignaturaDAOimpl();
        Area area = (Area) vista.comboboxArea.getSelectedItem();
        if (editable == true && nombreAsignatura.equals(vista.txtAsignatura.getText())
                && idArea == area.getId()) {

        } else {

            try {
                String sql = "SELECT nombre\n"
                        + "FROM asignatura\n"
                        + "WHERE LOWER(nombre) = LOWER(?)\n"
                        + "AND asignatura.area_id = ?";
                dao.conectar();
                PreparedStatement ps = dao.conexion.prepareStatement(sql);
                ps.setString(1, vista.txtAsignatura.getText());
                ps.setInt(2, area.getId());
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    return true;
                }
                ps.close();
                rs.close();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    dao.cerrar();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return false;
    }

    private boolean registrarAsignatura() {
        Area area = (Area) vista.comboboxArea.getSelectedItem();

        //float peso = (idArea == area.getId()) ? calcularPeso() - pesoActual + Float.parseFloat(vista.txtPeso.getText()) : calcularPeso() + Float.parseFloat(vista.txtPeso.getText());
        //calcularPeso() + Float.parseFloat(vista.txtPeso.getText());
        try {
            if (calcularPeso() + Float.parseFloat(vista.txtPeso.getText()) <= 100 && existeAsignatura() == false) {
                AsignaturaDAO dao = new AsignaturaDAOimpl();
                Asignatura asignatura = new Asignatura();

                asignatura.setNombre(vista.txtAsignatura.getText());
                asignatura.setArea_id(area.getId());
                asignatura.setPeso(Float.parseFloat(vista.txtPeso.getText()));
                dao.registrar(asignatura);
                return true;
            } else if (existeAsignatura() == true) {
                mostrarError("La asignatura " + vista.txtAsignatura.getText() + " ya existe en el area " + area.getNombre() + ".");
            } else {
                mostrarError("La suma del peso de las asignaturas del area", "no puede ser mayor a 100%.");
            }
        } catch (Exception e) {
            System.out.println("Error al registrar la asginatura " + e.getMessage());
        }
        return false;
    }

    private boolean editarAsignatura() {
        Area area = (Area) vista.comboboxArea.getSelectedItem();
        float peso = (idArea == area.getId()) ? calcularPeso() - pesoActual + Float.parseFloat(vista.txtPeso.getText()) : calcularPeso() + Float.parseFloat(vista.txtPeso.getText());
        //System.out.println(calcularPeso() + Float.parseFloat(vista.txtPeso.getText()));
        try {
            if (peso <= 100 && existeAsignatura() == false) {
                AsignaturaDAO dao = new AsignaturaDAOimpl();
                Asignatura asignatura = new Asignatura();
                asignatura.setId(id);
                asignatura.setNombre(vista.txtAsignatura.getText());
                asignatura.setArea_id(area.getId());
                asignatura.setPeso(Float.parseFloat(vista.txtPeso.getText()));
                dao.modificar(asignatura);
                System.out.println("entra? " + id);
                return true;
            } else if (existeAsignatura() == true) {
                mostrarError("La asignatura " + vista.txtAsignatura.getText() + " ya existe en el area " + area.getNombre() + ".");
            } else {
                mostrarError("La suma del peso de las asignaturas del area", "no puede ser mayor a 100.");
            }
        } catch (Exception e) {
            System.out.println("Error al registrar la asginatura " + e.getMessage());
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String opcion = ae.getActionCommand();
        switch (opcion) {
            case "Registrar":
                if (!existenCamposVacios()) {
                    if (registrarAsignatura() == true) {
                        ControladorPrincipal.mostrarPanel(new Asignaturas(vista.txtAsignatura.getText()));
                        limpiarCampos();
                        mostrarConfirmacion("Asignatura registrada con éxito.");
                    }
                }
                break;
            case "Guardar":
                if (existenCamposVacios() == false) {
                    if (editarAsignatura() == true) {
                        vista.dispose();
                        ControladorPrincipal.mostrarPanel(new Asignaturas(vista.txtAsignatura.getText()));
                    }
                }

                break;
            case "Cerrar":
                vista.dispose();
                break;
            case "X":
                vista.dispose();
                break;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        int letra = e.getKeyChar();
        if (e.getSource() == vista.txtPeso) {
            char c = e.getKeyChar();
            if (!((c >= '0' && c <= '9') || c == '.' || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                e.consume();
                if (vista.txtPeso.getText().isEmpty() || vista.txtPeso.getText().equals(vista.txtPeso.getPlaceHolder())) {
                    vista.txtPeso.setText(vista.txtPeso.getPlaceHolder());
                    vista.txtPeso.setForeground(Color.GRAY);
                    vista.txtPeso.setCaretPosition(0);
                }

            }
        }
        if (letra == 10 && e.getSource() == vista.txtPeso && editable == false) {
            if (!existenCamposVacios()) {
                if (registrarAsignatura() == true) {
                    ControladorPrincipal.mostrarPanel(new Asignaturas(vista.txtAsignatura.getText()));
                    limpiarCampos();
                    mostrarConfirmacion("Asignatura registrada con éxito.");
                }
            } else if (vista.txtAsignatura.getText().isEmpty()
                    || vista.txtAsignatura.getText().equals(vista.txtAsignatura.getPlaceHolder())
                    || vista.txtPeso.getText().isEmpty()
                    || vista.txtPeso.getText().equals(vista.txtPeso.getPlaceHolder())) {
                vista.txtAsignatura.setText(vista.txtAsignatura.getPlaceHolder());
                vista.txtAsignatura.setForeground(Color.GRAY);
                //vista.comboboxArea.setSelectedIndex(0);
                vista.txtPeso.setText(vista.txtPeso.getPlaceHolder());
                vista.txtPeso.setForeground(Color.GRAY);
            }
        } else if (letra == 10 && e.getSource() == vista.txtPeso && editable == true) {
            if (existenCamposVacios() == false) {
                if (editarAsignatura() == true) {
                    vista.dispose();
                    ControladorPrincipal.mostrarPanel(new Asignaturas(vista.txtAsignatura.getText()));
                }
            } else if (vista.txtAsignatura.getText().isEmpty()
                    || vista.txtAsignatura.getText().equals(vista.txtAsignatura.getPlaceHolder())
                    || vista.txtPeso.getText().isEmpty()
                    || vista.txtPeso.getText().equals(vista.txtPeso.getPlaceHolder())) {
                vista.txtAsignatura.setText(vista.txtAsignatura.getPlaceHolder());
                vista.txtAsignatura.setForeground(Color.GRAY);
                //vista.comboboxArea.setSelectedIndex(0);
                vista.txtPeso.setText(vista.txtPeso.getPlaceHolder());
                vista.txtPeso.setForeground(Color.GRAY);
            }
        }

    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

}
