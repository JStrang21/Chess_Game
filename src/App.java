import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import java.util.Scanner;

public class App{

    public static void main(String[] args) {
        //launch(args);
        Game g = new Game(1);
        //Mixed up X and Y coords initially
        //White top of board/Black bottom of board
//          a  b  c  d  e  f  g  h
//          0  1  2  3  4  5  6  7    y
// 8      0
// 7      1
// 6      2
// 5      3
// 4      4
// 3      5
// 2      6
// 1      7

//        x

        /*
        Bugs:
        -Crashes when pawn moves diagonal to space with no piece:illegal move but don't want crashing
         */
        System.out.println("Enter original piece square, space, where you want piece to move");
        System.out.println("Ex: b7 b6");
        //While game has not been won continue game
        boolean gameWon = false;
        while (!gameWon) {
            Scanner input = new Scanner(System.in);
            String src = null;
            String des = null;
            //TODO account for wrong input: crashes when input is wrong
            if (g.white.isTurn()) {
                /*boolean kingInCheck = g.white.inCheck(g.board, 1);
                if (kingInCheck) {
                    System.out.println("White King in check, must get king out of check");
                }*/
                System.out.println("White player enter originating piece square: ");
                src = input.next();
                System.out.println("Enter destination square: ");
                des = input.next();

            }
            else if (g.black.isTurn()) {
                /*boolean kingInCheck = g.black.inCheck(g.board, 2);
                if (g.black.inCheck(g.board, 2)) {
                    System.out.println("Black King in check, must get king out of check");
                }*/
                System.out.println("Black player enter originating piece square: ");
                src = input.next();
                System.out.println("Enter destination square: ");
                des = input.next();
            }
            //TODO: add stalemate, checkMate logic

            g.board.movePiece(src, des);
            g.board.printBoard();
            //Maybe check for check after movement
            if (g.white.inCheck(g.board, 1)) {
                
            }
            else if (g.black.inCheck(g.board, 2)) {

            }
            gameWon = g.checkWin();
            //g.printRemovedPieces();
        }
        if (gameWon) {
            System.out.println(g.board.winner + " wins the game");
        }
    }

}



/*
                //Check if King is in check
                boolean whiteKingInCheck = g.board.checkIfWhiteKingInCheck();
                //Has to move so king is not in check
                while (whiteKingInCheck) {
                    System.out.println("White king is in check, must get out of check");
                    System.out.println("Enter originating piece square");
                    src = input.next();
                    System.out.println("Enter destination square");
                    des = input.next();
                    boolean canMove = g.board.movePiece(src, des);
                    whiteKingInCheck = g.board.checkIfWhiteKingInCheck();
                    if (whiteKingInCheck == false) {
                        break;
                    }
                }*/

