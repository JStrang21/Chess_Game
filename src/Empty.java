public class Empty extends Piece{
    String name = "Empty";

    public boolean canMove(Square[][]b, int desX, int desY) {
        return false;
    }

    @Override
    public String getNameString() {
        return name;
    }

    public String getName() {
        return name;
    }
}
