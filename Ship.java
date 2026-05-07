public class Ship {
    private int level;
    private int safety;

    public Ship() {
        level = 1;
        safety = 50;
    }

    public void upgrade() {
        level++;
        safety += 10;
        System.out.println("Ship upgraded to Level " + level);
    }

    public int getLevel() {
        return level;
    }

    public int getSafety() {
        return safety;
    }
}