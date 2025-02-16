package playerManagement;

import UI.GameInput;

public class PlayerFactory {
    public static Player createPlayer(PlayerCreationData data, GameInput input) {
        return new HumanPlayer(data.playerName(), input);
    }
}
