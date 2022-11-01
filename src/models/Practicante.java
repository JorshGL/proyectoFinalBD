package models;

import DatabaseConnection.DBConnection;
import records.Grado;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Practicante {
    private final String cedula;
    private final String nombres;
    private final String apellidos;
    private final LocalDate fechaNacimiento;
    private final String nacionalidad;
    private final ArrayList<Grado> grados = new ArrayList<>();
    private final ArrayList<Examen> examenes = new ArrayList<>();
    private String modalidadEscuela;
    private LocalDate fechaIngresoLiga;
    private float peso;


    public Practicante(String cedula, String nombres, String apellidos, LocalDate fechaNacimiento, String nacionalidad, ArrayList<Grado> grados, ArrayList<Examen> examenes, String modalidadEscuela, LocalDate fechaIngresoLiga, float peso) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.grados.addAll(grados);
        this.examenes.addAll(examenes);
        this.modalidadEscuela = modalidadEscuela;
        this.fechaIngresoLiga = fechaIngresoLiga;
        this.peso = peso;
    }

    public Practicante(HashMap<String, Object> data) {
        this.cedula = (String)data.get("cedula");
        this.nombres = (String)data.get("nombres");
        this.apellidos = (String)data.get("apellidos");
        this.fechaNacimiento = (LocalDate)data.get("fecha_nacimiento");
        this.nacionalidad = (String)data.get("nacionalidad");
        this.grados.addAll((ArrayList<Grado>)data.get("grados"));
        this.examenes.addAll((ArrayList<Examen>)data.get("examen"));
        this.modalidadEscuela = (String)data.get("modalidadEscuela");
        this.fechaIngresoLiga = (LocalDate)data.get("fechaIngresoLiga");
        this.peso = (float)data.get("peso");
    }

    public int saveInDB(DBConnection db) {
        String insertP = "INSERT INTO PRACTICANTES (" + cedula;
        return db.executeSQL(insertP);
    }

    public void updateInDB(DBConnection db) {
        String sqlP = "UPDATE PRACTICANTES cedula=" + cedula + "...";
        String valuesG = "";
        for (Grado g : grados) {

        }
    }
}

