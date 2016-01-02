package de.notepass.npBackup.ui.api;

import de.notepass.npBackup.ui.bindings.MainWindow;
import de.notepass.npBackup.ui.bindings.MainWindowTab;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Created by kim on 02.01.2016.
 */
public class FxUiApi extends Application {
    private static MainWindow mainWindowInstance = null;

    public static MainWindow getMainWindowInstance() throws IOException {
        if (mainWindowInstance == null) {
            FXMLLoader loader = new FXMLLoader(FxUiApi.class.getResource("/ui/MainWindow.fxml"));
            loader.setResources(ResourceBundle.getBundle("translations"));
            loader.load();
            mainWindowInstance = loader.getController();
        }

        return mainWindowInstance;
    }

    public static MainWindowTab openBackup(Object backup) throws IOException {
        FXMLLoader loader = new FXMLLoader(FxUiApi.class.getResource("/ui/MainWindowTab.fxml"));
        loader.setResources(ResourceBundle.getBundle("translations"));
        loader.load();
        MainWindowTab tab = loader.getController();
        MainWindow w = getMainWindowInstance();
        w.getMainWindowTabPane().getTabs().add(new Tab(backup.toString(), tab.getRootPane()));
        return tab;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainWindow window = FxUiApi.getMainWindowInstance();
        Scene s = new Scene(window.getRootPane(), 750, 500);
        primaryStage.setScene(s);
        primaryStage.setMinHeight(550);
        primaryStage.setMinWidth(800);
        primaryStage.setTitle("npBackup");
        primaryStage.show();
        FxUiApi.openBackup("Backup 1");
    }
}
