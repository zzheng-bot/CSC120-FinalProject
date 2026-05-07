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

    public void showMap() {
        System.out.println();
        System.out.println("🗺️ OCEAN MAP");
        System.out.println("----------------------");
        System.out.println("        A's Kingdom");
        System.out.println("             |");
        System.out.println("             |");
        System.out.println("M's Kingdom --- I's Kingdom");
        System.out.println("----------------------");
        System.out.println("A's Kingdom requires Ship Level 3.");
    }
}