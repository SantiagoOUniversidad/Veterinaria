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
                .listaPersonas(new ArrayList<>()).listaCitas(new ArrayList<>()).listaMascotas(new ArrayList<>()).listaCitasDelDia(new ArrayList<>()).build();


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
        consulta1 = new Consulta("1", "Otitis", "Antibióticos", true, mascota1, vet1);
        consulta2 = new Consulta("2", "Herida", "Curación", false, mascota2, vet2);


        // Crear cita
        cita1 = new Cita("1", LocalDate.of(2025, 8, 15), LocalTime.of(10, 30),
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
        assertTrue(veterinaria.verificarPersonaExiste(propietario1));
        assertTrue(veterinaria.verificarPersonaExiste(apoyo1));
        assertTrue(veterinaria.verificarPersonaExiste(vet1));
    }

    @Test
    void agregarPersona() {
        Persona apoyo2 = PersonalApoyo.builder()
                .id("P2")
                .nombreCompleto("Felipe")
                .build();
        assertTrue(veterinaria.agregarPersona(apoyo2));
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
        assertTrue(veterinaria.actualizarPersona("P1", apoyo2));
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
        Veterinario vet3 = Veterinario.builder()
                .id("V3")
                .nombreCompleto("Pedro Pérez")
                .especialidad("Cardiología")
                .listaCitasVeterinario(new ArrayList<>())
                .listaConsultasVeterinario(new ArrayList<>())
                .build();
        assertTrue(veterinaria.agregarVeterinario(vet3));
    }

    @Test
    void eliminarVeterinario() {
        assertTrue(veterinaria.eliminarVeterinario("V1"));
    }

    @Test
    void actalizarVeterinario() {
        Veterinario vetNuevo = Veterinario.builder()
                .id("V1")
                .nombreCompleto("Carlos López Renovado")
                .especialidad("Cirugía Avanzada")
                .listaCitasVeterinario(new ArrayList<>())
                .listaConsultasVeterinario(new ArrayList<>())
                .build();
        assertTrue(veterinaria.actualizarVeterinario(vetNuevo, "V1"));
    }

    @Test
    void mostrarVeterinario() {
        assertEquals(vet1, veterinaria.mostrarVeterinario("V1"));
    }


    @Test
    void agregarPersonalApoyo() {
        PersonalApoyo apoyoNuevo = PersonalApoyo.builder()
                .id("P3")
                .nombreCompleto("alfonso")
                .build();
        assertTrue(veterinaria.agregarPersonalApoyo(apoyoNuevo));
    }

    @Test
    void eliminarPersonalApoyo() {

        assertTrue(veterinaria.eliminarPersonalApoyo("P1"));
    }

    @Test
    void actualizarPersonalApoyo() {

        PersonalApoyo apoyoNuevo = PersonalApoyo.builder()
                .id("P3")
                .nombreCompleto("alfonso")
                .build();
        assertTrue(veterinaria.actualizarPersonalApoyo(apoyoNuevo, "P1"));
    }

    @Test
    void mostrarPersonalApoyo() {
        veterinaria.getListaPersonas().add(apoyo1);
        assertEquals(apoyo1, veterinaria.mostrarPersonalApoyo("P1"));
    }

    @Test
    void verificarCitaExiste() {

        assertTrue(veterinaria.verificarCitaExiste(cita1));
    }

    @Test
    void eliminarCita() {
        veterinaria.getListaCitas().add(cita1);
        assertTrue(veterinaria.eliminarCita("1"));
    }

    @Test
    void actualizarCita() {
        veterinaria.getListaCitas().add(cita1);
        Cita citaNueva = new Cita("4", LocalDate.of(2025, 9, 15), LocalTime.of(10, 0),
                EstadoConsulta.PENDIENTE, vet1, mascota2);
        assertTrue(veterinaria.actualizarCita("1", citaNueva));
    }

    @Test
    void mostrarCita() {
        veterinaria.getListaCitas().add(cita1);
        assertEquals(cita1, veterinaria.mostrarCita("1"));
    }

    @Test
    void verificarCitaMascotaExiste() {
        assertTrue(veterinaria.verificarCitaMascotaExiste(cita1));
    }

    @Test
    void agregarCitaMascota() {
        Cita citaNueva = new Cita("4", LocalDate.of(2025, 9, 15), LocalTime.of(10, 0),
                EstadoConsulta.PENDIENTE, vet1, mascota2);
        assertTrue(veterinaria.agregarCitaMascota(citaNueva));
    }

    @Test
    void eliminarCitaMascota() {
        assertTrue(veterinaria.eliminarCitaMascota("1"));
    }

    @Test
    void actualizarCitaMascota() {
        Cita citaNueva = new Cita("4", LocalDate.of(2025, 9, 15), LocalTime.of(10, 0),
                EstadoConsulta.PENDIENTE, vet1, mascota1);
        assertTrue(veterinaria.actualizarCitaMascota("1", citaNueva));
    }

    @Test
    void agregarCitaVeterinaria() {
        Cita citaNueva = new Cita("4", LocalDate.of(2025, 9, 15), LocalTime.of(10, 0),
                EstadoConsulta.PENDIENTE, vet1, mascota1);
        assertTrue(veterinaria.agregarCitaVeterinaria(citaNueva));
    }

    @Test
    void verificarCitaVeterinarioExiste() {
        assertTrue(veterinaria.verificarCitaVeterinarioExiste(cita1));
    }

    @Test
    void agregarCitaVeterinario() {
        Cita citaNueva = new Cita("4", LocalDate.of(2025, 9, 15), LocalTime.of(10, 0),
                EstadoConsulta.PENDIENTE, vet1, mascota2);
        assertTrue(veterinaria.agregarCitaVeterinario(citaNueva));
    }

    @Test
    void eliminarCitaVeterinario() {
        assertTrue(veterinaria.eliminarCitaVeterinario("1"));
    }

    @Test
    void actualizarCitaVeterinario() {
        Cita citaNueva = new Cita("4", LocalDate.of(2025, 9, 15), LocalTime.of(10, 0),
                EstadoConsulta.PENDIENTE, vet1, mascota1);
        assertTrue(veterinaria.actualizarCitaVeterinario("1", citaNueva));
    }

    @Test
    void agregarCitaGeneral() {
        Cita citaNueva = new Cita("5", LocalDate.of(2025, 10, 5), LocalTime.of(9, 30),
                EstadoConsulta.PENDIENTE, vet1, mascota1);
        assertTrue(veterinaria.agregarCitaGeneral(citaNueva));
    }

    @Test
    void actualizarEstadoCita() {
        assertTrue(veterinaria.actualizarEstadoCita(cita1, EstadoConsulta.ATENDIDA));
    }

    @Test
    void agregarCitaDiaVeterinario() {
        Cita citaNueva = new Cita("5", LocalDate.of(2025, 10, 5), LocalTime.of(9, 30),
                EstadoConsulta.PENDIENTE, vet1, mascota1);
        assertTrue(veterinaria.agregarCitaDiaVeterinario(citaNueva));
    }

    @Test
    void eliminarCitaDiaVeterinario() {
        assertTrue(veterinaria.eliminarCitaDiaVeterinario(vet1));
    }

    @Test
    void actualizarListaCitasDiaVeterinario() {
        assertTrue(veterinaria.actualizarListaCitasDiaVeterinario(cita1));
    }

    @Test
    void verificarConsultaMascota() {

        assertTrue(veterinaria.verificarConsultaMascota(consulta1));
    }

    @Test
    void agregarConsultaMascota() {
        Consulta consulta3 = new Consulta("3", "Tos De Perrera", "Antibióticos", true, mascota1, vet1);
        assertTrue(veterinaria.agregarConsultaMascota(consulta3));
    }
    @Test
    void agregarCitaDia() {


        Cita citaHoy = new Cita(
                "C001",
                LocalDate.now(),
                LocalTime.of(10, 0),
                EstadoConsulta.PENDIENTE,
                vet1,
                null
        );

        veterinaria.agregarCitaDia(citaHoy);

        assertTrue(veterinaria.getListaCitasDelDia().contains(citaHoy));
        assertTrue(vet1.getListaCitasDiaVeterinario().contains(citaHoy));
    }

    @Test
    void eliminarCitaDia() {

        Cita citaPasada = new Cita(
                "C002",
                LocalDate.now().minusDays(1),
                LocalTime.of(10, 0),
                EstadoConsulta.PENDIENTE,
                vet1,
                null
        );

        Cita citaAtendida = new Cita(
                "C003",
                LocalDate.now(),
                LocalTime.of(11, 0),
                EstadoConsulta.ATENDIDA,
                vet1,
                null
        );

        veterinaria.getListaCitasDelDia().add(citaPasada);
        veterinaria.getListaCitasDelDia().add(citaAtendida);

        veterinaria.eliminarCitaDia();

        assertFalse(veterinaria.getListaCitasDelDia().contains(citaPasada));
        assertFalse(veterinaria.getListaCitasDelDia().contains(citaAtendida));
    }

    @Test
    void actualizarCitasDia() {


        Cita citaHoy = new Cita(
                "C004",
                LocalDate.now(),
                LocalTime.of(12, 0),
                EstadoConsulta.PENDIENTE,
                vet1,
                null
        );

        veterinaria.actualizarCitasDia(citaHoy);

        assertTrue(veterinaria.getListaCitasDelDia().contains(citaHoy));
        assertTrue(vet1.getListaCitasDiaVeterinario().contains(citaHoy));
    }


}