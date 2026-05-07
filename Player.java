public class Player {
    private int money;
    private int food;
    private int water;
    private int crew;
    private Ship ship;
    private Location location;

    public Player(Location start) {
        money = 50;
        food = 20;
        water = 20;
        crew = 1;
        ship = new Ship();
        location = start;
    }

    public void addMoney(int amount) {
        money += amount;
    }

    public void spendMoney(int amount) {
        money -= amount;
    }

    public void consumeFood(int amount) {
        food = Math.max(0, food - amount);
    }

    public void consumeWater(int amount) {
        water = Math.max(0, water - amount);
    }

    public void addFood(int amount) {
        food += amount;
    }

    public void addWater(int amount) {
        water += amount;
    }

    public void recruitCrew() {
        crew++;
    }

    public void showStatus() {
        System.out.println();
        System.out.println("📊 PLAYER STATUS");
        System.out.println("----------------------");
        System.out.println("Money: $" + money);
        System.out.println("Food: " + food);
        System.out.println("Water: " + water);
        System.out.println("Crew: " + crew);
        System.out.println("Ship Level: " + ship.getLevel());
        System.out.println("Location: " + location.getName());
    }

    public int getMoney() {
        return money;
    }

    public int getFood() {
        return food;
    }

    public int getWater() {
        return water;
    }

    public int getCrew() {
        return crew;
    }

    public Ship getShip() {
        return ship;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}