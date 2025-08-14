package co.edu.uniquindio.veterinaria.Modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor

public class Consulta {
    private String codigoConsulta;
    private String diagnostico, tratamiento;
    private boolean medicina;
    private Mascota mascota;
    private Veterinario veterinario;

}
