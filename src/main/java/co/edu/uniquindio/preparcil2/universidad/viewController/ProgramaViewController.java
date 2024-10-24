package co.edu.uniquindio.preparcil2.universidad.viewController;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.preparcil2.universidad.controller.UniversidadController;
import co.edu.uniquindio.preparcil2.universidad.model.Programa;
import co.edu.uniquindio.preparcil2.universidad.model.Universidad;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
public class ProgramaViewController {
    UniversidadController universidadController;
    ObservableList<Programa> listaProgramas = FXCollections.observableArrayList();
    Programa programaSeleccionado;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Programa, String> tbColAdscritos;

    @FXML
    private TableColumn<Programa, String> tbColCodigo;

    @FXML
    private TableColumn<Programa, String> tbColModalidad;

    @FXML
    private TableColumn<Programa, String> tbColNombre;

    @FXML
    private TableView<Programa> tbPrograma;

    @FXML
    private TextField txtBuscarEstuadiante;

    @FXML
    void onBuscar(ActionEvent event) {
        listaProgramas.clear();
        listaProgramas.addAll(universidadController.bucarProgramas(txtBuscarEstuadiante.getText()));
        System.out.println(listaProgramas);
        tbPrograma.getItems().clear();
        tbPrograma.getItems().addAll(listaProgramas);
    }
    @FXML
    void initialize() {
        universidadController = new UniversidadController();
        initView();
    }
    private void initView() {
        initDataBinding();
        obtenerProgramas();
        tbPrograma.getItems().clear();
        tbPrograma.getItems().addAll(listaProgramas);
        listenerSelection();
    }
    private void initDataBinding() {
        tbColCodigo.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCodigo())));
        tbColNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbColModalidad.setCellValueFactory(cellData -> new SimpleStringProperty(universidadController.obtenerModalidad(cellData.getValue().getNombre())));
        tbColAdscritos.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAdscritos())));
    }
    private void obtenerProgramas() {
        listaProgramas.addAll(universidadController.obteneProgramas());
    }
    private void listenerSelection() {
        tbPrograma.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            programaSeleccionado = newValue;
        });
    }
}
