import java.util.Scanner;

public class Game {
    private Board board;
    private Player[] players;
    private int currentPlayer;
    private Scanner scanner;

    public Game(Player p1, Player p2) {
        board = new Board();
        players = new Player[]{p1, p2};
        currentPlayer = 0;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            board.printBoard();
            Player player = players[currentPlayer];
            System.out.println(player.getName() + " (" + player.getToken().getSymbol() + "), elige una columna (0-6):");

            int column;
            while (true) {
                try {
                    column = Integer.parseInt(scanner.nextLine());
                    if (column >= 0 && column < 7) break;
                } catch (NumberFormatException ignored) {}
                System.out.println("Entrada inválida. Inténtalo de nuevo:");
            }

            if (board.dropToken(column, player.getToken().getSymbol())) {
                if (board.checkWin(player.getToken().getSymbol())) {
                    board.printBoard();
                    System.out.println("¡" + player.getName() + " ha ganado!");
                    break;
                } else if (board.isFull()) {
                    board.printBoard();
                    System.out.println("¡Empate! El tablero está lleno.");
                    break;
                }
                currentPlayer = 1 - currentPlayer;
            } else {
                System.out.println("Columna llena, intenta de nuevo.");
            }
        }
        scanner.close();
    }
}