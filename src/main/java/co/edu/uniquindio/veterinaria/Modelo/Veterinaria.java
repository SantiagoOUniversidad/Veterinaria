package co.edu.uniquindio.veterinaria.Modelo;

import java.util.List;

public class Veterinaria {
    private String nombre;
    private String nit;
    private List<Persona> listaPersonas;
    private List<Cita> listaCitas;
    private List<Mascota> listaMascotas;


    public boolean verificarPersonaExiste(Persona persona) {
        for (Persona usuario : listaPersonas) {
            if(persona.getId().equals(usuario.getId())) {
                return true;
            }
        }
        return false;
    }

    public boolean agregarPersona(Persona persona) {
        if (verificarPersonaExiste(persona)) {
            return false;
        } else {
            listaPersonas.add(persona);
            return true;
        }
    }

    public boolean eliminarPersona(String id) {
        for (int i = 0; i < listaPersonas.size(); i++) {
            if(listaPersonas.get(i).getId().equals(id)) {
                listaPersonas.remove(i);
                return true;
            }
        } return false;
    }

    public boolean actualizarPersona(String id, Persona persona) {
        for (int i = 0; i < listaPersonas.size(); i++) {
            if(listaPersonas.get(i).getId().equals(id)) {
                listaPersonas.set(i, persona);
                return true;
            }
        } return false;
    }

    public Persona mostrarPersona(String id) {
        for (Persona persona : listaPersonas) {
            if(persona.getId().equals(id)) {
                return persona;
            }
        } return null;
    }



    public boolean verificarMascotaExiste(Mascota mascota) {
        for (Mascota mascota1: listaMascotas) {
            if(mascota.getIdveterinario().equals(mascota1.getIdveterinario())) {
                return true;
            }
        }
        return false;
    }

    public boolean agregarMascota(Mascota mascota) {
        if (verificarMascotaExiste(mascota)) {
            return false;
        } else {
            listaMascotas.add(mascota);
            return true;
        }
    }

    public boolean eliminarMascota(String id) {
        for (int i = 0; i < listaMascotas.size(); i++) {
            if(listaMascotas.get(i).getIdveterinario().equals(id)) {
                listaMascotas.remove(i);
                return true;
            }
        } return false;
    }

    public boolean actualizarMascota(String id, Mascota mascota) {
        for (int i = 0; i < listaMascotas.size(); i++) {
            if(listaMascotas.get(i).getIdveterinario().equals(id)) {
                listaMascotas.set(i, mascota);
                return true;
            }
        } return false;
    }

    public Mascota mostrarMascota(String id) {
        for (Mascota mascota : listaMascotas) {
            if(mascota.getIdveterinario().equals(id)) {
                return mascota;
            }
        } return null;
    }
}

