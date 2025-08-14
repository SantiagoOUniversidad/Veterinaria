package co.edu.uniquindio.veterinaria.Modelo;


import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder

//Modelo inicio

public class Veterinaria {
    private String nombre;
    private String nit;
    private List<Persona> listaPersonas;
    private List<Cita> listaCitas;
    private List<Mascota> listaMascotas;
    private List<Cita> listaCitasDelDia;

    // validacion existencia persona
    public boolean verificarPersonaExiste(Persona persona) {
        for (Persona usuario : listaPersonas) {
            if (persona.getId().equals(usuario.getId())) {
                return true;
            }
        }
        return false;
    }

    //agregar persona a la lista
    public boolean agregarPersona(Persona persona) {
        if (verificarPersonaExiste(persona)) {
            return false;
        } else {
            listaPersonas.add(persona);
            return true;
        }
    }

    // eliminar persona de la lista
    public boolean eliminarPersona(String id) {
        for (int i = 0; i < listaPersonas.size(); i++) {
            if (listaPersonas.get(i).getId().equals(id)) {
                listaPersonas.remove(i);
                return true;
            }
        }
        return false;
    }

    // actualizar persona de la lista
    public boolean actualizarPersona(String id, Persona persona) {
        for (int i = 0; i < listaPersonas.size(); i++) {
            if (listaPersonas.get(i).getId().equals(id)) {
                listaPersonas.set(i, persona);
                return true;
            }
        }
        return false;
    }

    // mostrar persona en la lista
    public Persona mostrarPersona(String id) {
        for (Persona persona : listaPersonas) {
            if (persona.getId().equals(id)) {
                return persona;
            }
        }
        return null;
    }


    //validacion existencia mascota
    public boolean verificarMascotaExiste(Mascota mascota) {
        for (Mascota mascota1 : listaMascotas) {
            if (mascota.getIdveterinario().equals(mascota1.getIdveterinario())) {
                return true;
            }
        }
        return false;
    }

    // agregar mascota a la lista
    public boolean agregarMascota(Mascota mascota) {
        if (verificarMascotaExiste(mascota)) {
            return false;
        } else {
            listaMascotas.add(mascota);
            return true;
        }
    }

    // eliminar mascota de la lista
    public boolean eliminarMascota(String id) {
        for (int i = 0; i < listaMascotas.size(); i++) {
            if (listaMascotas.get(i).getIdveterinario().equals(id)) {
                listaMascotas.remove(i);
                return true;
            }
        }
        return false;
    }

    //actualizar mascota de la lista
    public boolean actualizarMascota(String id, Mascota mascota) {
        for (int i = 0; i < listaMascotas.size(); i++) {
            if (listaMascotas.get(i).getIdveterinario().equals(id)) {
                listaMascotas.set(i, mascota);
                return true;
            }
        }
        return false;
    }

    //mostrar mascota en la lista
    public Mascota mostrarMascota(String id) {
        for (Mascota mascota : listaMascotas) {
            if (mascota.getIdveterinario().equals(id)) {
                return mascota;
            }
        }
        return null;
    }

    public boolean agregarVeterinario(Veterinario veterinario) {
        if (veterinario == null) {
            return false;
        }
        return agregarPersona(veterinario);
    }

    public boolean eliminarVeterinario(String id) {
        if (id == null) return false;
        Persona persona = mostrarPersona(id);
        if (persona instanceof Veterinario) {
            return eliminarPersona(id);
        }
        return false;
    }

    public boolean actalizarVeterinario(Veterinario veterinario, String id) {
        if (id == null || veterinario == null) return false;
        Persona persona = mostrarPersona(id);
        if (persona instanceof Veterinario) {
            return actualizarPersona(id, veterinario);
        }
        return false;
    }

    public Veterinario mostrarVeterinario(String id) {
        if (id == null) return null;
        Persona persona = mostrarPersona(id);
        if (persona instanceof Veterinario) {
            return (Veterinario) persona;
        }
        return null;
    }

    public boolean agregarPersonalApoyo(PersonalApoyo personalApoyo) {
        if (personalApoyo == null) {
            return false;
        }
        return agregarPersona(personalApoyo);
    }

    public boolean eliminarPersonalApoyo(String id) {
        if (id == null) return false;
        Persona persona = mostrarPersona(id);
        if (persona instanceof PersonalApoyo) {
            return eliminarPersona(id);
        }
        return false;
    }

    public boolean actualizarPersonalApoyo(PersonalApoyo personalApoyo, String id) {
        if (id == null || personalApoyo == null) return false;
        Persona persona = mostrarPersona(id);
        if (persona instanceof PersonalApoyo) {
            return actualizarPersona(id, personalApoyo);
        }
        return false;
    }

    public PersonalApoyo mostrarPersonalApoyo(String id) {
        if (id == null) return null;
        Persona persona = mostrarPersona(id);
        if (persona instanceof PersonalApoyo) {
            return (PersonalApoyo) persona;
        }
        return null;
    }

