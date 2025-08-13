package co.edu.uniquindio.veterinaria.Modelo;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

public class Veterinario extends Persona {
    private String especialidad;
    private List<Cita> listaCitasVeterinario;
    private List<Consulta> listaConsultasVeterinario;
}
