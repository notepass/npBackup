package de.notepass.npBackup.ui.bindings;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by kim on 02.01.2016.
 */
public class MainWindow implements Initializable {
    @FXML
    private TabPane mainWindowTabPane;
    @FXML
    private BorderPane rootPane;

    public TabPane getMainWindowTabPane() {
        return mainWindowTabPane;
    }

    public BorderPane getRootPane() {
        return rootPane;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
