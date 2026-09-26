package alertas;

import java.awt.Image;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MensajeAdvertencia extends javax.swing.JDialog {

    public static int ACEPTAR;

    public MensajeAdvertencia(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setImageLabel(img, "imagenes/advertencia.png");
    }

    public MensajeAdvertencia(JDialog parent, boolean modal) {
        initComponents();
        setImageLabel(img, "imagenes/advertencia.png");
    }

    public MensajeAdvertencia(JPanel parent, boolean modal) {
        initComponents();
        setImageLabel(img, "imagenes/advertencia.png");
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
        titulo = new javax.swing.JLabel();
        etiquetaMensaje = new javax.swing.JLabel();
        btnEliminar = new principal.MyButton();
        btnCancelar = new principal.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
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
        mensaje.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        img.setText("IMAGEN");
        img.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mensaje.add(img, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 100, 100));

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
        mensaje.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 40, -1));

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("¿Estás seguro?");
        mensaje.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 500, -1));

        etiquetaMensaje.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etiquetaMensaje.setForeground(new java.awt.Color(153, 153, 153));
        etiquetaMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaMensaje.setText("Se eliminara el grupo 01 del grado primero");
        mensaje.add(etiquetaMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 500, -1));

        btnEliminar.setBackground(new java.awt.Color(25, 135, 84));
        btnEliminar.setText("Si, ¡Eliminar!");
        btnEliminar.setColorHover(new java.awt.Color(21, 115, 71));
        btnEliminar.setColorNormal(new java.awt.Color(25, 135, 84));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        mensaje.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 120, 30));

        btnCancelar.setBackground(new java.awt.Color(220, 53, 69));
        btnCancelar.setText("No, ¡Cancelar!");
        btnCancelar.setColorHover(new java.awt.Color(187, 45, 59));
        btnCancelar.setColorNormal(new java.awt.Color(220, 53, 69));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        mensaje.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 120, 30));

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(fondo, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fondoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fondoMouseClicked

    }//GEN-LAST:event_fondoMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        ACEPTAR = 0;
        this.dispose();
    }//GEN-LAST:event_formMouseClicked

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        ACEPTAR = 0;
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void fondoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fondoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_fondoKeyTyped

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        ACEPTAR = 1;
        this.dispose();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        ACEPTAR = 0;
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(MensajeAdvertencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MensajeAdvertencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MensajeAdvertencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MensajeAdvertencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MensajeAdvertencia dialog = new MensajeAdvertencia(new javax.swing.JFrame(), true);
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
    public principal.MyButton btnCancelar;
    public principal.MyButton btnCerrar;
    public principal.MyButton btnEliminar;
    public javax.swing.JLabel etiquetaMensaje;
    public javax.swing.JPanel fondo;
    public javax.swing.JLabel img;
    private javax.swing.JPanel mensaje;
    public javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
