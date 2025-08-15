package co.edu.uniquindio.veterinaria.Modelo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor

public class Sesion {
    // Singleton documentar Olarte "/**"
    public static Sesion instancia;
    private Persona persona;

    private Sesion() {
        this.persona = null;
    }

    // Getter de nuestra instancia documentar Olarte
    public static Sesion getInstancia() {
        if (instancia == null) {
            instancia = new Sesion();
        }
        return instancia;
    }

    // Metodo para cerrar sesion documentar Olarte
    public void cerrarSesion(){
        persona = null;
    }
}