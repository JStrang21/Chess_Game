public abstract class Piece extends Square{
    //0 = white && 2 = black
    int color;
    //Current square position
    int curX;
    int curY;

    public boolean canMove(int desX, int desY) {
        //From current square position check if specific piece can make given move

        return false;
    }


    //abstract boolean tracePath(int destX, int destY);
}
