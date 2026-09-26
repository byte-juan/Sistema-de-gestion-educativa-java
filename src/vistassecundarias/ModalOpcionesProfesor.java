package vistassecundarias;

import controladorsecundario.ControladorModalOpcionesProfesor;
import java.awt.Frame;
import modelo.Profesor;

public class ModalOpcionesProfesor extends javax.swing.JDialog {

    private Profesor profesor;

    public ModalOpcionesProfesor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ControladorModalOpcionesProfesor controladorModalOpcionesProfesor = new ControladorModalOpcionesProfesor(this);
    }

    public ModalOpcionesProfesor(Frame frame, boolean modal, Profesor profesor) {
        super(frame, modal);
        initComponents();
        this.profesor = profesor;
        ControladorModalOpcionesProfesor controladorModalOpcionesProfesor = new ControladorModalOpcionesProfesor(this,profesor);
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
        formulario1 = new javax.swing.JPanel();
        header1 = new javax.swing.JPanel();
        titulo1 = new javax.swing.JLabel();
        btnX1 = new principal.MyButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnRegistrar = new principal.MyButton();
        btnCerrar = new principal.MyButton();
        txtNombre = new principal.MyTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellido = new principal.MyTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellido2 = new principal.MyTextField();
        jLabel1 = new javax.swing.JLabel();
        comboboxSexo = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txtNombre2 = new principal.MyTextField();
        jLabel8 = new javax.swing.JLabel();
        txtUsuario = new principal.MyTextField();
        txtContraseña = new principal.MyTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        comboboxRol = new javax.swing.JComboBox<>();

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
        titulo.setText("Registrar nuevo profesor");
        header.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 9, 480, -1));

        btnX.setText("X");
        btnX.setColorHover(new java.awt.Color(13, 110, 253));
        btnX.setColorTextHover(new java.awt.Color(0, 0, 0));
        btnX.setColorTextNormal(new java.awt.Color(240, 240, 240));
        btnX.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        btnX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXActionPerformed(evt);
            }
        });
        header.add(btnX, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 5, 40, -1));

        formulario.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 50));

        formulario1.setBackground(new java.awt.Color(255, 255, 255));
        formulario1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header1.setBackground(new java.awt.Color(13, 110, 253));
        header1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        titulo1.setForeground(new java.awt.Color(255, 255, 255));
        titulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo1.setText("Registrar nuevo estudiante");
        header1.add(titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 9, 740, -1));

        btnX1.setText("X");
        btnX1.setColorHover(new java.awt.Color(13, 110, 253));
        btnX1.setColorTextHover(new java.awt.Color(0, 0, 0));
        btnX1.setColorTextNormal(new java.awt.Color(240, 240, 240));
        btnX1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        header1.add(btnX1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 5, 40, -1));

        formulario1.add(header1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jLabel4.setText("Nombre:");
        formulario1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jLabel5.setText("Segundo nombre:");
        formulario1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        btnRegistrar.setText("Registrar");
        formulario1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, 100, 30));

        btnCerrar.setBackground(new java.awt.Color(233, 30, 99));
        btnCerrar.setText("Cerrar");
        btnCerrar.setColorHover(new java.awt.Color(216, 27, 96));
        btnCerrar.setColorNormal(new java.awt.Color(233, 30, 99));
        btnCerrar.setFocusable(false);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        formulario1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 100, 30));

        txtNombre.setText("Ingrese el nombre");
        txtNombre.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        txtNombre.setNextFocusableComponent(txtNombre2);
        txtNombre.setPlaceHolder("Ingrese el nombre");
        formulario1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jLabel2.setText("Apellido:");
        formulario1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        txtApellido.setText("Ingrese el apellido");
        txtApellido.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        txtApellido.setNextFocusableComponent(txtApellido2);
        txtApellido.setPlaceHolder("Ingrese el apellido");
        formulario1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jLabel3.setText("Segundo apellido:");
        formulario1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        txtApellido2.setText("Ingrese el segundo apellido");
        txtApellido2.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        txtApellido2.setNextFocusableComponent(comboboxSexo);
        txtApellido2.setPlaceHolder("Ingrese el segundo apellido");
        formulario1.add(txtApellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jLabel1.setText("Sexo:");
        formulario1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));

        comboboxSexo.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        comboboxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el sexo", "Masculino", "Femenino" }));
        comboboxSexo.setNextFocusableComponent(txtUsuario);
        formulario1.add(comboboxSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 200, 30));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setToolTipText("");
        formulario1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, 230));
        formulario1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 520, -1));

        txtNombre2.setText("Ingrese el segundo nombre");
        txtNombre2.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        txtNombre2.setNextFocusableComponent(txtApellido);
        txtNombre2.setPlaceHolder("Ingrese el segundo nombre");
        formulario1.add(txtNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jLabel8.setText("Usuario:");
        formulario1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, -1));

        txtUsuario.setText("Ingrese el usuario");
        txtUsuario.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        txtUsuario.setNextFocusableComponent(txtContraseña);
        txtUsuario.setPlaceHolder("Ingrese el usuario");
        formulario1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));

        txtContraseña.setText("Ingrese la contraseña");
        txtContraseña.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        txtContraseña.setNextFocusableComponent(comboboxRol);
        txtContraseña.setPlaceHolder("Ingrese la contraseña");
        formulario1.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jLabel9.setText("Contraseña:");
        formulario1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jLabel10.setText("Rol:");
        formulario1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, -1, -1));

        comboboxRol.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        comboboxRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el rol", "Administrador", "Profesor" }));
        comboboxRol.setNextFocusableComponent(txtNombre);
        formulario1.add(comboboxRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 200, 30));

        formulario.add(formulario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 380));

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(formulario, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(formulario, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(fondo, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnXActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModalOpcionesProfesor dialog = new ModalOpcionesProfesor(new javax.swing.JFrame(), true);
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
    public principal.MyButton btnX1;
    public javax.swing.JComboBox<String> comboboxRol;
    public javax.swing.JComboBox<String> comboboxSexo;
    public javax.swing.JPanel fondo;
    private javax.swing.JPanel formulario;
    private javax.swing.JPanel formulario1;
    private javax.swing.JPanel header;
    private javax.swing.JPanel header1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public javax.swing.JLabel titulo;
    public javax.swing.JLabel titulo1;
    public principal.MyTextField txtApellido;
    public principal.MyTextField txtApellido2;
    public principal.MyTextField txtContraseña;
    public principal.MyTextField txtNombre;
    public principal.MyTextField txtNombre2;
    public principal.MyTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
