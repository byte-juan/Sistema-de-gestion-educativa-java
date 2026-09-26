package modelo;

public class Estudiante {

    private int id;
    private String nombre;
    private String nombre2;
    private String apellido;
    private String apellido2;
    private String sexo;
    private String nombreGrado;
    private String nombreGrupo;
    private int grupo_id;
    private int grado_id;

    public Estudiante() {

    }

    public Estudiante(int id, String nombre, String nombre2, String apellido, String apellido2, String sexo, String nombreGrado, String nombreGrupo, int grupo_id, int grado_id) {
        this.id = id;
        this.nombre = nombre;
        this.nombre2 = nombre2;
        this.apellido = apellido;
        this.apellido2 = apellido2;
        this.sexo = sexo;
        this.nombreGrado = nombreGrado;
        this.nombreGrupo = nombreGrupo;
        this.grupo_id = grupo_id;
        this.grado_id = grado_id;
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

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNombreGrado() {
        return nombreGrado;
    }

    public void setNombreGrado(String nombreGrado) {
        this.nombreGrado = nombreGrado;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public int getGrupo_id() {
        return grupo_id;
    }

    public void setGrupo_id(int grupo_id) {
        this.grupo_id = grupo_id;
    }

    public int getGrado_id() {
        return grado_id;
    }

    public void setGrado_id(int grado_id) {
        this.grado_id = grado_id;
    }

}
