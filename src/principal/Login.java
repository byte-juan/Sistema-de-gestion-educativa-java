package principal;

import controlador.ControladorLogin;
import javax.swing.ImageIcon;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        ControladorLogin controladorLogin = new ControladorLogin(this);
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/birrete_verde.png")).getImage());
//        ImageIcon icon = new ImageIcon("src\\imagenes\\birrete-blanco.png");
//        this.setIconImage(icon.getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCerrar = new principal.MyButton();
        titulo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnIniciarSesion = new principal.MyButton();
        jLabel2 = new javax.swing.JLabel();
        checkbox = new javax.swing.JCheckBox();
        contraseña = new principal.MyPasswordField();
        usuario = new principal.MyTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ok");
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCerrar.setBackground(new java.awt.Color(255, 255, 255));
        btnCerrar.setForeground(new java.awt.Color(0, 0, 0));
        btnCerrar.setText("X");
        btnCerrar.setColorHover(new java.awt.Color(220, 53, 69));
        btnCerrar.setColorNormal(new java.awt.Color(255, 255, 255));
        btnCerrar.setColorTextNormal(new java.awt.Color(0, 0, 0));
        btnCerrar.setFocusable(false);
        btnCerrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 2, 40, -1));

        titulo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Inicio de sesión");
        jPanel1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 500, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 150, -1, -1));

        btnIniciarSesion.setText("Iniciar sesión");
        jPanel1.add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/llave.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 215, -1, -1));

        checkbox.setBackground(new java.awt.Color(255, 255, 255));
        checkbox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkbox.setText("Mostrar contraseña");
        checkbox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        checkbox.setFocusable(false);
        jPanel1.add(checkbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, -1, -1));

        contraseña.setCaretPosition(0);
        contraseña.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        contraseña.setNextFocusableComponent(usuario);
        jPanel1.add(contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, -1, -1));

        usuario.setText("Usuario");
        usuario.setToolTipText("");
        usuario.setCaretPosition(0);
        usuario.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        usuario.setPlaceHolder("Usuario");
        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });
        jPanel1.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 145, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioActionPerformed

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        
        }
        
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
     
        });
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public principal.MyButton btnCerrar;
    public principal.MyButton btnIniciarSesion;
    public javax.swing.JCheckBox checkbox;
    public principal.MyPasswordField contraseña;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel titulo;
    public principal.MyTextField usuario;
    // End of variables declaration//GEN-END:variables
}
