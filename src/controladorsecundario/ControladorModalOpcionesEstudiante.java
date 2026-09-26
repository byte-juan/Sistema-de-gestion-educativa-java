package controladorsecundario;

import alertas.MensajeError;
import alertas.MensajeInformacion;
import controlador.ControladorPrincipal;
import dao.EstudianteDAOimpl;
import dao.GrupoDAOimpl;
import interfaces.EstudianteDAO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import modelo.Estudiante;
import modelo.Grado;
import modelo.Grupo;
import vista.Estudiantes;
import vistassecundarias.ModalOpcionesEstudiante;

public class ControladorModalOpcionesEstudiante implements ActionListener, ItemListener, KeyListener {

    private final ModalOpcionesEstudiante vista;
    private int estudianteId;
    private Estudiante modelo;
    private boolean bandera = false;
    private int indiceFinal = -1;
    private boolean edicion = false;

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorModalOpcionesEstudiante(ModalOpcionesEstudiante vista) {
        this.vista = vista;
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.comboboxSexo.addItemListener(this);
        this.vista.comboboxGrado.addItemListener(this);
        this.vista.comboboxGrupo.addItemListener(this);
        this.vista.btnCerrar.addActionListener(this);
        this.vista.comboboxGrado.addKeyListener(this);
        this.vista.btnX.addActionListener(this);
        this.vista.txtNombre.requestFocus();
        cargarCombobox();
        this.vista.comboboxGrupo.addItem(new Grupo(0, "Seleccione el grupo"));
    }

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorModalOpcionesEstudiante(ModalOpcionesEstudiante vista, Estudiante modelo) {

        this.vista = vista;
        this.modelo = modelo;
        this.edicion = true;
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.btnCerrar.addActionListener(this);
        this.vista.comboboxSexo.addItemListener(this);
        this.vista.comboboxGrado.addItemListener(this);
        this.vista.comboboxGrupo.addItemListener(this);
        this.vista.comboboxGrado.addKeyListener(this);
        this.vista.btnCerrar.addActionListener(this);
        this.vista.btnX.addActionListener(this);
        this.estudianteId = modelo.getId();
        this.vista.titulo.setText("Editar estudiante");
        this.vista.comboboxSexo.setSelectedItem(modelo.getSexo());
        this.vista.btnRegistrar.setText("Guardar");

        this.vista.txtNombre.setText(modelo.getNombre());
        this.vista.txtNombre2.setText(modelo.getNombre2());
        this.vista.txtApellido.setText(modelo.getApellido());
        this.vista.txtApellido2.setText(modelo.getApellido2());
        cargarCombobox();
        this.vista.comboboxGrado.setSelectedIndex(modelo.getGrado_id());
        cargarGrupos(modelo.getGrado_id());
        for (int i = 0; i < vista.comboboxGrupo.getItemCount(); i++) {
            Grupo grupo = (Grupo) vista.comboboxGrupo.getItemAt(i);
            if (grupo.getId() == modelo.getGrupo_id()) {
                vista.comboboxGrupo.setSelectedItem(grupo);
            }
        }

        //PONER TEXTOS EN NEGRO
        this.vista.txtNombre.setForeground(Color.BLACK);
        this.vista.txtNombre2.setForeground(Color.BLACK);
        this.vista.txtApellido.setForeground(Color.BLACK);
        this.vista.txtApellido2.setForeground(Color.BLACK);
    }

