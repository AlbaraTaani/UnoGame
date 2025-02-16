package enumsAndInterfaces;


import java.util.Random;

public class ColorChooser implements IColorChooser {
    private final Random random;

    public ColorChooser(Random random) {
        this.random = random;
    }

    @Override
    public Color chooseRandomColor() {
        Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
        return colors[random.nextInt(colors.length)];
    }
}
