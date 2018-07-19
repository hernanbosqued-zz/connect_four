package connect_four;

class Printer {
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

    public void printTurn(Turn turn) {
        printNewRow();
        System.out.print("Turno de " + turn.getName() + ": ");
    }
}
