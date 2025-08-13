package co.edu.uniquindio.veterinaria.Modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor

public class Cita {
    private String idCita;
    private LocalDate fecha;
    private LocalTime hora;
    private EstadoConsulta estadoConsulta;
    private Veterinario veterinario;
    private Mascota mascota;
}