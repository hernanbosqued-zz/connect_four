package connect_four;

class Printer {

    private Board board;

    Printer(Board board) {
        this.board = board;
    }

    void print() {
        for (int row = board.rows - 1; row >= 0; row--) {
            for (int column = 0; column < board.columns; column++) {
                print(board.board[row][column].getShape());
            }
            printNewRow();
        }
    }

    private void print(String shape) {
        System.out.print(shape + " ");
    }

    private void printNewRow() {
        System.out.print('\n');
    }
}
