package records;

import java.time.LocalDateTime;

public final class Examen {
    private final LocalDateTime fechaHora;
    private final int puntajeCombate;
    private final int puntajeFiguras;
    private final String indicador;
    private final String gradoPresentado;
    private final int numeroGradoPresentado;

    public Examen(LocalDateTime fechaHora, int puntajeCombate, int puntajeFiguras, String indicador, String gradoPresentado, int numeroGradoPresentado) {
        this.fechaHora = fechaHora;
        this.puntajeCombate = puntajeCombate;
        this.puntajeFiguras = puntajeFiguras;
        this.indicador = indicador;
        this.gradoPresentado = gradoPresentado;
        this.numeroGradoPresentado = numeroGradoPresentado;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public int getPuntajeCombate() {
        return puntajeCombate;
    }

    public int getPuntajeFiguras() {
        return puntajeFiguras;
    }

    public String getIndicador() {
        return indicador;
    }

    public String getGradoPresentado() {
        return gradoPresentado;
    }

    public int getNumeroGradoPresentado() {
        return numeroGradoPresentado;
    }
}
