package connect_four;

import java.io.IOException;
import java.util.Scanner;

public class connect_four {

    public static void main(String[] args) throws IOException {

        Player player1 = new Player("Hernan", new ChipYellow());
        Player player2 = new Player("Emma", new ChipBlue());
        Board board = new Board(6, 7);
        Game game = new Game(board, player1, player2);
        Printer printer = new Printer();

        while (!game.hasWinner()) {
            System.out.print("\033[H\033[2J");

            printer.printBoard(board);

            Turn turn = game.getTurn();
            printer.printTurn(turn);

            Scanner s = new Scanner(System.in);
            String input = s.nextLine();
            turn.move(Character.getNumericValue(input.getBytes()[0]));

            game.endTurn(turn);
        }
    }
}