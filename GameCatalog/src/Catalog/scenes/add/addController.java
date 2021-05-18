package Catalog.scenes.add;

import Catalog.Utils.FileUtils;
import Catalog.Utils.SceneLoader;
import Catalog.data.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Class to define the controller for the add.fxml
 * @author robertoiglesiasllorena*/
public class addController implements Initializable {


    @FXML
    private TableColumn colName;
    @FXML
    private TableColumn colPlatform;
    @FXML
    private TableColumn colYear;
    @FXML
    private TableColumn colCategory;
    @FXML
    private TableColumn colOther;
    @FXML
    private TableColumn colDownload;
    @FXML
    private TableView tableGame;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPlatform;
    @FXML
    private TextField txtYear;
    @FXML
    private ComboBox<String> comboCategory;
    @FXML
    private ComboBox<String> comboDisk;
    @FXML
    private TextField txtDigitalSize;
    @FXML
    private TextField txtDigitalDownload;
    @FXML
    private ComboBox comboCartridge;

    ObservableList<Game> games;


    /**
     * Void Method that initializes the combobox, table, and the observable list with the games
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboCategory.getItems().addAll("Completed", "Playing", "To be played", "Wish List");
        comboDisk.getItems().addAll("Cd-Rom", "DVD", "Blu-Ray");
        comboCartridge.getItems().addAll("Original", "Emulated");

        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colPlatform.setCellValueFactory(new PropertyValueFactory("platform"));
        colYear.setCellValueFactory(new PropertyValueFactory("year"));
        colCategory.setCellValueFactory(new PropertyValueFactory("category"));
        colOther.setCellValueFactory(new PropertyValueFactory("other"));
        colDownload.setCellValueFactory(new PropertyValueFactory("downloadPlatform"));

        games = FXCollections.observableArrayList(FileUtils.readGames());
        tableGame.setItems(games);
    }

    /**
     * Void Method that allows you to return to the main scene.
     * @param actionEvent Parameter that receives the action on the button.
     * @throws IOException Exception thrown if the scene cannot be loaded.
     */
    public void goBack(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScene("/Catalog/scenes/main/main.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }

    /**
     * Void Method that allows you to add or modify a Disk.
     * @param actionEvent Parameter that receives the action on the button.
     */
    public void addDisk(ActionEvent actionEvent) {
        if(txtName.getText().equals("") || txtPlatform.getText().equals("") ||
                txtYear.getText().equals("") ||
                comboCategory.getSelectionModel().getSelectedIndex() < 0 ||
                comboDisk.getSelectionModel().getSelectedIndex() < 0)
        {
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setTitle("Error");
            dialog.setHeaderText("Error to apply changes");
            dialog.setContentText("Fill in the name, platform, year, category and format fields.");
            dialog.showAndWait();
        }
        else {
            boolean exists = false;
            for (Game g : games) {
                if(txtName.getText().equals(g.getName()))
                {
                    games.set(games.indexOf(g), new Disk(txtName.getText(), txtPlatform.getText(), Integer.parseInt(txtYear.getText()),
                            comboCategory.getSelectionModel().getSelectedItem(),
                            comboDisk.getSelectionModel().getSelectedItem()));
                    exists = true;
                }
            }
            if(!exists)
            {
                games.add(new Disk(txtName.getText(), txtPlatform.getText(), Integer.parseInt(txtYear.getText()),
                        comboCategory.getSelectionModel().getSelectedItem(),
                        comboDisk.getSelectionModel().getSelectedItem()));
            }
        }
        FileUtils.saveGames(games);
    }
    /**
     * Void Method that allows you to add or modify a Digital game.
     * @param actionEvent Parameter that receives the action on the button.
     */
    public void addDigital(ActionEvent actionEvent) {
        if(txtName.getText().equals("") || txtPlatform.getText().equals("") ||
                txtYear.getText().equals("") || txtDigitalSize.getText().equals("") ||
                txtDigitalDownload.getText().equals("") ||
                comboCategory.getSelectionModel().getSelectedIndex() < 0)
        {
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setTitle("Error");
            dialog.setHeaderText("Error to apply changes");
            dialog.setContentText("Fill in the name, platform, year, category size and download platform fields.");
            dialog.showAndWait();
        }
        else {
            boolean exists = false;
            for (Game g : games) {
                if(txtName.getText().equals(g.getName()))
                {
                    games.set(games.indexOf(g), new Digital(txtName.getText(), txtPlatform.getText(), Integer.parseInt(txtYear.getText()),
                            comboCategory.getSelectionModel().getSelectedItem(),
                            Integer.parseInt(txtDigitalSize.getText()), txtDigitalDownload.getText()));
                    exists = true;
                }
            }
            if(!exists)
            {
                games.add(new Digital(txtName.getText(), txtPlatform.getText(), Integer.parseInt(txtYear.getText()),
                        comboCategory.getSelectionModel().getSelectedItem(),
                        Integer.parseInt(txtDigitalSize.getText()), txtDigitalDownload.getText()));
            }

        }
        FileUtils.saveGames(games);
    }
    /**
     * Void Method that allows you to add or modify a Cartridge.
     * @param actionEvent Parameter that receives the action on the button.
     */
    public void addCartridge(ActionEvent actionEvent) {
        if(txtName.getText().equals("") || txtPlatform.getText().equals("") ||
                txtYear.getText().equals("") ||
                comboCategory.getSelectionModel().getSelectedIndex() < 0 ||
                comboCartridge.getSelectionModel().getSelectedIndex() < 0)
        {
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setTitle("Error");
            dialog.setHeaderText("Error to apply changes");
            dialog.setContentText("Fill in the name, platform, year, category and original/emulated fields.");
            dialog.showAndWait();
        }
        else {
            boolean exists = false;
            for (Game g : games) {
                if(txtName.getText().equals(g.getName()))
                {
                    games.set(games.indexOf(g), new Cartridge(txtName.getText(), txtPlatform.getText(), Integer.parseInt(txtYear.getText()),
                            comboCategory.getSelectionModel().getSelectedItem(),
                            comboCartridge.getSelectionModel().getSelectedItem().equals("Original")? true:false));
                    exists = true;
                }
            }
            if(!exists)
            {
                games.add(new Cartridge(txtName.getText(), txtPlatform.getText(), Integer.parseInt(txtYear.getText()),
                    comboCategory.getSelectionModel().getSelectedItem(),
                    comboCartridge.getSelectionModel().getSelectedItem().equals("Original")? true:false));
            }
            FileUtils.saveGames(games);
        }
    }
}
