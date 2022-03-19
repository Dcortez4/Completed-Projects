module a6.dcortez.fxchat.fxchat {
    requires javafx.controls;
    requires javafx.fxml;


    opens a6.dcortez.fxchat.fxchat to javafx.fxml;
    exports a6.dcortez.fxchat.fxchat;
}