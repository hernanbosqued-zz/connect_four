package connect_four;

abstract class Chip {

    int column;

    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_YELLOW = "\u001B[33m";
    static final String ANSI_BLUE = "\u001B[34m";

    public abstract String getShape();

    Chip inColumn(int column) {
        this.column = column;
        return this;
    }
}
