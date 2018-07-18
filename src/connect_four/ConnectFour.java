package connect_four;

public class ConnectFour {

    public static void main(String[] args) {
        Board board = new Board(6,7);

        board.putChip(new ChipYellow(),1);
        board.putChip(new ChipYellow(),1);
        board.putChip(new ChipBlue(),2);
        board.putChip(new ChipBlue(),2);
        board.putChip(new ChipBlue(),1);
        board.putChip(new ChipYellow(),1);
        board.putChip(new ChipYellow(),1);
        board.putChip(new ChipYellow(),2);
        board.putChip(new ChipYellow(),6);

        Printer printer = new Printer(board);
        printer.print();
    }
}