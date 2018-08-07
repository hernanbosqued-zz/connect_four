package connect_four;

import static connect_four.Game.CHECK.*;

class Game {
    private Board board;
    private Player[] players;
    private int turnIndex;
    private Player currentPlayer;
    private static int WIN_CONDITION = 3;
    private boolean repeatTurn;

    enum DIRECTION {
        FORWARD(1),
        BACKWARD(-1);

        private int direction;

        DIRECTION(int direction) {
            this.direction = direction;
        }
    }

    enum CHECK {
        HORIZONAL(0, 1),
        VERTICAL(1, 0),
        LTORDIAG(1, 1),
        RTOLDIAG(1, -1);

        public int x;
        public int y;

        CHECK(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

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


    void move(Turn turn) {
        turn.row = board.putChip(turn.player.chip, turn.column);
    }

    boolean hasWinner(Turn turn, Board board) {

        int countRow = check(HORIZONAL, turn, board);
        int countColumn = check(VERTICAL, turn, board);
        int countLtoR = check(LTORDIAG, turn, board);
        int countRtoL = check(RTOLDIAG, turn, board);

        return countRow >= WIN_CONDITION || countColumn >= WIN_CONDITION || countLtoR >= WIN_CONDITION || countRtoL >= WIN_CONDITION;
    }

    private int check(DIRECTION direction, CHECK checkOptions, Turn turn, Board board) {
        int count = 0;

        for (int indexRow = turn.row + direction.direction * checkOptions.x, indexColumn = turn.column + direction.direction * checkOptions.y;
                    indexRow >= 0 &&
                    indexRow < board.rows &&
                    indexColumn >= 0 &&
                    indexColumn < board.columns &&
                    board.board[indexRow][indexColumn].visit(turn.player.chip);
             indexRow = indexRow + direction.direction * checkOptions.x, indexColumn = indexColumn + direction.direction * checkOptions.y) {

            count++;
        }
        return count;
    }

    private int check(CHECK checkOptions, Turn turn, Board board) {
        int count = check(DIRECTION.FORWARD, checkOptions, turn, board);
        count += check(DIRECTION.BACKWARD, checkOptions, turn, board);
        return count;
    }


    void nextTurn() {
        if (repeatTurn) {
            repeatTurn = false;
        } else {
            currentPlayer = nextPlayer();
        }
    }

    void repeatTurn() {
        repeatTurn = true;
    }
}
