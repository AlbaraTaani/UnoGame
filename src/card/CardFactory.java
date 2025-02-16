package card;


import enumsAndInterfaces.*;

public class CardFactory {
    private final IColorChooser colorChooser;

    public CardFactory(IColorChooser colorChooser) {
        this.colorChooser = colorChooser;
    }

    public Card createCard(CardType type, Color color) {
        return createCard(type, color, -1);
    }

    public Card createCard(CardType type, Color color, int number) {
        return switch (type) {
            case NUMBER -> new NumberCard(color, number);
            case SKIP -> new SkipCard(color);
            case REVERSE -> new ReverseCard(color);
            case DRAW_TWO -> new DrawTwoCard(color);
            case WILD -> new WildCardStandard(colorChooser);
            case WILD_DRAW_FOUR -> new WildDrawFourCard(colorChooser);
            default -> throw new IllegalArgumentException("Unknown card type");
        };
    }
}
