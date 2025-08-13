package co.edu.uniquindio.veterinaria.Controladores;

import co.edu.uniquindio.veterinaria.Modelo.Veterinaria;
import co.edu.uniquindio.veterinaria.VeterinariaApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

import java.io.IOException;

public class ControladorPrincipal {
    // Atributos
    private static ControladorPrincipal instancia = new ControladorPrincipal();

    // Contructor
    private ControladorPrincipal() {}

    public static ControladorPrincipal getInstancia() {
        if (instancia == null) {
            instancia = new ControladorPrincipal();
        }
        return instancia;
    }

    // Crear alerta
    public void crearAlerta(String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle("Alerta");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    // Funcion para abrir pantallas
    public static void openView(String archivo, String titulo, Stage primaryStage) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(VeterinariaApp.class.getResource(archivo));
            Parent rootLayout = loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setTitle(titulo);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // Funcion para abrir pantallas
    public static void openViewPanel(String archivo, String titulo, Stage primaryStage) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(VeterinariaApp.class.getResource(archivo));
            Parent rootLayout = loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setTitle(titulo);
            primaryStage.setMaximized(true);
            primaryStage.setResizable(true);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // Función para cerrar ventanas
    public static void cerrarVentana(Stage stage){
        stage.close();
    }
}
