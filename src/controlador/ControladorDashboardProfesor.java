
    package controlador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import principal.Login;
import principal.MyButton;
import vista.Asignaturas;
import vista.Calificaciones;
import vista.DashboardPrueba;
import vista.Desempeño;
import vista.Estudiantes;
import vista.Inicio;

public class ControladorDashboardProfesor implements ActionListener {

    private final DashboardPrueba dashboard;

    public ControladorDashboardProfesor(DashboardPrueba dashboard) {

        this.dashboard = dashboard;

        this.dashboard.btnInicio.addActionListener(this);
        this.dashboard.btnEstudiantes.addActionListener(this);
        this.dashboard.btnAsignaturas.addActionListener(this);
        this.dashboard.btnDesempeño.addActionListener(this);
        this.dashboard.btnCalificaciones.addActionListener(this);
        this.dashboard.btnCerrarSesion.addActionListener(this);

        iniciar();
    }

    private void iniciar() {

        dashboard.setVisible(true);

        dashboard.btnInicio.setBackground(new Color(23, 86, 197));

        mostrarPanel(new Inicio());
    }

    public static void mostrarPanel(JPanel p) {

        p.setSize(780, 430);
        p.setLocation(0, 0);

        DashboardPrueba.contenido.removeAll();
        DashboardPrueba.contenido.add(p, BorderLayout.CENTER);
        DashboardPrueba.contenido.revalidate();
        DashboardPrueba.contenido.repaint();
    }

    private void resetearBotones() {

        MyButton[] botones = {

            dashboard.btnInicio,
            dashboard.btnEstudiantes,
            dashboard.btnAsignaturas,
            dashboard.btnDesempeño,
            dashboard.btnCalificaciones

        };

        for (MyButton boton : botones) {

            boton.setBackground(boton.getColorNormal());
        }
    }

    private void activarBoton(MyButton boton) {

        resetearBotones();

        boton.setBackground(new Color(23, 86, 197));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String opcion = e.getActionCommand();

        switch (opcion) {

            case "Inicio":

                mostrarPanel(new Inicio());
                activarBoton(dashboard.btnInicio);

                break;

            case "Estudiantes":

                mostrarPanel(new Estudiantes());
                activarBoton(dashboard.btnEstudiantes);

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

            case "Cerrar sesión":

                dashboard.dispose();

                Login login = new Login();
                login.setVisible(true);

                break;
        }
    }
}

