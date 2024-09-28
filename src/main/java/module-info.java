module discretas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens Application to javafx.fxml;
    opens Controladores to javafx.fxml;
    exports Application;
}
