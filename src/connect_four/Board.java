package connect_four;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
class Board {
    int rowCount;
    int columnCount;

    private List<Chip>[] columnArray;

    Board(int rows, int columns) {
        this.rowCount = rows;
        this.columnCount = columns;
        initBoard();
    }

    private void initBoard() {
        columnArray = new ArrayList[columnCount];
        for (int i = 0; i < columnCount; i++) {
            columnArray[i] = new ArrayList<>();
        }
    }

    List<Chip> getRow(int row) {
        List<Chip> list = new ArrayList<>();
        for (List<Chip> column : columnArray) {
            try{
                list.add(column.get(row));

            }
            catch (Exception err){
                list.add(new NoChip());
            }
        }

        return list;
    }

    void putChip(Chip chip, int column) {
        columnArray[column].add(chip);
    }
}