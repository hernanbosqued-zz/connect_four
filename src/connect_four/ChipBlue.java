package connect_four;

public class ChipBlue extends Chip {

    @Override
    public String getShape() {
        return Chip.ANSI_BLUE + "●" + Chip.ANSI_RESET;
    }
}
