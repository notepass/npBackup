package de.notepass.npBackup.ui.api;

import com.sun.deploy.util.FXLoader;
import de.notepass.npBackup.ui.bindings.MainWindow;
import de.notepass.npBackup.ui.bindings.MainWindowTab;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

/**
 * Created by kim on 02.01.2016.
 */
public class MainWindowApi {
    private static MainWindow mainWindowInstance = null;

    public static MainWindow getMainWindowInstance() throws IOException {
        if (mainWindowInstance == null) {
            FXMLLoader loader = new FXMLLoader(MainWindowApi.class.getResource("/ui/MainWindow.fxml"));
            loader.load();
            mainWindowInstance = loader.getController();
        }

        return mainWindowInstance;
    }

    public static MainWindowTab openBackup(Object backup) {
        return null;
    }
}
