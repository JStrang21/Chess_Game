public class Empty extends Piece{
    String name = "Empty";

    public boolean canMove(Square[][]b, int desX, int desY) {
        return false;
    }

    public String getName() {
        return name;
    }
}
