import java.util.Scanner;

public class TicTacToe {
    public char computerChoice;
    public char userChoice;
    public int counter = 0;
    public char[] board;

    public char[] createBoard() {
        board = new char[10];
        for (int i = 1; i < board.length; i++) {
            board[i] = ' ';
        }
        return board;
    }

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

    public static void displayBoard(char[] board) {
        System.out.println(board[1] + "|" + board[2] + "|" + board[3]);
        System.out.println("------");
        System.out.println(board[4] + "|" + board[5] + "|" + board[6]);
        System.out.println("------");
        System.out.println(board[7] + "|" + board[8] + "|" + board[9]);
    }

    public boolean validateMove(int location) {
        if (0 < location && location < 10) {
            if (board[location] != ' ') return false;
            return true;
        }
        return false;
    }

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
            if(counter<=9) makeUserMove();
            else return;
        }
    }

    public void makeComputerMove() {
        int move = (int) Math.floor(Math.random() * 10) % 9 + 1;
        System.out.println("Wait its computers turn now");
        if (validateMove(move)) {
            board[move] = computerChoice;
            System.out.println(move);
            counter++;
            checkGameStatus("Computer");
        } else {
            if(counter<=9) makeComputerMove();
            else return;
        }
    }

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

    public boolean allEqual(int a, int b, int c) {
        return (a == c) && (b == c);
    }

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
            if (key.equals("Computer") && counter <9) makeUserMove();
            else if (key.equals("User") && counter <9) makeComputerMove();
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