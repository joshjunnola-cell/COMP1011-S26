public class GameTest {

    public static void main(String[] args) {
        Player p = new Player("Josh");
        p.pickUp("Sword");
        p.pickUp("Shield");
        p.showInventory();
    }

}

