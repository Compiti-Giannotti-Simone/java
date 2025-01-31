package it.giannotti;

public class TicTacToe {

    // 0 1 2
    // 3 4 5
    // 6 7 8
    private int board[][];
    // 1 = O, 2 = X, 0 = Empty
    private int player;

    private static TicTacToe instance = null;

    public static TicTacToe getInstance() {
        if (instance == null) {
            instance = new TicTacToe();
        }
        return instance;
    }

    public int[][] getBoard() {
        return board;
    }

    private TicTacToe() {
        board = new int[3][3];
    }

    public void reset() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 0;
            }
        }
        player = 1;
    }

    public void playerAction(int played) {
        int row = played / 3;
        int col = played % 3;
        board[row][col] = player;
        player = (player % 2) + 1;
    }

    public int checkWin() {
        // check row/column wins
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] != 0 && board[i][0] == board[i][1] && board[i][1] == board[i][2])
                return board[i][0];
            if (board[0][i] != 0 && board[0][i] == board[1][i] && board[1][i] == board[2][i])
                return board[0][i];
        }
        // check diagonal wins
        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return board[0][0];
        if (board[0][2] != 0 && board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return board[0][2];
        // check if board is full (tie)
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                // 0 = no win, game ongoing
                if (board[i][j] == 0)
                    return 0;
            }
        }
        // no empty spaces or wins found, tied game
        // -1 = tie
        return -1;
    }
}
