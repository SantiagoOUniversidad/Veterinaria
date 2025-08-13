package co.edu.uniquindio.veterinaria;

import co.edu.uniquindio.veterinaria.Controladores.ControladorPrincipal;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class VeterinariaApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ControladorPrincipal controladorPrincipal = ControladorPrincipal.getInstancia();
        ControladorPrincipal.openView("inicioSesion.fxml", "Inicio Sesion", stage);
    }
}
