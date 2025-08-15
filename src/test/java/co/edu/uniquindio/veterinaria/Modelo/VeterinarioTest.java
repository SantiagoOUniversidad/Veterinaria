package co.edu.uniquindio.veterinaria.Modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VeterinarioTest {
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
        mascota1 = new Mascota("Firulais", "Perro", "Labrador", "5", "V1",
                new ArrayList<>(), new ArrayList<>(), propietario1);

        mascota2 = new Mascota("Michi", "Gato", "Siames", "3", "V2",
                new ArrayList<>(), new ArrayList<>(), propietario1);

        // Crear consultas
        consulta1 = new Consulta("1","Otitis", "Antibióticos", true, mascota1, vet1);
        consulta2 = new Consulta("2","Herida", "Curación", false, mascota2, vet2);

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
        veterinaria.getListaCitas().add(cita1);
    }


    @Test
    void crearConsultas() {
        Consulta consulta3 = new Consulta("3","Herida", "Curación", false, mascota2, vet2);
        assertTrue(vet2.crearConsultas(veterinaria, consulta3));
    }

    @Test
    void agendaCitasDiaVeterinario() {
        Cita citaHoy = new Cita("2", LocalDate.now(), LocalTime.of(9, 0),
                EstadoConsulta.PENDIENTE, vet1, mascota1);
        vet1.getListaCitasDiaVeterinario().add(citaHoy);

        // Ejecutamos
        String agenda = vet1.agendaCitasDiaVeterinario();

        // Verificamos
        assertTrue(agenda.contains("Citas del día para " + vet1.getNombreCompleto()));
        assertTrue(agenda.contains(citaHoy.getIdCita()));
        assertTrue(agenda.contains(mascota1.getNombre()));
    }

    @Test
    void historialConsultasMascota() {

        String historial = vet1.historialConsultasMascota(mascota1);


        assertTrue(historial.contains("Historial de consultas de " + mascota1.getNombre()));
        assertTrue(historial.contains(consulta1.getCodigoConsulta()));
        assertTrue(historial.contains(consulta1.getDiagnostico()));
        assertTrue(historial.contains(consulta1.getTratamiento()));
    }
}