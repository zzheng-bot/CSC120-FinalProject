public class Ship {
    private int level = 1;
    private int safety = 50;

    public void upgrade() {
        level++;
        safety += 10;
    }

    public int getLevel() {
        return level;
    }

    public int getSafety() {
        return safety;
    }
}