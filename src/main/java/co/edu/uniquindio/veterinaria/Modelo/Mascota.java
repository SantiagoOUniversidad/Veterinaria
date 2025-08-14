package co.edu.uniquindio.veterinaria.Modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor

public class Mascota {
    private String nombre, especie, raza, edad, idveterinario;
    private List<Cita> listaCitasMascota;
    private List<Consulta> listaConsultasMascota;
    private Propietario propietario;


}
