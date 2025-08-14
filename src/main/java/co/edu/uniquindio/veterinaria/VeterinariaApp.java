package co.edu.uniquindio.veterinaria;

import co.edu.uniquindio.veterinaria.Controladores.ControladorPrincipal;
import co.edu.uniquindio.veterinaria.Modelo.PersonalApoyo;
import co.edu.uniquindio.veterinaria.Modelo.Veterinaria;
import co.edu.uniquindio.veterinaria.Modelo.Veterinario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class VeterinariaApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Veterinaria veterinaria = Veterinaria.getInstancia();
        Veterinario veterinario = Veterinario.builder().nombreCompleto("VetTest").id("123").especialidad("Test").build();
        PersonalApoyo personalTest = PersonalApoyo.builder().nombreCompleto("Test").id("456").build();
        veterinaria.agregarVeterinario(veterinario);
        veterinaria.agregarPersonalApoyo(personalTest);
        ControladorPrincipal.openView("inicioSesion.fxml", "Inicio Sesion", stage);
    }
}
