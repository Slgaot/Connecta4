import java.util.Scanner;

public class Connecta4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nombre del Jugador 1: ");
        String name1 = scanner.nextLine();
        System.out.print("Nombre del Jugador 2: ");
        String name2 = scanner.nextLine();

        Player p1 = new Player(name1, "\uD83D\uDD34");
        Player p2 = new Player(name2, "\uD83D\uDD35");

        Game game = new Game(p1, p2);
        game.start();

        scanner.close();
    }
}