package co.edu.uniquindio.veterinaria.Modelo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class VeterinariaTest {

    private Veterinaria veterinaria;
    private Veterinario vet1, vet2;
    private PersonalApoyo apoyo1;
    private Propietario propietario1;
    private Mascota mascota1, mascota2;
    private Consulta consulta1, consulta2;
    private Cita cita1;

    @BeforeEach
    public void setUp() {
        veterinaria = Veterinaria.builder().nombre("veterinaria 24/7").nit("1234")
                .listaPersonas(new ArrayList<>()).listaCitas(new ArrayList<>()).listaMascotas(new ArrayList<>()).build();


        // Crear veterinarios
        vet1 = Veterinario.builder()
                .id("V1")
                .nombreCompleto("Carlos López")
                .especialidad("Cirugía")
                .listaCitasVeterinario(new ArrayList<>())
                .listaConsultasVeterinario(new ArrayList<>())
                .build();

        vet2 = Veterinario.builder()
                .id("V2")
                .nombreCompleto("María Gómez")
                .especialidad("Dermatología")
                .listaCitasVeterinario(new ArrayList<>())
                .listaConsultasVeterinario(new ArrayList<>())
                .build();

        // Crear personal de apoyo
        apoyo1 = PersonalApoyo.builder()
                .id("P1")
                .nombreCompleto("Luis Fernández")
                .build();

        // Crear propietario
        propietario1 = Propietario.builder()
                .id("PR1")
                .nombreCompleto("Ana Martínez")
                .telefono("123456789")
                .direccion("Calle 123")
                .listaMascotasPropietario(new ArrayList<>())
                .build();

        // Crear mascotas
        mascota1 = new Mascota("Firulais", "Perro", "Labrador", "5", "0000",
                new ArrayList<>(), new ArrayList<>(), propietario1);

        mascota2 = new Mascota("Michi", "Gato", "Siames", "3", "0001",
                new ArrayList<>(), new ArrayList<>(), propietario1);

        // Crear consultas
        consulta1 = new Consulta("1","Otitis", "Antibióticos", true, mascota1, vet1);
        consulta2 = new Consulta("2","Herida", "Curación", false, mascota2, vet2);



        // Crear cita
        cita1 = new Cita("1",LocalDate.of(2025, 8, 15), LocalTime.of(10, 30),
                EstadoConsulta.PENDIENTE, vet1, mascota1);

        vet1.getListaCitasVeterinario().add(cita1);
        mascota1.getListaCitasMascota().add(cita1);

        // Agregar consultas a listas de veterinarios y mascotas
        vet1.getListaConsultasVeterinario().add(consulta1);
        vet2.getListaConsultasVeterinario().add(consulta2);
        mascota1.getListaConsultasMascota().add(consulta1);
        mascota2.getListaConsultasMascota().add(consulta2);

        // Agregar datos a Veterinaria
        veterinaria.getListaPersonas().add(vet1);
        veterinaria.getListaPersonas().add(vet2);
        veterinaria.getListaPersonas().add(apoyo1);
        veterinaria.getListaPersonas().add(propietario1);
        veterinaria.getListaMascotas().add(mascota1);
        veterinaria.getListaMascotas().add(mascota2);
        veterinaria.getListaCitas().add(cita1);
    }


    @Test
    void verificarPersonaExiste() {
       assertTrue (veterinaria.verificarPersonaExiste(propietario1));
       assertTrue(veterinaria.verificarPersonaExiste(apoyo1));
       assertTrue(veterinaria.verificarPersonaExiste(vet1));
    }

    @Test
    void agregarPersona() {
        Persona apoyo2 = PersonalApoyo.builder()
                .id("P2")
                .nombreCompleto("Felipe")
                .build();
        assertTrue (veterinaria.agregarPersona(apoyo2));
    }

    @Test
    void eliminarPersona() {
        assertTrue(veterinaria.eliminarPersona("V1"));
    }

    @Test
    void actualizarPersona() {
        Persona apoyo2 = PersonalApoyo.builder()
                .id("P2")
                .nombreCompleto("Felipe")
                .build();
        assertTrue(veterinaria.actualizarPersona("P1",apoyo2 ));
    }

    @Test
    void mostrarPersona() {
        assertEquals(veterinaria.mostrarPersona("V1"), vet1);
        assertEquals(veterinaria.mostrarPersona("P1"), apoyo1);
    }

    @Test
    void verificarMascotaExiste() {
        assertTrue(veterinaria.verificarMascotaExiste(mascota1));
        assertTrue(veterinaria.verificarMascotaExiste(mascota2));
    }

    @Test
    void agregarMascota() {
        Mascota mascota3 = new Mascota("Canelo", "Perro", "Labrador", "5", "0002",
                new ArrayList<>(), new ArrayList<>(), propietario1);
        assertTrue(veterinaria.agregarMascota(mascota3));
    }

    @Test
    void eliminarMascota() {
        assertTrue(veterinaria.eliminarMascota("0000"));
    }

    @Test
    void actualizarMascota() {
        Mascota mascota2 = new Mascota("Canelo", "Perro", "Labrador", "5", "0001",
                new ArrayList<>(), new ArrayList<>(), propietario1);
        assertTrue(veterinaria.actualizarMascota("0001", mascota2));
    }

    @Test
    void mostrarMascota() {
        assertEquals(veterinaria.mostrarMascota("0001"), mascota2);
    }

    @Test
    void agregarVeterinario() {

    }

    @Test
    void eliminarVeterinario() {
    }

    @Test
    void actalizarVeterinario() {
    }

    @Test
    void mostrarVeterinario() {
    }

    @Test
    void agregarPersonalApoyo() {
    }

    @Test
    void eliminarPersonalApoyo() {
    }

    @Test
    void actualizarPersonalApoyo() {
    }

    @Test
    void mostrarPersonalApoyo() {
    }

    @Test
    void verificarCitaExiste() {
    }

    @Test
    void agregarCitaVeterinaria() {
    }

    @Test
    void eliminarCita() {
    }

    @Test
    void actualizarCita() {
    }

    @Test
    void mostrarCita() {
    }

    @Test
    void verificarCitaMascotaExiste() {
    }

    @Test
    void agregarCitaMascota() {
    }

    @Test
    void eliminarCitaMascota() {
    }

    @Test
    void actualizarCitaMascota() {
    }

    @Test
    void verificarCitaVeterinarioExiste() {
    }

    @Test
    void agregarCitaVeterinario() {
    }

    @Test
    void eliminarCitaVeterinario() {
    }

    @Test
    void actualizarCitaVeterinario() {
    }

    @Test
    void agregarCitaGeneral() {
    }

    @Test
    void actualizarEstadoCita() {
    }

    @Test
    void agregarCitaDiaVeterinario() {
    }

    @Test
    void eliminarCitaDiaVeterinario() {
    }

    @Test
    void actualizarListaCitasDiaVeterinario() {
    }

    @Test
    void verificarConsultaMascota() {
    }

    @Test
    void agregarConsultaMascota() {
    }

    @Test
    void agregarCitaDia() {
    }

    @Test
    void eliminarCitaDia() {
    }

    @Test
    void actualizarCitasDia() {
    }
}
