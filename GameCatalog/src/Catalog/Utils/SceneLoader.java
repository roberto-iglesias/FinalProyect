package Catalog.Utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * Class that incorporates the method to change between scenes.
 * @author robertoiglesiasllorena*/
public class SceneLoader {
    /**
     * Void Method that allow us to change between scenes.
     * @param viewPath Route where the scene is
     * @param stage Scene to load
     * @throws IOException Exception thrown if the scene cannot be loaded.
     */
    public static void loadScene(String viewPath, Stage stage) throws IOException
    {
        Parent root = FXMLLoader.load(
                SceneLoader.class.getResource(viewPath));
        Scene viewScene = new Scene(root);
        stage.setScene(viewScene);
        stage.show();
    }
}
