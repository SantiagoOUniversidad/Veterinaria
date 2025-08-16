package co.edu.uniquindio.veterinaria.Controladores;

import co.edu.uniquindio.veterinaria.Modelo.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class panelPyMControlador implements Initializable {
    Veterinaria veterinaria = Veterinaria.getInstancia();
    Sesion sesion = Sesion.getInstancia();
    ControladorPrincipal controladorPrincipal = ControladorPrincipal.getInstancia();
    PersonalApoyo personalApoyo = PersonalApoyo.builder().build();

    @FXML
    private TextField txtNombrePro;

    @FXML
    private TextField txtCedulaPro;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtDireccion;

    @FXML
    private ListView<Mascota> lvMascotas;

    private ObservableList<Mascota> mascotas;

    @FXML
    private TextField txtNombreMas;

    @FXML
    private TextField txtEspecie;

    @FXML
    private TextField txtRaza;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtIdVet;

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        mascotas = FXCollections.observableArrayList(veterinaria.getListaMascotas());
        lvMascotas.setItems(mascotas);
    }

    @FXML
    void onVolver(ActionEvent event) throws IOException {
        ControladorPrincipal.openView("panelPersonalApoyo.fxml", "Panel Personal Apoyo", new Stage());
        ControladorPrincipal.cerrarVentana((Stage) txtDireccion.getScene().getWindow());
    }

    @FXML
    void onAgregarPro(ActionEvent event) {
        agregarPropietario();
    }

    @FXML
    void onEditarPro(ActionEvent event) {
        editarPropietario();
    }

    @FXML
    void onEliminarPro(ActionEvent event) {
        eliminarPropietario();
    }

    @FXML
    void onAgregarMas(ActionEvent event) {
        agregarMascota();
    }

    @FXML
    void onEliminarMas(ActionEvent event) {
        eliminarMascota();
    }

    @FXML
    void onAgregarMascotaPro(ActionEvent event) {
        agregarMascotaPropietario();
    }

    private void agregarMascotaPropietario() {
        Mascota mascota = lvMascotas.getSelectionModel().getSelectedItem();
        String cedula  = txtCedulaPro.getText();
        try {
            if (personalApoyo.mostrarPropietario(veterinaria, cedula) == null){
                throw new Exception("Error agregando mascota al propietario");
            } else {
                Propietario propietario = personalApoyo.mostrarPropietario(veterinaria, cedula);
                propietario.getListaMascotasPropietario().add(mascota);
                controladorPrincipal.crearAlerta("Mascota asignada", Alert.AlertType.INFORMATION);
            }
        } catch (Exception e) {
            controladorPrincipal.crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void eliminarMascota() {
        String idMascota = txtIdVet.getText();
        try {
            if (!personalApoyo.eliminarMascota(veterinaria, idMascota)){
                throw new Exception("Error eliminando mascota");
            } else {
                mascotas.setAll(veterinaria.getListaMascotas());
                controladorPrincipal.crearAlerta("Mascota eliminada", Alert.AlertType.INFORMATION);
            }
        } catch (Exception e) {
            controladorPrincipal.crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void agregarMascota() {
        String nombre = txtNombreMas.getText();
        String especie = txtEspecie.getText();
        String raza = txtRaza.getText();
        String edad = txtEdad.getText();
        String idVet = txtIdVet.getText();
        try {
            Mascota mascota = Mascota.builder().nombre(nombre).especie(especie).raza(raza).edad(edad).idveterinario(idVet).listaConsultasMascota(new ArrayList<>()).build();
            if (!personalApoyo.agregarMascota(veterinaria, mascota)){
                throw new Exception("Error agregando mascota");
            } else {
                controladorPrincipal.crearAlerta("Mascota creada", Alert.AlertType.INFORMATION);
                mascotas.setAll(veterinaria.getListaMascotas());
            }
        } catch (Exception e) {
            controladorPrincipal.crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void eliminarPropietario() {
        String cedula = txtCedulaPro.getText();
        try {
            if (!personalApoyo.eliminarPropietario(veterinaria, cedula)){
                throw new Exception("Error eliminando propietario");
            } else {
                controladorPrincipal.crearAlerta("Propietario eliminado", Alert.AlertType.INFORMATION);
            }
        } catch (Exception e) {
            controladorPrincipal.crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void editarPropietario() {
        String nombre = txtNombrePro.getText();
        String cedula = txtCedulaPro.getText();
        String telefono = txtTelefono.getText();
        String direccion = txtDireccion.getText();
        try {
            Propietario propietario = Propietario.builder().nombreCompleto(nombre).id(cedula).telefono(telefono).direccion(direccion).build();
            if (!personalApoyo.actualizarPropietario(veterinaria, propietario, cedula)){
                throw new Exception("Error editando propietario");
            } else {
                controladorPrincipal.crearAlerta("Propietario editado", Alert.AlertType.INFORMATION);
            }
        } catch (Exception e) {
            controladorPrincipal.crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void agregarPropietario() {
        String nombre = txtNombrePro.getText();
        String cedula = txtCedulaPro.getText();
        String telefono = txtTelefono.getText();
        String direccion = txtDireccion.getText();
        try {
            Propietario propietario = Propietario.builder().nombreCompleto(nombre).id(cedula).telefono(telefono).direccion(direccion).build();
            if (!personalApoyo.agregarPropietario(veterinaria, propietario)){
                throw new Exception("Error agregando propietario");
            } else {
                controladorPrincipal.crearAlerta("Propietario creado", Alert.AlertType.INFORMATION);
            }
        } catch (Exception e) {
            controladorPrincipal.crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}
