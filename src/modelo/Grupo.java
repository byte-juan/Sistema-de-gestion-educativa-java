package modelo;

public class Grupo {

    private int id;
    private String nombre;
    private int idGrado;
    private String nombreGrado;

    public Grupo() {

    }

    public Grupo(int id, String nombre, int idGrado, String nombreGrado) {
        this.id = id;
        this.nombre = nombre;
        this.idGrado = idGrado;
        this.nombreGrado = nombreGrado;
    }

    public Grupo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(int idGrado) {
        this.idGrado = idGrado;
    }

    public String getNombreGrado() {
        return nombreGrado;
    }

    public void setNombreGrado(String nombreGrado) {
        this.nombreGrado = nombreGrado;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
