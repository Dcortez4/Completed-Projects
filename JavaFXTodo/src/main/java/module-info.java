module a8.dcortez.javafxtodo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires org.json;


    opens a8.dcortez.javafxtodo to javafx.fxml;
    exports a8.dcortez.javafxtodo;
}