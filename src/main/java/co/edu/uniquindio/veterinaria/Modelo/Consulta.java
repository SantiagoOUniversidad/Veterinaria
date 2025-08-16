package co.edu.uniquindio.veterinaria.Modelo;

import lombok.*;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor

public class Consulta {
    private String codigoConsulta;
    private String diagnostico, tratamiento;
    private boolean medicina;
    private Mascota mascota;
    private Veterinario veterinario;

    @Override
    public String toString() {
        return "Codigo: " + codigoConsulta +
                ", Diagnostico: " + diagnostico +
                ", Tratamiento: " + tratamiento +
                ", Medicina: " + medicina +
                ", mascota: " + mascota;
    }
}
