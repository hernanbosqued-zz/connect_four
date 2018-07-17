package connect_four.board;

import java.util.Stack;

public class Board {
    private int rows;
    private int columns;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    @SuppressWarnings("unchecked")
    public void print() {

        Stack<Chip>[] stacks = new Stack[columns];

        for (int i = 0; i < columns; i++) {
            stacks[i] = new Stack<>();
        }

        stacks[0].push(new Chip());

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

    class Chip {

    }
}