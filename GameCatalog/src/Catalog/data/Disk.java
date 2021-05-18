package Catalog.data;

/**
 * Class to define Disk an their names, platforms, years of release, category and format
 * @author robertoiglesiasllorena*/
public class Disk extends Game {
    private String other;
    /**
     * Constructor with parameters
     * @param name A String with the disk name
     * @param platform A String with the disk platform
     * @param year A Integer with the disk year
     * @param category A String with the disk category
     * @param other A String with the disk format
     */
    public Disk(String name, String platform, int year, String category, String other) {
        super(name, platform, year, category);
        this.other = other;
    }

    /**
     * Returns the disk's format
     * @return disk's format
     */
    public String getOther() { return other; }

    /**
     * Returns the null to fill the table
     * @return null
     */
    public String getDownloadPlatform() { return null; }

    /**
     * Establishes the disk's format
     * @param other disk's format
     */
    public void setOther(String other) { this.other = other; }

    /**
     * Method that returns a String with all the attributes of a disk.
     * @return a returns a String with all the attributes of a disk
     */
    @Override
    public String toString() {
        return "Disk" + ";" + super.toString() + ";" + other;
    }
}
