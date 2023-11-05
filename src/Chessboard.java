import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Chessboard {
    //8x8 Board of squares/chessboard
    public Square[][] board = new Square[8][8];
    //public LinkedList<Piece> removedPieces = new LinkedList<Piece>();
    public LinkedList<Piece> removedPiecesWhite = new LinkedList<Piece>();
    public LinkedList<Piece> removedPiecesBlack = new LinkedList<Piece>();
    String winner = null;

    //Ensure correct turns
    boolean whiteTurn = true;
    boolean blackTurn = false;
    Player white;
    Player black;
    boolean won = false;


    public Chessboard(Player w, Player b) {
        white = w;
        black = b;
        //Sets up board with white pieces on one side and black pieces on other side
        initalizePieces();
    }

    public Piece getPiece(int x, int y) {
        if (board[x][y].piece == null) {
            Piece empty = new Empty();
            return empty;
        }
        return board[x][y].piece;
    }

    public boolean movePiece(String src, String des) {
        //String src = srcX and srcY while String des = desX and desY
        //TODO: converter is wrong?
        int[] convertedCoords = convert(src, des);
        int srcX = convertedCoords[0];
        int srcY = convertedCoords[1];
        int desX = convertedCoords[2];
        int desY = convertedCoords[3];
        //Player decides where to move piece, board checks if move is possible given the specific pieces movement
        //Get target piece from inputted x and y
        Piece targetPiece = board[srcX][srcY].getPiece();
        if (targetPiece == null) {
            System.out.println("No piece at selected square");
            return false;
        }
        //Check if turn is out of order
        if (white.isTurn() && targetPiece.getColorInt() != white.color) {
            System.out.println("Not black player's turn");
            return false;
        }
        if (black.isTurn() && targetPiece.getColorInt() != black.color) {
            System.out.println("Not white player's turn");
            return false;
        }

        boolean squareOccupied = board[desX][desY].isOccupied;
        Piece occupyingPiece = board[desX][desY].getPiece();
        //TODO: fix pawnfirstmove-inCheck fn which checks all pieces turns it from t to f even though it hasn't moved
        //For Pawn Promotion
        if (targetPiece.getNameString().equals("Pawn") && targetPiece.canMove(board, desX, desY)) {
            Pawn targetPawn = (Pawn) targetPiece;
            if (Math.abs(desX - srcX) == 1 && ((desX == 7) || (desX == 0))) {
                if (targetPawn.diagonalAttack == false) {
                    System.out.println("Pawn cannot move forward onto a square occupied by another piece");
                    return false;
                }
                Scanner input = new Scanner(System.in);
                //Ask player which piece
                System.out.println("Pawn promoted, type capitol first letter of desired piece: ");
                System.out.println("Options include: Queen, Rook, Bishop, and Knight");
                //char firstLetter = input.next(".").charAt(0);
                //TODO: make sure this works
                char firstLetter = 'A';
                while (!checkFirstLetter(firstLetter)) {
                    firstLetter = input.next(".").charAt(0);
                }

                occupyingPiece.setCoords(10, 10);
                board[desX][desY].removePiece();
                Piece newPiece = createNewPiece(firstLetter, targetPawn.getColorInt(), desX, desY);
                //Remove target piece from original square
                board[srcX][srcY].removePiece();
                //Move new piece to dest square
                board[desX][desY].addPiece(newPiece);
                newPiece.setCoords(desX, desY);
                changeTurn();
                return true;
                /*
                //If white pawn reaches opposite side
                if (desX == 7 || desX == 0) {
                    //Ask player which piece
                    System.out.println("Pawn promoted, type capitol first letter of desired piece: ");
                    System.out.println("Options include: Queen, Rook, Bishop, and Knight");
                    //char firstLetter = input.next(".").charAt(0);
                    //TODO: make sure this works
                    char firstLetter = 'A';
                    while (checkFirstLetter(firstLetter)) {
                        firstLetter = input.next(".").charAt(0);
                    }

                    Piece newPiece = createNewPiece(firstLetter, targetPawn.getColorInt(), desX, desY);
                    targetPiece = newPiece;
                    board[srcX][srcY].removePiece();
                    //targetPiece.setCoords(desX, desY);
                    changeTurn();
                    return true;

                }
                /*else if (targetPawn.color == 2 && desX == 0) {
                    //Ask player which piece
                    System.out.println("Pawn promoted, type capitol first letter of desired piece: ");
                    System.out.println("Options include: Queen, Rook, Bishop, and Knight");
                    //char firstLetter = input.next(".").charAt(0);
                    //TODO: make sure this works
                    char firstLetter = 'A';
                    while (checkFirstLetter(firstLetter)) {
                        firstLetter = input.next(".").charAt(0);
                    }

                    Piece newPiece = createNewPiece(firstLetter, targetPawn.getColorInt(), desX, desY);
                    targetPiece = newPiece;
                    board[srcX][srcY].removePiece();
                    //targetPiece.setCoords(desX, desY);
                    changeTurn();
                    return true;
                }*/
            }
        }

        //TODO: Maybe Structure conditions where canMove is first condition-easier to think through
        //If no piece occupying destination square, check if target piece is able to move
        if (occupyingPiece ==  null && targetPiece.canMove(board, desX, desY)) {
            //Remove target piece from original square
            board[srcX][srcY].removePiece();
            //Move target piece to dest square
            board[desX][desY].addPiece(targetPiece);
            //Updated piece coords
            targetPiece.setCoords(desX, desY);
            changeTurn();
            return true;
        }
        else if (occupyingPiece ==  null && !targetPiece.canMove(board, desX, desY)) {
            System.out.println("Illegal move");
            return false;
        }
        //If color of piece occupying destination square is same color, then cannot move there
        //Might not need second condition (&& squareOccupied) because first condition would satisfy: test
        if ((targetPiece.getColorInt() == occupyingPiece.getColorInt()) && squareOccupied) {
            System.out.println("Cannot move to square occupied by allied piece");
            return false;
        }

        //If move is possible and square has enemy piece then move piece to des square and account for kill
        if (targetPiece.canMove(board, desX, desY) && squareOccupied)  {
            String targetName = targetPiece.getName();
            //Ensure pawn only does diagonalAttack (not front etc)
            if (targetName.equals("Pawn")) {
                Pawn targetPawn = (Pawn) targetPiece;
                //If pawn cannot do diagnoal than stop
                if (targetPawn.diagonalAttack == false) {
                    System.out.println("Pawn cannot move forward onto a square occupied by another piece");
                    return false;
                }
            }
            //Add killed piece to white or black list of removed pieces
            if (occupyingPiece.getColorInt() == 1) {
                removedPiecesWhite.add(occupyingPiece);
            }
            else {
                removedPiecesBlack.add(occupyingPiece);
            }
            //TODO: print what piece was taken
            //Remove piece from board
            board[desX][desY].removePiece();
            //Update its coords
            occupyingPiece.setCoords(10, 10);

            //Remove target piece from original square
            board[srcX][srcY].removePiece();
            //Move target piece to dest square
            board[desX][desY].addPiece(targetPiece);
            //Updated piece coords
            targetPiece.setCoords(desX, desY);
            changeTurn();
            return true;
        }
        //TODO: See if this block can be removed
        //If move is possible and no enemy piece on destination square
        else if (targetPiece.canMove(board, desX, desY) && !squareOccupied) {
            //Move piece to destination square
            board[desX][desY].addPiece(targetPiece);
            //Updated piece coords
            targetPiece.setCoords(desX, desY);
            //Remove piece from previous square
            board[srcX][srcY].removePiece();
            changeTurn();
            return true;
        }
        //Else return false and piece stays in square
        return false;
    }

    public void initalizePieces() {
        //Initalize board squares
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Square();
            }
        }
        //Create array to hold each players' pieces
        //TODO maybe have pieces arrays be class variables
        Piece[] whitePieces = new Piece[16];
        Piece[] blackPieces = new Piece[16];

        //Instantiate pieces for each player
        whitePieces = createPieces(whitePieces, 1);
        blackPieces = createPieces(blackPieces, 2);

        //Add pieces to board
        //Match pieces with correct squares on board: black on top white on bottom
        for (int i = 0; i < 8; i++) {
            //Add piece to appropriate starting square
            board[0][i].addPiece(whitePieces[i]);
            //Set piece coordinates
            whitePieces[i].setCoords(0, i);

            //Add piece to appropriate starting square
            board[7][i].addPiece(blackPieces[i]);
            //Set piece coordinates
            blackPieces[i].setCoords(7, i);
        }
        //Place pawns
        //TODO: remove pawns to test easier
        for (int i = 0; i < 8; i++) {
            //Add piece to appropriate starting square
            board[1][i].addPiece(whitePieces[i + 8]);
            //Set piece coordinates
            whitePieces[i + 8].setCoords(1, i);

            //Add piece to appropriate starting square
            board[6][i].addPiece(blackPieces[i + 8]);
            //Set piece coordinates
            blackPieces[i + 8].setCoords(6, i);
        }
    }

    public Piece createNewPiece(char firstLetter, int color, int desX, int desY) {
        //char[] allFirstLetters = {'Q', 'R', 'B', 'K'};
        Piece newPiece = null;
        if (firstLetter == 'Q') {
            newPiece = new Queen(color);
        }
        else if (firstLetter == 'R') {
            newPiece = new Rook(color);
        }
        else if (firstLetter == 'B') {
            newPiece = new Bishop(color);
        }
        else if (firstLetter == 'K') {
            newPiece = new Knight(color);
        }
        newPiece.curX = desX;
        newPiece.curY = desY;
        return newPiece;
    }

    public Piece[] createPieces(Piece[] pieces, int color) {
        //Pieces added to array in order of board position

        //TODO test to make sure combined for loop works
        for (int i = 0; i < 16; i++) {
            if (i == 0 || i == 7) {
                pieces[i] = new Rook(color);
            }
            else if (i == 1 || i == 6) {
                pieces[i] = new Knight(color);
            }
            else if (i == 2 || i == 5) {
                pieces[i] = new Bishop(color);
            }
            else if (i == 3) {
                pieces[i] = new Queen(color);
            }
            else if (i == 4) {
                pieces[i] = new King(color);
            }
            else {
                pieces[i] = new Pawn(color);
            }
        }

        //For loop to add pawns
        for (int i = 8; i < 16; i++) {
            pieces[i] = new Pawn(color);
        }

        return pieces;
    }

    public int[] convert(String src, String des) {
        //Ex: src's char(1st) == coords[1] && src's int(2nd) == coords[0]
        int[] coords = new int[4];

        //Find what first digit/y is
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

        int j = 0;
        for (char i : letters) {
            if (src.charAt(0) == i) {
                coords[1] = j;
            }
            if (des.charAt(0) == i) {
                coords[3] = j;
            }
            j++;
        }

        //Find what int/x is
        int[] ints = {99, 7, 6, 5, 4, 3, 2, 1, 0};
        char srcIntChar = src.charAt(1);
        int srcInt = Character.getNumericValue(srcIntChar);
        char desIntChar = des.charAt(1);
        int desInt = Character.getNumericValue(desIntChar);

        coords[0] = ints[srcInt];
        coords[2] = ints[desInt];
        /*for (int i : ints) {
            if (srcInt == i) {
                coords[0] = i;
            }
            if (desInt == i) {
                coords[2] = i;
            }
        }*/
        return coords;
    }

    public void printBoard() {
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        System.out.print("     a");
        for (int k = 1; k < 8; k++) {
            System.out.print("     " + letters[k]);
        }
        System.out.println();

        printHorizontalLines();

        for (int i = 0, k = 8; i < 8; i++) {
            System.out.print(k + " |");
            k--;
            for (int j = 0; j < 8; j++) {
                Piece p = board[i][j].getPiece();
                System.out.print("  ");
                if (p == null) {
                    System.out.print("   |");
                    continue;
                }
                //System.out.print(" ");
                p.printOnBoard();
                System.out.print(" |");
            }
            System.out.println();
            printHorizontalLines();
        }
    }

    public void printHorizontalLines() {
        System.out.print("  |__");
        for (int i = 0; i < 15; i++) {
            System.out.print("___");
        }
        System.out.print("|");
        System.out.println();
    }

    public void changeTurn() {
        //Change player turn
        if (white.isTurn()) {
            white.turn = false;
            black.turn = true;
        }
        else {
            black.turn = false;
            white.turn = true;
        }
    }

    public boolean checkForRemovedKing() {
        //If king is in either lists then game is over
        for (Piece p : removedPiecesWhite) {
            if (p.getNameString().equals("King")) {
                winner = "White";
                return true;
            }
        }
        for (Piece p : removedPiecesBlack) {
            if (p.getNameString().equals("King")) {
                winner = "Black";
                return true;
            }
        }
        return false;
    }

    public boolean inCheckMate() {
        //Get each king
        King king = null;
        if (white.isTurn()) {
            king = getWhiteKing();
        }
        else {
            king = getBlackKing();
        }
        //Check if king is in check
        int curX = king.curX;
        int curY = king.curY;
        if (king.isInCheck(board, curX, curY)) {
            //If king is in check and has not way to move out then checkmate
            for (int i = -1; i < 2; i ++) {
                for (int j = -1; j < 2; j++) {
                    int desY = curY + j;
                    int desX = curX + i;
                    if (king.canMove(board, desX, desY)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public King getWhiteKing() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece occupying = board[i][j].getPiece();
                if (occupying == null) {
                    continue;
                }
                else if (occupying.getNameString().equals("King") && occupying.getColorInt() == 1) {
                    return (King) occupying;
                }
            }
        }
        return null;
    }

    public King getBlackKing() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece occupying = board[i][j].getPiece();
                if (occupying == null) {
                    continue;
                }
                else if (occupying.getNameString().equals("King") && occupying.getColorInt() == 2) {
                    return (King) occupying;
                }
            }
        }
        return null;
    }

    public boolean movedOutOfCheck(String src, String des) {
        int[] convertedCoords = convert(src, des);
        int srcX = convertedCoords[0];
        int srcY = convertedCoords[1];
        int desX = convertedCoords[2];
        int desY = convertedCoords[3];
        //Check if piece selected is King, if not king check if moving that piece to des square stops check
        Piece allyPiece = board[srcX][srcY].getPiece();
        if (!allyPiece.getNameString().equals("King")) {

        }

        //Only get to this if piece selected is king
        Piece king = board[srcX][srcY].getPiece();
        //Ensure selected piece is king in check
        if (!king.getNameString().equals("King")) {
            return false;
        }

        //TODO: Move all these loops to seperate functions
        //Find all moves possible for king and add to 2D array
        int[][] kingPossibleMoves = new int[8][2];
        int count = 0;
        for (int i = -1; i < 2; i ++) {
            for (int j = -1; j < 2; j++) {
                int tempX = srcX + i;
                int tempY = srcY + j;
                if (tempX >= 8 || tempY >= 8 || tempX < 0 || tempY < 0) {
                    continue;
                }
                else if ((i == 0) && (j == 0)) {
                    continue;
                }
                else if (king.canMove(board, srcX + i, srcY + j)) {
                    kingPossibleMoves[count][0] = srcX + i;
                    kingPossibleMoves[count][1] = srcY + j;
                    count++;
                }
            }
        }
        //Find color of piece checking king
        int kingColor = king.getColorInt();
        int opposingColor;
        if (kingColor == 1) {
            opposingColor = 2;
        }
        else {
            opposingColor = 1;
        }

        Piece checkingPiece = findCheckingPiece(board, king, opposingColor);

        int[][] checkingPossibleMoves = new int[30][2];
        //Find all moves checkingPiece can make
        int countTwo = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (checkingPiece.canMove(board, i, j)) {
                    checkingPossibleMoves[countTwo][0] = i;
                    checkingPossibleMoves[countTwo][1] = j;
                    countTwo++;
                }
            }
        }

        int[][] goodMoves = new int[8][2];

        //Compare two arrays and king potential move isn't in checkingPossibleMoves then it is a safe move
        //int length = getArrayLength(checkingPossibleMoves);
        //TODO: Change arrays to lists, because of 0,0 values & edge case where at corner of board (wouldn't know its a move)
        int goodCount = 0;
        for (int j = 0; j < 8; j++) {
            //TODO: Might be an edge case for corner of board
            /*if (((i == 0) && (j == 0)) || ((checkingPossibleMoves[i][0] == 0) && (checkingPossibleMoves[i][1] == 0)))  {
                continue;
            }*/
            int one  = kingPossibleMoves[j][0];
            int two = kingPossibleMoves[j][1];
            int[] coord = {one, two};
            int[] zeros = {0, 0};
            if (coord == zeros) {
                continue;
            }
            if (!Arrays.stream(checkingPossibleMoves).anyMatch(e -> Arrays.equals(e, coord))) {
                goodMoves[goodCount][0] = kingPossibleMoves[j][0];
                goodMoves[goodCount][1] = kingPossibleMoves[j][1];
                goodCount++;
            }
        }
        
        //Check if player entered correct move
        for (int i = 0; i < 8; i++) {
            if (goodMoves[i][0] == desX && goodMoves[i][1] == desY) {
                return true;
            }
        }
        //TODO: Add function to make sure goodMove isn't moving into another check (check that the goodMove is actually good)


        return false;
    }

    private Piece findCheckingPiece(Square[][] board, Piece king, int opposingColor ) {
        //Find piece checking king
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece occupying = board[i][j].getPiece();
                if (occupying == null) {
                    continue;
                }
                else if (occupying.canMove(board, king.curX, king.curY) && occupying.getColorInt() == opposingColor) {
                    return occupying;
                }
                /*else if (canMoveTest(occupying.curX, occupying.curY, king.curX, king.curY)) {

                }*/
            }
        }
        return null;
    }

    public boolean checkFirstLetter(char firstLetter) {
        char[] listOfAcceptable = {'Q', 'R', 'B', 'K'};
        for (int i = 0; i < listOfAcceptable.length; i++) {
            if (firstLetter == listOfAcceptable[i]) {
                return true;
            }
        }
        return false;
    }
}

