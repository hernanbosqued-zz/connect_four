package connect_four;

public class NoChip extends Chip {

    @Override
    public String getShape() {
        return "○";
    }

    @Override
    public boolean visit(Visitor visitor) {
        return visitor.accept(this);
    }
}
