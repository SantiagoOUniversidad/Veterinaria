package co.edu.uniquindio.veterinaria.Modelo;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder

public class Persona {
    private String nombreCompleto;
    private String id;
}
