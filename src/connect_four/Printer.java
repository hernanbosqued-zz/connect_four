package connect_four;

import java.util.Scanner;

class Printer {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    private Scanner scanner;

    Printer() {
        scanner = new Scanner(System.in);
    }

    void printBoard(Board board) {
        printNewRow();

        for (int row = board.rows - 1; row >= 0; row--) {
            for (int column = 0; column < board.columns; column++) {
                printChip(board.board[row][column].getShape());
            }
            printNewRow();
        }
    }

    private void printChip(String shape) {
        System.out.print(shape + " ");
    }

    private void printNewRow() {
        System.out.print('\n');
    }

    void printTurn(Turn turn) {
        printNewRow();
        System.out.print("Turno de " + turn.getName() + ": ");
    }

    void clearScreen() {
        System.out.print("\033[H\033[2J");
    }

    int getInput(int max) throws BadInputException {
        String input = scanner.nextLine();
        try {
            int numericInput = Character.getNumericValue(input.getBytes()[0]);
            if (numericInput <= max) {
                return numericInput;
            } else throw new BadInputException();
        } catch (Exception err) {
            throw new BadInputException();
        }
    }

    void printInputErrorMessage() {
        System.out.print(ANSI_RED + "Error de ingreso. Pulse ENTER para volver a intentar." + ANSI_RESET);
        scanner.nextLine();
    }
}
