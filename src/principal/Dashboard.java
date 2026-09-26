package principal;

import controlador.ControladorPrincipal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UnsupportedLookAndFeelException;

public class Dashboard extends javax.swing.JFrame {

    public Dashboard() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ControladorPrincipal controladorPrincipal = new ControladorPrincipal(this);       
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/birrete_verde.png")).getImage());
        this.setTitle("Schooltool");                
        SetDate();
    }

    private void SetDate() {
        LocalDate now = LocalDate.now();
        Locale spanishLocale = new Locale("es", "ES");
        fecha.setText(now.format(DateTimeFormatter.ofPattern("'Hoy es' EEEE dd 'de' MMMM 'de' yyyy", spanishLocale)));
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            System.out.println(e.getMessage());
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnInicio = new principal.MyButton();
        btnGrupos = new principal.MyButton();
        btnEstudiantes = new principal.MyButton();
        btnProfesores = new principal.MyButton();
        btnAreas = new principal.MyButton();
        btnAsignaturas = new principal.MyButton();
        btnDesempeño = new principal.MyButton();
        btnCalificaciones = new principal.MyButton();
        btnClases = new principal.MyButton();
        btnCerrarSesion = new principal.MyButton();
        jSeparator2 = new javax.swing.JSeparator();
        header = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        contenido = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1020, 680));

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setMinimumSize(new java.awt.Dimension(1020, 640));
        background.setPreferredSize(new java.awt.Dimension(1020, 640));

        menu.setBackground(new java.awt.Color(9, 72, 179));
        menu.setPreferredSize(new java.awt.Dimension(240, 640));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SCHOOLTOOL");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnInicio.setBackground(new java.awt.Color(9, 72, 179));
        btnInicio.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 1));
        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hogar.png"))); // NOI18N
        btnInicio.setText("Inicio");
        btnInicio.setColorHover(new java.awt.Color(23, 86, 197));
        btnInicio.setColorNormal(new java.awt.Color(9, 72, 179));
        btnInicio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInicio.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnInicio.setIconTextGap(10);

        btnGrupos.setBackground(new java.awt.Color(9, 72, 179));
        btnGrupos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 1));
        btnGrupos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/grupo.png"))); // NOI18N
        btnGrupos.setText("Grupos");
        btnGrupos.setColorHover(new java.awt.Color(23, 86, 197));
        btnGrupos.setColorNormal(new java.awt.Color(9, 72, 179));
        btnGrupos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGrupos.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnGrupos.setIconTextGap(10);

        btnEstudiantes.setBackground(new java.awt.Color(9, 72, 179));
        btnEstudiantes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 1));
        btnEstudiantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/graduado-gordo.png"))); // NOI18N
        btnEstudiantes.setText("Estudiantes");
        btnEstudiantes.setColorHover(new java.awt.Color(23, 86, 197));
        btnEstudiantes.setColorNormal(new java.awt.Color(9, 72, 179));
        btnEstudiantes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEstudiantes.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnEstudiantes.setIconTextGap(10);

        btnProfesores.setBackground(new java.awt.Color(9, 72, 179));
        btnProfesores.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 1));
        btnProfesores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/profesor.png"))); // NOI18N
        btnProfesores.setText("Profesores");
        btnProfesores.setColorHover(new java.awt.Color(23, 86, 197));
        btnProfesores.setColorNormal(new java.awt.Color(9, 72, 179));
        btnProfesores.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnProfesores.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnProfesores.setIconTextGap(10);

        btnAreas.setBackground(new java.awt.Color(9, 72, 179));
        btnAreas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 1));
        btnAreas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atomico.png"))); // NOI18N
        btnAreas.setText("Areas");
        btnAreas.setColorHover(new java.awt.Color(23, 86, 197));
        btnAreas.setColorNormal(new java.awt.Color(9, 72, 179));
        btnAreas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAreas.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnAreas.setIconTextGap(10);

        btnAsignaturas.setBackground(new java.awt.Color(9, 72, 179));
        btnAsignaturas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 1));
        btnAsignaturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/libros2.png"))); // NOI18N
        btnAsignaturas.setText("Asignaturas");
        btnAsignaturas.setColorHover(new java.awt.Color(23, 86, 197));
        btnAsignaturas.setColorNormal(new java.awt.Color(9, 72, 179));
        btnAsignaturas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAsignaturas.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnAsignaturas.setIconTextGap(10);

        btnDesempeño.setBackground(new java.awt.Color(9, 72, 179));
        btnDesempeño.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 1));
        btnDesempeño.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/insignia.png"))); // NOI18N
        btnDesempeño.setText("Desempeño");
        btnDesempeño.setColorHover(new java.awt.Color(23, 86, 197));
        btnDesempeño.setColorNormal(new java.awt.Color(9, 72, 179));
        btnDesempeño.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDesempeño.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnDesempeño.setIconTextGap(10);

        btnCalificaciones.setBackground(new java.awt.Color(9, 72, 179));
        btnCalificaciones.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 1));
        btnCalificaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calificacion.png"))); // NOI18N
        btnCalificaciones.setText("Calificaciones");
        btnCalificaciones.setColorHover(new java.awt.Color(23, 86, 197));
        btnCalificaciones.setColorNormal(new java.awt.Color(9, 72, 179));
        btnCalificaciones.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCalificaciones.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnCalificaciones.setIconTextGap(10);

        btnClases.setBackground(new java.awt.Color(9, 72, 179));
        btnClases.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 1));
        btnClases.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asignar.png"))); // NOI18N
        btnClases.setText("Clases");
        btnClases.setToolTipText("");
        btnClases.setColorHover(new java.awt.Color(23, 86, 197));
        btnClases.setColorNormal(new java.awt.Color(9, 72, 179));
        btnClases.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClases.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnClases.setIconTextGap(10);

        btnCerrarSesion.setBackground(new java.awt.Color(9, 72, 179));
        btnCerrarSesion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 1));
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar_sesion.png"))); // NOI18N
        btnCerrarSesion.setText("Cerrar sesión");
        btnCerrarSesion.setColorHover(new java.awt.Color(23, 86, 197));
        btnCerrarSesion.setColorNormal(new java.awt.Color(9, 72, 179));
        btnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCerrarSesion.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnCerrarSesion.setIconTextGap(10);

        jSeparator2.setPreferredSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnAreas, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnAsignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnClases, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnDesempeño, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnCalificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(78, 78, 78)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnAreas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnAsignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnClases, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnDesempeño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnCalificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        header.setBackground(new java.awt.Color(25, 118, 210));
        header.setPreferredSize(new java.awt.Dimension(780, 150));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Administración");

        fecha.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        fecha.setForeground(new java.awt.Color(255, 255, 255));
        fecha.setText("Hoy es {dayname} {day} de {month} de {year}");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fecha)
                    .addComponent(jLabel2))
                .addContainerGap(287, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addComponent(fecha)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        contenido.setBackground(new java.awt.Color(255, 255, 255));
        contenido.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
                    .addComponent(contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    public principal.MyButton btnAreas;
    public principal.MyButton btnAsignaturas;
    public principal.MyButton btnCalificaciones;
    public principal.MyButton btnCerrarSesion;
    public principal.MyButton btnClases;
    public principal.MyButton btnDesempeño;
    public principal.MyButton btnEstudiantes;
    public principal.MyButton btnGrupos;
    public principal.MyButton btnInicio;
    public principal.MyButton btnProfesores;
    public static javax.swing.JPanel contenido;
    private javax.swing.JLabel fecha;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel menu;
    // End of variables declaration//GEN-END:variables
}
