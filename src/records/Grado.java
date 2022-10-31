package records;

import java.time.LocalDateTime;

public final class Grado {
    private final LocalDateTime fechaHoraExamen;
    private final String modalidad;
    private final String descripcion;

    public Grado(LocalDateTime fechaHoraExamen, String modalidad, String descripcion) {
        this.fechaHoraExamen = fechaHoraExamen;
        this.modalidad = modalidad;
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaHoraExamen() {
        return fechaHoraExamen;
    }

    public String getModalidad() {
        return modalidad;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
