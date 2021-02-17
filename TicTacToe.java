import java.util.Scanner;
public class TicTacToe {
    public char computerChoice;
    public char userChoice;
    public int counter = 0;
    public char[] board;
    //    create board
    public char[] createBoard() {
        board = new char[10];
        for (int i = 1; i < board.length; i++) {
            board[i] = ' ';
        }
        return board;
    }

    //creating make choice for x or o
    public void makeChoice() {
        Scanner obj = new Scanner(System.in);
        System.out.println("enter what you want X or O ");
        char player = obj.next().charAt(0);
        char computer = ' ';
        if (player == 'X' || player == 'x') {
            computerChoice = 'O';
            userChoice = 'X';
        } else if (player == 'O' || player == 'o') {
            computerChoice = 'X';
            userChoice = 'O';
        } else {
            System.out.println("invalid");
        }
        System.out.println("player is " + userChoice + " " + "computer is " + computerChoice);
    }

    //display board
    public static void displayBoard(char[] board) {
        System.out.println(board[1] + "|" + board[2] + "|" + board[3]);
        System.out.println("------");
        System.out.println(board[4] + "|" + board[5] + "|" + board[6]);
        System.out.println("------");
        System.out.println(board[7] + "|" + board[8] + "|" + board[9]);
    }

    //if location is empty and added player value
    public boolean validateMove(int location) {
        if (0 < location && location < 10) {
            if (board[location] != ' ') return false;
            return true;
        }
        return false;
    }

    //make move for user only
    public void makeUserMove() {
        Scanner obj = new Scanner(System.in);
        System.out.println("enter a location number ");
        int location = obj.nextInt();
        if (validateMove(location)) {
            board[location] = userChoice;
            counter++;
            checkGameStatus("User");
        } else {
            System.out.println("Sorry you have selected the wrong position try again");
            if (counter <= 9) makeUserMove();
            else return;
        }
    }

    //computer move
    public void makeComputerMove() {
        int move = (int) Math.floor(Math.random() * 10) % 9 + 1;
        System.out.println("Wait its computers turn now");
        int bestmove = computerWinMove();
        if (bestmove != 0) {
            board[bestmove] = computerChoice;
            System.out.println(bestmove);
            counter++;
            checkGameStatus("Computer");
            return;
        }
        bestmove = computerBlockMove();
        if (bestmove != 0) {
            board[bestmove] = computerChoice;
            System.out.println(bestmove);
            counter++;
            checkGameStatus("Computer");
            return;
        }
        bestmove = getCorner();
        if (bestmove != 0){
            board[bestmove] = computerChoice;
            System.out.println(bestmove);
            counter++;
            checkGameStatus("Computer");
            return;
        }
        bestmove = getCenter();
        if (bestmove != 0){
            board[bestmove] = computerChoice;
            System.out.println(bestmove);
            counter++;
            checkGameStatus("Computer");
            return;
        }
        if (bestmove == 0) {
            if (validateMove(move)) {
                board[move] = computerChoice;
                System.out.println(move);
                counter++;
                checkGameStatus("Computer");
            } else {
                if (counter <= 9) makeComputerMove();
                else return;
            }
        }
    }

    //who play first
    public static boolean tossToBegin() {
        int toss = (int) Math.floor(Math.random() * 10) % 2;
        if (toss == 0) {
            System.out.println("Player its your turn to play");
            return false;
        } else {
            System.out.println("computer it's your turn to play");
            return true;
        }
    }

    //check condition if win
    public boolean allEqual(int a, int b, int c) {
        return (a == c) && (b == c);
    }

    //check condition to win
    public boolean twoEqual(char a, char b) {
        return (a == b) && a == computerChoice;
    }

