package co.edu.uniquindio.veterinaria.Modelo;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor

public class Cita {
    private String idCita;
    private LocalDate fecha;
    private LocalTime hora;
    private EstadoConsulta estadoConsulta;
    private Veterinario veterinario;
    private Mascota mascota;

    @Override
    public String toString() {
        return "Id" + ", " + idCita + ", " + fecha + ", " +  hora + ", " + estadoConsulta + ", " + "Nombre del paciente" + ": " +mascota.getNombre() + ", " + "Veterinario" + ": " + veterinario.getNombreCompleto();
    }
}