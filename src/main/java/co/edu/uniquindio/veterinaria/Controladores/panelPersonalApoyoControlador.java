package co.edu.uniquindio.veterinaria.Controladores;

import co.edu.uniquindio.veterinaria.Modelo.Persona;
import co.edu.uniquindio.veterinaria.Modelo.Sesion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class panelPersonalApoyoControlador implements Initializable {
    Persona persona =  Sesion.getInstancia().getPersona();

    @FXML
    private Label lblNombre;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblNombre.setText("Hola, " + persona.getNombreCompleto());
    }

    @FXML
    void onVolver(ActionEvent event) throws IOException {
        Sesion.getInstancia().cerrarSesion();
        ControladorPrincipal.openView("inicioSesion.fxml", "Iniciar Sesion", new Stage());
        ControladorPrincipal.cerrarVentana((Stage) lblNombre.getScene().getWindow());
    }

    @FXML
    void onPyM(ActionEvent event) throws IOException {
        ControladorPrincipal.openView("panelPyM.fxml", "Panel Propietarios y Mascotas", new Stage());
        ControladorPrincipal.cerrarVentana((Stage) lblNombre.getScene().getWindow());
    }

    @FXML
    void onCitas(ActionEvent event) throws IOException {
        ControladorPrincipal.openView("panelCrearCitas.fxml", "Panel Agendar Citas", new Stage());
        ControladorPrincipal.cerrarVentana((Stage) lblNombre.getScene().getWindow());
    }
}
