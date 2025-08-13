package co.edu.uniquindio.veterinaria.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;

public class inicioSesionControlador {
    ControladorPrincipal controladorPrincipal = ControladorPrincipal.getInstancia();

    @FXML
    private TextField txtCedula;

    @FXML
    private Button btnIniciar;

    @FXML
    void onBtnIniciar(ActionEvent event) {
        iniciarSesion();
    }

    private void iniciarSesion(){
        try {
            String cedula = txtCedula.getText();
            camposVacios(cedula);
        } catch (Exception e) {
            controladorPrincipal.crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void camposVacios(String cedula) throws Exception {
        if (cedula.isEmpty()){
            throw new Exception("Rellena todos los campos");
        }
    }
}
