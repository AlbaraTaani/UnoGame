package game;

import UI.*;
import card.CardFactory;
import enumsAndInterfaces.*;
import coreGameComponents.*;
import scoring.*;

import java.util.Random;

public class GameFactory {
    public static Game createStandardUnoGame() {
        Random random = new Random();
        IColorChooser colorChooser = new ColorChooser(random);
        CardFactory cardFactory = new CardFactory(colorChooser);
        DeckFactory deckFactory = new StandardDeckFactory(cardFactory);
        Deck deck = new StandardUnoDeck(deckFactory);
        GameInput input = new GameInput();
        GameOutput output = new GameOutput();
        Scoreboard scoreboard = new Scoreboard(new ClassicScoringStrategy(), 500, output);
        return new StandardUnoGame(input, output, deck, scoreboard);
    }

    public static Game createSimpleUnoGame() {
        Random random = new Random();
        IColorChooser colorChooser = new ColorChooser(random);
        CardFactory cardFactory = new CardFactory(colorChooser);
        DeckFactory deckFactory = new SimpleDeckFactory(cardFactory);

        Deck deck = new StandardUnoDeck(deckFactory);
        GameInput input = new GameInput();
        GameOutput output = new GameOutput();
        Scoreboard scoreboard = new Scoreboard(new ClassicScoringStrategy(), 500, output);
        return new SimpleUnoGame(input, output, deck, scoreboard);
    }
}