    //check if computer can make best move
    public int computerWinMove() {
        for (int i = 1; i < 10; i = i + 3) {
            if (twoEqual(board[i], board[i + 1]) && board[i + 2] == ' ') {
                return i + 2;
            }
        }
        for (int i = 1; i < 10; i = i + 3) {
            if (twoEqual(board[i], board[i + 2]) && board[i + 1] == ' ') {
                return i + 1;
            }
        }
        for (int i = 1; i < 10; i = i + 3) {
            if (twoEqual(board[i + 1], board[i + 2]) && board[i] == ' ') {
                return i;
            }
        }
        for (int i = 1; i < 3; i = i + 1) {
            if (twoEqual(board[i], board[i + 3]) && board[i + 6] == ' ') {
                return i + 6;
            }
        }
        for (int i = 1; i < 3; i = i + 1) {
            if (twoEqual(board[i], board[i + 6]) && board[i + 3] == ' ') {
                return i + 3;
            }
        }
        for (int i = 1; i < 3; i = i + 1) {
            if (twoEqual(board[i + 3], board[i + 6]) && board[i] == ' ') {
                return i;
            }
        }
        return 0;
    }

    public boolean checkToBlock(char a, char b) {
        return (a == b) && a == userChoice;
    }

    //check if computer can block user
    public int computerBlockMove() {
        for (int i = 1; i < 10; i = i + 3) {
            if (checkToBlock(board[i], board[i + 1]) && board[i + 2] == ' ') {
                return i + 2;
            }
        }
        for (int i = 1; i < 10; i = i + 3) {
            if (checkToBlock(board[i], board[i + 2]) && board[i + 1] == ' ') {
                return i + 1;
            }
        }
        for (int i = 1; i < 10; i = i + 3) {
            if (checkToBlock(board[i + 1], board[i + 2]) && board[i] == ' ') {
                return i;
            }
        }
        for (int i = 1; i < 3; i = i + 1) {
            if (checkToBlock(board[i], board[i + 3]) && board[i + 6] == ' ') {
                return i + 6;
            }
        }
        for (int i = 1; i < 3; i = i + 1) {
            if (checkToBlock(board[i], board[i + 6]) && board[i + 3] == ' ') {
                return i + 3;
            }
        }
        for (int i = 1; i < 3; i = i + 1) {
            if (checkToBlock(board[i + 3], board[i + 6]) && board[i] == ' ') {
                return i;
            }
        }
        return 0;
    }
//check if corner are available
    public int getCorner() {
        if (board[1] == ' ') return 1;
        else if (board[3] == ' ') return 3;
        else if (board[7] == ' ') return 7;
        else if (board[9] == ' ') return 9;
        return 0;
    }
    public int getCenter(){
        if (board[5]==' ') return 5;
        return 0;
    }

    //check game status whether win tie lose
    public void checkGameStatus(String key) {
        displayBoard(board);
        // System.out.println(counter);
        if (counter <= 9) {
            for (int i = 1; i < 10; i = i + 3) {
                if (allEqual(board[i], board[i + 1], board[i + 2]) && board[i] != ' ') {
                    System.out.println(key + " has won the game");
                    return;
                }
            }
            for (int i = 1; i < 3; i = i + 1) {
                if (allEqual(board[i], board[i + 3], board[i + 6]) && board[i] != ' ') {
                    System.out.println(key + " has won the game");
                    return;
                }
            }
            if (allEqual(board[1], board[5], board[9]) && board[1] != ' ') {
                System.out.println(key + " has won the game");
                return;
            }
            if (allEqual(board[3], board[5], board[7]) && board[3] != ' ') {
                System.out.println(key + " has won the game");
                return;
            }
            if (key.equals("Computer") && counter < 9) makeUserMove();
            else if (key.equals("User") && counter < 9) makeComputerMove();
            else System.out.println("it's a tie");
        }
    }

    public static void main(String[] args) {
        int gamestatus = 0;
        TicTacToe game = new TicTacToe();
        System.out.println("welcome to TikTakToe");
        char[] board = game.createBoard();
        game.makeChoice();
        if (tossToBegin()) game.makeComputerMove();
        else game.makeUserMove();
    }
}