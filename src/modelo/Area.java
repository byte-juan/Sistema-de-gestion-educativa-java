package modelo;

public class Area {

    private int id;
    private String nombre;

    public Area(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Area() {

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

    @Override
    public String toString() {
        return nombre;
    }

}
