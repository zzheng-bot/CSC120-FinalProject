import java.util.Random;

public class Event {
    private Random rand = new Random();

    public void triggerStorm(Player player) {
        int chance = rand.nextInt(100);

        if (chance > player.getShip().getSafety()) {
            System.out.println("🌪️ Storm! You lost supplies!");
            player.consumeFood(5);
            player.consumeWater(5);
        } else {
            System.out.println("⛅ You avoided the storm.");
        }
    }
}