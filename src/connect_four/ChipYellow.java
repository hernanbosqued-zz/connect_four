package connect_four;

public class ChipYellow extends Chip {

    @Override
    public String getShape() {
        return Chip.ANSI_YELLOW + "●" + Chip.ANSI_RESET;
    }
}
