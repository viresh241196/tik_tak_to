import java.util.Scanner;

public class  TicTacToe {
    //creating board
    public static char[] createBoard() {
        char[] board = new char[10];
        for (int i = 1; i < board.length; i++) {
            board[i] = ' ';
        }
        return board;
    }
    //creating make choice for x or o
    public static void makeChoice() {
        Scanner obj = new Scanner(System.in);
        System.out.println("enter what you want X or O ");
        char player = obj.next().charAt(0);
        char computer = ' ';
        if (player == 'X' || player == 'x') {
            computer = 'O';
        } else if (player == 'O' || player == 'o') {
            computer = 'X';
        } else {
            System.out.println("invalid");
        }
    }
    //display board
    public static void displayBoard(char[] board) {
        System.out.println(board[1] + "|" + board[2] + "|" + board[3]);
        System.out.println("------");
        System.out.println(board[4] + "|" + board[5] + "|" + board[6]);
        System.out.println("------");
        System.out.println(board[7] + "|" + board[8] + "|" + board[9]);
        System.out.println(board);
    }

    //make move only if location is empty
    public static void makeMove(char[] board) {
        Scanner obj = new Scanner(System.in);
        System.out.println("enter a location number ");
        int location = obj.nextInt();
        if (0 < location && location < 10) {
            if (board[location] == ' ') {
                System.out.println("your input is valid");
            } else
                System.out.println("invalid");
        }
    }

    public static void main(String[] args) {
        System.out.println("welcome to TikTakTo");
        char[] board = createBoard();
        makeChoice();
        displayBoard(board);
        makeMove(board);
    }
}
