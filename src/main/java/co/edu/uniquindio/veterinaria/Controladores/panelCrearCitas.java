package co.edu.uniquindio.veterinaria.Controladores;

import co.edu.uniquindio.veterinaria.Modelo.Cita;
import co.edu.uniquindio.veterinaria.Modelo.Mascota;
import co.edu.uniquindio.veterinaria.Modelo.Veterinaria;
import co.edu.uniquindio.veterinaria.Modelo.Veterinario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class panelCrearCitas {
    Veterinaria veterinaria = Veterinaria.getInstancia();
    ControladorPrincipal controladorPrincipal = ControladorPrincipal.getInstancia();

    @FXML
    private TextField txtNumeroCita;

    @FXML
    private DatePicker dtFecha;

    @FXML
    private TextField txtHora;

    @FXML
    private TextField txtCedulaVet;

    @FXML
    private TextField txtIdMascota;

    @FXML
    void onCrearCitas(ActionEvent event) {
        crearCita();
    }

    private void crearCita() {
        String numeroCita = txtNumeroCita.getText();
        LocalDate fecha = dtFecha.getValue();
        LocalTime hora = horaSeleccionada();
        String cedulaVet = txtCedulaVet.getText();
        String idMascota = txtIdMascota.getText();
        try {
            Veterinario veterinario = veterinaria.mostrarVeterinario(cedulaVet);
            Mascota mascota = veterinaria.mostrarMascota(idMascota);
            Cita cita = Cita.builder().idCita(numeroCita).fecha(fecha).hora(hora).veterinario(veterinario).mascota(mascota).build();
            if (!veterinaria.agregarCitaVeterinaria(cita)) {
                throw new Exception("Error al agregar cita");
            } else {
                controladorPrincipal.crearAlerta("Cita agendada", Alert.AlertType.INFORMATION);
            }
        } catch (Exception e) {
            controladorPrincipal.crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public LocalTime horaSeleccionada() {
        try {
            return LocalTime.parse(txtHora.getText());
        } catch (DateTimeParseException e) {
            // Manejar error si el formato es incorrecto
            return null;
        }
    }

}