    //<editor-fold defaultstate="collapsed" desc="metodo para seleccionar en combobox por telcado">
    private void seleccionarElementoPorTeclado(JComboBox combobox, char letra) {
        /* 
             * el indiceInicial va a depender del indiceFinal 
             * si es mayor o igual a 0 y menor al tamañoCombobox entonces inicia con el valor del indiceFinal
             * caso contrario iniciara en 1.
             * el indiceEncontrado iniciara en -1 para indicar que aun no hay ningun elemento selccionado
         */
        //char letra = ke.getKeyChar();

        int indiceEncontrado = -1;
        int tamañoCombobox = combobox.getItemCount();
        int indiceInicial = (indiceFinal >= 0 && indiceFinal < tamañoCombobox - 1) ? indiceFinal + 1 : 1;
        boolean recorridoCompleto = false;

        for (int i = indiceInicial; i < tamañoCombobox; i++) {
            String item = combobox.getItemAt(i).toString();//obtiene el item en la posición i                         
            /*
                 * si existe un item que inicia con la misma letra presionada entonces
                 * el indiceEncontrado va a ser igual al iterador del for i y además finaliza la busqueda                    
             */
            if (Character.toLowerCase(item.charAt(0)) == Character.toLowerCase(letra)) {
                indiceEncontrado = i;
                bandera = true;
                break;
            }

            /*
                 * si el iterador es igual al tamaño del combobox entonces reinicia la busqueda.                                  
             */
            if (i == tamañoCombobox - 1) {

                if (recorridoCompleto) {
                    break;
                } else {
                    i = 0;
                    recorridoCompleto = true;
                }
            }
        }
        /*
             * si el indiceEncontrado es mayor o igual a 0 significa que existe un item que inicia 
             * con la tecla presionada y entonces selecciona ese item 
             * y el indiceFinal va a ser igual al indice encontrado
             * sino resetea la busqueda 
         */
        if (bandera == true && indiceEncontrado >= 0) {
            combobox.setSelectedIndex(indiceEncontrado);
            indiceFinal = indiceEncontrado;
        } else {
            indiceFinal = -1;
            bandera = false;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo mostrarConfirmacion">
    private void mostrarConfirmacion(String texto) {
        MensajeInformacion mensaje = new MensajeInformacion(vista, true);
        mensaje.etiquetaMensaje.setText(texto);
        mensaje.setSize(vista.getSize());
        mensaje.setLocationRelativeTo(vista);
        mensaje.setBackground(new Color(0, 0, 0, 75));
        mensaje.fondo.setBackground(new Color(0, 0, 0, 75));
        mensaje.setVisible(true);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo mostrarError">
    private void mostrarError(String texto) {
        MensajeError mensaje = new MensajeError(vista, true);
        mensaje.etiquetaMensaje1.setText(texto);
        mensaje.setSize(vista.getSize());
        mensaje.setLocationRelativeTo(vista);
        mensaje.setBackground(new Color(0, 0, 0, 75));
        mensaje.fondo.setBackground(new Color(0, 0, 0, 75));
        mensaje.setVisible(true);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo existenCamposVacios">
    public boolean existenCamposVacios() {

        int sexo = vista.comboboxSexo.getSelectedIndex();
        int grado = vista.comboboxGrado.getSelectedIndex();
        int grupo = vista.comboboxGrupo.getSelectedIndex();

        String[] campos = {
            vista.txtNombre.getText(),
            vista.txtNombre2.getText(),
            vista.txtApellido.getText(),
            vista.txtApellido2.getText(),};

        String[] placeholders = {
            vista.txtNombre.getPlaceHolder(),
            vista.txtNombre2.getPlaceHolder(),
            vista.txtApellido.getPlaceHolder(),
            vista.txtApellido2.getPlaceHolder(),};
        for (int i = 0; i < campos.length; i++) {
            // se coloca i!=1 para permitr que el nombre2 sea nulo
            if (i != 1 && campos[i].isEmpty() || i != 1 && campos[i].equals(placeholders[i])) {
                mostrarError("No se permiten campos vacíos");
                return true;
            }
        }
        if (sexo == 0 || grado == 0 || grupo == -1) {
            mostrarError("El Sexo,grado y grupo deben ser seleccionados.");
            return true;
        }
        return false;
    }
    //</editor-fold>    

    // <editor-fold defaultstate="collapsed" desc="Metodo para registrar un estudiante"> 
    public boolean registrarEstudiante() {
        if (!existenCamposVacios()) {
            try {
                EstudianteDAO dao = new EstudianteDAOimpl();
                Estudiante estudiante = new Estudiante();
                Grupo grupo = (Grupo) vista.comboboxGrupo.getSelectedItem();
                Grado grado = (Grado) vista.comboboxGrado.getSelectedItem();
                String nombre2 = vista.txtNombre2.getText();
                String nombre2PlaceHolder = vista.txtNombre2.getPlaceHolder();
                estudiante.setNombre(vista.txtNombre.getText());
                estudiante.setNombre2((nombre2.equals("") || nombre2.equals(nombre2PlaceHolder)) ? "" : nombre2);
                estudiante.setApellido(vista.txtApellido.getText());
                estudiante.setApellido2(vista.txtApellido2.getText());
                estudiante.setSexo((String) vista.comboboxSexo.getSelectedItem());
                estudiante.setGrupo_id(grupo.getId());
                estudiante.setGrado_id(grado.getId());
                dao.registrar(estudiante);
                return true;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return false;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodo para editar un estudiante"> 
    public boolean editarEstudiante() {
        if (!existenCamposVacios()) {
            try {
                EstudianteDAO dao = new EstudianteDAOimpl();
                Estudiante estudiante = new Estudiante();
                Grupo grupo = (Grupo) vista.comboboxGrupo.getSelectedItem();
                Grado grado = (Grado) vista.comboboxGrado.getSelectedItem();
                String nombre2 = vista.txtNombre2.getText();
                String nombre2PlaceHolder = vista.txtNombre2.getPlaceHolder();
                estudiante.setId(estudianteId);
                estudiante.setNombre(vista.txtNombre.getText());
                estudiante.setNombre2((nombre2.equals("") || nombre2.equals(nombre2PlaceHolder)) ? "" : nombre2);
                estudiante.setApellido(vista.txtApellido.getText());
                estudiante.setApellido2(vista.txtApellido2.getText());
                estudiante.setSexo((String) vista.comboboxSexo.getSelectedItem());
                estudiante.setGrupo_id(grupo.getId());
                estudiante.setGrado_id(grado.getId());
                dao.modificar(estudiante);
                return true;
            } catch (Exception e) {
                System.out.println("Error al editar estudiante" + e.getMessage());
            }
        }
        return false;

    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodo para llenar un combobox"> 
    private void cargarCombobox() {

        GrupoDAOimpl dao = new GrupoDAOimpl();
        String sql = "SELECT * FROM grado";
        String sql2 = "SELECT * FROM grado WHERE nombre = grado";
        try {
            dao.conectar();
            PreparedStatement ps = dao.conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            this.vista.comboboxGrado.addItem(new Grado(0, "Seleccione el grado escolar"));
            while (rs.next()) {
                vista.comboboxGrado.addItem(new Grado(Integer.parseInt(rs.getString("id")), rs.getString("nombre")));
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodo para llenar el combobox de grupo"> 
    private void cargarGrupos(int id) {
        String sql = "SELECT * FROM grupo WHERE grado_id=?";
        try {
            GrupoDAOimpl dao = new GrupoDAOimpl();
            dao.conectar();
            PreparedStatement ps = dao.conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            vista.comboboxGrupo.removeAllItems();
            while (rs.next()) {
                vista.comboboxGrupo.addItem(new Grupo(rs.getInt("id"), rs.getString("nombre")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //</editor-fold>

    private void limpiarCampos() {
        vista.txtNombre.setText(vista.txtNombre.getPlaceHolder());
        vista.txtNombre2.setText(vista.txtNombre2.getPlaceHolder());
        vista.txtApellido.setText(vista.txtApellido.getPlaceHolder());
        vista.txtApellido2.setText(vista.txtApellido2.getPlaceHolder());
        vista.comboboxSexo.setSelectedIndex(0);
        vista.txtNombre.setForeground(Color.GRAY);
        vista.txtNombre2.setForeground(Color.GRAY);
        vista.txtApellido.setForeground(Color.GRAY);
        vista.txtApellido2.setForeground(Color.GRAY);
        vista.txtNombre.requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String opcion = e.getActionCommand();
        switch (opcion) {
            case "Registrar":
                if (registrarEstudiante() == true) {
                    //obtener la cantidad de filas de la tabla.
                    int fila = Estudiantes.myTable1.getRowCount();
                    ControladorPrincipal.mostrarPanel(new Estudiantes(fila));
                    limpiarCampos();
                    mostrarConfirmacion("Estudiante registrada con éxito.");
                }
                break;
            case "Guardar":
                if (editarEstudiante() == true) {
                    vista.dispose();
                    ControladorPrincipal.mostrarPanel(new Estudiantes(Estudiantes.myTable1.getSelectedRow()));
                }
                break;
            case "Cerrar":
                vista.dispose();
                break;
            case "X":
                vista.dispose();
                break;
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == vista.comboboxGrado) {
            Grado grado = (Grado) vista.comboboxGrado.getSelectedItem();
            int id = grado.getId();
            cargarGrupos(id);
        }

    }

    @Override
    public void keyTyped(KeyEvent ke) {

        if (ke.getSource() == vista.comboboxGrado) {
            seleccionarElementoPorTeclado(vista.comboboxGrado, ke.getKeyChar());
        }

    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

} 
 