public abstract class Piece extends Square{
    //1 = white && 2 = black
    int color;
    //Current square position
    int curX;
    int curY;
    String name;

    /*public boolean canMove(int desX, int desY) {
        //From current square position check if specific piece can make given move

        return false;
    }*/

    abstract boolean canMove(int desX, int desY);

    public void setCoordinates(int desX, int desY) {
        curX = desX;
        curY = desY;
    }

    abstract String getName();

    //abstract boolean tracePath(int destX, int destY);
}
