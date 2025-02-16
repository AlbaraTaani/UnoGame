package card;

import enumsAndInterfaces.*;

public abstract class WildCard extends Card {
    protected IColorChooser colorChooser;

    public WildCard(CardType type, IColorChooser colorChooser) {
        super(Color.WILD, type);
        this.colorChooser = colorChooser;
    }

    @Override
    public boolean isPlayableOn(Card topCard) {
        return true;
    }
}
