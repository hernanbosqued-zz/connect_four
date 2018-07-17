package connect_four.board;

public class Board {
    private int rows;
    private int columns;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("·");
                System.out.print(" ");
            }
            System.out.print('\n');
//            System.out.print("○");
//            System.out.print("●");
        }
    }
}