public class Player {
    private int money = 50;
    private int food = 20;
    private int water = 20;
    private int crew = 1;

    private Ship ship;
    private Location location;

    public Player(Location start) {
        this.location = start;
        this.ship = new Ship();
    }

    public void addMoney(int amount) {
        money += amount;
    }

    public void spendMoney(int amount) {
        money -= amount;
    }

    public int getMoney() {
        return money;
    }

    public int getCrew() {
        return crew;
    }

    public void recruitCrew() {
        crew++;
    }

    public void consumeFood(int amount) {
        food -= amount;
    }

    public void consumeWater(int amount) {
        water -= amount;
    }

    public void addFood(int amount) {
        food += amount;
    }

    public void addWater(int amount) {
        water += amount;
    }

    public Ship getShip() {
        return ship;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location loc) {
        this.location = loc;
    }

    public void showStatus() {
        System.out.println("📊 Status:");
        System.out.println("Money: " + money);
        System.out.println("Food: " + food);
        System.out.println("Water: " + water);
        System.out.println("Crew: " + crew);
        System.out.println("Ship Level: " + ship.getLevel());
        System.out.println("Location: " + location.getName());
    }
}