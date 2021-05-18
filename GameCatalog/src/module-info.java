/**
 * Module that implements the necessary javafx libraries and opens the necessary packages for the application.
 * */

module GameCatalog {
    requires javafx.controls;
    requires javafx.fxml;

    opens Catalog;
    opens Catalog.data;
    opens Catalog.scenes.main;
    opens Catalog.scenes.add;
    opens Catalog.Utils;
    opens Catalog.scenes.other;
}