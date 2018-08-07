package connect_four;

public class ChipYellow extends Chip implements Visitor {

    @Override
    public String getShape() {
        return Chip.ANSI_YELLOW + "●" + Chip.ANSI_RESET;
    }

    @Override
    public boolean visit(Visitor visitor) {
        return visitor.accept(this);
    }

    @Override
    public boolean accept(ChipYellow chip) {
        return true;
    }
}
