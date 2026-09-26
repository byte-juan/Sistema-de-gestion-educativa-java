package interfaces;

import java.util.List;

import modelo.Grupo;

public interface GrupoDAO {

    public void registrar(Grupo grupo) throws Exception;

    public void modificar(Grupo grupo) throws Exception;

    public void eliminar(int grupoId) throws Exception;

    public List<Grupo> listar() throws Exception;
    
    public Grupo obtenerGrupoPorId(int grupoId) throws Exception;

}
