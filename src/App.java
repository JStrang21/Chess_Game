import java.lang.Math;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App{

    public static void main(String[] args) {
        Game g = new Game(1);
        //Mixed up X and Y coords initially
//          a  b  c  d  e  f  g  h
//          0  1  2  3  4  5  6  7
// 8      0
// 7      1
// 6      2
// 5      3
// 4      4
// 3      5
// 2      6
// 1      7

        g.board.movePiece("b1","c3");
        g.board.movePiece("c3","d5");
        g.board.printBoard();

    }
}
