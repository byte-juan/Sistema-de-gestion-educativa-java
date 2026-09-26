
package modelo;

public class Periodo {
    
    private int id;
    private String periodoAcademico;

    public Periodo(int id, String periodoAcademico) {
        this.id = id;
        this.periodoAcademico = periodoAcademico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeriodoAcademico() {
        return periodoAcademico;
    }

    public void setPeriodoAcademico(String periodoAcademico) {
        this.periodoAcademico = periodoAcademico;
    }

    @Override
    public String toString() {
        return periodoAcademico;
    }
    
    
    
    
    
}
