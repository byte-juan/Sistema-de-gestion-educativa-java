package vistassecundarias;

import controladorsecundario.ControladorModalOpcionesAsignatura;
import java.awt.Frame;
import modelo.Asignatura;

public class ModalOpcionesAsignatura extends javax.swing.JDialog {

    private Asignatura asignatura;

    public ModalOpcionesAsignatura(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ControladorModalOpcionesAsignatura controladorModalOpcionesAsignatura = new ControladorModalOpcionesAsignatura(this);

    }

    public ModalOpcionesAsignatura(Frame parent, boolean modal, Asignatura asignatura) {
        super(parent, modal);
        this.asignatura = asignatura;
        initComponents();
        ControladorModalOpcionesAsignatura controladorModalOpcionesAsignatura = new ControladorModalOpcionesAsignatura(this, asignatura);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        fondo = new javax.swing.JPanel();
        formulario = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        btnX = new principal.MyButton();
        jLabel2 = new javax.swing.JLabel();
        comboboxArea = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtAsignatura = new principal.MyTextField();
        btnRegistrar = new principal.MyButton();
        btnCerrar = new principal.MyButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        txtPeso = new principal.MyTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        fondo.setBackground(new java.awt.Color(255, 255, 255));

        formulario.setBackground(new java.awt.Color(255, 255, 255));
        formulario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(13, 110, 253));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Registrar nueva asignatura");
        header.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 9, 360, -1));

        btnX.setText("X");
        btnX.setColorHover(new java.awt.Color(13, 110, 253));
        btnX.setColorTextHover(new java.awt.Color(0, 0, 0));
        btnX.setColorTextNormal(new java.awt.Color(240, 240, 240));
        btnX.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        header.add(btnX, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 5, 40, -1));

        formulario.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jLabel2.setText("Area:");
        formulario.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        comboboxArea.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        formulario.add(comboboxArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 200, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jLabel3.setText("Asignatura:");
        formulario.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        txtAsignatura.setText("Nombre de la asignatura");
        txtAsignatura.setCaretPosition(0);
        txtAsignatura.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        txtAsignatura.setPlaceHolder("Nombre de la asignatura");
        formulario.add(txtAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        btnRegistrar.setText("Registrar");
        formulario.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 100, 30));

        btnCerrar.setBackground(new java.awt.Color(233, 30, 99));
        btnCerrar.setText("Cerrar");
        btnCerrar.setColorHover(new java.awt.Color(216, 27, 96));
        btnCerrar.setColorNormal(new java.awt.Color(233, 30, 99));
        btnCerrar.setFocusable(false);
        formulario.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 100, 30));
        formulario.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 400, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jLabel4.setText("Peso:");
        formulario.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        txtPeso.setText("Valor de la asignatura");
        txtPeso.setCaretPosition(0);
        txtPeso.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        txtPeso.setNextFocusableComponent(comboboxArea);
        txtPeso.setPlaceHolder("Valor de la asignatura");
        txtPeso.setSoloNumeros(true);
        formulario.add(txtPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(formulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(formulario, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(fondo, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            //java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                ModalOpcionesAsignatura dialog = new ModalOpcionesAsignatura(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public principal.MyButton btnCerrar;
    public principal.MyButton btnRegistrar;
    public principal.MyButton btnX;
    public javax.swing.JComboBox<Object> comboboxArea;
    public javax.swing.JPanel fondo;
    private javax.swing.JPanel formulario;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel titulo;
    public principal.MyTextField txtAsignatura;
    public principal.MyTextField txtPeso;
    // End of variables declaration//GEN-END:variables
}
