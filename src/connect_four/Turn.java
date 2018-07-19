package connect_four;

class Turn {
    Player player;
    int column;

    Turn(Player player) {
        this.player = player;
    }

    void move(int column) {
        this.column = column - 1;
    }

    String getName() {
        return player.name;
    }
}
