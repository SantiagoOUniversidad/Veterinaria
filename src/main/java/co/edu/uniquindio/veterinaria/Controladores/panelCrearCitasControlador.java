package co.edu.uniquindio.veterinaria.Controladores;

import co.edu.uniquindio.veterinaria.Modelo.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class panelCrearCitasControlador {
    Veterinaria veterinaria = Veterinaria.getInstancia();
    ControladorPrincipal controladorPrincipal = ControladorPrincipal.getInstancia();

    @FXML
    private TextField txtNumeroCita;

    @FXML
    private DatePicker dtFecha;

    @FXML
    private TextField txtHora;

    @FXML
    private ComboBox<EstadoConsulta> cbEstado;

    @FXML
    private TextField txtCedulaVet;

    @FXML
    private TextField txtIdMascota;

    @FXML
    public void initialize() {
        ObservableList<EstadoConsulta> estadoConsulta = FXCollections.observableArrayList(
                EstadoConsulta.PENDIENTE,
                EstadoConsulta.ATENDIDA,
                EstadoConsulta.CANCELADA
        );
        cbEstado.setItems(estadoConsulta);
    }

    @FXML
    void onCrearCitas(ActionEvent event) {
        crearCita();
    }

    @FXML
    void onEliminarCita(ActionEvent event) {
        eliminarCita();
    }

    @FXML
    void onVolver(ActionEvent event) throws IOException {
        ControladorPrincipal.openView("panelPersonalApoyo.fxml", "Panel Personal Apoyo", new Stage());
        ControladorPrincipal.cerrarVentana((Stage) txtHora.getScene().getWindow());
    }

    private void eliminarCita() {
        String cita = txtNumeroCita.getText();
        try {
            if (!veterinaria.eliminarCita(cita)) {
                throw new Exception("Error al eliminar la cita");
            } else  {
                controladorPrincipal.crearAlerta("Cita cancelada", Alert.AlertType.INFORMATION);
            }
        } catch (Exception e) {
            controladorPrincipal.crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void crearCita() {
        String numeroCita = txtNumeroCita.getText();
        LocalDate fecha = dtFecha.getValue();
        LocalTime hora = horaSeleccionada();
        EstadoConsulta estadoConsulta = cbEstado.getValue();
        String cedulaVet = txtCedulaVet.getText();
        String idMascota = txtIdMascota.getText();
        try {
            Veterinario veterinario = veterinaria.mostrarVeterinario(cedulaVet);
            Mascota mascota = veterinaria.mostrarMascota(idMascota);
            Cita cita = Cita.builder().idCita(numeroCita).fecha(fecha).hora(hora).estadoConsulta(estadoConsulta).veterinario(veterinario).mascota(mascota).build();
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
            return null;
        }
    }

}
