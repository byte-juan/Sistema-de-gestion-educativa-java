package interfaces;

import java.util.List;
import modelo.Profesor;

public interface ProfesorDAO {

    public void registrar(Profesor profesor) throws Exception;

    public void modificar(Profesor profesor)throws Exception;

    public void eliminar(int profesorId)throws Exception;

    public List<Profesor> listar()throws Exception;

    public Profesor obtenerProfesorPorId(int profesorId)throws Exception;

}
