package connect_four;


interface Visitor {
    boolean accept(ChipYellow chip);
    boolean accept(ChipBlue chip);
    boolean accept(Chip chip);
}
