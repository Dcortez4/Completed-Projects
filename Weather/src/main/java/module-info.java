module a4.dcortez.weather {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires java.net.http;


    opens a4.dcortez.weather to javafx.fxml;
    exports a4.dcortez.weather;
}