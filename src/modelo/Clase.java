package modelo;

public class Clase {

    private int id;
    private int profesor_id;
    private int asignatura_id;
    private int grupo_id;
    private String nombre;
    private String apellido;
    private String asignatura;
    private String grupo;
    private String grado;

    public Clase() {
    }

    
    public Clase(int id, int profesor_id, int asignatura_id, int grupo_id, String nombre, String apellido, String asignatura, String grupo, String grado) {
        this.id = id;
        this.profesor_id = profesor_id;
        this.asignatura_id = asignatura_id;
        this.grupo_id = grupo_id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.asignatura = asignatura;
        this.grupo = grupo;
        this.grado = grado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProfesor_id() {
        return profesor_id;
    }

    public void setProfesor_id(int profesor_id) {
        this.profesor_id = profesor_id;
    }

    public int getAsignatura_id() {
        return asignatura_id;
    }

    public void setAsignatura_id(int asignatura_id) {
        this.asignatura_id = asignatura_id;
    }

    public int getGrupo_id() {
        return grupo_id;
    }

    public void setGrupo_id(int grupo_id) {
        this.grupo_id = grupo_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

}
