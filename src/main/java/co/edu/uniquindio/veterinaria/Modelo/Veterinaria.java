package co.edu.uniquindio.veterinaria.Modelo;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor


public class Veterinaria {
    private String nombre;
    private String nit;
    private List<Persona> listaPersonas;
    private List<Cita> listaCitas;
    private List<Mascota> listaMascotas;
    private List<Cita> listaCitasDelDia;
    private static Veterinaria instancia;

    private Veterinaria() {
        this.nombre = "Veterinaria";
        this.nit = "222222222";
        this.listaPersonas = new ArrayList<>();
        this.listaCitas = new ArrayList<>();
        this.listaMascotas = new ArrayList<>();
        this.listaCitasDelDia = new ArrayList<>();
    }

    //Singleton documentar Olarte
    public static Veterinaria getInstancia() {
        if (instancia == null) {
            instancia = new Veterinaria();
        }
        return instancia;
    }

    /**
     * Metodo para validar la existencia de una persona en una lista
     * @param persona
     * @return boolean
     */

    public boolean verificarPersonaExiste(Persona persona) {
        for (Persona usuario : listaPersonas) {
            if (persona.getId().equals(usuario.getId())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para agregar una persona a una lista
     * @param persona
     * @return boolean
     */
    public boolean agregarPersona(Persona persona) {
        if (verificarPersonaExiste(persona)) {
            return false;
        } else {
            listaPersonas.add(persona);
            return true;
        }
    }

    /**
     * Metodo para eliminar a una persona de una lista
     * @param id
     * @return boolean
     */

    public boolean eliminarPersona(String id) {
        for (int i = 0; i < listaPersonas.size(); i++) {
            if (listaPersonas.get(i).getId().equals(id)) {
                listaPersonas.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para actualizar a una persona de una lista
     * @param id
     * @param persona
     * @return boolean
     */
    public boolean actualizarPersona(String id, Persona persona) {
        for (int i = 0; i < listaPersonas.size(); i++) {
            if (listaPersonas.get(i).getId().equals(id)) {
                listaPersonas.set(i, persona);
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para mostrar una persona de una lista
     * @param id
     * @return persona
     */
    public Persona mostrarPersona(String id) {
        for (Persona persona : listaPersonas) {
            if (persona.getId().equals(id)) {
                return persona;
            }
        }
        return null;
    }

    /**
     * Metodo para validar la existencia de una mascota en una lista
     * @param mascota
     * @return boolean
     */

    public boolean verificarMascotaExiste(Mascota mascota) {
        for (Mascota mascota1 : listaMascotas) {
            if (mascota.getIdveterinario().equals(mascota1.getIdveterinario())) {
                return true;
            }
        }
        return false;
    }

    /**
     * metodo para agregr una mascota a una lista
     * @param mascota
     * @return boolean
     */
    public boolean agregarMascota(Mascota mascota) {
        if (verificarMascotaExiste(mascota)) {
            return false;
        } else {
            listaMascotas.add(mascota);
            return true;
        }
    }

    /**
     * metodo para eliminar una mascota de una lista
     * @param id
     * @return boolean
     */
    public boolean eliminarMascota(String id) {
        for (int i = 0; i < listaMascotas.size(); i++) {
            if (listaMascotas.get(i).getIdveterinario().equals(id)) {
                listaMascotas.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para actualizar una mascota de una lista
     * @param id
     * @param mascota
     * @return boolean
     */
    public boolean actualizarMascota(String id, Mascota mascota) {
        for (int i = 0; i < listaMascotas.size(); i++) {
            if (listaMascotas.get(i).getIdveterinario().equals(id)) {
                listaMascotas.set(i, mascota);
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para mostrar una mascota de una lista
     * @param id
     * @return mascota
     */

    public Mascota mostrarMascota(String id) {
        for (Mascota mascota : listaMascotas) {
            if (mascota.getIdveterinario().equals(id)) {
                return mascota;
            }
        }
        return null;
    }

    /**
     * Metodo para agregar un veterinario a una lista
     * @param veterinario
     * @return boolean
     */

    public boolean agregarVeterinario(Veterinario veterinario) {
        if (veterinario == null) {
            return false;
        }
        return agregarPersona(veterinario);
    }

    /**
     * Metodo para eliminar a un veterinario de una lista
     * @param id
     * @return boolean
     */

    public boolean eliminarVeterinario(String id) {
        if (id == null) return false;
        Persona persona = mostrarPersona(id);
        if (persona instanceof Veterinario) {
            return eliminarPersona(id);
        }
        return false;
    }

    /**
     * Metodo para actualizar un veterinario de una lista
     * @param veterinario
     * @param id
     * @return boolean
     */

    public boolean actualizarVeterinario(Veterinario veterinario, String id) {
        if (id == null || veterinario == null) return false;
        Persona persona = mostrarPersona(id);
        if (persona instanceof Veterinario) {
            return actualizarPersona(id, veterinario);
        }
        return false;
    }

    /**
     * Metodo para mostrar a un veterinrio de una lista
     * @param id
     * @return veterinario
     */

    public Veterinario mostrarVeterinario(String id) {
        if (id == null) return null;
        Persona persona = mostrarPersona(id);
        if (persona instanceof Veterinario) {
            return (Veterinario) persona;
        }
        return null;
    }

    /**
     * Metodo para agregar a un personal de apoyo a una lista
     * @param personalApoyo
     * @return boolean
     */

    public boolean agregarPersonalApoyo(PersonalApoyo personalApoyo) {
        if (personalApoyo == null) {
            return false;
        }
        return agregarPersona(personalApoyo);
    }

    /**
     * Metodo para eliminar a un personal de apoyo de una lista
     * @param id
     * @return boolean
     */

    public boolean eliminarPersonalApoyo(String id) {
        if (id == null) return false;
        Persona persona = mostrarPersona(id);
        if (persona instanceof PersonalApoyo) {
            return eliminarPersona(id);
        }
        return false;
    }

    /**
     * Metodo para actualizar a un personal de apoyo de una lista
     * @param personalApoyo
     * @param id
     * @return boolean
     */

    public boolean actualizarPersonalApoyo(PersonalApoyo personalApoyo, String id) {
        if (id == null || personalApoyo == null) return false;
        Persona persona = mostrarPersona(id);
        if (persona instanceof PersonalApoyo) {
            return actualizarPersona(id, personalApoyo);
        }
        return false;
    }

    /**
     * Metodo para mostrar a un personal de apoyo de una lista
     * @param id
     * @return personalApoyo
     */

    public PersonalApoyo mostrarPersonalApoyo(String id) {
        if (id == null) return null;
        Persona persona = mostrarPersona(id);
        if (persona instanceof PersonalApoyo) {
            return (PersonalApoyo) persona;
        }
        return null;
    }

    /**
     * Metodo para validar la existencia de una cita en una lista
     * @param cita
     * @return boolean
     */

    public boolean verificarCitaExiste(Cita cita) {
        for (Cita cita1 : listaCitas) {
            if (cita.getIdCita().equals(cita1.getIdCita())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para agregar una cita a una lista
     * @param cita
     * @return boolean
     */

    public boolean agregarCitaVeterinaria(Cita cita) {
        if (verificarCitaExiste(cita)) {
            return false;
        } else {
            listaCitas.add(cita);
            return true;
        }
    }

    /**
     * Metodo para eliminar una cita de una lista
     * @param id
     * @return boolean
     */

    public boolean eliminarCita(String id) {
        for (int i = 0; i < listaCitas.size(); i++) {
            if (listaCitas.get(i).getIdCita().equals(id)) {
                listaCitas.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para actualizar una cita de una lista
     * @param id
     * @param cita
     * @return boolean
     */

    public boolean actualizarCita(String id, Cita cita) {
        for (int i = 0; i < listaCitas.size(); i++) {
            if (listaCitas.get(i).getIdCita().equals(id)) {
                listaCitas.set(i, cita);
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para mostrar una cita de una lista
     * @param id
     * @return cita
     */

    public Cita mostrarCita(String id) {
        for (Cita cita : listaCitas) {
            if (cita.getIdCita().equals(id)) {
                return cita;
            }
        }
        return null;
    }

    /**
     * Metodo para validar la exitencia de una cita en una lista de una mascota
     * @param cita
     * @return boolean
     */

    public boolean verificarCitaMascotaExiste(Cita cita) {
        Mascota mascota1 = cita.getMascota();
        for (Cita cita1 : mascota1.getListaCitasMascota()) {
            if (cita.getIdCita().equals(cita1.getIdCita())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para agregar una cita a una lista de una mascota
     * @param cita
     * @return boolean
     */

    public boolean agregarCitaMascota(Cita cita) {
        Mascota mascota1 = cita.getMascota();
        if (verificarCitaMascotaExiste(cita)) {
            return false;
        } else {
            mascota1.getListaCitasMascota().add(cita);
            return true;
        }
    }

    /**
     * Metodo para eliminar una cita de una lista de una mascota
     * @param id
     * @return boolean
     */

    public boolean eliminarCitaMascota(String id) {
        Cita cita1 = mostrarCita(id);
        Mascota mascota1 = cita1.getMascota();
        for (int i = 0; i < mascota1.getListaCitasMascota().size(); i++) {
            if (mascota1.getListaCitasMascota().get(i).getIdCita().equals(id)) {
                mascota1.getListaCitasMascota().remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para actualizar una cita de una lista de una mascota
     * @param id
     * @param cita
     * @return boolean
     */

    public boolean actualizarCitaMascota(String id, Cita cita) {
        Mascota mascota1 = cita.getMascota();
        for (int i = 0; i < mascota1.getListaCitasMascota().size(); i++) {
            if (mascota1.getListaCitasMascota().get(i).getIdCita().equals(id)) {
                mascota1.getListaCitasMascota().set(i, cita);
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para validar la existencia de una cita en una lista de un veterinario
     * @param cita
     * @return boolean
     */

    public boolean verificarCitaVeterinarioExiste(Cita cita) {
        Veterinario veterinario = cita.getVeterinario();
        for (Cita cita1 : veterinario.getListaCitasVeterinario()) {
            if (cita.getIdCita().equals(cita1.getIdCita())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para agregar una cita a una lista de un veterinario
     * @param cita
     * @return boolean
     */

    public boolean agregarCitaVeterinario(Cita cita) {
        Veterinario veterinario = cita.getVeterinario();
        if (verificarCitaVeterinarioExiste(cita)) {
            return false;
        } else {
            veterinario.getListaCitasVeterinario().add(cita);
            return true;
        }
    }

    /**
     * Metodo paraa eliminar una cita de una lista de un veterinario
     * @param id
     * @return boolean
     */

    public boolean eliminarCitaVeterinario(String id) {
        Cita cita1 = mostrarCita(id);
        Veterinario veterinario = cita1.getVeterinario();
        for (int i = 0; i < veterinario.getListaCitasVeterinario().size(); i++) {
            if (veterinario.getListaCitasVeterinario().get(i).getIdCita().equals(id)) {
                veterinario.getListaCitasVeterinario().remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para actualizar una lista de una cita de un veterinario
     * @param id
     * @param cita
     * @return boolean
     */

    public boolean actualizarCitaVeterinario(String id, Cita cita) {
        Veterinario veterinario = cita.getVeterinario();
        for (int i = 0; i < veterinario.getListaCitasVeterinario().size(); i++) {
            if (veterinario.getListaCitasVeterinario().get(i).getIdCita().equals(id)) {
                veterinario.getListaCitasVeterinario().set(i, cita);
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para agregar una cita de forma general a la lista de veterinaria, veterinario y mascota
     * @param cita
     * @return boolean
     */

    public boolean agregarCitaGeneral(Cita cita) {
        if (cita == null) {
            return false;
        }
        if (!agregarCitaVeterinaria(cita)) {
            return false;
        }
        if (!agregarCitaMascota(cita)) {
            eliminarCita(cita.getIdCita());
            return false;
        }
        if (!agregarCitaVeterinario(cita)) {
            eliminarCita(cita.getIdCita());
            eliminarCitaMascota(cita.getIdCita());
            return false;
        }

        actualizarListaCitasDiaVeterinario(cita);
        return true;
    }

    /**
     * Metodo para actualizar el estado de una cita ya existente en la lista de un veterinario, una mascota y la veterinaria
     * @param cita
     * @param nuevoEstado
     * @return boolean
     */

    public boolean actualizarEstadoCita(Cita cita, EstadoConsulta nuevoEstado) {
        if (cita == null) {
            return false;
        }
        cita.setEstadoConsulta(nuevoEstado);
        if (nuevoEstado == EstadoConsulta.CANCELADA) {
            if (cita.getVeterinario() != null) {
                cita.getVeterinario().getListaCitasVeterinario().remove(cita);
                if (cita.getVeterinario().getListaCitasDiaVeterinario().contains(cita)) {
                    cita.getVeterinario().getListaCitasDiaVeterinario().remove(cita);
                }
            }
            if (cita.getMascota() != null) {
                cita.getMascota().getListaCitasMascota().remove(cita);
            }
        }
        if (nuevoEstado == EstadoConsulta.ATENDIDA) {
            actualizarCita(cita.getIdCita(), cita);
            actualizarCitaMascota(cita.getIdCita(), cita);
            actualizarCitaVeterinario(cita.getIdCita(), cita);
        }
        return true;
    }

    /**
     * Metodo para agregar una cita a una lista de citas del dia de un veterinario
     * @param cita
     */

    public boolean agregarCitaDiaVeterinario(Cita cita) {
        if (cita == null) {
            return false;
        }
        LocalDate hoy = LocalDate.now();
        if (cita.getFecha().equals(hoy)) {
            cita.getVeterinario().getListaCitasDiaVeterinario().add(cita);
        }
        return true;
    }

    /**
     * Metodo para eliminar una cita de una lista de citas del dia de un veterinario
     * @param veterinario
     */

    public boolean eliminarCitaDiaVeterinario(Veterinario veterinario) {
        if (veterinario == null) {
            return false;
        }
        LocalDate hoy = LocalDate.now();
        List<Cita> lista = veterinario.getListaCitasDiaVeterinario();
        if (lista == null) {
            lista = new ArrayList<>();
            veterinario.setListaCitasDiaVeterinario(lista);
        }

        for (int  i = lista.size()-1 ; i >=0; i--) {
            Cita cita = lista.get(i);
            if (cita.getFecha().isBefore(hoy) || cita.getEstadoConsulta() == EstadoConsulta.ATENDIDA) {
                lista.remove(i);
            }
        }
        return true;
    }

    /**
     * Metodo para actualizar las citas de una lista de citas del dia de un veterinario
     * @param cita
     */

    public boolean actualizarListaCitasDiaVeterinario(Cita cita) {
        if  (cita == null || cita.getVeterinario() == null) {
            return false;
        }
        agregarCitaDiaVeterinario(cita);
        eliminarCitaDiaVeterinario(cita.getVeterinario());
        return true;
    }

    /**
     * Metodo para validar la existencia de una consulta en una lista de una mascota
     * @param consulta
     * @return boolean
     */

    public boolean verificarConsultaMascota(Consulta consulta) {
        Mascota mascota = consulta.getMascota();
        for (Consulta consulta1: mascota.getListaConsultasMascota()) {
            if (consulta.getCodigoConsulta().equals(consulta1.getCodigoConsulta())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para agregar una consulta a una lista de una mascota
     * @param consulta
     * @return boolean
     */

    public boolean agregarConsultaMascota(Consulta consulta) {
        Mascota mascota = consulta.getMascota();
        if (verificarConsultaMascota(consulta)) {
            return false;
        } else {
            return mascota.getListaConsultasMascota().add(consulta);
        }
    }

    /**
     * Metodo para agregar una cita a una lista de citas del dia de una veterinaria
     * @param cita
     */

    public void agregarCitaDia(Cita cita) {
        if (cita == null) {
            return;
        }
        LocalDate hoy = LocalDate.now();
        if (cita.getFecha().equals(hoy)) {
            cita.getVeterinario().getListaCitasDiaVeterinario().add(cita);
        }
        listaCitasDelDia.add(cita);
    }

    /**
     * Metodo para eliminar una cita de una lista de citas del dia de una veterinaria
     */

    public void eliminarCitaDia() {
        LocalDate hoy = LocalDate.now();
        for (int  i = listaCitasDelDia.size()-1 ; i >=0; i--) {
            Cita cita = listaCitasDelDia.get(i);
            if (cita.getFecha().isBefore(hoy) || cita.getEstadoConsulta() == EstadoConsulta.ATENDIDA) {
                listaCitasDelDia.remove(i);
            }
        }
    }

    /**
     * Metodo para actualizar las citas de una lista de citas del dia de una veterinaria
     * @param cita
     */

    public void actualizarCitasDia(Cita cita) {
        if  (cita == null) {
            return;
        }
        agregarCitaDia(cita);
        eliminarCitaDia();
    }
}