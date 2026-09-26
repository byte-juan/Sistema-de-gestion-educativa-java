package vistassecundarias;

import modelo.Asignatura;

public class OpcionesAsignatura extends javax.swing.JPanel {

    Asignatura asignatura;

    public OpcionesAsignatura() {
        initComponents();        
        //ControladorOpcionesAsignatura controladorOpcionesAsignatura = new ControladorOpcionesAsignatura(this);

    }

    public OpcionesAsignatura(Asignatura asignatura) {
        initComponents();
        this.asignatura = asignatura;
       // ControladorOpcionesAsignatura controladorOpcionesAsignatura = new ControladorOpcionesAsignatura(this, asignatura);
    }

    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        btnRegistrar = new principal.MyButton();
        jLabel1 = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        comboboxArea = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboboxProfesor = new javax.swing.JComboBox<>();
        btnVolver = new principal.MyButton();

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setPreferredSize(new java.awt.Dimension(780, 430));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegistrar.setText("Registrar");
        background.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 250, 35));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Area:");
        background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        titulo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        titulo.setText("Registrar nueva asignatura");
        background.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        comboboxArea.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        background.add(comboboxArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 250, 35));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nombre:");
        background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Profesor:");
        background.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        comboboxProfesor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        background.add(comboboxProfesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 250, 35));

        btnVolver.setBackground(new java.awt.Color(233, 30, 99));
        btnVolver.setText("Volver");
        btnVolver.setColorHover(new java.awt.Color(216, 27, 96));
        btnVolver.setColorNormal(new java.awt.Color(233, 30, 99));
        background.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 305, 250, 35));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel background;
    public principal.MyButton btnRegistrar;
    public principal.MyButton btnVolver;
    public javax.swing.JComboBox<Object> comboboxArea;
    public javax.swing.JComboBox<Object> comboboxProfesor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
