package co.edu.uniquindio.veterinaria.Modelo;

import lombok.*;
        import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

public class Propietario extends Persona {
    private String telefono;
    private String direccion;
    @Builder.Default
    private List<Mascota> listaMascotasPropietario = new ArrayList<>();
}
