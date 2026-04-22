import java.util.Scanner;

public class Game {
    private Player player;
    private World world;
    private Shop shop;
    private Event event;
    private boolean isRunning;
    private Scanner scanner;

    public void start() {
        scanner = new Scanner(System.in);
        world = new World();
        player = new Player(world.getLocationByName("M's Kingdom"));
        shop = new Shop();
        event = new Event();

        isRunning = true;

        System.out.println("Welcome to Ocean Voyage!");
        gameLoop();
    }

    public void gameLoop() {
        while (isRunning) {
            System.out.print("\n> ");
            String input = scanner.nextLine();
            processCommand(input);
        }
    }

    public void processCommand(String input) {
        String[] parts = input.split(" ");
        String command = parts[0];

        switch (command) {
            case "status":
                player.showStatus();
                break;

            case "fish":
                fish();
                event.triggerStorm(player);
                break;

            case "sail":
                if (parts.length > 1) {
                    sail(parts[1]);
                } else {
                    System.out.println("Where to?");
                }
                break;

            case "shop":
                if (player.getLocation().hasShop()) {
                    shop.openShop(player);
                } else {
                    System.out.println("No shop here.");
                }
                break;

            case "quit":
                isRunning = false;
                break;

            default:
                System.out.println("Unknown command.");
        }
    }

    private void fish() {
        int amount = player.getCrew() * 2;
        player.addMoney(amount * player.getLocation().getFishPrice());
        System.out.println("You caught fish and earned $" + amount * player.getLocation().getFishPrice());
    }

    private void sail(String destinationName) {
        Location dest = world.getLocationByName(destinationName);

        if (dest != null) {
            player.setLocation(dest);
            player.consumeFood(2);
            player.consumeWater(2);
            System.out.println("Sailed to " + dest.getName());
            event.triggerStorm(player);
        } else {
            System.out.println("Unknown location.");
        }
    }
}