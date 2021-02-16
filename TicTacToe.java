import java.util.Scanner;

public class TicTacToe {
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
        } else if (player == 'O' || player == 'o'){
            computer = 'X';
        } else {
            System.out.println("invalid");
        }
    }

    public static void main(String[] args) {
        System.out.println("welcome to TikTakTo");
        createBoard();
        makeChoice();
    }
}
