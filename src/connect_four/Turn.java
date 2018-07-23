package connect_four;

class Turn {
    Player player;
    int row;
    int column;

    Turn(Player player) {
        this.player = player;
    }

    void make(int column) {
        this.column = column - 1;
    }

    String getName() {
        return player.name;
    }
}
