package modelo;

public class Asignatura {

    private int id;
    private String nombre;
    private int area_id;
    private String nombreArea;
    private float peso;

    public Asignatura(int id, String nombre, int area_id, String nombreArea, Float peso) {
        this.id = id;
        this.nombre = nombre;
        this.area_id = area_id;
        this.nombreArea = nombreArea;
        this.peso = peso;
    }

    public Asignatura() {

    }

    public Asignatura(int id, String nombre) {
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

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    
    @Override
    public String toString() {
        return nombre;
    }

    
}
