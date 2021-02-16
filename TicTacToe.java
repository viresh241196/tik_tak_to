import java.util.Scanner;

public class TicTacToe {
    public static char[] createBoard() {
        char[] board = new char[10];
        for (int i = 1; i < board.length; i++) {
            board[i] = ' ';
        }
        return board;
    }

    public static char makeChoice() {
        Scanner obj = new Scanner(System.in);
        System.out.println("enter what you want X or O ");
        char player1 = obj.next().charAt(0);
        char computer = ' ';
        if (player1 == 'X' || player1 == 'x') {
            computer = 'O';
        } else if (player1 == 'O' || player1 == 'o') {
            computer = 'X';
        } else {
            System.out.println("invalid");
        }
        System.out.println("player is " + player1 + " " + "computer is " + computer);
        return player1;
    }

    public static void displayBoard(char[] board) {
        System.out.println(board[1] + "|" + board[2] + "|" + board[3]);
        System.out.println("------");
        System.out.println(board[4] + "|" + board[5] + "|" + board[6]);
        System.out.println("------");
        System.out.println(board[7] + "|" + board[8] + "|" + board[9]);
    }

    public static void makeMove(char[] board, char player1) {
        Scanner obj = new Scanner(System.in);
        System.out.println("enter a location number ");
        int location = obj.nextInt();
        if (0 < location && location < 10) {
            if (board[location] == ' ') {
                board[location] = player1;
            } else
                System.out.println("invalid");
        }
    }

    public static void tossToBegin() {
        int toss = (int) Math.floor(Math.random() * 10) % 2;
        if (toss == 0) {
            System.out.println("Player1 is your change to play");
        } else {
            System.out.println("computer is your change to play");
        }
    }

    public static void checkGameStatus(int gamestatus,char[] board) {
        int result = 0;
        if (board[1] == board[2] && board[3] == board[1] && board[1] != ' ') {
            result = 1;
        }
        else if (board[4] == board[5] && board[4] == board[6] && board[4] != ' ') {
            result = 1;
        }
        else if (board[7] == board[8] && board[7] == board[9] && board[7] != ' ') {
            result = 1;
        }
        else if (board[1] == board[4] && board[1] == board[7] && board[1] != ' ') {
            result = 1;
        }
        else if (board[2] == board[5] && board[2] == board[8] && board[2] != ' ') {
            result = 1;
        }
        else if (board[3] == board[6] && board[3] == board[9] && board[3] != ' ') {
            result = 1;
        }
        else if (board[1] == board[5] && board[1] == board[9] && board[1] != ' ') {
            result = 1;
        }
        else if (board[3] == board[5] && board[3] == board[7] && board[3] != ' ') {
            result = 1;
        }

    }

    public static void main(String[] args) {
        int gamestatus = 0;
        System.out.println("welcome to TikTakTo");
        char[] board = createBoard();
        char player = makeChoice();
        checkGameStatus(gamestatus,board);
        tossToBegin();
//        displayBoard(board);
//        makeMove(board,player);
//        displayBoard(board);
    }

}