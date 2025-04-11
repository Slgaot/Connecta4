public class Board {
    private final int ROWS = 6;
    private final int COLUMNS = 7;
    private String[][] grid; // Cambiado a String para admitir emojis

    public Board() {
        grid = new String[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                grid[i][j] = "⬜"; // Inicializa con casillas vacías
            }
        }
    }

    public boolean dropToken(int column, String symbol) {
        if (column < 0 || column >= COLUMNS || !grid[0][column].equals("⬜")) {
            return false;
        }
        for (int i = ROWS - 1; i >= 0; i--) {
            if (grid[i][column].equals("⬜")) {
                grid[i][column] = symbol;
                return true;
            }
        }
        return false;
    }

    public boolean checkWin(String symbol) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (checkDirection(i, j, 1, 0, symbol) || // Horizontal
                        checkDirection(i, j, 0, 1, symbol) || // Vertical
                        checkDirection(i, j, 1, 1, symbol) || // Diagonal ↘
                        checkDirection(i, j, 1, -1, symbol)) { // Diagonal ↙
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDirection(int row, int col, int dRow, int dCol, String symbol) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int r = row + i * dRow;
            int c = col + i * dCol;
            if (r >= 0 && r < ROWS && c >= 0 && c < COLUMNS && grid[r][c].equals(symbol)) {
                count++;
            } else {
                break;
            }
        }
        return count == 4;
    }

    public boolean isFull() {
        for (int j = 0; j < COLUMNS; j++) {
            if (grid[0][j].equals("⬜")) {
                return false;
            }
        }
        return true;
    }

    public void printBoard() {
        System.out.println("\n  0   1   2   3   4   5   6 ");

        for (String[] row : grid) {
            for (String cell : row) {
                System.out.print(" " + cell + " ");
            }
            System.out.println();
        }

        System.out.println("  0   1   2   3   4   5   6 ");
    }
}