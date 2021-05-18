package Catalog.scenes.other;

import Catalog.Utils.FileUtils;
import Catalog.Utils.SceneLoader;
import Catalog.data.Disk;
import Catalog.data.Game;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.Console;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

/**
 * Class to define the controller for the other.fxml
 * @author robertoiglesiasllorena*/
public class otherController implements Initializable {


    @FXML
    private ComboBox<String> comboCat;
    @FXML
    private TextField txtSearch;
    @FXML
    private TableView tableGame;
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
    ObservableList<Game> games;
    ObservableList<Game> aux;

    /**
     * Void Method that initializes the combobox, table, and the observable list with the games
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboCat.getItems().addAll("Completed", "Playing", "To be played", "Wish List");

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
     * Void Method that sort the games in alphabetical order according to their names.
     * @param actionEvent Parameter that receives the action on the button.
     */
    public void sort(ActionEvent actionEvent) {
        Collections.sort(games ,new Comparator<Game>() {
            @Override
            public int compare(Game o1, Game o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        FileUtils.saveGames(games);
    }
    /**
     * Void Method that allows you to change the category of a game.
     * @param actionEvent Parameter that receives the action on the button.
     */
    public void change(ActionEvent actionEvent) {
        if(txtSearch.getText().equals("") || comboCat.getSelectionModel().getSelectedIndex() < 0)
        {
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setTitle("Error");
            dialog.setHeaderText("Error to apply changes");
            dialog.setContentText("Fill in the name and category fields.");
            dialog.showAndWait();
        }
        else
        {
            if(games != null) {
                for (Game g : games) {
                    if (txtSearch.getText().equals(g.getName())) {
                        games.get(games.indexOf(g)).setCategory(comboCat.getSelectionModel().getSelectedItem());
                        games.set(games.indexOf(g), g);
                    }
                }
            }
            if(aux != null) {
                for (Game g : aux) {
                    if (txtSearch.getText().equals(g.getName())) {
                        aux.get(aux.indexOf(g)).setCategory(comboCat.getSelectionModel().getSelectedItem());
                        aux.set(aux.indexOf(g), g);
                    }
                }
            }
            FileUtils.saveGames(games);
        }
    }
    /**
     * Void Method that allows you to show the games with the indicated category.
     * @param actionEvent Parameter that receives the action on the button.
     */
    public void show(ActionEvent actionEvent) {
        aux = FXCollections.observableArrayList();
        for (Game g : games) {
            if(comboCat.getSelectionModel().getSelectedItem().equals(g.getCategory()))
            {
                aux.add(g);
            }
        }
        tableGame.setItems(aux);
    }
    /**
     * Void Method that allows you to search a game.
     * @param actionEvent Parameter that receives the action on the button.
     */
    public void search(ActionEvent actionEvent) {
        aux = FXCollections.observableArrayList();
        for (Game g : games) {
            if(g.getName().toLowerCase().contains(txtSearch.getText().toLowerCase()))
            {
                aux.add(g);
            }
        }
        tableGame.setItems(aux);
    }
    /**
     * Void Method that allows you to delete a game.
     * @param actionEvent Parameter that receives the action on the button.
     */
    public void delete(ActionEvent actionEvent) {
        boolean exists = false;
        if(games != null) {
            for (Game g : games) {
                if (g.getName().equalsIgnoreCase(txtSearch.getText())) {
                    games.remove(games.indexOf(g));
                    FileUtils.saveGames(games);
                    exists = true;
                    if (aux != null) {
                        for (Game a : aux) {
                            if (a.getName().equalsIgnoreCase(txtSearch.getText())) {
                                aux.remove(aux.indexOf(a));
                                return;
                            }
                        }
                    }
                    else
                        return;
                }
            }
            if(!exists)
            {
                Alert dialog = new Alert(Alert.AlertType.ERROR);
                dialog.setTitle("Error");
                dialog.setHeaderText("Error to delete");
                dialog.setContentText("The game does not exist in the catalog.");
                dialog.showAndWait();
            }
        }
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
}
