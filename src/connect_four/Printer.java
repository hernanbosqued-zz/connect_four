package connect_four;

import java.util.List;

class Printer{

    private Board board;

    Printer(Board board){
        this.board = board;
    }

    void print(){
        for( int i=board.rowCount-1; i >= 0; i --){
            printRow(board.getRow(i));
        }
    }

    private void printRow(List<Chip> items) {
        for(Chip item : items) {
            System.out.print(item.getShape() + " ");
        }
        System.out.print('\n');
    }
}
