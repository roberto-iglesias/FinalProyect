package Catalog;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main Class that manages the operation of the application.
 * @author robertoiglesiasllorena*/
public class Main extends Application {

    /**
     * Void Method that load the main stage.
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("scenes/main/main.fxml"));
        primaryStage.setTitle("GameCatalogFx");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }

    /**
     * Void Method that launch the application.
     * @param args Arguments received by the main method
     */
    public static void main(String[] args) {
        launch(args);
    }
}
