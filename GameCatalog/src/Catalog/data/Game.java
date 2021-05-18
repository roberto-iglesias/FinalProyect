package Catalog.data;

/**
 * Class to define games an their names, platforms, years of release, and category
 * @author robertoiglesiasllorena*/

public abstract class Game {
    protected String name;
    protected String platform;
    protected int year;
    protected String category;

/**
 * Constructor with parameters
 * @param name A String with the game name
 * @param platform A String with the game platform
 * @param year A Integer with the game year
 * @param category A String with the game category
*/
public Game(String name, String platform, int year, String category) {
        this.name = name;
        this.platform = platform;
        this.year = year;
        this.category = category;
    }

    /**
     * Returns the game's name
     * @return game's name
     */
    public String getName() { return name; }

    /**
     * Returns the game's platform
     * @return game's platform
     */
    public String getPlatform() { return platform; }

    /**
     * Returns the game's year
     * @return game's year
     */
    public int getYear() { return year; }

    /**
     * Returns the game's category
     * @return game's category
     */
    public String getCategory() { return category; }

    /**
     * Establishes the game's name
     * @param name game's name
     */
    public void setName(String name) { this.name = name; }

    /**
     * Establishes the game's platform
     * @param platform game's platform
     */
    public void setPlatform(String platform) { this.platform = platform; }

    /**
     * Establishes the game's year
     * @param year the game's year
     */
    public void setYear(int year) { this.year = year; }

    /**
     * Establishes the game's category
     * @param category game's category
     */
    public void setCategory(String category) { this.category = category; }

    /**
     * Method that sort the games in alphabetical order according to their names.
     * @return a boolean
     */
    @Override
    public boolean equals(Object o) {
        Game g = (Game) o;
        return this.getName().equals(g.getName());
    }
    /**
     * Method that returns a String with all the attributes of a game.
     * @return a returns a String with all the attributes of a game
     */
    @Override
    public String toString() {
        return name + ";" + platform + ";" + year + ";" + category;
    }
}
