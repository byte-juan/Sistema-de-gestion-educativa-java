package controlador;

import alertas.MensajeError;
import db.Conexion;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Profesor;
import principal.Dashboard;
import principal.Login;
import vista.DashboardPrueba;
import static vista.Inicio.titulo;

public class ControladorLogin implements ActionListener, KeyListener {

    private final Login vista;
    public static String TITULO_BIENVENIDA;
    private boolean bandera = false;

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorLogin(Login vista) {
        this.vista = vista;
        this.vista.btnIniciarSesion.addActionListener(this);
        this.vista.btnCerrar.addActionListener(this);
        this.vista.checkbox.addActionListener(this);
        this.vista.addKeyListener(this);
        this.vista.contraseña.addKeyListener(this);
        this.vista.usuario.addKeyListener(this);

    }

    //<editor-fold defaultstate="collapsed" desc="metodo para mostrar mensaje de error" >
    public void mostrarError(String texto) {
        MensajeError mensaje = new MensajeError(vista, true);
        mensaje.etiquetaMensaje1.setText(texto);
        mensaje.setSize(vista.getSize());
        mensaje.setLocationRelativeTo(vista);
        mensaje.setBackground(new Color(0, 0, 0, 75));
        mensaje.fondo.setBackground(new Color(0, 0, 0, 75));
        mensaje.setVisible(true);
    }
    //</editor-fold>    

    private boolean iniciarSesion() {
        Conexion objConexion = new Conexion();
        String usuario = vista.usuario.getText();
        char[] contraseña;
        contraseña = vista.contraseña.getPassword();

        String sql = "SELECT profesor.id,profesor.nombre,profesor.nombre2,profesor.apellido,profesor.apellido2,profesor.sexo,profesor.usuario,\n"
                + "profesor.contraseña,profesor.rol_id,rol.nombre AS rol\n"
                + "FROM profesor,rol\n"
                + "WHERE profesor.rol_id = rol.id\n"
                + "AND profesor.usuario =?\n"
                + "GROUP BY(profesor.id)";

        try {

            Profesor profesor = new Profesor();
            System.out.println("hasta aqui ejecuta");
            objConexion.conectar();
            System.out.println("luego de la conexión");
            PreparedStatement ps = objConexion.conexion.prepareStatement(sql);
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            if (usuario.equals("") || contraseña.length == 0 || usuario.equals(vista.usuario.getPlaceHolder())
                    || Arrays.equals(contraseña, vista.contraseña.getPlaceHolder().toCharArray())) {
                mostrarError("Ingresa todos los campos.");
                bandera = true;
            } else if (rs.next()) {

                profesor.setId(rs.getInt("id"));
                profesor.setNombre(rs.getString("nombre"));
                profesor.setNombre2(rs.getString("nombre2"));
                profesor.setApellido(rs.getString("apellido"));
                profesor.setApellido2(rs.getString("apellido2"));
                profesor.setSexo(rs.getString("sexo"));
                profesor.setUsuario(rs.getString("usuario"));
                profesor.setContraseña(rs.getString("contraseña"));
                profesor.setRol_id(rs.getInt("rol_id"));
                profesor.setNombreRol(rs.getString("rol"));

                if (Arrays.equals(contraseña, profesor.getContraseña().toCharArray())) {
                    if (profesor.getNombreRol().equals("Administrador")) {
                        String bienvenida = profesor.getSexo().equals("Masculino") ? "Bienvenido" : "Bienvenida";
                        String rol = profesor.getSexo().equals("Masculino") ? "administrador" : "administradora";
                        vista.dispose();
                        Dashboard dashboard = new Dashboard();
                        TITULO_BIENVENIDA = bienvenida + " " + rol + ", " + profesor.getNombre();
                        titulo.setText(TITULO_BIENVENIDA);
                        return true;

                    } else if (profesor.getNombreRol().equals("Profesor")) {
                        String bienvenida = profesor.getSexo().equals("Masculino") ? "Bienvenido" : "Bienvenida";
                        String rol = profesor.getSexo().equals("Masculino") ? "profesor" : "profesora";
                        vista.dispose();
                        DashboardPrueba dashboardPrueba = new DashboardPrueba();
                        dashboardPrueba.setVisible(true);
                        TITULO_BIENVENIDA = bienvenida + " " + rol + ", " + profesor.getNombre();
                        titulo.setText(TITULO_BIENVENIDA);
                        return true;

                    }

                } else {
                    mostrarError("Contraseña incorrecta.");
                    bandera = false;
                }

            } else {
                mostrarError("El usuario no existe.");
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println("ejemplo");
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        } finally {
            try {
                objConexion.cerrar();
            } catch (SQLException ex) {
                System.out.println("ejemplo");
                Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String opcion = ae.getActionCommand();
        switch (opcion) {
            case "Mostrar contraseña":
                if (Arrays.equals(vista.contraseña.getPlaceHolder().toCharArray(), vista.contraseña.getPassword())) {

                } else if (vista.checkbox.isSelected()) {
                    vista.contraseña.setEchoChar((char) 0);
                } else {
                    vista.contraseña.setEchoChar('*');
                }
                break;
            case "Iniciar sesión":
                iniciarSesion();
                break;
            case "X":
                System.exit(0);
                break;
        }

    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if (vista.checkbox.isSelected()) {
            vista.contraseña.setEchoChar((char) 0);
        } else if (!Arrays.equals(vista.contraseña.getPassword(), vista.contraseña.getPlaceHolder().toCharArray())) {
            vista.contraseña.setEchoChar('*');
        }

        if (ke.getKeyChar() == 10 && ke.getSource() == vista.contraseña) {
            iniciarSesion();
            if (bandera == true) {
                vista.contraseña.setText(vista.contraseña.getPlaceHolder());
                vista.contraseña.setEchoChar((char) 0);
                vista.contraseña.setForeground(Color.GRAY);
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
