package rpg;

/**
 *
 * @author Nate
 */
public class Map {

    private Location[][] locs;

    public Map(Location[][] locs) {
        this.locs = locs;
    }

    public Location[][] getMap() {
        return locs;
    }
}
/**
 * Allons-y
 */
