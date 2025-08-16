package co.edu.uniquindio.veterinaria.Controladores;

import co.edu.uniquindio.veterinaria.Modelo.Cita;
import co.edu.uniquindio.veterinaria.Modelo.Sesion;
import co.edu.uniquindio.veterinaria.Modelo.Veterinaria;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class panelVeterinarioControlador {
    Sesion sesion = Sesion.getInstancia();
    Veterinaria veterinaria = Veterinaria.getInstancia();

    @FXML
    private Label lblVeterinario;

    @FXML
    private ListView<Cita> lvVeterinario;

    ObservableList<Cita> citas;

    @FXML
    public void initialize() {
        lblVeterinario.setText("Hola, " + sesion.getPersona().getNombreCompleto());
        citas = FXCollections.observableArrayList(veterinaria.getListaCitas());
        lvVeterinario.setItems(citas);
    }

    @FXML
    void onVolver(ActionEvent event) throws IOException {
        Sesion.getInstancia().cerrarSesion();
        ControladorPrincipal.openView("inicioSesion.fxml", "Iniciar Sesion", new Stage());
        ControladorPrincipal.cerrarVentana((Stage) lblVeterinario.getScene().getWindow());
    }

    @FXML
    void onAtenderCita(ActionEvent event) throws IOException {
        ControladorPrincipal.openView("panelConsulta.fxml", "Panel Citas", new Stage());
        ControladorPrincipal.cerrarVentana((Stage) lblVeterinario.getScene().getWindow());
    }

    @FXML
    void onVerConsultas(ActionEvent event) throws IOException {
        ControladorPrincipal.openView("panelVerConsultas.fxml", "Ver Consultas", new Stage());
        ControladorPrincipal.cerrarVentana((Stage) lblVeterinario.getScene().getWindow());
    }
}
