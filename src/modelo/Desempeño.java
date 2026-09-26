package modelo;

public class Desempeño {

    private int id;
    private String descripcion;
    private String superior;
    private String alto;
    private String basico;
    private String bajo;
    private int grado_id;
    private int asignatura_id;
    private int periodo_id;
    private int grupo_id;
    private String nombreGrado;
    private String nombreAsignatura;
    private String periodoAcademico;
    private String nombreGrupo;

    public Desempeño(int id, String descripcion, String superior, String alto, String basico, String bajo, int grado_id, int asignatura_id, int periodo_id, int grupo_id, String nombreGrado, String nombreAsignatura, String periodoAcademico, String nombreGrupo) {
        this.id = id;
        this.descripcion = descripcion;
        this.superior = superior;
        this.alto = alto;
        this.basico = basico;
        this.bajo = bajo;
        this.grado_id = grado_id;
        this.asignatura_id = asignatura_id;
        this.periodo_id = periodo_id;
        this.grupo_id = grupo_id;
        this.nombreGrado = nombreGrado;
        this.nombreAsignatura = nombreAsignatura;
        this.periodoAcademico = periodoAcademico;
        this.nombreGrupo = nombreGrupo;
    }

    
    public Desempeño() {

    }

    public Desempeño(int id, String descripcion, String superior, String alto, String basico, String bajo, int grado_id, int asignatura_id, int periodo_id, String nombreGrado, String nombreAsignatura, String periodoAcademico) {
        this.id = id;
        this.descripcion = descripcion;
        this.superior = superior;
        this.alto = alto;
        this.basico = basico;
        this.bajo = bajo;
        this.grado_id = grado_id;
        this.asignatura_id = asignatura_id;
        this.periodo_id = periodo_id;
        this.nombreGrado = nombreGrado;
        this.nombreAsignatura = nombreAsignatura;
        this.periodoAcademico = periodoAcademico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSuperior() {
        return superior;
    }

    public void setSuperior(String superior) {
        this.superior = superior;
    }

    public String getAlto() {
        return alto;
    }

    public void setAlto(String alto) {
        this.alto = alto;
    }

    public String getBasico() {
        return basico;
    }

    public void setBasico(String basico) {
        this.basico = basico;
    }

    public String getBajo() {
        return bajo;
    }

    public void setBajo(String bajo) {
        this.bajo = bajo;
    }

    public int getGrado_id() {
        return grado_id;
    }

    public void setGrado_id(int grado_id) {
        this.grado_id = grado_id;
    }

    public int getAsignatura_id() {
        return asignatura_id;
    }

    public void setAsignatura_id(int asignatura_id) {
        this.asignatura_id = asignatura_id;
    }

    public int getPeriodo_id() {
        return periodo_id;
    }

    public void setPeriodo_id(int periodo_id) {
        this.periodo_id = periodo_id;
    }

    public String getNombreGrado() {
        return nombreGrado;
    }

    public void setNombreGrado(String nombreGrado) {
        this.nombreGrado = nombreGrado;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public String getPeriodoAcademico() {
        return periodoAcademico;
    }

    public void setPeriodoAcademico(String periodoAcademico) {
        this.periodoAcademico = periodoAcademico;
    }

    public int getGrupo_id() {
        return grupo_id;
    }

    public void setGrupo_id(int grupo_id) {
        this.grupo_id = grupo_id;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    
}
