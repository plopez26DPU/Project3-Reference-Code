module org.depaul {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens org.depaul.gui to javafx.fxml;

    exports org.depaul.gui;
	exports org.depaul.app;
	opens org.depaul.app to javafx.fxml;
}