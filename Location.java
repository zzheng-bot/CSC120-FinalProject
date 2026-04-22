public class Location {
    private String name;
    private boolean hasShop;
    private int fishPrice;

    public Location(String name, boolean hasShop, int fishPrice) {
        this.name = name;
        this.hasShop = hasShop;
        this.fishPrice = fishPrice;
    }

    public String getName() {
        return name;
    }

    public boolean hasShop() {
        return hasShop;
    }

    public int getFishPrice() {
        return fishPrice;
    }
}