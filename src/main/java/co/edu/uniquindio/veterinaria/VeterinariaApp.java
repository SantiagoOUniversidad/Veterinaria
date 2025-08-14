package co.edu.uniquindio.veterinaria;

import co.edu.uniquindio.veterinaria.Controladores.ControladorPrincipal;
import co.edu.uniquindio.veterinaria.Modelo.Veterinaria;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class VeterinariaApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ControladorPrincipal controladorPrincipal = ControladorPrincipal.getInstancia();
        ControladorPrincipal.openView("inicioSesion.fxml", "Inicio Sesion", stage);
    }
}
