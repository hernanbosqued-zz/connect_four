package connect_four;

class Game {
    private Board board;
    private Player[] players;
    private int turnIndex;
    private Player currentPlayer;
    private static int WIN_CONDITION = 3;
    private boolean repeatFlag;

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
        int countRow = checkRow(turn, board);
        int countColumn = checkColumn(turn, board);
        int countLtoR = checkLeftToRightDiagonal(turn, board);
        int countRtoL = checkRightToLeftDiagonal(turn, board);
        if( countRow == WIN_CONDITION || countColumn == WIN_CONDITION || countLtoR == WIN_CONDITION || countRtoL == WIN_CONDITION){
            return true;
        }
        else return false;
    }

    private int checkLeftToRightDiagonal(Turn turn, Board board) {
        int count = 0;
        for (int indexRow = turn.row - 1, indexColumn = turn.column - 1; indexRow >= 0 && indexColumn >= 0; indexRow--, indexColumn--) {
            if (board.board[indexRow][indexColumn].getClass() == turn.player.chip.getClass()) {
                count++;
            } else break;
        }

        for (int indexRow = turn.row + 1, indexColumn = turn.column + 1; indexRow < board.rows && indexColumn < board.columns; indexRow++, indexColumn++) {
            if (board.board[indexRow][indexColumn].getClass() == turn.player.chip.getClass()) {
                count++;
            } else break;
        }

        return count;
    }

    private int checkRightToLeftDiagonal(Turn turn, Board board) {
        int count = 0;
        for (int indexRow = turn.row - 1, indexColumn = turn.column + 1; indexRow >= 0 && indexColumn < board.columns; indexRow--, indexColumn++) {
            if (board.board[indexRow][indexColumn].getClass() == turn.player.chip.getClass()) {
                count++;
            } else break;
        }

        for (int indexRow = turn.row + 1, indexColumn = turn.column - 1; indexRow < board.rows && indexColumn >= 0; indexRow++, indexColumn--) {
            if (board.board[indexRow][indexColumn].getClass() == turn.player.chip.getClass()) {
                count++;
            } else break;
        }

        return count;
    }

    private int checkRow(Turn turn, Board board) {
        int count = 0;
        for (int index = turn.column - 1; index >= 0; index--) {
            if (board.board[turn.row][index].getClass() == turn.player.chip.getClass()) {
                count++;
            } else break;
        }

        for (int index = turn.column + 1; index < board.columns; index++) {
            if (board.board[turn.row][index].getClass() == turn.player.chip.getClass()) {
                count++;
            } else break;
        }

        return count;
    }

    private int checkColumn(Turn turn, Board board) {
        int count = 0;
        for (int index = turn.row - 1; index >= 0; index--) {
            if (board.board[index][turn.column].getClass() == turn.player.chip.getClass()) {
                count++;
            } else break;
        }

        for (int index = turn.row + 1; index < board.rows; index++) {
            if (board.board[index][turn.column].getClass() == turn.player.chip.getClass()) {
                count++;
            } else break;
        }

        return count;
    }

    void nextTurn() {
        if (repeatFlag) {
            repeatFlag = false;
        }else{
            currentPlayer = nextPlayer();
        }
    }

    void repeatTurn() {
        repeatFlag = true;
    }
}
