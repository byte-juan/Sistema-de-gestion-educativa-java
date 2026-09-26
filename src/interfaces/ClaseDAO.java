package interfaces;

import java.util.List;
import modelo.Clase;

public interface ClaseDAO {

    public void registrarClase(Clase clase) throws Exception;

    public void modificarClase(Clase clase) throws Exception;

    public void eliminarClase(int claseId) throws Exception;

    public List<Clase> listar() throws Exception;

    public Clase obtenerClasePorId(int claseId) throws Exception;

}
