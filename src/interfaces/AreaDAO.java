package interfaces;

import java.util.List;
import modelo.Area;

public interface AreaDAO {

    public void registrar(Area area) throws Exception;

    public void modificar(Area area) throws Exception;

    public void eliminar(int areaId) throws Exception;

    public List<Area> listar() throws Exception;

    public Area obtenerAreaPorId(int areaId) throws Exception;

}
