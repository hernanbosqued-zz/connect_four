package connect_four;

public class ChipBlue extends Chip implements Visitor {

    @Override
    public String getShape() {
        return Chip.ANSI_BLUE + "●" + Chip.ANSI_RESET;
    }

    @Override
    public boolean visit(Visitor visitor) {
        return visitor.accept(this);
    }

    @Override
    public boolean accept(ChipBlue chip) {
        return true;
    }
}