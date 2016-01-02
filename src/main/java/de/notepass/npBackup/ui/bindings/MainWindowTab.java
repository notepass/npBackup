package de.notepass.npBackup.ui.bindings;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TreeView;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by kim on 02.01.2016.
 */
public class MainWindowTab implements Initializable {
    @FXML
    GridPane rootPane;
    @FXML
    TreeView localFileTree;
    @FXML
    TreeView archiveFileTree;
    @FXML
    Button startBackupButton;
    @FXML
    Button configureBackupButton;
    @FXML
    Button restoreFilesButton;
    @FXML
    Button advancedOptionsButton;

    public TreeView getLocalFileTree() {
        return localFileTree;
    }

    public TreeView getArchiveFileTree() {
        return archiveFileTree;
    }

    public Button getStartBackupButton() {
        return startBackupButton;
    }

    public Button getConfigureBackupButton() {
        return configureBackupButton;
    }

    public Button getRestoreFilesButton() {
        return restoreFilesButton;
    }

    public Button getAdvancedOptionsButton() {
        return advancedOptionsButton;
    }

    public GridPane getRootPane() {
        return rootPane;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
