package co.edu.uniquindio.veterinaria.Modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonalApoyoTest {
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
                .listaCitasDiaVeterinario(new ArrayList<>())
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

        // Agregar consultas a listas de veterinarios y mascotas
        vet1.getListaConsultasVeterinario().add(consulta1);
        vet2.getListaConsultasVeterinario().add(consulta2);
        mascota1.getListaConsultasMascota().add(consulta1);
        mascota2.getListaConsultasMascota().add(consulta2);

        // Crear cita
        cita1 = new Cita("1", LocalDate.of(2025, 8, 15), LocalTime.of(10, 30),
                EstadoConsulta.PENDIENTE, vet1, mascota1);

        vet1.getListaCitasVeterinario().add(cita1);
        mascota1.getListaCitasMascota().add(cita1);

        // Agregar datos a Veterinaria
        veterinaria.getListaPersonas().add(vet1);
        veterinaria.getListaPersonas().add(vet2);
        veterinaria.getListaPersonas().add(apoyo1);
        veterinaria.getListaPersonas().add(propietario1);
        veterinaria.getListaMascotas().add(mascota1);
        veterinaria.getListaMascotas().add(mascota2);
        propietario1.getListaMascotasPropietario().add(mascota1);
        propietario1.getListaMascotasPropietario().add(mascota2);
        veterinaria.getListaCitas().add(cita1);

    }


    @Test
    void agregarPropietario() {
        Propietario propietario2 = Propietario.builder()
                .id("PR2")
                .nombreCompleto("Ana Martínez")
                .telefono("123456789")
                .direccion("Calle 123")
                .listaMascotasPropietario(new ArrayList<>())
                .build();
        assertTrue(apoyo1.agregarPropietario(veterinaria, propietario2));
    }

    @Test
    void eliminarPropietario() {
        assertTrue(apoyo1.eliminarPropietario(veterinaria, "PR1"));
    }

    @Test
    void actualizarPropietario() {
        Propietario propietario2 = Propietario.builder()
                .id("PR2")
                .nombreCompleto("Ana Martínez")
                .telefono("123456789")
                .direccion("Calle 123")
                .listaMascotasPropietario(new ArrayList<>())
                .build();
        assertTrue(apoyo1.actualizarPropietario(veterinaria, propietario2, "PR1"));
    }

    @Test
    void mostrarPropietario() {
        assertEquals(apoyo1.mostrarPropietario(veterinaria, "PR1"), propietario1);
    }

    @Test
    void agregarMascota() {
        Mascota mascota3 = new Mascota("Canelo", "Perro", "Labrador", "5", "0002",
                new ArrayList<>(), new ArrayList<>(), propietario1);
        assertTrue(apoyo1.agregarMascota(veterinaria, mascota3));
    }

    @Test
    void eliminarMascota() {
        assertTrue(apoyo1.eliminarMascota(veterinaria, "0000"));
    }

    @Test
    void actualizarMascota() {
        Mascota mascota3 = new Mascota("Canelo", "Perro", "Labrador", "5", "0002",
                new ArrayList<>(), new ArrayList<>(), propietario1);
        assertTrue(apoyo1.actualizarMascota(veterinaria, mascota3, "0000"));
    }

    @Test
    void mostrarMascota() {
        assertEquals(apoyo1.mostrarMascota(veterinaria, "0000"), mascota1);
    }

    @Test
    void agregarCita() {
        Cita cita2 = new Cita("2", LocalDate.of(2025, 9, 15), LocalTime.of(8, 30),
                EstadoConsulta.PENDIENTE, vet1, mascota2);
        assertTrue(apoyo1.agregarCita(veterinaria, cita2));
    }

    @Test
    void eliminarCita() {
        veterinaria.getListaCitas().add(cita1);
        assertTrue(apoyo1.eliminarCita(veterinaria, "1"));
    }

    @Test
    void actualizarCita() {
        veterinaria.getListaCitas().add(cita1);
        Cita cita2 = new Cita("2", LocalDate.of(2025, 9, 15), LocalTime.of(8, 30),
                EstadoConsulta.PENDIENTE, vet1, mascota2);
        apoyo1.actualizarCita(veterinaria,cita2,"1");
        assertEquals(veterinaria.getListaCitas().contains(cita1), true);
    }

    @Test
    void mostrarCita() {

        assertEquals(cita1, apoyo1.mostrarCita(veterinaria, "1"));
    }

    @Test
    void actualizarEstadoCita() {
       apoyo1.actualizarEstadoCita(veterinaria, cita1, EstadoConsulta.CANCELADA);
        assertEquals(EstadoConsulta.CANCELADA, cita1.getEstadoConsulta());
    }

    @Test
    void citasDelDia() {

        String citasHoy = apoyo1.citasDelDia(veterinaria);
        assertTrue(citasHoy.contains("1"));
    }
}
