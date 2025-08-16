package co.edu.uniquindio.veterinaria.Controladores;

import co.edu.uniquindio.veterinaria.Modelo.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class panelConsultasControlador {
    Sesion sesion = Sesion.getInstancia();
    Veterinaria veterinaria = Veterinaria.getInstancia();
    ControladorPrincipal controladorPrincipal = ControladorPrincipal.getInstancia();

    @FXML
    private ListView<Persona> lvPropietario;

    private ObservableList<Persona> propietarios;

    @FXML
    private ListView<Mascota> lvMascota;

    private ObservableList<Mascota> mascotas;

    @FXML
    private ListView<Cita> lvCita;

    private ObservableList<Cita> citas;

    @FXML
    private TextField txtConsulta;

    @FXML
    private TextField txtDiagnostico;

    @FXML
    private TextField txtTratamiento;

    @FXML
    private ComboBox<Boolean> cbMedicina;

    @FXML
    public void initialize() {
        propietarios = FXCollections.observableArrayList(veterinaria.getListaPersonas());
        lvPropietario.setItems(propietarios);
        mascotas = FXCollections.observableArrayList(veterinaria.getListaMascotas());
        lvMascota.setItems(mascotas);
        citas = FXCollections.observableArrayList(veterinaria.getListaCitas());
        lvCita.setItems(citas);
        ObservableList<Boolean> medicina = FXCollections.observableArrayList(
                true,
                false
        );
        cbMedicina.setItems(medicina);
    }

    @FXML
    void onVolver(ActionEvent event) throws IOException {
        ControladorPrincipal.openView("panelVeterinario.fxml", "Panel Veterinario", new Stage());
        ControladorPrincipal.cerrarVentana((Stage) cbMedicina.getScene().getWindow());
    }

    @FXML
    void onGuardarConsulta(ActionEvent event) {
       crearConsulta();
    }

    private void crearConsulta() {
        String codigo = txtConsulta.getText();
        String diagnostico = txtDiagnostico.getText();
        String tratamiento = txtTratamiento.getText();
        boolean medicina =  cbMedicina.getValue();
        Mascota mascota = lvMascota.getSelectionModel().getSelectedItem();
        Veterinario veterinario = (Veterinario) sesion.getPersona();
        Cita cita = lvCita.getSelectionModel().getSelectedItem();
        try {
            Consulta consulta = Consulta.builder().codigoConsulta(codigo).diagnostico(diagnostico).tratamiento(tratamiento).medicina(medicina).mascota(mascota).veterinario(veterinario).build();
            if (!veterinario.crearConsultas(veterinaria, consulta)) {
                throw new Exception("Error creando la consulta");
            } else {
                cita.setEstadoConsulta(EstadoConsulta.ATENDIDA);
                controladorPrincipal.crearAlerta("Consulta creada", Alert.AlertType.INFORMATION);
            }
        } catch (Exception e) {
            controladorPrincipal.crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}
