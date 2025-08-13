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
        if (veterinaria == null || id == null) return false;
        Persona persona = veterinaria.mostrarPersona(id);
        if (persona instanceof Propietario) {
            return veterinaria.eliminarPersona(id);
        }
        return false;
    }

    public boolean actualizarPropietario(Veterinaria veterinaria, Propietario propietario, String id) {
        if (veterinaria == null || id == null || propietario == null) return false;
        Persona persona = veterinaria.mostrarPersona(id);
        if (persona instanceof Propietario) {
            return veterinaria.actualizarPersona(id, propietario);
        }
        return false;
    }

    public Propietario mostrarPropietario(Veterinaria veterinaria, String id) {
        if (veterinaria == null || id == null) return null;
        Persona persona = veterinaria.mostrarPersona(id);
        if (persona instanceof Propietario) {
            return (Propietario) persona;
        }
        return null;
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
