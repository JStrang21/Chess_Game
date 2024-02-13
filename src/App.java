/*import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;*/
import java.util.Scanner;

public class App {

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
        //Run through game to make testing easier
        int clock = 0;
        int whiteMove = 0;
        int blackMove = 0;
        while (clock <= 45) {
            //While game has not been won continue game
                String srcTest = null;
                String desTest = null;
                //Added moves to make testing faster
                String[][] white = {{"a7","a5"},{"b7","b5"},{"a5","a4"},{"c7","b6"},{"b6","b5"},{"d7","d5"},{"e7","e6"},{"h7","h5"},{"e6","d5"},{"h5","g4"},{"g4","f3"},{"f3","e2"},{"h8","h2"},{"a8","a5"},{"a5","b5"},{"b5","b2"},{"e8","f7"},{"b2","d2"},{"h2","h8"},{"d2","a2"},{"a2","a8"},{"f7","e8"},{"a8","a7"}};
                String[][] black = {{"a2","a4"},{"a4","b5"},{"b5","b6"},{"b2","b3"},{"b3","a4"},{"a4","b5"},{"c2","c4"},{"c4","d5"},{"g2","g4"},{"f2","f3"},{"a1","a7"},{"a7","f7"},{"f7","g7"},{"g7","g5"},{"g5","d5"},{"d1","e2"},{"e2","d1"},{"d5","a5"},{"a5","a1"},{"h1","h2"},{"h2","h1"},{"h1","h2"},{"h2","h1"}};
                //TODO: make inCheckBlock and nonCheckBlock return src and des moves to moves[]
                String[] moves = new String[2];
                //TODO account for wrong input: crashes when input is wrong
                //Check logic: iterate through all possible moves for all pieces and check which moves get king out of check->if inputed move is same as one in list then acceptable move
                //List possible moves for piece that threatens king and possible moves for king and the spots king can move are available
                if (g.white.isTurn()) {
                    g.white.isInCheck(g.board);
                    if (g.white.inCheck) {
                        while (g.white.inCheck) {
                            //g.inCheckBlock(1, src, des, input);
                            System.out.println("White King in check, must get king out of check");
                            System.out.println("White player enter originating piece square: ");
                            srcTest = white[whiteMove][0];
                            System.out.println("Enter destination square: ");
                            desTest = white[whiteMove][1];
                            if (g.board.movedOutOfCheck(srcTest, desTest)) {
                                g.white.inCheck = false;
                                g.board.movePiece(srcTest, desTest);
                                whiteMove++;
                                g.board.printBoard();
                            } else {
                                srcTest = null;
                                desTest = null;
                            }
                        }
                    } else {
                        //g.nonCheckBlock(1, src, des, input, gameWon);
                        System.out.println("White player enter originating piece square: ");
                        srcTest = white[whiteMove][0];
                        System.out.println("Enter destination square: ");
                        desTest = white[whiteMove][1];
                        g.board.movePiece(srcTest, desTest);
                        whiteMove++;
                        g.board.printBoard();

                    }
                } else if (g.black.isTurn()) {
                    g.black.isInCheck(g.board);
                    if (g.black.inCheck) {
                        while (g.black.inCheck) {
                            //g.inCheckBlock(2, src, des, input);
                            System.out.println("Black King in check, must get king out of check");
                            System.out.println("Black player enter originating piece square: ");
                            srcTest = black[blackMove][0];
                            System.out.println("Enter destination square: ");
                            desTest = black[blackMove][1];
                            if (g.board.movedOutOfCheck(srcTest, desTest)) {
                                g.black.inCheck = false;
                                g.board.movePiece(srcTest, desTest);
                                blackMove++;
                                g.board.printBoard();

                            } else {
                                srcTest = null;
                                desTest = null;
                            }
                        }
                    } else {
                        //g.nonCheckBlock(2, src, des, input, gameWon);
                        System.out.println("Black player enter originating piece square: ");
                        srcTest = black[blackMove][0];
                        System.out.println("Enter destination square: ");
                        desTest = black[blackMove][1];
                        g.board.movePiece(srcTest, desTest);
                        blackMove++;
                        g.board.printBoard();
                    }

            }
            clock++;
        }

        System.out.println("Enter original piece square, space, where you want piece to move");
        System.out.println("Ex: b7 b6");
        //While game has not been won continue game
        boolean gameWon = false;
        while (!gameWon) {
            Scanner input = new Scanner(System.in);
            String src = null;
            String des = null;
            //Added moves to make testing faster
            String[] white = {};
            String[] black = {};
            //TODO: make inCheckBlock and nonCheckBlock return src and des moves to moves[]
            String[] moves = new String[2];
            //TODO account for wrong input: crashes when input is wrong
            //Check logic: iterate through all possible moves for all pieces and check which moves get king out of check->if inputed move is same as one in list then acceptable move
            //List possible moves for piece that threatens king and possible moves for king and the spots king can move are available
            if (g.white.isTurn()) {
                g.white.isInCheck(g.board);
                if (g.white.inCheck) {
                    while (g.white.inCheck) {
                        //g.inCheckBlock(1, src, des, input);
                        System.out.println("White King in check, must get king out of check");
                        System.out.println("White player enter originating piece square: ");
                        src = input.next();
                        System.out.println("Enter destination square: ");
                        des = input.next();
                        if (g.board.movedOutOfCheck(src, des)) {
                            g.white.inCheck = false;
                            g.board.movePiece(src, des);
                            g.board.printBoard();
                            gameWon = g.checkWin();
                        } else {
                            src = null;
                            des = null;
                        }
                    }
                } else {
                    //g.nonCheckBlock(1, src, des, input, gameWon);
                    System.out.println("White player enter originating piece square: ");
                    src = input.next();
                    System.out.println("Enter destination square: ");
                    des = input.next();
                    g.board.movePiece(src, des);
                    g.board.printBoard();
                    gameWon = g.checkWin();
                }
            } else if (g.black.isTurn()) {
                g.black.isInCheck(g.board);
                if (g.black.inCheck) {
                    while (g.black.inCheck) {
                        //g.inCheckBlock(2, src, des, input);
                        System.out.println("Black King in check, must get king out of check");
                        System.out.println("Black player enter originating piece square: ");
                        src = input.next();
                        System.out.println("Enter destination square: ");
                        des = input.next();
                        if (g.board.movedOutOfCheck(src, des)) {
                            g.black.inCheck = false;
                            g.board.movePiece(src, des);
                            g.board.printBoard();
                            gameWon = g.checkWin();
                        } else {
                            src = null;
                            des = null;
                        }
                    }
                } else {
                    //g.nonCheckBlock(2, src, des, input, gameWon);
                    System.out.println("Black player enter originating piece square: ");
                    src = input.next();
                    System.out.println("Enter destination square: ");
                    des = input.next();
                    g.board.movePiece(src, des);
                    g.board.printBoard();
                    gameWon = g.checkWin();
                }
            }
            //TODO: add stalemate, checkMate logic

            /*g.board.movePiece(src, des);
            g.board.printBoard();
            gameWon = g.checkWin();
            //g.printRemovedPieces();

             */
        }
        if (gameWon) {
            System.out.println(g.board.winner + " wins the game");
        }
    }
}

