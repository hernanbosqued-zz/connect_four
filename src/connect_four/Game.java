package connect_four;

class Game {
    private Board board;
    private Player[] players;
    private int turnIndex;

    private Player currentPlayer;

    Game(Board board, Player... players) {
        this.board = board;
        this.players = players;
        currentPlayer = players[0];
    }

    Turn getTurn() {
        return new Turn(currentPlayer);
    }

    private Player nextPlayer() {
        turnIndex = ++turnIndex % players.length;
        return players[turnIndex];
    }

    boolean hasWinner() {
        return false;
    }

    void move(Turn turn) {
        turn.row = board.putChip(turn.player.chip, turn.column);
    }

    void checkForWinner(Turn turn, Board board) {

    }

    void nextTurn() {
        currentPlayer = nextPlayer();
    }
}
