package interfaces;

import java.util.List;
import modelo.Desempeño;

public interface DesempeñoDAO {
    
    public void registrarDesempeño(Desempeño desempeño) throws Exception;
    
    public void modificarDesempeño(Desempeño desempeño) throws Exception;
    
    public void eliminar(int desempeñoId) throws Exception;
    
    public List<Desempeño> listar() throws Exception;
    
    public Desempeño obtenerDesempeñoPorid(int desempeñoId) throws Exception;
    
    
    

}
