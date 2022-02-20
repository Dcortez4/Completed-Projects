module a3.dcortez.contactsapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;


    opens a3.dcortez.contactsapp to javafx.fxml;
    exports a3.dcortez.contactsapp;
}