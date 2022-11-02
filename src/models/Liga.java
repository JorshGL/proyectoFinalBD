package models;

import DatabaseConnection.DBConnection;

import java.time.LocalDate;

public final class Liga {
    private final String personeriaJuridica;
    private final LocalDate fechaAfiliacion;
    private final String modalidadEscuela;
    private final String ciudadSede;

    public Liga(String personeriaJuridica, LocalDate fechaAfiliacion, String modalidadEscuela, String ciudadSede) {
        this.personeriaJuridica = personeriaJuridica;
        this.fechaAfiliacion = fechaAfiliacion;
        this.modalidadEscuela = modalidadEscuela;
        this.ciudadSede = ciudadSede;
    }

    public String getPersoneriaJuridica() {
        return personeriaJuridica;
    }

    public LocalDate getFechaAfiliacion() {
        return fechaAfiliacion;
    }

    public String getModalidadEscuela() {
        return modalidadEscuela;
    }

    public String getCiudadSede() {
        return ciudadSede;
    }

    public int saveInDB(DBConnection db) {
        String sql = String.format(
                "INSERT INTO LIGAS (%s, %s, %s, %s)",
                personeriaJuridica, fechaAfiliacion, modalidadEscuela, ciudadSede
        );
        return db.executeSQL(sql);
    }
}
