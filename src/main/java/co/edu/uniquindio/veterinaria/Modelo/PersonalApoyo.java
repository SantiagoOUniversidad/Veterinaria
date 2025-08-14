package co.edu.uniquindio.veterinaria.Modelo;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public boolean agregarCita(Veterinaria veterinaria, Cita cita) {
        if (veterinaria == null || cita == null) {
            return false;
        }
         veterinaria.agregarCitaGeneral(cita);
         veterinaria.actualizarCitasDia(cita);
        return true;

    }

    public boolean eliminarCita(Veterinaria veterinaria, String id) {
        if (veterinaria == null || id == null) {
            return false;
        }
        Cita cita = veterinaria.mostrarCita(id);
        return veterinaria.eliminarCita(id) && veterinaria.eliminarCitaMascota(id)
                && veterinaria.eliminarCitaVeterinario(id);
    }

    public boolean actualizarCita(Veterinaria veterinaria, Cita cita, String idCita) {
        if (veterinaria == null || idCita == null|| cita == null) {
            return false;
        }
        return veterinaria.actualizarCita(idCita, cita) && veterinaria.actualizarCitaMascota(idCita, cita)
                && veterinaria.actualizarCitaVeterinario(idCita, cita);
    }
    public Cita mostrarCita(Veterinaria veterinaria, String idCita) {
        if (veterinaria == null || idCita == null) {
            return null;
        }
        return veterinaria.mostrarCita(idCita);
    }

    public boolean actualizarEstadoCita(Veterinaria veterinaria, Cita cita, EstadoConsulta estadoConsulta) {
        if (veterinaria == null || estadoConsulta == null || cita == null) return false;
        return veterinaria.actualizarEstadoCita(cita, estadoConsulta);
    }

    public String citasDelDia(Veterinaria veterinaria) {
        if (veterinaria == null) return null;
        StringBuilder citasDelDia = new StringBuilder();
        citasDelDia.append("citas de hoy").append(LocalDate.now()).append("\n");
        for (Cita cita : veterinaria.getListaCitasDelDia()){
            citasDelDia.append(cita.getIdCita()).append(cita.getVeterinario()).append("\t")
                    .append(cita.getMascota()).append("\t").append(cita.getHora()).append("\t")
                    .append(cita.getEstadoConsulta()).append("\t").append("\n");
        }
        return citasDelDia.toString();
    }





}
