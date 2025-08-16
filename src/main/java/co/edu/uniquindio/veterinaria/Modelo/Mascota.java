package co.edu.uniquindio.veterinaria.Modelo;

import lombok.*;

import java.util.List;
@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class Mascota {
    private String nombre, especie, raza, edad, idveterinario;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Cita> listaCitasMascota;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Consulta> listaConsultasMascota;

    private Propietario propietario;

    @Override
    public String toString() {
        return "Mascota: " +
                "nombre: " + nombre +
                ", especie: " + especie +
                ", raza: " + raza +
                ", edad: " + edad +
                ", veterinario: " + idveterinario;
    }
}
