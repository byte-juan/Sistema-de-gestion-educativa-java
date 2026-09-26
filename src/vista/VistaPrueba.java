package vista;

import controlador.ControladorGrupo;
import javax.swing.table.DefaultTableModel;

public class VistaPrueba extends javax.swing.JPanel {

    public VistaPrueba() {
        initComponents();
        
    }

    public void limpiarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) myTable1.getModel();
        System.out.println("este es el modelo" + modelo.getRowCount());
        System.out.println("este es la tabla" + (myTable1.getRowCount() - 1));
        for (int i = 0; i <= modelo.getRowCount() - 1; i++) {
            modelo.removeRow(i);
            i = i - 1;
            System.out.println("contador tabla" + i);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myTextField2 = new principal.MyTextField();
        background = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        myTable1 = new principal.MyTable();
        jLabel1 = new javax.swing.JLabel();
        btnRegistrar = new principal.MyButton();
        btnEditar = new principal.MyButton();
        btnEliminar = new principal.MyButton();
        myTextField1 = new principal.MyTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setMinimumSize(new java.awt.Dimension(0, 0));
        background.setPreferredSize(new java.awt.Dimension(780, 430));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(450, 280));

        myTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "grado", "grupo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        myTable1.setFontHeader(new java.awt.Font("Segoe UI Semibold", 1, 15)); // NOI18N
        myTable1.setIntercellSpacing(new java.awt.Dimension(0, 1));
        myTable1.setShowVerticalLines(false);
        myTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(myTable1);
        if (myTable1.getColumnModel().getColumnCount() > 0) {
            myTable1.getColumnModel().getColumn(0).setResizable(false);
            myTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
            myTable1.getColumnModel().getColumn(1).setResizable(false);
            myTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
            myTable1.getColumnModel().getColumn(2).setResizable(false);
            myTable1.getColumnModel().getColumn(2).setPreferredWidth(70);
        }

        background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 710, 265));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel1.setText("Gruposg");
        background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        btnRegistrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anadir.png"))); // NOI18N
        btnRegistrar.setText("Nuevo");
        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRegistrar.setIconTextGap(10);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        background.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 373, 130, 35));

        btnEditar.setBackground(new java.awt.Color(25, 135, 84));
        btnEditar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setColorHover(new java.awt.Color(21, 115, 71));
        btnEditar.setColorNormal(new java.awt.Color(25, 135, 84));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEditar.setIconTextGap(10);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        background.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 373, 130, 35));

        btnEliminar.setBackground(new java.awt.Color(220, 53, 69));
        btnEliminar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setColorHover(new java.awt.Color(187, 45, 59));
        btnEliminar.setColorNormal(new java.awt.Color(220, 53, 69));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        background.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 373, 130, 35));
        background.add(myTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 45, 710, -1));

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

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void myTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myTable1MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1){
            int fila = myTable1.rowAtPoint(evt.getPoint());
            if(fila==-1){
                myTable1.clearSelection();
            }
        }
    }//GEN-LAST:event_myTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel background;
    public principal.MyButton btnEditar;
    public principal.MyButton btnEliminar;
    public principal.MyButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public principal.MyTable myTable1;
    private principal.MyTextField myTextField1;
    private principal.MyTextField myTextField2;
    // End of variables declaration//GEN-END:variables
}