    //validacion existencia cita
    public boolean verificarCitaExiste(Cita cita) {
        for (Cita cita1 : listaCitas) {
            if (cita.getIdCita().equals(cita1.getIdCita())) {
                return true;
            }
        }
        return false;
    }

    // agregar cita a la lista
    public boolean agregarCitaVeterinaria(Cita cita) {
        if (verificarCitaExiste(cita)) {
            return false;
        } else {
            listaCitas.add(cita);
            return true;
        }
    }

    // eliminar cita de la lista
    public boolean eliminarCita(String id) {
        for (int i = 0; i < listaCitas.size(); i++) {
            if (listaCitas.get(i).getIdCita().equals(id)) {
                listaCitas.remove(i);
                return true;
            }
        }
        return false;
    }

    //actualizar cita de la lista
    public boolean actualizarCita(String id, Cita cita) {
        for (int i = 0; i < listaCitas.size(); i++) {
            if (listaCitas.get(i).getIdCita().equals(id)) {
                listaCitas.set(i, cita);
                return true;
            }
        }
        return false;
    }

    //mostrar cita en la lista
    public Cita mostrarCita(String id) {
        for (Cita cita : listaCitas) {
            if (cita.getIdCita().equals(id)) {
                return cita;
            }
        }
        return null;
    }

    public boolean verificarCitaMascotaExiste(Cita cita) {
        Mascota mascota1 = cita.getMascota();
        for (Cita cita1 : mascota1.getListaCitasMascota()) {
            if (cita.getIdCita().equals(cita1.getIdCita())) {
                return true;
            }
        }
        return false;
    }

    // agregar cita a la lista
    public boolean agregarCitaMascota(Cita cita) {
        Mascota mascota1 = cita.getMascota();
        if (verificarCitaMascotaExiste(cita)) {
            return false;
        } else {
            mascota1.getListaCitasMascota().add(cita);
            return true;
        }
    }

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

    public boolean verificarCitaVeterinarioExiste(Cita cita) {
        Veterinario veterinario = cita.getVeterinario();
        for (Cita cita1 : veterinario.getListaCitasVeterinario()) {
            if (cita.getIdCita().equals(cita1.getIdCita())) {
                return true;
            }
        }
        return false;
    }

    // agregar cita a la lista
    public boolean agregarCitaVeterinario(Cita cita) {
        Veterinario veterinario = cita.getVeterinario();
        if (verificarCitaVeterinarioExiste(cita)) {
            return false;
        } else {
            veterinario.getListaCitasVeterinario().add(cita);
            return true;
        }
    }

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

    public void agregarCitaDiaVeterinario(Cita cita) {
        if (cita == null) {
            return;
        }
        LocalDate hoy = LocalDate.now();
        if (cita.getFecha().equals(hoy)) {
            cita.getVeterinario().getListaCitasDiaVeterinario().add(cita);
        }
    }

    public void eliminarCitaDiaVeterinario(Veterinario veterinario) {
        if (veterinario == null) {
            return;
        }
        LocalDate hoy = LocalDate.now();
        List<Cita> lista = veterinario.getListaCitasDiaVeterinario();
        for (int  i = lista.size()-1 ; i >=0; i--) {
            Cita cita = lista.get(i);
            if (cita.getFecha().isBefore(hoy) || cita.getEstadoConsulta() == EstadoConsulta.ATENDIDA) {
                lista.remove(i);
            }
        }
    }

    public void actualizarListaCitasDiaVeterinario(Cita cita) {
        if  (cita == null || cita.getVeterinario() == null) {
            return;
        }
        agregarCitaDiaVeterinario(cita);
        eliminarCitaDiaVeterinario(cita.getVeterinario());
    }

    public boolean verificarConsultaMascota(Consulta consulta) {
        Mascota mascota = consulta.getMascota();
        for (Consulta consulta1: mascota.getListaConsultasMascota()) {
            if (consulta.getCodigoConsulta().equals(consulta1.getCodigoConsulta())) {
                return true;
            }
        }
        return false;
    }


    public boolean agregarConsultaMascota(Consulta consulta) {
        Mascota mascota = consulta.getMascota();
        if (verificarConsultaMascota(consulta)) {
            return false;
        } else {
            return mascota.getListaConsultasMascota().add(consulta);
        }
    }

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

    public void eliminarCitaDia() {
        LocalDate hoy = LocalDate.now();
        for (int  i = listaCitasDelDia.size()-1 ; i >=0; i--) {
            Cita cita = listaCitasDelDia.get(i);
            if (cita.getFecha().isBefore(hoy) || cita.getEstadoConsulta() == EstadoConsulta.ATENDIDA) {
                listaCitasDelDia.remove(i);
            }
        }
    }

    public void actualizarCitasDia(Cita cita) {
        if  (cita == null) {
            return;
        }
        agregarCitaDia(cita);
        eliminarCitaDia();
    }







}



