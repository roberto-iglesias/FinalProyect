package Catalog.data;

/**
 * Class to define Digital an their names, platforms, years of release, category, size
 * and download platform
 * @author robertoiglesiasllorena*/
public class Digital extends Game {
    private int other;
    private String downloadPlatform;

    /**
     * Constructor with parameters
     * @param name A String with the digital name
     * @param platform A String with the digital platform
     * @param year A Integer with the digital year
     * @param category A String with the digital category
     * @param other A Integer with the digital size
     * @param downloadPlatform A String with the digital download platform
     */
    public Digital(String name, String platform, int year, String category,
                   int other, String downloadPlatform) {
        super(name, platform, year, category);
        this.other = other;
        this.downloadPlatform = downloadPlatform;
    }
    /**
     * Returns the digital's size
     * @return digital's size
     */
    public int getOther() { return other; }
    /**
     * Returns the digital's download platform
     * @return digital's download platform
     */
    public String getDownloadPlatform() { return downloadPlatform; }

    /**
     * Establishes the digital's size
     * @param other digital's size
     */
    public void setOther(int other) { this.other = other; }
    /**
     * Establishes the digital's download platform
     * @param downloadPlatform digital's download platform
     */
    public void setDownloadPlatform(String downloadPlatform) { this.downloadPlatform = downloadPlatform; }

    /**
     * Method that returns a String with all the attributes of a digital.
     * @return a returns a String with all the attributes of a digital
     */
    @Override
    public String toString() {
        return "Digital" + ";" + super.toString() +
                ";" + other + ";" + downloadPlatform;
    }
}
