package interfaces;

import java.util.List;
import modelo.Asignatura;

public interface AsignaturaDAO {

    public void registrar(Asignatura asignatura) throws Exception;

    public void modificar(Asignatura asignatura) throws Exception;

    public void eliminar(int asignaturaId) throws Exception;

    public List<Asignatura> listar() throws Exception;

    public Asignatura obtenerAsignaturaPorId(int asignaturaId) throws Exception;

}
