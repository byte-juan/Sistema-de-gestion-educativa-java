/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author agust
 */
public class Calificacion {
    private int id;
    private int estudianteId;
    private int asignaturaId;
    private int profesorId;
    private double nota;

    public Calificacion() {} 
    
    public Calificacion(int id, int estudianteId, int asignaturaId, int profesorId, double nota) {
        this.id = id;
        this.estudianteId = estudianteId;
        this.asignaturaId = asignaturaId;
        this.profesorId = profesorId;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public int getEstudianteId() {
        return estudianteId;
    }

    public int getAsignaturaId() {
        return asignaturaId;
    }

    public int getProfesorId() {
        return profesorId;
    }

    public double getNota() {
        return nota;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEstudianteId(int estudianteid) {
        this.estudianteId = estudianteid;
    }

    public void setAsignaturaId(int asignaturaid) {
        this.asignaturaId = asignaturaid;
    }

    public void setProfesorId(int profesorid) {
        this.profesorId = profesorid;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    @Override
    public String toString() {
        return "Calificacion{" +
                "id=" + id +
                ", estudianteId=" + estudianteId +
                ", asignaturaId=" + asignaturaId +
                ", profesorId=" + profesorId +
                ", nota=" + nota +
                '}';
    }
}
