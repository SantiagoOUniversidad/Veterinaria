package co.edu.uniquindio.veterinaria.Modelo;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

public class Veterinario extends Persona {
    private String especialidad;
    private List<Cita> listaCitasVeterinario;
    private List<Consulta> listaConsultasVeterinario;

    public List<Cita> agendaMedico(Veterinaria veterinaria,Veterinario veterinario) {
        if (veterinaria.getListaCitas().contains(veterinario)) {
            return listaCitasVeterinario;
        }
        return null;
    }
    public boolean crearConsulta(Consulta consulta) {
        if (consulta == null) {
            return false;
        }
        listaConsultasVeterinario.add(consulta);
        return true;
    }

    public List<Consulta> historialMascota(Mascota mascota) {
        List<Consulta> listaConsultasMascotas = new ArrayList<>();
        for (Consulta consulta : listaConsultasVeterinario) {
            if (consulta.getMascota().equals(mascota)) {
                listaConsultasMascotas.add(consulta);
            }
        }
        return listaConsultasMascotas;
    }
}
