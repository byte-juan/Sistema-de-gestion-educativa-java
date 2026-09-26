package interfaces;

import java.util.List;
import modelo.Calificacion;

public interface CalificacionDAO {

    public void registrar(Calificacion calificacion) throws Exception;

    public void modificar(Calificacion calificacion)throws Exception;

    public void eliminar(int calificacionId)throws Exception;

    public List<Calificacion> listar()throws Exception;

    public Calificacion obtenerProfesorPorId(int profesorId)throws Exception;
}

