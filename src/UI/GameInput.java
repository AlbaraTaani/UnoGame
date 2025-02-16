package UI;

import card.Card;
import enumsAndInterfaces.Color;
import card.NumberCard;
import playerManagement.*;

import java.util.*;

public class GameInput {
    private final Scanner scanner = new Scanner(System.in);

    public int readPlayerCount() {
        System.out.print("Enter number of players (2-10): ");
        return Integer.parseInt(scanner.nextLine());
    }

    public PlayerCreationData readPlayerDetails(int playerNumber) {
        System.out.print("Enter name for player " + playerNumber + ": ");
        String name = scanner.nextLine().trim();
        return new PlayerCreationData("human", name);
    }

    public Card readCardSelection(Player player) {
        System.out.println("Select a card to play or choose to draw:");
        List<Card> hand = player.getHand();
        for (int i = 0; i < hand.size(); i++) {
            System.out.println((i + 1) + ": " + describeCard(hand.get(i)));
        }
        System.out.println((hand.size() + 1) + ": Draw card");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == hand.size() + 1) return null;
        return hand.get(choice - 1);
    }

    public Color readForColor() {
        System.out.println("Choose a color: 1 - RED, 2 - BLUE, 3 - GREEN, 4 - YELLOW");
        int choice = Integer.parseInt(scanner.nextLine());
        return switch (choice) {
            case 1 -> Color.RED;
            case 2 -> Color.BLUE;
            case 3 -> Color.GREEN;
            case 4 -> Color.YELLOW;
            default -> Color.RED;
        };
    }

    private String describeCard(Card card) {
        if (card instanceof NumberCard) {
            return card.getColor() + " " + ((NumberCard) card).getNumber();
        } else {
            return card.getColor() + " " + card.getType();
        }
    }
}
