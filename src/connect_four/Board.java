package connect_four;


class Board {
    final int rows;
    final int columns;
    private int[] columnIndex;
    Chip[][] board;

    Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.columnIndex = new int[columns];
        this.board = new Chip[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                board[row][column] = new NoChip();
            }
        }
    }

    int putChip(Chip chip, int column) {
        board[columnIndex[column]][column] = chip;
        return columnIndex[column]++;
    }
}