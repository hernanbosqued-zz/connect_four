package connect_four;

abstract class Chip{

    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_YELLOW = "\u001B[33m";
    static final String ANSI_BLUE = "\u001B[34m";

    public abstract String getShape( );
}
