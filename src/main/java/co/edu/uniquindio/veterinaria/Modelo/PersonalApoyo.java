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

    /**
     * Metodo para agregar un propietario a lista de veterinaria
     * @param veterinaria
     * @param propietario
     * @return boolean
     */

    public boolean agregarPropietario(Veterinaria veterinaria, Propietario propietario) {
        if (veterinaria == null || propietario == null) {
            return false;
        }
        return veterinaria.agregarPersona(propietario);
    }

    /**
     * Metodo para eliminar un propietario de la lista de veterinaria
     * @param veterinaria
     * @param id
     * @return boolean
     */

    public boolean eliminarPropietario(Veterinaria veterinaria, String id) {
        if (veterinaria == null || id == null) return false;
        Persona persona = veterinaria.mostrarPersona(id);
        if (persona instanceof Propietario) {
            return veterinaria.eliminarPersona(id);
        }
        return false;
    }

    /**
     * Metodo para actualizar un propietario de la lista de veterinaria
     * @param veterinaria
     * @param propietario
     * @param id
     * @return boolean
     */

    public boolean actualizarPropietario(Veterinaria veterinaria, Propietario propietario, String id) {
        if (veterinaria == null || id == null || propietario == null) return false;
        Persona persona = veterinaria.mostrarPersona(id);
        if (persona instanceof Propietario) {
            return veterinaria.actualizarPersona(id, propietario);
        }
        return false;
    }

    /**
     * Metodo para mostrar los datos de un propietario de la lista veterinaria
     * @param veterinaria
     * @param id
     * @return propietario
     */

    public Propietario mostrarPropietario(Veterinaria veterinaria, String id) {
        if (veterinaria == null || id == null) return null;
        Persona persona = veterinaria.mostrarPersona(id);
        if (persona instanceof Propietario) {
            return (Propietario) persona;
        }
        return null;
    }

    /**
     * Metodo para agregar una mascota a la lista de veterinaria
     * @param veterinaria
     * @param mascota
     * @return boolean
     */

    public boolean agregarMascota(Veterinaria veterinaria, Mascota mascota) {
        if (veterinaria == null || mascota == null) {
            return false;
        }
        return veterinaria.agregarMascota(mascota);
    }

    /**
     * Metodo para eliminar una mascota de la lista de veterinaria
     * @param veterinaria
     * @param idVeterinario
     * @return boolean
     */

    public boolean eliminarMascota(Veterinaria veterinaria, String idVeterinario) {
        if (veterinaria == null || idVeterinario == null) {
            return false;
        }
        return veterinaria.eliminarMascota(idVeterinario);
    }

    /**
     * Metodo para actualizar una mascota de la lista de veterinaria
     * @param veterinaria
     * @param mascota
     * @param idVeterinario
     * @return boolean
     */

    public boolean actualizarMascota(Veterinaria veterinaria, Mascota mascota, String idVeterinario) {
        if (veterinaria == null || idVeterinario == null || mascota == null) {
            return false;
        }
        return veterinaria.actualizarMascota(idVeterinario, mascota);
    }

    /**
     * Metodo para mostrar una mascota de la lista de veterinaria
     * @param veterinaria
     * @param idVeterinario
     * @return mascota
     */

    public Mascota mostrarMascota(Veterinaria veterinaria, String idVeterinario) {
        if (veterinaria == null || idVeterinario == null) {
            return null;
        }
        return veterinaria.mostrarMascota(idVeterinario);
    }

    /**
     * Metodo para agregar una cita a la lista de veterinaria
     * @param veterinaria
     * @param cita
     * @return boolean
     */

    public boolean agregarCita(Veterinaria veterinaria, Cita cita) {
        if (veterinaria == null || cita == null) {
            return false;
        }
         veterinaria.agregarCitaGeneral(cita);
         veterinaria.actualizarCitasDia(cita);
        return true;

    }

    /**
     * Metodo para eliminar una cita de la lista de veterinaria
     * @param veterinaria
     * @param id
     * @return boolean
     */

    public boolean eliminarCita(Veterinaria veterinaria, String id) {
        if (veterinaria == null || id == null) {
            return false;
        }
        Cita cita = veterinaria.mostrarCita(id);
        return veterinaria.eliminarCita(id) && veterinaria.eliminarCitaMascota(id)
                && veterinaria.eliminarCitaVeterinario(id);
    }

    /**
     * Metodo para actualizar una cita de la lista de veterinaria
     * @param veterinaria
     * @param cita
     * @param idCita
     * @return boolean
     */

    public boolean actualizarCita(Veterinaria veterinaria, Cita cita, String idCita) {
        if (veterinaria == null || idCita == null|| cita == null) {
            return false;
        }
        return veterinaria.actualizarCita(idCita, cita) && veterinaria.actualizarCitaMascota(idCita, cita)
                && veterinaria.actualizarCitaVeterinario(idCita, cita);
    }

    /**
     * Metodo para mostrar una cita de la lista de veterinaria
     * @param veterinaria
     * @param idCita
     * @return cita
     */

    public Cita mostrarCita(Veterinaria veterinaria, String idCita) {
        if (veterinaria == null || idCita == null) {
            return null;
        }
        return veterinaria.mostrarCita(idCita);
    }

    /**
     * Metodo para actualizar el estado de una cita existente
     * @param veterinaria
     * @param cita
     * @param estadoConsulta
     * @return boolean
     */

    public boolean actualizarEstadoCita(Veterinaria veterinaria, Cita cita, EstadoConsulta estadoConsulta) {
        if (veterinaria == null || estadoConsulta == null || cita == null) return false;
        return veterinaria.actualizarEstadoCita(cita, estadoConsulta);
    }

    /**
     * Metodo para generar un String con todas las citas del día
     * @param veterinaria
     * @return String
     */

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
