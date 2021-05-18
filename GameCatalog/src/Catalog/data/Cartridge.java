package Catalog.data;
/**
 * Class to define Cartridge an their names, platforms, years of release, category and format
 * @author robertoiglesiasllorena*/
public class Cartridge extends Game {
    private boolean original;
    private String other;

    /**
     * Constructor with parameters
     * @param name A String with the cartridge name
     * @param platform A String with the cartridge platform
     * @param year A Integer with the cartridge year
     * @param category A String with the cartridge category
     * @param original A boolean with the cartridge format
     */
    public Cartridge(String name, String platform, int year, String category, boolean original) {
        super(name, platform, year, category);
        this.original = original;
        this.other = original? "Original":"Emulated";
    }

    /**
     * Returns the null to fill the table
     * @return null
     */
    public String getDownloadPlatform() { return null; }

    /**
     * Returns the cartridge's format
     * @return cartridge's format
     */
    public String getOther() { return other; }

    /**
     * Method that returns a String with all the attributes of a cartridge.
     * @return a returns a String with all the attributes of a cartridge
     */
    @Override
    public String toString() {
        return "Cartridge" + ";" + super.toString() + ";" + (original? "Original":"Emulated");
    }
}
