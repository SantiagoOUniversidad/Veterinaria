package co.edu.uniquindio.veterinaria.Controladores;

import co.edu.uniquindio.veterinaria.Modelo.Persona;
import co.edu.uniquindio.veterinaria.Modelo.Sesion;
import co.edu.uniquindio.veterinaria.Modelo.Veterinaria;
import co.edu.uniquindio.veterinaria.Modelo.Veterinario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class inicioSesionControlador {
    ControladorPrincipal controladorPrincipal = ControladorPrincipal.getInstancia();
    Veterinaria veterinaria = Veterinaria.getInstancia();

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
            if (cedula.equals("123456")){
                ControladorPrincipal.openView("panelAdmin.fxml", "Panel de Administrador", new Stage());
                ControladorPrincipal.cerrarVentana((Stage) txtCedula.getScene().getWindow());
            }
            if (veterinaria.mostrarPersona(cedula) == null){
                throw new Exception("Persona no encontrada");
            }
            if (veterinaria.mostrarPersona(cedula) != null){
                if (veterinaria.mostrarPersona(cedula) instanceof Veterinario){
                    Sesion sesion = Sesion.getInstancia();
                    sesion.setPersona(veterinaria.mostrarPersona(cedula));
                    ControladorPrincipal.openView("panelVeterinario.fxml", "Panel de Veterinario", new Stage());
                    ControladorPrincipal.cerrarVentana((Stage) txtCedula.getScene().getWindow());
                } else {
                    Sesion sesion = Sesion.getInstancia();
                    sesion.setPersona(veterinaria.mostrarPersona(cedula));
                    ControladorPrincipal.openView("panelPersonalApoyo.fxml", "Panel de Personal de Apoyo", new Stage());
                    ControladorPrincipal.cerrarVentana((Stage) txtCedula.getScene().getWindow());
                }
            }
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
