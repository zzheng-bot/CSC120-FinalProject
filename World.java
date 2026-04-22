import java.util.ArrayList;

public class World {
    private ArrayList<Location> locations;

    public World() {
        locations = new ArrayList<>();

        locations.add(new Location("M's Kingdom", true, 5));
        locations.add(new Location("A's Kingdom", false, 10));
        locations.add(new Location("I's Kingdom", true, 8));
    }

    public Location getLocationByName(String name) {
        for (Location loc : locations) {
            if (loc.getName().equalsIgnoreCase(name)) {
                return loc;
            }
        }
        return null;
    }
}