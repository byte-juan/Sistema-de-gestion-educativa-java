package controladorsecundario;

import alertas.MensajeError;
import alertas.MensajeInformacion;
import controlador.ControladorPrincipal;
import dao.AsignaturaDAOimpl;
import dao.DesempeñoDAOimpl;
import dao.GrupoDAOimpl;
import db.Conexion;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.Asignatura;
import modelo.Desempeño;
import modelo.Grado;
import modelo.Grupo;
import modelo.Periodo;
import vistassecundarias.OpcionesDesempeño;

public class ControladorOpcionesDesempeño implements ActionListener, KeyListener, ItemListener {

    private final OpcionesDesempeño vista;
    DesempeñoDAOimpl dao = new DesempeñoDAOimpl();
    Desempeño modelo;
    private int indiceFinal = -1;
    private boolean bandera = false;
    private int desempeñoId;

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorOpcionesDesempeño(OpcionesDesempeño vista) {
        this.vista = vista;
        this.vista.btnVolver.addActionListener(this);
        this.vista.txtDescripcion.addKeyListener(this);
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.comboboxGrado.addItemListener(this);

        cargarComboboxAsignatura();
        cargarComboboxPeriodo();
        cargarComboboxGrado();
        this.vista.comboboxAsignatura.addKeyListener(this);
        this.vista.comboboxPeriodo.addKeyListener(this);
        this.vista.comboboxGrado.addKeyListener(this);
        this.vista.comboboxGrupo.addItem(new Grupo(0, "Seleccione el grupo"));

    }

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorOpcionesDesempeño(OpcionesDesempeño vista, Desempeño modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.desempeñoId = modelo.getId();
        this.vista.comboboxGrado.addItemListener(this);
        this.vista.btnVolver.addActionListener(this);
        this.vista.txtDescripcion.addKeyListener(this);
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.titulo.setText("Editar desempeño");
        this.vista.btnRegistrar.setText("Guardar");
        this.vista.txtDescripcion.setText(modelo.getDescripcion());
        this.vista.txtSuperior.setText(modelo.getSuperior());
        this.vista.txtAlto.setText(modelo.getAlto());
        this.vista.txtBasico.setText(modelo.getBasico());
        this.vista.txtBajo.setText(modelo.getBajo());
        cargarComboboxAsignatura();
        cargarComboboxPeriodo();
        cargarComboboxGrado();
        cargarComboboxGrupo(modelo.getGrado_id());
        for (int i = 0; i < vista.comboboxAsignatura.getItemCount(); i++) {
            Asignatura asignatura = (Asignatura) vista.comboboxAsignatura.getItemAt(i);
            if (asignatura.getId() == modelo.getAsignatura_id()) {
                vista.comboboxAsignatura.setSelectedItem(asignatura);
            }
        }
        for (int i = 0; i < vista.comboboxPeriodo.getItemCount(); i++) {
            Periodo periodo = (Periodo) vista.comboboxPeriodo.getItemAt(i);
            if (periodo.getId() == modelo.getPeriodo_id()) {
                vista.comboboxPeriodo.setSelectedItem(periodo);
            }
        }

        for (int i = 0; i < vista.comboboxGrado.getItemCount(); i++) {
            Grado grado = (Grado) vista.comboboxGrado.getItemAt(i);
            if (grado.getId() == modelo.getGrado_id()) {
                vista.comboboxGrado.setSelectedItem(grado);
            }
        }
        for (int i = 0; i < vista.comboboxGrupo.getItemCount(); i++) {
            Grupo grupo = (Grupo) vista.comboboxGrupo.getItemAt(i);
            System.out.println(grupo.getId() + "=" + modelo.getGrupo_id());
            if (grupo.getId() == modelo.getGrupo_id()) {
                vista.comboboxGrupo.setSelectedItem(grupo);
            }
        }
        this.vista.comboboxAsignatura.addKeyListener(this);
        this.vista.comboboxPeriodo.addKeyListener(this);
        this.vista.comboboxGrado.addKeyListener(this);
    }

