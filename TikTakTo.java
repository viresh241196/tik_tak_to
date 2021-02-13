import java.util.Scanner;

public class TikTakTo {
    public static char[] createBoard() {
        char[] board = new char[10];
        for (int i = 1; i < board.length; i++) {
            board[i] = ' ';
        }
        return board;
    }

    public static void makeChoice() {
        Scanner obj = new Scanner(System.in);

        System.out.println("enter what you want X or O ");
        char player1 = obj.next().charAt(0);
        char computer;
        if (player1 == 'X' || player1 == 'x') {
            computer = 'O';
        } else {
            player1 = 'O';
            computer = 'X';
        }
        System.out.println("player is " + player1 + " " + "computer is " + computer);
    }

    public static void main(String[] args) {
        System.out.println("welcome to TikTakTo");
        createBoard();
        makeChoice();

    }
}
