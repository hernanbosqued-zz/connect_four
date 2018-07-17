package connect_four;

import connect_four.board.Board;

public class ConnectFour {

    public static void main(String[] args) {
        Board board = new Board(7,7);
        board.print();
    }
}