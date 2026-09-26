package controlador;

import alertas.MensajeAdvertencia;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import principal.Dashboard;
import principal.Login;
import principal.MyButton;
import vista.Areas;
import vista.Asignaturas;
import vista.Calificaciones;
import vista.Clases;
import vista.Desempeño;
import vista.Estudiantes;
import vista.Grupos;
import vista.Inicio;
import vista.Profesores;

public class ControladorPrincipal implements ActionListener {

    private final Dashboard dashboard;

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorPrincipal(Dashboard dashboard) {
        this.dashboard = dashboard;
        this.dashboard.btnInicio.addActionListener(this);
        this.dashboard.btnGrupos.addActionListener(this);
        this.dashboard.btnEstudiantes.addActionListener(this);
        this.dashboard.btnProfesores.addActionListener(this);
        this.dashboard.btnAreas.addActionListener(this);
        this.dashboard.btnAsignaturas.addActionListener(this);
        this.dashboard.btnDesempeño.addActionListener(this);
        this.dashboard.btnCalificaciones.addActionListener(this);
        this.dashboard.btnCerrarSesion.addActionListener(this);
        this.dashboard.btnClases.addActionListener(this);
        iniciar();

    }

    public void mostrarAdvertencia(String texto) {
        MensajeAdvertencia mensaje = new MensajeAdvertencia(dashboard, true);
        mensaje.titulo.setText(texto);
        mensaje.setSize(dashboard.getSize());
        mensaje.setLocationRelativeTo(dashboard);
        mensaje.setBackground(new Color(0, 0, 0, 75));
        mensaje.fondo.setBackground(new Color(0, 0, 0, 75));
        mensaje.setVisible(true);
    }

    private void iniciar() {
        dashboard.setVisible(true);
        dashboard.btnInicio.setSelected(true);

        if (dashboard.btnInicio.isSelected()) {
            dashboard.btnInicio.setBackground(new Color(23, 86, 197));
            mostrarPanel(new Inicio());
        }
    }

    public static void mostrarPanel(JPanel p) {
        p.setSize(780, 430);
        p.setLocation(0, 0);
        Dashboard.contenido.removeAll();
        Dashboard.contenido.add(p, BorderLayout.CENTER);
        Dashboard.contenido.revalidate();
        Dashboard.contenido.repaint();
    }

    //<editor-fold defaultstate="collapsed" desc="metodo resetearBotones">
    private void resetearBotones() {
        MyButton[] botones = {
            dashboard.btnInicio,
            dashboard.btnGrupos,
            dashboard.btnEstudiantes,
            dashboard.btnProfesores,
            dashboard.btnAreas,
            dashboard.btnAsignaturas,
            dashboard.btnClases,
            dashboard.btnDesempeño,
            dashboard.btnCalificaciones
        };

        for (MyButton boton : botones) {
            boton.setSelected(false);
            boton.setBackground(boton.getColorNormal());
        }

    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="metodo activarBoton"> 
    private void activarBoton(MyButton b) {
        resetearBotones();
        String opcion = b.getText();
        switch (opcion) {
            case "Inicio":
                dashboard.btnInicio.setSelected(true);
                dashboard.btnInicio.setBackground(new Color(23, 86, 197));
                break;

            case "Grupos":
                dashboard.btnGrupos.setSelected(true);
                dashboard.btnGrupos.setBackground(new Color(23, 86, 197));
                break;

            case "Estudiantes":
                dashboard.btnEstudiantes.setSelected(true);
                dashboard.btnEstudiantes.setBackground(new Color(23, 86, 197));
                break;
                
            case "Profesores":
                dashboard.btnProfesores.setSelected(true);
                dashboard.btnProfesores.setBackground(new Color(23, 86, 197));
                break;
                
            case "Areas":
                dashboard.btnAreas.setSelected(true);
                dashboard.btnAreas.setBackground(new Color(23, 86, 197));
                break;
                
            case "Asignaturas":
                dashboard.btnAsignaturas.setSelected(true);
                dashboard.btnAsignaturas.setBackground(new Color(23, 86, 197));
                break;
                
            case "Desempeño":
                dashboard.btnDesempeño.setSelected(true);
                dashboard.btnDesempeño.setBackground(new Color(23, 86, 197));
                break;
                
            case "Calificaciones":
                dashboard.btnCalificaciones.setSelected(true);
                dashboard.btnCalificaciones.setBackground(new Color(23, 86, 197));
                break;
                
            case "Clases":
                dashboard.btnClases.setSelected(true);
                dashboard.btnClases.setBackground(new Color(23, 86, 197));
                break;                

        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodo actionPerformed"> 
    @Override
    public void actionPerformed(ActionEvent e) {
        String opcion = e.getActionCommand();
        switch (opcion) {
            case "Inicio":
                mostrarPanel(new Inicio());
                activarBoton(dashboard.btnInicio);
                break;

            case "Grupos":
                mostrarPanel(new Grupos());
                activarBoton(dashboard.btnGrupos);

                break;
            case "Estudiantes":
                mostrarPanel(new Estudiantes());
                activarBoton(dashboard.btnEstudiantes);
                break;
            case "Profesores":
                mostrarPanel(new Profesores());
                activarBoton(dashboard.btnProfesores);
                break;
            case "Areas":
                mostrarPanel(new Areas());
                activarBoton(dashboard.btnAreas);
                break;

            case "Asignaturas":
                mostrarPanel(new Asignaturas());
                activarBoton(dashboard.btnAsignaturas);
                break;
            case "Desempeño":
                mostrarPanel(new Desempeño());
                activarBoton(dashboard.btnDesempeño);
                break;
            case "Calificaciones":
                mostrarPanel(new Calificaciones());
                activarBoton(dashboard.btnCalificaciones);
                break;
            case "Clases":
                mostrarPanel(new Clases());
                activarBoton(dashboard.btnClases);
                break;
            case "Cerrar sesión":
                //mostrarAdvertencia("¿Desea finalizar la sesión?");

                dashboard.dispose();
                Login login = new Login();
                login.setVisible(true);

                break;

        }

    }
    // </editor-fold>

}
