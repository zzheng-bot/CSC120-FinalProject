import java.util.Random;

//Handles random game events.
public class Event {
    private Random rand;
    //Creates event manager.
    public Event() {
        rand = new Random();
    }

    //Triggers storm event.
    public void triggerStorm(Player player) {
        int chance = rand.nextInt(100);
        if (chance > player.getShip().getSafety()) {
            System.out.println("A storm damaged your supplies!");
            player.consumeFood(5);
            player.consumeWater(5);
        } else {
            System.out.println("You safely passed through the storm.");
        }
    }

    //Random event generator.
    public void randomEvent(Player player) {
        int eventChance = rand.nextInt(100);
        if (eventChance < 20) {
            int treasure = rand.nextInt(50) + 20;
            System.out.println("You discovered treasure worth $" + treasure);
            player.addMoney(treasure);
        } else if (eventChance > 85) {
            int lost = rand.nextInt(20) + 10;
            System.out.println("Pirates stole $" + lost);
            player.spendMoney(Math.min(lost, player.getMoney()));
        }
    }
}