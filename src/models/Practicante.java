package models;

import DatabaseConnection.DBConnection;
import records.Examen;
import records.Grado;

import java.time.LocalDate;
import java.util.ArrayList;

public final class Practicante {
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

    /**Guarda el practicante, sus grados y examenes en la base de datos
     *@return {#Participantes insertados, #grados insertados, #examenes insertados}
     * */
    public int[] saveInDB(DBConnection db) {
        String insertP = String.format(
                "INSERT INTO PRACTICANTES (%s, %s, %s, %s, %s, %s, %s, %s)",
                cedula, nombres, apellidos, fechaNacimiento, modalidadEscuela,
                nacionalidad, fechaIngresoLiga, peso
        );
        String insertG = "INSERT INTO GRADOS ";
        for (Grado g : grados) {
            String values = String.format("(%s, %s, %s, %s),",
                    cedula, g.getFechaHoraExamen(), g.getModalidad(), g.getDescripcion());
            insertG += values;
        }
        StringBuffer sbG = new StringBuffer(insertG);
        sbG.deleteCharAt(sbG.length()-1);
        insertG = new String(sbG);
        String insertE = "INSERT INTO EXAMENES ";
        for (Examen e : examenes) {
            String values = String.format("(%s, %s, %s, %s, %s, %s, %s),",
                    cedula, e.getFechaHora(), e.getPuntajeCombate(), e.getPuntajeFiguras(),
                    e.getIndicador(), e.getGradoPresentado(), e.getNumeroGradoPresentado()
            );
            insertE += values;
        }
        StringBuffer sbE = new StringBuffer(insertE);
        sbE.deleteCharAt(sbE.length()-1);
        insertE = new String(sbE);
        return new int[] {db.executeSQL(insertP), db.executeSQL(insertG), db.executeSQL(insertE)};
    }

    public void updateInDB(DBConnection db) {
        String sqlP = "UPDATE PRACTICANTES cedula=" + cedula + "...";
        String valuesG = "";
        for (Grado g : grados) {

        }
    }
}

