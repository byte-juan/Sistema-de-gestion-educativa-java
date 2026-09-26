package alertas;

import java.awt.Image;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MensajeInformacion extends javax.swing.JDialog {

    public MensajeInformacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setImageLabel(img, "imagenes/cheque.png");
    }

    public MensajeInformacion(JDialog parent, boolean modal) {
        initComponents();
        setImageLabel(img, "imagenes/cheque.png");
    }

    public MensajeInformacion(JPanel parent, boolean modal) {
        initComponents();
        setImageLabel(img, "imagenes/cheque.png");
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
        contenedor = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        img = new javax.swing.JLabel();
        myButton1 = new principal.MyButton();
        etiquetaMensaje = new javax.swing.JLabel();

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
        fondo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fondoMouseClicked(evt);
            }
        });

        contenedor.setBackground(new java.awt.Color(255, 255, 255));
        contenedor.setPreferredSize(new java.awt.Dimension(500, 200));
        contenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("¡Registrado!");
        titulo.setToolTipText("");
        titulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        contenedor.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 500, -1));

        img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        img.setText("IMAGEN");
        img.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        contenedor.add(img, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 100, 100));

        myButton1.setBackground(new java.awt.Color(255, 255, 255));
        myButton1.setForeground(new java.awt.Color(0, 0, 0));
        myButton1.setText("X");
        myButton1.setColorHover(new java.awt.Color(220, 53, 69));
        myButton1.setColorNormal(new java.awt.Color(255, 255, 255));
        myButton1.setColorTextNormal(new java.awt.Color(0, 0, 0));
        myButton1.setFocusable(false);
        myButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });
        contenedor.add(myButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 40, -1));

        etiquetaMensaje.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etiquetaMensaje.setForeground(new java.awt.Color(153, 153, 153));
        etiquetaMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaMensaje.setText("El grupo ha sido registrado.");
        contenedor.add(etiquetaMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 500, -1));

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(fondo, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_myButton1ActionPerformed

    private void fondoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fondoMouseClicked

    }//GEN-LAST:event_fondoMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_formMouseClicked

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        // TODO add your handling code here:
        int tecla = evt.getKeyChar();
        if (tecla == 10) {
            this.dispose();
        }
    }//GEN-LAST:event_formKeyTyped

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MensajeInformacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MensajeInformacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MensajeInformacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MensajeInformacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MensajeInformacion dialog = new MensajeInformacion(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel contenedor;
    public javax.swing.JLabel etiquetaMensaje;
    public javax.swing.JPanel fondo;
    public javax.swing.JLabel img;
    public principal.MyButton myButton1;
    public javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
