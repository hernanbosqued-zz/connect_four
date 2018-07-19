package connect_four;

class Game {
    private Board board;
    private Player[] players;
    private int turnIndex;

    Game(Board board, Player... players) {
        this.board = board;
        this.players = players;
    }

    Turn getTurn() {
        return new Turn(nextPlayer());
    }

    private Player nextPlayer() {
        turnIndex = turnIndex % players.length;
        return players[turnIndex++];
    }

    boolean hasWinner() {
        return false;
    }

    void endTurn(Turn turn) {
        board.putChip(turn.player.chip, turn.column);
    }
}
