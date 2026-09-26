package vista;

import controlador.ControladorEstudiante;
import java.awt.Rectangle;

public class Estudiantes extends javax.swing.JPanel {

    public Estudiantes() {
        initComponents();
        ControladorEstudiante obj = new ControladorEstudiante(this);
    }

    public Estudiantes(int fila) {
        initComponents();
        ControladorEstudiante controlador = new ControladorEstudiante(this);

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
        btnRegistrar = new principal.MyButton();
        btnEliminar = new principal.MyButton();
        btnEditar = new principal.MyButton();
        txtBuscar = new principal.MyTextField();
        jLabel4 = new javax.swing.JLabel();
        comboboxGrado = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        comboboxGrupo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnFiltro = new principal.MyButton();
        cantidadEstudiantes = new javax.swing.JLabel();

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setMinimumSize(new java.awt.Dimension(780, 430));
        background.setPreferredSize(new java.awt.Dimension(780, 430));
        background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backgroundMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel1.setText("Estudiantes");

        myTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Nombre 2", "Apellido", "Apellido 2", "Sexo", "Ciclo", "Grupo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        myTable1.setFontHeader(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        myTable1.setIntercellSpacing(new java.awt.Dimension(0, 1));
        jScrollPane1.setViewportView(myTable1);
        if (myTable1.getColumnModel().getColumnCount() > 0) {
            myTable1.getColumnModel().getColumn(0).setResizable(false);
            myTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
            myTable1.getColumnModel().getColumn(1).setResizable(false);
            myTable1.getColumnModel().getColumn(2).setResizable(false);
            myTable1.getColumnModel().getColumn(3).setResizable(false);
            myTable1.getColumnModel().getColumn(4).setResizable(false);
            myTable1.getColumnModel().getColumn(5).setResizable(false);
            myTable1.getColumnModel().getColumn(6).setResizable(false);
            myTable1.getColumnModel().getColumn(7).setResizable(false);
            myTable1.getColumnModel().getColumn(7).setPreferredWidth(20);
        }

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anadir.png"))); // NOI18N
        btnRegistrar.setText("Nuevo");
        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRegistrar.setIconTextGap(10);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(220, 53, 69));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setColorHover(new java.awt.Color(187, 45, 59));
        btnEliminar.setColorNormal(new java.awt.Color(220, 53, 69));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnEditar.setBackground(new java.awt.Color(25, 135, 84));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setColorHover(new java.awt.Color(21, 115, 71));
        btnEditar.setColorNormal(new java.awt.Color(25, 135, 84));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEditar.setIconTextGap(10);

        txtBuscar.setText("Ingrese el nombre del estudiante a buscar");
        txtBuscar.setToolTipText("");
        txtBuscar.setPlaceHolder("Ingrese el nombre del estudiante a buscar");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Grado");

        comboboxGrado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboboxGrado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboboxGradoItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Grupo");

        comboboxGrupo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboboxGrupo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboboxGrupoItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Estudiante");

        btnFiltro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/quitar-filtro.png"))); // NOI18N

        cantidadEstudiantes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cantidadEstudiantes.setText("Cantidad de estudiantes:  ");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(comboboxGrado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(20, 20, 20))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(backgroundLayout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(86, 86, 86))
                                    .addComponent(jLabel1))
                                .addGap(51, 51, 51)))
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(comboboxGrupo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(20, 20, 20))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(136, 136, 136)))
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(336, 336, 336))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(10, 10, 10)
                                .addComponent(btnFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(cantidadEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addGap(40, 40, 40))))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))))
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboboxGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboboxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cantidadEstudiantes))
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
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

    private void backgroundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundMouseClicked
        // TODO add your handling code here:
        myTable1.clearSelection();
    }//GEN-LAST:event_backgroundMouseClicked

    private void comboboxGradoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboboxGradoItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_comboboxGradoItemStateChanged

    private void comboboxGrupoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboboxGrupoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxGrupoItemStateChanged

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    public principal.MyButton btnEditar;
    public principal.MyButton btnEliminar;
    public principal.MyButton btnFiltro;
    public principal.MyButton btnRegistrar;
    public javax.swing.JLabel cantidadEstudiantes;
    public javax.swing.JComboBox<Object> comboboxGrado;
    public javax.swing.JComboBox<Object> comboboxGrupo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    public static principal.MyTable myTable1;
    public principal.MyTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
