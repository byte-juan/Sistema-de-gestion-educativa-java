package controlador;

import javax.swing.ImageIcon;
import vista.Inicio;

public class ControladorInicio {

    private final Inicio vista;

    public ControladorInicio(Inicio vista) {
        this.vista = vista;
        ImageIcon image = new ImageIcon("src/imagenes/Bienvenido.png");
//        Icon icon = new ImageIcon(
//                image.getImage().getScaledInstance(vista.labelfondo.getWidth(), vista.labelfondo.getHeight(), Image.SCALE_DEFAULT)
//        );
//        vista.labelfondo.setIcon(icon);
        
      
        
    }

}
