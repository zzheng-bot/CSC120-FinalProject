import java.util.Scanner;

public class Shop {

    public void openShop(Player player) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🛒 Shop:");
        System.out.println("1. Buy Food ($10)");
        System.out.println("2. Buy Water ($10)");
        System.out.println("3. Upgrade Ship ($50)");
        System.out.println("4. Recruit Crew ($30)");

        String choice = sc.nextLine();

        switch (choice) {
            case "1":
                if (player.getMoney() >= 10) {
                    player.spendMoney(10);
                    player.addFood(10);
                }
                break;
            case "2":
                if (player.getMoney() >= 10) {
                    player.spendMoney(10);
                    player.addWater(10);
                }
                break;
            case "3":
                if (player.getMoney() >= 50) {
                    player.spendMoney(50);
                    player.getShip().upgrade();
                }
                break;
            case "4":
                if (player.getMoney() >= 30) {
                    player.spendMoney(30);
                    player.recruitCrew();
                }
                break;
        }
    }
}