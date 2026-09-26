package modelo;

public class Profesor {

    private int id;
    private String nombre;
    private String nombre2;
    private String apellido;
    private String apellido2;
    private String sexo;
    private String usuario;
    private String contraseña;
    private int rol_id;
    private String nombreRol;

    public Profesor(int id, String nombre, String nombre2, String apellido, String apellido2, String sexo, String usuario, String contraseña, int rol_id, String nombreRol) {
        this.id = id;
        this.nombre = nombre;
        this.nombre2 = nombre2;
        this.apellido = apellido;
        this.apellido2 = apellido2;
        this.sexo = sexo;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.rol_id = rol_id;
        this.nombreRol = nombreRol;
    }

    public Profesor(int id, String nombre, String nombre2, String apellido, String apellido2, String sexo) {
        this.id = id;
        this.nombre = nombre;
        this.nombre2 = nombre2;
        this.apellido = apellido;
        this.apellido2 = apellido2;
        this.sexo = sexo;
    }

    public Profesor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;

    }

    public Profesor(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Profesor() {

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

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
    

}
