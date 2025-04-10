public class Player {
    private final String name;
    private final Token token;

    public Player(String name, String symbol) {
        this.name = name;
        this.token = new Token(symbol);
    }

    public String getName() {
        return name;
    }

    public Token getToken() {
        return token;
    }
}
