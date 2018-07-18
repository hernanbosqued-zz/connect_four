package connect_four;

import java.util.ArrayList;
import java.util.List;

class Board {
    int rowCount;
    int columnCount;
    List<Chip> chips;

    Board(int rows, int columns) {
        this.rowCount = rows;
        this.columnCount = columns;
        chips = new ArrayList<>();
    }

    void putChip(Chip chip, int column) {
        chips.add(chip.inColumn(column));
    }
}