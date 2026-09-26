package vista;

import controlador.ControladorProfesor;
import java.awt.Rectangle;

public class Profesores extends javax.swing.JPanel {

    public Profesores() {
        initComponents();
        ControladorProfesor controladorProfesor = new ControladorProfesor(this);
    }
    
    public Profesores(int fila) {
        initComponents();
        ControladorProfesor controladorProfesor = new ControladorProfesor(this);

        // Seleccionar por intervalo
        myTable1.getRowCount();
        myTable1.setRowSelectionInterval(fila, fila);

        // Obtener la posición del rectángulo de la fila seleccionada
        Rectangle rect = myTable1.getCellRect(fila - 1, 0, true);

        // Hacer visible el rectangulo de la fila seleccionada
        myTable1.scrollRectToVisible(rect);
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        myTable1 = new principal.MyTable();
        btnEliminar = new principal.MyButton();
        btnEditar = new principal.MyButton();
        btnRegistrar = new principal.MyButton();
        txtBuscar = new principal.MyTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setPreferredSize(new java.awt.Dimension(780, 430));
        background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backgroundMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel1.setText("Profesores");

        myTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Nombre 2", "Apellido", "Apellido 2", "Sexo", "Usuario", "Contraseña", "Rol"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        myTable1.setFontHeader(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        myTable1.setIntercellSpacing(new java.awt.Dimension(0, 1));
        myTable1.setShowHorizontalLines(false);
        myTable1.setShowVerticalLines(false);
        jScrollPane1.setViewportView(myTable1);
        if (myTable1.getColumnModel().getColumnCount() > 0) {
            myTable1.getColumnModel().getColumn(0).setResizable(false);
            myTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
            myTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
            myTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            myTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
            myTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
            myTable1.getColumnModel().getColumn(5).setPreferredWidth(80);
            myTable1.getColumnModel().getColumn(6).setPreferredWidth(100);
            myTable1.getColumnModel().getColumn(7).setPreferredWidth(100);
            myTable1.getColumnModel().getColumn(8).setPreferredWidth(100);
        }

        btnEliminar.setBackground(new java.awt.Color(220, 53, 69));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setColorHover(new java.awt.Color(187, 45, 59));
        btnEliminar.setColorNormal(new java.awt.Color(220, 53, 69));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(25, 135, 84));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setColorHover(new java.awt.Color(21, 115, 71));
        btnEditar.setColorNormal(new java.awt.Color(25, 135, 84));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEditar.setIconTextGap(10);

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anadir.png"))); // NOI18N
        btnRegistrar.setText("Nuevo");
        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRegistrar.setIconTextGap(10);

        txtBuscar.setText("Ingrese el nombre del profesor a buscar");
        txtBuscar.setPlaceHolder("Ingrese el nombre del profesor a buscar");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, backgroundLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE))))
                .addGap(40, 40, 40))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

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

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void backgroundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundMouseClicked
        myTable1.clearSelection();
    }//GEN-LAST:event_backgroundMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    public principal.MyButton btnEditar;
    public principal.MyButton btnEliminar;
    public principal.MyButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static principal.MyTable myTable1;
    public principal.MyTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
