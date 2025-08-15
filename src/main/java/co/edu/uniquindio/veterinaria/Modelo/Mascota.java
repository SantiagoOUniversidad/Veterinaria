package co.edu.uniquindio.veterinaria.Modelo;

import lombok.*;

import java.util.List;
@Data
@Builder
@EqualsAndHashCode
@ToString
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
}
