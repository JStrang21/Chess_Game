public class Player {
    //If player object is human than game will wait for player to make move
    public boolean human;
    int color;
    boolean turn;

    public Player(int i) {
        //If player is instantiated with i as paramater rather than no parameter than that object is human playable
        human = true;
    }

    public boolean isTurn() {
        if (turn) {
            return true;
        }
        return false;
    }

    public Player() {
        human = false;
    }
}
