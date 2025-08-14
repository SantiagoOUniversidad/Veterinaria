package co.edu.uniquindio.veterinaria.Modelo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor

public class Sesion {
    // Singleton
    public static Sesion instancia;
    private Persona persona;

    private Sesion() {
        this.persona = null;
    }

    // Getter de nuestra instancia
    public static Sesion getInstancia() {
        if (instancia == null) {
            instancia = new Sesion();
        }
        return instancia;
    }

    // Metodo para cerrar sesion
    public void cerrarSesion(){
        persona = null;
    }
}