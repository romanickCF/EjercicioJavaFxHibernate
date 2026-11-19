package org.example.ejerciciojavafxhibernate;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.ejerciciojavafxhibernate.models.Equipo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TableColumn<Equipo, String> cAvailability;
    @FXML
    private TableView<Equipo> table;
    @FXML
    private TableColumn<Equipo, String> cCategory;
    @FXML
    private TableColumn<Equipo, String> cName;
    @FXML
    private TableColumn<Equipo, String> cId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        cId.setCellValueFactory((row) -> {
            Equipo equipment = row.getValue();
            Long id = equipment.getId();
            return new SimpleStringProperty(String.valueOf(id));
        });
        cName.setCellValueFactory((row) -> {
            if (row.getValue().getNombre().isBlank()) {
                return new SimpleStringProperty("--");
            } else {
                return new SimpleStringProperty(String.valueOf(row.getValue().getNombre()));
            }
        });
        cCategory.setCellValueFactory((row) -> {
            return new SimpleStringProperty(String.valueOf(row.getValue().getCategoria()).toUpperCase());
        });
        cAvailability.setCellValueFactory((row) -> {
            var availability = row.getValue().getDisponible();
            String output = availability ? "disponible" : "no disponible";
            return new SimpleStringProperty(output);
        });
           cargarDatos();

    }

    private void cargarDatos() {

        var cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();

        List<Equipo> lista = sf.fromSession(session ->
                session.createQuery("from Equipo", Equipo.class)
                        .getResultList()
        );

        sf.close();

        ObservableList<Equipo> observableList = FXCollections.observableList(lista);
        table.setItems(observableList);
    }
}
