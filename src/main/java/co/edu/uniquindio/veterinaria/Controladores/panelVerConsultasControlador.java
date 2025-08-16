package co.edu.uniquindio.veterinaria.Controladores;

import co.edu.uniquindio.veterinaria.Modelo.Consulta;
import co.edu.uniquindio.veterinaria.Modelo.Sesion;
import co.edu.uniquindio.veterinaria.Modelo.Veterinaria;
import co.edu.uniquindio.veterinaria.Modelo.Veterinario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class panelVerConsultasControlador {
    Sesion sesion = Sesion.getInstancia();

    @FXML
    private ListView<Consulta> lvConsultas;

    private ObservableList<Consulta> listaConsultas;

    @FXML
    public void initialize() {
        Veterinario veterinario = (Veterinario) sesion.getPersona();
        listaConsultas = FXCollections.observableArrayList(veterinario.getListaConsultasVeterinario());
        lvConsultas.setItems(listaConsultas);
    }

    @FXML
    void onVolver(ActionEvent event) throws IOException {
        ControladorPrincipal.openView("panelVeterinario.fxml", "Panel Veterinario", new Stage());
        ControladorPrincipal.cerrarVentana((Stage) lvConsultas.getScene().getWindow());
    }

}
