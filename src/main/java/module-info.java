module org.example.ejerciciojavafxhibernate {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ejerciciojavafxhibernate to javafx.fxml;
    exports org.example.ejerciciojavafxhibernate;
}