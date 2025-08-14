package co.edu.uniquindio.veterinaria.Controladores;

import co.edu.uniquindio.veterinaria.Modelo.PersonalApoyo;
import co.edu.uniquindio.veterinaria.Modelo.Veterinaria;
import co.edu.uniquindio.veterinaria.Modelo.Veterinario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class panelAdminControlador {
    Veterinaria veterinaria = Veterinaria.getInstancia();
    ControladorPrincipal controladorPrincipal = ControladorPrincipal.getInstancia();

    @FXML
    private TextField txtNombreVet;

    @FXML
    private TextField txtCedulaVet;

    @FXML
    private TextField txtEspecialidad;

    @FXML
    private TextField txtEliminarVet;

    @FXML
    private TextField txtNombreApoyo;

    @FXML
    private TextField txtCedulaApoyo;

    @FXML
    private TextField txtEliminarApoyo;

    @FXML
    void onAgregarVet(ActionEvent event) {
        crearVeterinario();
    }
    @FXML
    void onAgregarApoyo(ActionEvent event) {
        crearApoyo();
    }

    @FXML
    void onEliminarVet(ActionEvent event) {
        eliminarVeterinario();
    }

    @FXML
    void onEliminarApoyo(ActionEvent event) {
        eliminarApoyo();
    }

    @FXML
    void onVolver(ActionEvent event) throws IOException {
        ControladorPrincipal.openView("inicioSesion.fxml", "Iniciar Sesion", new Stage());
        ControladorPrincipal.cerrarVentana((Stage) txtCedulaVet.getScene().getWindow());
    }

    private void crearVeterinario() {
        String nombre =  txtNombreVet.getText();
        String cedula = txtCedulaVet.getText();
        String especialidad = txtEspecialidad.getText();
        Veterinario veterinario = Veterinario.builder().nombreCompleto(nombre).id(cedula).especialidad(especialidad).build();
        if (!veterinaria.agregarVeterinario(veterinario)){
            controladorPrincipal.crearAlerta("Error al crear veterinario", Alert.AlertType.ERROR);
        } else {
            controladorPrincipal.crearAlerta("Veterinario creado", Alert.AlertType.INFORMATION);
        }
    }

    private void crearApoyo() {
        String nombre =  txtNombreApoyo.getText();
        String cedula = txtCedulaApoyo.getText();
        PersonalApoyo apoyo = PersonalApoyo.builder().nombreCompleto(nombre).id(cedula).build();
        if (!veterinaria.agregarPersonalApoyo(apoyo)){
            controladorPrincipal.crearAlerta("Error al agregar personal apoyo", Alert.AlertType.ERROR);
        } else {
            controladorPrincipal.crearAlerta("Personal apoyo creado", Alert.AlertType.INFORMATION);
        }
    }

    private void eliminarVeterinario() {
        String cedula = txtEliminarVet.getText();
        if (!veterinaria.eliminarVeterinario(cedula)){
            controladorPrincipal.crearAlerta("Error al eliminar veterinario", Alert.AlertType.ERROR);
        } else {
            controladorPrincipal.crearAlerta("Veterinario eliminado", Alert.AlertType.INFORMATION);
        }
    }

    private void eliminarApoyo() {
        String cedula = txtEliminarApoyo.getText();
        if (!veterinaria.eliminarPersonalApoyo(cedula)){
            controladorPrincipal.crearAlerta("Error al eliminar personal apoyo", Alert.AlertType.ERROR);
        } else {
            controladorPrincipal.crearAlerta("Personal apoyo eliminado", Alert.AlertType.INFORMATION);
        }
    }

}
