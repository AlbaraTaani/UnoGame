package game;

public class GameDriver {
    public static void main(String[] args) {
        Game game = GameFactory.createSimpleUnoGame();
        game.play();
    }
}







