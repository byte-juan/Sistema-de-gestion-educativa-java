//package controladorsecundario;
//
//import alertas.MensajeError;
//import alertas.MensajeInformacion;
//import controlador.ControladorPrincipal;
//import dao.AreaDAOimpl;
//import dao.AsignaturaDAOimpl;
//import dao.ProfesorDAOimpl;
//import java.awt.Color;
//import java.awt.Frame;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.JComboBox;
//import modelo.Area;
//import modelo.Asignatura;
//import modelo.Profesor;
//import vista.Asignaturas;
//import vistassecundarias.OpcionesAsignatura;
//
//public class ControladorOpcionesAsignatura implements ActionListener, KeyListener {
//
//    private final OpcionesAsignatura vista;
//    private Asignatura modelo;
//    private int indiceFinal = -1;
//    private boolean bandera = false;
//    private int id;
//
//    @SuppressWarnings("LeakingThisInConstructor")
//    public ControladorOpcionesAsignatura(OpcionesAsignatura vista) {
//        this.vista = vista;
//        this.vista.btnRegistrar.addActionListener(this);
//        this.vista.btnVolver.addActionListener(this);
//        this.vista.comboboxArea.addKeyListener(this);
//        this.vista.comboboxProfesor.addKeyListener(this);
//        cargarComboboxArea();
//        cargarComboboxProfesor();
//    }
//
//    @SuppressWarnings("LeakingThisInConstructor")
//    public ControladorOpcionesAsignatura(OpcionesAsignatura vista, Asignatura modelo) {
//        this.vista = vista;
//        this.modelo = modelo;
//        this.id = modelo.getId();
//        this.vista.btnRegistrar.addActionListener(this);
//        this.vista.btnVolver.addActionListener(this);
//        this.vista.comboboxArea.addKeyListener(this);
//        this.vista.comboboxProfesor.addKeyListener(this);
//        this.vista.titulo.setText("Editar asignatura");
//        this.vista.txtNombre.setText(modelo.getNombre());
//        this.vista.txtNombre.setForeground(Color.black);
//        this.vista.btnRegistrar.setText("Guardar");
//        cargarComboboxArea();
//        cargarComboboxProfesor();
//        for (int i = 0; i < vista.comboboxArea.getItemCount(); i++) {
//            Area area = (Area) vista.comboboxArea.getItemAt(i);
//            if (area.getId() == modelo.getArea_id()) {
//                vista.comboboxArea.setSelectedItem(area);
//            }
//        }
//    }
//
//    //<editor-fold defaultstate="collapsed" desc="metodo para seleccionar en combobox por telcado">
//    private void seleccionarElementoPorTeclado(JComboBox combobox, char letra) {
//        /* 
//             * el indiceInicial va a depender del indiceFinal 
//             * si es mayor o igual a 0 y menor al tamañoCombobox entonces inicia con el valor del indiceFinal
//             * caso contrario iniciara en 1.
//             * el indiceEncontrado iniciara en -1 para indicar que aun no hay ningun elemento selccionado
//         */
//        //char letra = ke.getKeyChar();
//
//        int indiceEncontrado = -1;
//        int tamañoCombobox = combobox.getItemCount();
//        int indiceInicial = (indiceFinal >= 0 && indiceFinal < tamañoCombobox - 1) ? indiceFinal + 1 : 1;
//        boolean recorridoCompleto = false;
//
//        for (int i = indiceInicial; i < tamañoCombobox; i++) {
//            String item = combobox.getItemAt(i).toString();//obtiene el item en la posición i                         
//            /*
//                 * si existe un item que inicia con la misma letra presionada entonces
//                 * el indiceEncontrado va a ser igual al iterador del for i y además finaliza la busqueda                    
//             */
//            if (Character.toLowerCase(item.charAt(0)) == Character.toLowerCase(letra)) {
//                indiceEncontrado = i;
//                bandera = true;
//                break;
//            }
//
//            /*
//                 * si el iterador es igual al tamaño del combobox entonces reinicia la busqueda.                                  
//             */
//            if (i == tamañoCombobox - 1) {
//
//                if (recorridoCompleto) {
//                    break;
//                } else {
//                    i = 0;
//                    recorridoCompleto = true;
//                }
//            }
//        }
//        /*
//             * si el indiceEncontrado es mayor o igual a 0 significa que existe un item que inicia 
//             * con la tecla presionada y entonces selecciona ese item 
//             * y el indiceFinal va a ser igual al indice encontrado
//             * sino resetea la busqueda 
//         */
//        if (bandera == true && indiceEncontrado >= 0) {
//            combobox.setSelectedIndex(indiceEncontrado);
//            indiceFinal = indiceEncontrado;
//        } else {
//            indiceFinal = -1;
//            bandera = false;
//        }
//    }
//    //</editor-fold>
//
//    //<editor-fold defaultstate="collapsed" desc="metodo para mostrar mensaje de confirmacion">
//    public void mostrarConfirmacion(String texto) {
//        MensajeInformacion mensaje = new MensajeInformacion((Frame) vista.getTopLevelAncestor(), true);
//        //mensaje.titulo.setText(texto);
//        mensaje.etiquetaMensaje.setText(texto);
//        mensaje.setSize(vista.getParent().getParent().getSize());
//        mensaje.setLocationRelativeTo(vista.getParent().getParent());
//        mensaje.setBackground(new Color(0, 0, 0, 75));
//        mensaje.fondo.setBackground(new Color(0, 0, 0, 75));
//        mensaje.setVisible(true);
//    }
//    //</editor-fold>
//
//    //<editor-fold defaultstate="collapsed" desc="metodo para mostrar mensaje de error">
//    public void mostrarError(String texto) {
//        MensajeError mensaje = new MensajeError((Frame) vista.getTopLevelAncestor(), true);
//        mensaje.etiquetaMensaje.setText(texto);
//        mensaje.setSize(vista.getParent().getParent().getSize());
//        mensaje.setLocationRelativeTo(vista.getParent().getParent());
//        mensaje.setBackground(new Color(0, 0, 0, 75));
//        mensaje.fondo.setBackground(new Color(0, 0, 0, 75));
//        mensaje.setVisible(true);
//    }
//    //</editor-fold>
//
//    //<editor-fold defaultstate="collapsed" desc="metodo para registrar asignatura">
//    public boolean registrarAsignatura() {
//        try {
//            AsignaturaDAOimpl dao = new AsignaturaDAOimpl();
//            Asignatura asignatura = new Asignatura();
//            Profesor profesor = (Profesor) vista.comboboxProfesor.getSelectedItem();
//            Area area = (Area) vista.comboboxArea.getSelectedItem();
//            String nombre = vista.txtNombre.getText();
//            String nombrePlaceHolder = vista.txtNombre.getUPlaceHolder();
//            if (nombre.isEmpty() || nombre.equals(nombrePlaceHolder)
//                    || vista.comboboxArea.getSelectedIndex() == 0) {
//                mostrarError("No se permiten campos vacíos.");
//                //JOptionPane.showMessageDialog(null, "No se permiten campos vacios", "Mensaje", JOptionPane.ERROR_MESSAGE);
//            } else if (vista.comboboxProfesor.getSelectedIndex() == 0) {
//                asignatura.setNombre(nombre);
//                asignatura.setArea_id(area.getId());
//                //asignatura.setProfesor_id(0);
//                vista.txtNombre.setText(null);
//                vista.comboboxArea.setSelectedIndex(0);
//                vista.comboboxProfesor.setSelectedIndex(0);
//                dao.registrar(asignatura);
//                return true;
//            } else {
//                asignatura.setNombre(nombre);
//                asignatura.setArea_id(area.getId());               
//                vista.txtNombre.setText(null);
//                vista.comboboxArea.setSelectedIndex(0);
//                vista.comboboxProfesor.setSelectedIndex(0);
//                dao.registrar(asignatura);
//                return true;
//            }
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return false;
//
//    }
//    //</editor-fold>
//
//    //<editor-fold defaultstate="collapsed" desc="metodo para editar asignatura">
//    public boolean editarAsignatura() {
//        try {
//            AsignaturaDAOimpl dao = new AsignaturaDAOimpl();
//            Asignatura asignatura = new Asignatura();
//            Profesor profesor = (Profesor) vista.comboboxProfesor.getSelectedItem();
//            Area area = (Area) vista.comboboxArea.getSelectedItem();
//            String nombre = vista.txtNombre.getText();
//            String nombrePlaceHolder = vista.txtNombre.getUPlaceHolder();
//            if (nombre.isEmpty() || nombre.equals(nombrePlaceHolder)
//                    || vista.comboboxArea.getSelectedIndex() == 0) {
//                //JOptionPane.showMessageDialog(null, "No se permiten campos vacios", "Mensaje", JOptionPane.ERROR_MESSAGE);
//                mostrarError("No se permiten campos vacíos.");
//            } else {
//                asignatura.setNombre(nombre);
//                asignatura.setArea_id(area.getId());                
//                asignatura.setId(id);
//                vista.txtNombre.setText(null);
//                vista.comboboxArea.setSelectedIndex(0);
//                vista.comboboxProfesor.setSelectedIndex(0);
//                dao.modificar(asignatura);
//                return true;
//            }
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return false;
//    }
//    //</editor-fold>
//
//    // <editor-fold defaultstate="collapsed" desc="Metodo para llenar un combobox area"> 
//    private void cargarComboboxArea() {
//        try {
//            AreaDAOimpl dao = new AreaDAOimpl();
//            List<Area> lista = dao.listar();
//            vista.comboboxArea.addItem(new Area(0, "Seleccione el area"));
//            for (Area a : lista) {
//                vista.comboboxArea.addItem(new Area(a.getId(), a.getNombre()));
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(ControladorOpcionesAsignatura.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    // </editor-fold>
//
//    //<editor-fold defaultstate="collapsed" desc="metodo para llenar combobox de profesor ">
//    private void cargarComboboxProfesor() {
//        try {
//            ProfesorDAOimpl dao = new ProfesorDAOimpl();
//            List<Profesor> lista = dao.listar();
//            vista.comboboxProfesor.addItem(new Profesor(0, "Seleccione el profesor", ""));
//            for (Profesor p : lista) {
//                System.out.println(p.getId());
//                vista.comboboxProfesor.addItem(new Profesor(p.getId(), p.getNombre(), p.getApellido()));
//            }
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//    //</editor-fold>
//
//    //<editor-fold defaultstate="collapsed" desc="metodo de ActionEvent">
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        String opcion = e.getActionCommand();
//        switch (opcion) {
//            case "Registrar":
//                if (registrarAsignatura() == true) {
//                    mostrarConfirmacion("Asignatura registrada con éxito.");
//                    //JOptionPane.showMessageDialog(null, "Asignatura registrada con éxito.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
//                }
//                break;
//            case "Guardar":
//                if (editarAsignatura() == true) {
//                    ControladorPrincipal.mostrarPanel(new Asignaturas());
//                }
//                break;
//            case "Volver":
//                ControladorPrincipal.mostrarPanel(new Asignaturas());
//                break;
//        }
//
//    }
//    //</editor-fold>
//
//    //<editor-fold defaultstate="collapsed" desc="metodo de KeyEvent">
//    @Override
//    public void keyTyped(KeyEvent ke) {
//        if (ke.getSource() == vista.comboboxArea) {
//            seleccionarElementoPorTeclado(vista.comboboxArea, ke.getKeyChar());
//        } else if (ke.getSource() == vista.comboboxProfesor) {
//            seleccionarElementoPorTeclado(vista.comboboxProfesor, ke.getKeyChar());
//        }
//
//    }
//
//    @Override
//    public void keyPressed(KeyEvent ke) {
//
//    }
//
//    @Override
//    public void keyReleased(KeyEvent ke) {
//
//    }
//    //</editor-fold>
//
//}
