package co.edu.uniquindio.veterinaria.Modelo;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

public class PersonalApoyo extends Persona {

    public boolean agregarPropietario(Veterinaria veterinaria, Propietario propietario) {
        if (veterinaria == null || propietario == null) {
            return false;
        }
        return veterinaria.agregarPersona(propietario);
    }

    public boolean eliminarPropietario(Veterinaria veterinaria, String id) {
        if (veterinaria == null || id == null) {
            return false;
        }
        return veterinaria.eliminarPersona(id);
    }

    public boolean actualizarPropietario(Veterinaria veterinaria, Propietario propietario, String id) {
        if (veterinaria == null || id == null || propietario == null) {
            return false;
        }
        return veterinaria.actualizarPersona(id, propietario);
    }

    public Persona mostrarPropietario(Veterinaria veterinaria, String id) {
        if (veterinaria == null || id == null) {
            return null;
        }
        return veterinaria.mostrarPersona(id);
    }

    public boolean agregarMascota(Veterinaria veterinaria, Mascota mascota) {
        if (veterinaria == null || mascota == null) {
            return false;
        }
        return veterinaria.agregarMascota(mascota);
    }

    public boolean eliminarMascota(Veterinaria veterinaria, String idVeterinario) {
        if (veterinaria == null || idVeterinario == null) {
            return false;
        }
        return veterinaria.eliminarMascota(idVeterinario);
    }

    public boolean actualizarMascota(Veterinaria veterinaria, Mascota mascota, String idVeterinario) {
        if (veterinaria == null || idVeterinario == null || mascota == null) {
            return false;
        }
        return veterinaria.actualizarMascota(idVeterinario, mascota);
    }

    public Mascota mostrarMascota(Veterinaria veterinaria, String idVeterinario) {
        if (veterinaria == null || idVeterinario == null) {
            return null;
        }
        return veterinaria.mostrarMascota(idVeterinario);
    }

}
