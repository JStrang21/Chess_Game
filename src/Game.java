public class Game {
    Player white;
    Player black;
    Chessboard board = new Chessboard();


    public Game(int i) {
        //Substantiate playerOne with 1 as paramater to indicate that it's the human player
        if (i == 1) {
            //One player game
            white = new Player(i);
            black = new Player();
            //int 1 represents white && int 2 represents black
            white.color = 1;
            black.color = 2;
        }
        else if (i == 2) {
            //Two player game
            white = new Player(i);
            black = new Player(i);
        }
        /*else {
            //CPU vs CPU (may remove in future)
            playerOne = new Ai();
            playerTwo = new Ai();
        }*/
    }
}
