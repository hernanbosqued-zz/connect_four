package connect_four;

class Player {
    Chip chip;
    String name;

    Player(String name, Chip chipYellow) {
        this.name = name;
        this.chip = chipYellow;
    }
}
