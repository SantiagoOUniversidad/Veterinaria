package co.edu.uniquindio.veterinaria.Modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor

public class Persona {
    private String nombreCompleto;
    private String id;

    @Override
    public String toString() {
        return "Nombre: " + nombreCompleto +
                ", ID: " + id;
    }
}
