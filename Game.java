import java.util.Scanner;

//Main controller class for the game.
public class Game {

    private Player player;
    private World world;
    private Shop shop;
    private Event event;
    private boolean isRunning;
    private Scanner scanner;

    //Starts the game.
    public void start() {
        scanner = new Scanner(System.in);
        world = new World();
        player = new Player(world.getLocationByName("M's Kingdom"));
        shop = new Shop();
        event = new Event();
        isRunning = true;
        System.out.println("==================================");
        System.out.println("WELCOME TO OCEAN VOYAGE");
        System.out.println("==================================");
        System.out.println();
        System.out.println("You are a young captain with a small fishing boat.");
        System.out.println();
        System.out.println("Travel between kingdoms, catch fish, recruit crew, upgrade your ship, and survive dangerous storms.");
        System.out.println();
        System.out.println("Reach Ship Level 5 to win!");
        System.out.println();
        showHelp();
        gameLoop();
    }

    //Main game loop.
    private void gameLoop() {
        while (isRunning) {
            System.out.print("\n> ");
            String input = scanner.nextLine();
            processCommand(input);
        }
    }

    private void processCommand(String input) {
        String[] parts = input.split(" ");
        String command = parts[0].toLowerCase();
        switch (command) {
            case "status":
                player.showStatus();
                break;

            case "fish":
                fish();
                event.randomEvent(player);
                break;

            case "sail":
                if (parts.length > 1) {
                    String destination = input.substring(5);
                    sail(destination);
                } else {
                    System.out.println("Where do you want to sail?");
                }
                break;

            case "shop":
                if (player.getLocation().hasShop()) {
                    shop.openShop(player);
                } else {
                    System.out.println("No shop at this location.");
                }
                break;

            case "map":
                world.showMap();
                break;

            case "help":
                showHelp();
                break;

            case "quit":
                System.out.println("Goodbye.");
                isRunning = false;
                break;

            default:
                System.out.println("Unknown command.");
        }
        checkGameState();
    }

    //Fishing action.
    private void fish() {
        int amount = player.getCrew() * 2;
        int earnings = amount * player.getLocation().getFishPrice();
        player.addMoney(earnings);
        System.out.println("You caught fish and earned $" + earnings);
    }

    private void sail(String destinationName) {
        Location dest = world.getLocationByName(destinationName);
        if (dest == null) {
            System.out.println("Unknown location.");
            return;
        }

        // restricted area
        if (dest.getName().equals("A's Kingdom")
                && player.getShip().getLevel() < 3) {
            System.out.println("Dangerous waters block your path.");
            System.out.println("Your ship must be at least Level 3.");
            return;
        }

        player.setLocation(dest);
        player.consumeFood(2);
        player.consumeWater(2);
        System.out.println("You sailed to " + dest.getName());
        event.triggerStorm(player);
    }

    private void showHelp() {
        System.out.println();
        System.out.println("COMMANDS");
        System.out.println("----------------------");
        System.out.println("status  - show status");
        System.out.println("fish    - catch fish");
        System.out.println("sail X  - travel");
        System.out.println("shop    - open shop");
        System.out.println("map     - show map");
        System.out.println("help    - commands");
        System.out.println("quit    - exit game");
    }

    private void checkGameState() {
        if (player.getFood() <= 0 || player.getWater() <= 0) {
            System.out.println();
            System.out.println("You ran out of supplies.");
            System.out.println("GAME OVER.");
            isRunning = false;
        }

        if (player.getShip().getLevel() >= 8) {
            System.out.println();
            System.out.println("LEGENDARY CAPTAIN ACHIEVED!");
            System.out.println("You conquered the ocean!");
            isRunning = false;
        }
    }
}