    //<editor-fold defaultstate="collapsed" desc="metodo para mostrar mensaje de confirmacion">
    public void mostrarConfirmacion(String texto) {
        MensajeInformacion mensaje = new MensajeInformacion((Frame) vista.getTopLevelAncestor(), true);
        //mensaje.titulo.setText(texto);
        mensaje.etiquetaMensaje.setText(texto);
        mensaje.setSize(vista.getParent().getParent().getSize());
        mensaje.setLocationRelativeTo(vista.getParent().getParent());
        mensaje.setBackground(new Color(0, 0, 0, 75));
        mensaje.fondo.setBackground(new Color(0, 0, 0, 75));
        mensaje.setVisible(true);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo para mostrar mensaje de error">
    public void mostrarError(String texto) {
        MensajeError mensaje = new MensajeError((Frame) vista.getTopLevelAncestor(), true);
        mensaje.etiquetaMensaje1.setText(texto);
        mensaje.setSize(vista.getParent().getParent().getSize());
        mensaje.setLocationRelativeTo(vista.getParent().getParent());
        mensaje.setBackground(new Color(0, 0, 0, 75));
        mensaje.fondo.setBackground(new Color(0, 0, 0, 75));
        mensaje.setVisible(true);
    }
    //</editor-fold>    

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

    // <editor-fold defaultstate="collapsed" desc="Metodo para llenar comboboxAsignatura"> 
    private void cargarComboboxAsignatura() {
        try {
            AsignaturaDAOimpl dao = new AsignaturaDAOimpl();
            List<Asignatura> lista = dao.listar();
            vista.comboboxAsignatura.addItem(new Asignatura(0, "Seleccione la asignatura"));
            for (Asignatura a : lista) {
                vista.comboboxAsignatura.addItem(new Asignatura(a.getId(), a.getNombre()));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            //Logger.getLogger(ControladorOpcionesAsignatura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // </editor-fold>    

    //<editor-fold defaultstate="collapsed" desc="metodo para llenar comboboxPeriodo">
    private void cargarComboboxPeriodo() {
        Conexion conexion = new Conexion();
        String sql = "SELECT * FROM periodo";
        try {
            conexion.conectar();
            PreparedStatement ps = conexion.conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            vista.comboboxPeriodo.addItem(new Periodo(0, "Seleccione el periodo"));
            while (rs.next()) {
                vista.comboboxPeriodo.addItem(new Periodo(rs.getInt("id"), rs.getString("periodoAcademico")));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo para llenar comboboxGrado">
    private void cargarComboboxGrado() {
        Conexion conexion = new Conexion();
        String sql = "SELECT * FROM grado";
        try {
            conexion.conectar();
            PreparedStatement ps = conexion.conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            vista.comboboxGrado.addItem(new Grado(0, "Seleccione el grado"));
            while (rs.next()) {
                vista.comboboxGrado.addItem(new Grado(rs.getInt("id"), rs.getString("nombre")));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
    //</editor-fold>    

    //<editor-fold defaultstate="collapsed" desc="metodo para llenar comboboxGrupo">
    private void cargarComboboxGrupo(int gradoId) {
        String sql = "SELECT * FROM grupo WHERE grado_id=?";
        try {
            GrupoDAOimpl grupoDao = new GrupoDAOimpl();
            grupoDao.conectar();
            PreparedStatement ps = grupoDao.conexion.prepareStatement(sql);
            ps.setInt(1, gradoId);
            ResultSet rs = ps.executeQuery();
            vista.comboboxGrupo.removeAllItems();
            while (rs.next()) {
                vista.comboboxGrupo.addItem(new Grupo(rs.getInt("id"), rs.getString("nombre")));
            }
            if (vista.comboboxGrupo.getItemCount() == 0 && vista.comboboxGrado.getSelectedIndex() > 0) {
                vista.comboboxGrupo.addItem(new Grupo(0, "No existen grupos en este grado"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo para registrar desempeño">
    private boolean registrarDesempeño() {
        try {

            Asignatura asignatura = (Asignatura) vista.comboboxAsignatura.getSelectedItem();
            Periodo periodo = (Periodo) vista.comboboxPeriodo.getSelectedItem();
            Grado grado = (Grado) vista.comboboxGrado.getSelectedItem();
            Grupo grupo = (Grupo) vista.comboboxGrupo.getSelectedItem();
            String descripcion = vista.txtDescripcion.getText();
            if (vista.comboboxAsignatura.getSelectedIndex() == 0 || vista.comboboxPeriodo.getSelectedIndex() == 0
                    || vista.comboboxGrado.getSelectedIndex() == 0 || descripcion.equals("")
                    || grupo.getNombre().equals("No existen grupos en este grado")) {
                mostrarError("No se permiten campos vacíos.");
            } else {
                modelo.Desempeño desempeño = new modelo.Desempeño();
                desempeño.setDescripcion(descripcion);
                desempeño.setSuperior(vista.txtSuperior.getText());
                desempeño.setAlto(vista.txtAlto.getText());
                desempeño.setBasico(vista.txtBasico.getText());
                desempeño.setBajo(vista.txtBajo.getText());
                desempeño.setAsignatura_id(asignatura.getId());
                desempeño.setPeriodo_id(periodo.getId());
                desempeño.setGrupo_id(grupo.getId());
                dao.registrarDesempeño(desempeño);
                vista.txtDescripcion.setText(null);
                vista.txtSuperior.setText(null);
                vista.txtAlto.setText(null);
                vista.txtBasico.setText(null);
                vista.txtBajo.setText(null);
                return true;

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error" + e.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo para editar desempeño">
    private boolean editarDesempeño() {
        try {

            Asignatura asignatura = (Asignatura) vista.comboboxAsignatura.getSelectedItem();
            Periodo periodo = (Periodo) vista.comboboxPeriodo.getSelectedItem();
            Grado grado = (Grado) vista.comboboxGrado.getSelectedItem();
            String descripcion = vista.txtDescripcion.getText();
            if (vista.comboboxAsignatura.getSelectedIndex() == 0 || vista.comboboxPeriodo.getSelectedIndex() == 0
                    || vista.comboboxGrado.getSelectedIndex() == 0 || descripcion.equals("")) {
                mostrarError("No se permiten campos vacíos.");
            } else {
                modelo.Desempeño desempeño = new modelo.Desempeño();
                desempeño.setId(desempeñoId);
                desempeño.setDescripcion(descripcion);
                desempeño.setSuperior(vista.txtSuperior.getText());
                desempeño.setAlto(vista.txtAlto.getText());
                desempeño.setBasico(vista.txtBasico.getText());
                desempeño.setBajo(vista.txtBajo.getText());
                desempeño.setAsignatura_id(asignatura.getId());
                desempeño.setPeriodo_id(periodo.getId());
                desempeño.setGrado_id(grado.getId());
                dao.modificarDesempeño(desempeño);
                return true;

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error" + e.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo ActionEvent">
    @Override
    public void actionPerformed(ActionEvent ae) {
        String opcion = ae.getActionCommand();
        switch (opcion) {
            case "Volver":
                ControladorPrincipal.mostrarPanel(new vista.Desempeño());
                break;
            case "Registrar":
                if (registrarDesempeño() == true) {
                    mostrarConfirmacion("Descriptor de desempeño registrado con éxito.");
                }
                break;
            case "Guardar":
                if (editarDesempeño() == true) {
                    ControladorPrincipal.mostrarPanel(new vista.Desempeño());
                }
                break;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo KeyEvent">
    @Override
    public void keyTyped(KeyEvent ke) {
        if (ke.getSource() == vista.comboboxAsignatura) {
            seleccionarElementoPorTeclado(vista.comboboxAsignatura, ke.getKeyChar());
        } else if (ke.getSource() == vista.comboboxPeriodo) {
            seleccionarElementoPorTeclado(vista.comboboxPeriodo, ke.getKeyChar());
        } else if (ke.getSource() == vista.comboboxGrado) {
            seleccionarElementoPorTeclado(vista.comboboxGrado, ke.getKeyChar());
        }

    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if (ke.getSource() == vista.txtDescripcion) {
            vista.txtSuperior.setText("Demuestra habilidades superiores para " + vista.txtDescripcion.getText());
            vista.txtAlto.setText("Demuestra habilidades para " + vista.txtDescripcion.getText());
            vista.txtBasico.setText("Algunas veces demuestra habilidades para " + vista.txtDescripcion.getText());
            vista.txtBajo.setText("Demuestra debilidades para " + vista.txtDescripcion.getText());
        }
    }
    //</editor-fold>

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getSource() == vista.comboboxGrado) {
            Grado grado = (Grado) vista.comboboxGrado.getSelectedItem();
            int id = grado.getId();
            cargarComboboxGrupo(id);
        }
    }

}
