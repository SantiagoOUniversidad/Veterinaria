package co.edu.uniquindio.veterinaria.Controladores;

import co.edu.uniquindio.veterinaria.Modelo.Cita;
import co.edu.uniquindio.veterinaria.Modelo.Persona;
import co.edu.uniquindio.veterinaria.Modelo.Sesion;
import co.edu.uniquindio.veterinaria.Modelo.Veterinaria;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class panelPersonalApoyoControlador implements Initializable {
    Persona persona =  Sesion.getInstancia().getPersona();
    Veterinaria veterinaria = Veterinaria.getInstancia();

    @FXML
    private Label lblNombre;

    @FXML
    private ListView<Cita> lvCitas;

    private ObservableList<Cita> citas;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblNombre.setText("Hola, " + persona.getNombreCompleto());
        citas = FXCollections.observableArrayList(veterinaria.getListaCitas());
        lvCitas.setItems(citas);
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
