package models;

import java.util.Date;

public class Practicante {
    private final String cedula;
    private final String nombres;
    private final String apellidos;
    private final Date fechaNacimiento;
    private final String nacionalidad;
    private String modalidadEscuela;
    private Liga liga;
    private Date fechaIngresoLiga;
    private float peso;

    public Practicante(String cedula, String nombres, String apellidos, Date fechaNacimiento, String nacionalidad, String modalidadEscuela, Liga liga, float peso) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.modalidadEscuela = modalidadEscuela;
        this.liga = liga;
        this.peso = peso;
    }
}

