package connect_four;

public class connect_four {
    private static int ROWS = 6;
    private static int COLUMNS = 7;

    public static void main(String[] args) {

        Player player1 = new Player("Hernan", new ChipYellow());
        Player player2 = new Player("Emma", new ChipBlue());

        Board board = new Board(ROWS, COLUMNS);
        Game game = new Game(board, player1, player2);
        Turn turn;
        Printer printer = new Printer();
        printer.printBoard(board);

        do {
            game.nextTurn();

            turn = game.getTurn();
            printer.printTurn(turn);

            try
            {
                int columnSelected = printer.getInput(COLUMNS);
                turn.make(columnSelected);
                game.move(turn);
            }
            catch (BadInputException exception)
            {
                printer.printInputErrorMessage();
                game.repeatTurn();
            }
            catch (IndexOutOfBoundsException exception)
            {
                printer.printFullColumnErrorMessage();
                game.repeatTurn();
            }
            printer.printBoard(board);
        } while (!game.hasWinner(turn, board));

        printer.printWinner(game.getTurn().player);
    }
}