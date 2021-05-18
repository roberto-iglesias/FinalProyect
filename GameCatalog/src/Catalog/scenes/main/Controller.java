package Catalog.scenes.main;

import Catalog.Utils.SceneLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Class to define the controller for the main.fxml
 * @author robertoiglesiasllorena*/
public class Controller {

    @FXML
    private ComboBox comboShow;
    @FXML
    private TextField txtSearch;
    @FXML
    private TextField txtDelete;
    @FXML
    private TextField txtChange;
    @FXML
    private TextField txtModify;

    /**
     * Void Method that allows you to go to the add scene.
     * @param actionEvent Parameter that receives the action on the button.
     * @throws IOException Exception thrown if the scene cannot be loaded.
     */
    public void goToAdd(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScene("/Catalog/scenes/add/add.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }

    /**
     * Void Method that allows you to go to the other scene.
     * @param actionEvent Parameter that receives the action on the button.
     * @throws IOException Exception thrown if the scene cannot be loaded.
     */
    public void goToOther(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScene("/Catalog/scenes/other/other.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }
}
