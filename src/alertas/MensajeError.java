package alertas;

import java.awt.Image;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MensajeError extends javax.swing.JDialog {

    public MensajeError(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        btnCerrar.setVisible(false);
        setImageLabel(img, "imagenes/error.png");
    }

    public MensajeError(JDialog parent, boolean modal) {
        initComponents();
        btnCerrar.setVisible(false);
        setImageLabel(img, "imagenes/error.png");
    }

    public MensajeError(JPanel parent, boolean modal) {
        initComponents();
        btnCerrar.setVisible(false);
        setImageLabel(img, "imagenes/error.png");
    }

    private void setImageLabel(JLabel label, String ruta) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(ruta);        

        if (resource != null) {
            ImageIcon image = new ImageIcon(resource);
            Icon icon = new ImageIcon(
                    image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH)
            );
            label.setText(null);
            label.setBorder(null);
            label.setIcon(icon);
            this.repaint();
        } else {
            System.err.println("No se pudo cargar el recurso: " + ruta);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        fondo = new javax.swing.JPanel();
        mensaje = new javax.swing.JPanel();
        img = new javax.swing.JLabel();
        btnCerrar = new principal.MyButton();
        jLabel1 = new javax.swing.JLabel();
        btnAceptar = new principal.MyButton();
        etiquetaMensaje1 = new javax.swing.JLabel();
        etiquetaMensaje2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        fondo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.setPreferredSize(new java.awt.Dimension(500, 300));
        fondo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fondoMouseClicked(evt);
            }
        });
        fondo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fondoKeyTyped(evt);
            }
        });

        mensaje.setBackground(new java.awt.Color(255, 255, 255));
        mensaje.setLayout(null);

        img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        img.setText("IMAGEN");
        img.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mensaje.add(img);
        img.setBounds(210, 30, 80, 80);

        btnCerrar.setBackground(new java.awt.Color(255, 255, 255));
        btnCerrar.setForeground(new java.awt.Color(0, 0, 0));
        btnCerrar.setText("X");
        btnCerrar.setColorHover(new java.awt.Color(220, 53, 69));
        btnCerrar.setColorNormal(new java.awt.Color(255, 255, 255));
        btnCerrar.setColorTextNormal(new java.awt.Color(0, 0, 0));
        btnCerrar.setFocusable(false);
        btnCerrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        mensaje.add(btnCerrar);
        btnCerrar.setBounds(460, 0, 40, 30);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Error");
        mensaje.add(jLabel1);
        jLabel1.setBounds(0, 120, 500, 32);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        mensaje.add(btnAceptar);
        btnAceptar.setBounds(200, 200, 100, 30);

        etiquetaMensaje1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etiquetaMensaje1.setForeground(new java.awt.Color(153, 153, 153));
        etiquetaMensaje1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaMensaje1.setText("¡No se permiten campos vacíos!");
        mensaje.add(etiquetaMensaje1);
        etiquetaMensaje1.setBounds(0, 160, 500, 25);

        etiquetaMensaje2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etiquetaMensaje2.setForeground(new java.awt.Color(153, 153, 153));
        etiquetaMensaje2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mensaje.add(etiquetaMensaje2);
        etiquetaMensaje2.setBounds(0, 190, 500, 25);

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = -40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(fondo, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fondoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fondoMouseClicked

    }//GEN-LAST:event_fondoMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_formMouseClicked

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_formKeyTyped

    private void fondoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fondoKeyTyped
        // TODO add your handling code here:
        int tecla = evt.getKeyChar();
        if (tecla == 10) {
            this.dispose();
        }
    }//GEN-LAST:event_fondoKeyTyped

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MensajeError.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MensajeError.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MensajeError.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MensajeError.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MensajeError dialog = new MensajeError(new javax.swing.JFrame(), true);
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
    public principal.MyButton btnAceptar;
    public principal.MyButton btnCerrar;
    public javax.swing.JLabel etiquetaMensaje1;
    public javax.swing.JLabel etiquetaMensaje2;
    public javax.swing.JPanel fondo;
    public javax.swing.JLabel img;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel mensaje;
    // End of variables declaration//GEN-END:variables
}
