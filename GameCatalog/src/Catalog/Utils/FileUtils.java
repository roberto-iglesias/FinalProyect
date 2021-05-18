package Catalog.Utils;

import Catalog.data.*;
import javafx.collections.FXCollections;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;

/**
 * Class that incorporates the methods to save to a file or load from a file.
 * @author robertoiglesiasllorena*/
public class FileUtils {

    /**
     * Method that return a list of games from a file
     * @return List of games
     */
    public static List<Game> readGames() {
        List<Game> games = FXCollections.observableArrayList();
        try (BufferedReader reader = new BufferedReader(new FileReader("games.txt"))) {
            while (reader.ready()) {
                String[] line = (reader.readLine().split(";"));
                String group = line[0];

                if(group.contains("Disk")) {
                    Game g = new Disk(line[1], line[2], Integer.parseInt(line[3]), line[4], line[5]);
                    games.add(g);
                }
                if(group.contains("Digital")) {
                    Game g = new Digital(line[1], line[2], Integer.parseInt(line[3]),
                            line[4], Integer.parseInt(line[5]), line[6]);
                    games.add(g);
                }
                if(group.contains("Cartridge")) {
                    Game g = new Cartridge(line[1], line[2], Integer.parseInt(line[3]), line[4],
                            line[5].contains("Original")? true:false);
                    games.add(g);
                }
            }
            return games;
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * Void Method that receives a list of games and saves them in a file.
     * @param games list of games
     */
    public static void saveGames(List<Game> games) {
        try(PrintWriter pw = new PrintWriter("games.txt"))
        {
            games.stream().forEach(f -> pw.println(f.toString()));
        } catch (Exception e) {}
    }
}
