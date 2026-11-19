module org.example.ejerciciojavafxhibernate {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires static lombok;
    requires java.naming;
    opens org.example.ejerciciojavafxhibernate.models;

    opens org.example.ejerciciojavafxhibernate to javafx.fxml;
    exports org.example.ejerciciojavafxhibernate;
}