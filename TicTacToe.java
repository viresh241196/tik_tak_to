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

        } else {
            System.out.println("Sorry you have selected the wrong position try again");
            if(counter<9) makeUserMove();
        }
        counter++;
        checkGameStatus("User");
        return;
    }
//computer move
    public void makeComputerMove() {
        int move = (int) Math.floor(Math.random() * 10) % 9 + 1;
        System.out.println("Wait its computers turn now");
        if (validateMove(move)) {
            board[move] = computerChoice;
            System.out.println(move);

        } else {
            System.out.println(move);
            System.out.println("Sorry you have selected the wrong position try again");
            if(counter<9) makeComputerMove();
        }
        counter++;
        checkGameStatus("Computer");
        return;
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
//check condition
    public boolean allEqual(int a, int b, int c) {
        return (a == c) && (b == c);
    }
//check game status whether win tie lose
    public void checkGameStatus(String key) {
        displayBoard(board);
        System.out.println(counter);
        int result = 0;
        if (counter <= 9) {
            for (int i = 1; i < 10; i = i + 3) {
                if (allEqual(board[i], board[i + 1], board[i + 2]) && board[i] != ' ') {
                    System.out.println(key + " has won the game");
                    counter=10;
                    return;
                }
            }
            for (int i = 1; i < 3; i = i + 1) {
                if (allEqual(board[i], board[i + 3], board[i + 6]) && board[i] != ' ') {
                    System.out.println(key + " has won the game");
                    counter=10;
                    return;
                }
            }
            if (allEqual(board[1], board[5], board[9]) && board[1] != ' ') {
                System.out.println(key + " has won the game");
                counter=10;
                return;
            }
            if (allEqual(board[3], board[5], board[7]) && board[3] != ' ') {
                System.out.println(key + " has won the game");
                counter=10;
                return;
            }
            if (key.equals("Computer") && counter <=9) makeUserMove();
            else if (key.equals("User") && counter <=9) makeComputerMove();
        }
        else if (counter == 10) {
            System.out.println("it's a tie");
            return;
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        System.out.println("welcome to TikTakToe");
        char[] board = game.createBoard();
        game.makeChoice();
        if (tossToBegin()) game.makeComputerMove();
        else game.makeUserMove();
        // displayBoard(board);
    }
}