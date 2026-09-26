package vistassecundarias;

import controladorsecundario.ControladorOpcionesDesempeño;
import modelo.Desempeño;

public class OpcionesDesempeño extends javax.swing.JPanel {

    Desempeño desempeño;

    public OpcionesDesempeño() {
        initComponents();
        ControladorOpcionesDesempeño controladorOpcionesDesempeño = new ControladorOpcionesDesempeño(this);
    }
    
    public OpcionesDesempeño(Desempeño desempeño){
        initComponents();
        this.desempeño = desempeño;
        ControladorOpcionesDesempeño controladorOpcionesDesempeño = new ControladorOpcionesDesempeño(this,desempeño);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnRegistrar = new principal.MyButton();
        comboboxAsignatura = new javax.swing.JComboBox<>();
        comboboxPeriodo = new javax.swing.JComboBox<>();
        comboboxGrado = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSuperior = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        btnVolver = new principal.MyButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtAlto = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtBasico = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtBajo = new javax.swing.JTextArea();
        comboboxGrupo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();

        setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setPreferredSize(new java.awt.Dimension(780, 430));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        titulo.setText("Registrar nuevo desempeño");
        background.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Asignatura:");
        background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Periodo:");
        background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Grado:");
        background.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Descripcion:");
        background.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        background.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 50, 10, 360));

        btnRegistrar.setText("Registrar");
        background.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 271, 35));

        comboboxAsignatura.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        background.add(comboboxAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 271, 30));

        comboboxPeriodo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        background.add(comboboxPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 271, 30));

        comboboxGrado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        background.add(comboboxGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 271, 30));

        txtSuperior.setEditable(false);
        txtSuperior.setColumns(20);
        txtSuperior.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSuperior.setLineWrap(true);
        txtSuperior.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtSuperior);

        background.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 51, 272, 77));

        jScrollPane3.setToolTipText("");
        jScrollPane3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtDescripcion.setColumns(20);
        txtDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        jScrollPane3.setViewportView(txtDescripcion);

        background.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 271, 60));

        btnVolver.setBackground(new java.awt.Color(233, 30, 99));
        btnVolver.setText("Volver");
        btnVolver.setColorHover(new java.awt.Color(216, 27, 96));
        btnVolver.setColorNormal(new java.awt.Color(233, 30, 99));
        background.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 375, 271, 35));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Desempeño superior:");
        background.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 31, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Desempeño alto:");
        background.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 128, -1, -1));

        txtAlto.setEditable(false);
        txtAlto.setColumns(20);
        txtAlto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAlto.setLineWrap(true);
        txtAlto.setWrapStyleWord(true);
        jScrollPane4.setViewportView(txtAlto);

        background.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 148, 272, 77));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Desempeño básico:");
        background.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 225, -1, -1));

        txtBasico.setEditable(false);
        txtBasico.setColumns(20);
        txtBasico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBasico.setLineWrap(true);
        txtBasico.setWrapStyleWord(true);
        jScrollPane5.setViewportView(txtBasico);

        background.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 245, 272, 77));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Desempeño bajo:");
        background.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 322, -1, -1));

        txtBajo.setEditable(false);
        txtBajo.setColumns(20);
        txtBajo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBajo.setLineWrap(true);
        txtBajo.setWrapStyleWord(true);
        jScrollPane6.setViewportView(txtBajo);

        background.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 342, 272, 77));

        comboboxGrupo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        background.add(comboboxGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 270, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Grupo:");
        background.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    public principal.MyButton btnRegistrar;
    public principal.MyButton btnVolver;
    public javax.swing.JComboBox<Object> comboboxAsignatura;
    public javax.swing.JComboBox<Object> comboboxGrado;
    public javax.swing.JComboBox<Object> comboboxGrupo;
    public javax.swing.JComboBox<Object> comboboxPeriodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel titulo;
    public javax.swing.JTextArea txtAlto;
    public javax.swing.JTextArea txtBajo;
    public javax.swing.JTextArea txtBasico;
    public javax.swing.JTextArea txtDescripcion;
    public javax.swing.JTextArea txtSuperior;
    // End of variables declaration//GEN-END:variables
}
