package controlador;

import dao.ClaseDAOimpl;
import interfaces.ClaseDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Clase;
import vista.Clases;

public class ControladorClase implements ActionListener, KeyListener {

    private final Clases vista;

    public ControladorClase(Clases vista) {
        this.vista = vista;
        cargarDatos();
    }

    private void cargarDatos() {
        ClaseDAO dao = new ClaseDAOimpl();
        try {
            DefaultTableModel modelo = (DefaultTableModel) vista.myTable1.getModel();
            List<Clase> lista = dao.listar();
            for (Clase c : lista) {
                modelo.addRow(new Object[]{c.getId(),c.getNombre()+" "+c.getApellido(),c.getAsignatura(),c.getGrado(),c.getGrupo()});
            }

        } catch (Exception e) {
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

}
