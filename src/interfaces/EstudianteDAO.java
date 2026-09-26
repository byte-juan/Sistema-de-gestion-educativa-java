package interfaces;

import java.util.List;
import modelo.Estudiante;

public interface EstudianteDAO {

    public void registrar(Estudiante estudiante) throws Exception;

    public void modificar(Estudiante estudiante) throws Exception;

    public void eliminar(int estudianteId) throws Exception;

    public List<Estudiante> listar() throws Exception;

    public Estudiante obtenerEstudiantePorId(int estudianteId) throws Exception;

}
