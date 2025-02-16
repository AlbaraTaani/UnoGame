package playerManagement;


import java.util.*;

public class PlayerManager {
    private List<Player> players;
    private Iterator<Player> iterator;

    public PlayerManager(List<Player> players) {
        this.players = new ArrayList<>(players);
        this.iterator = new PlayerManager.CyclicIterator<>(this.players);
    }

    public Player getNextPlayer() {
        return iterator.next();
    }

    public void skipPlayer() {
        if (iterator.hasNext()) {
            iterator.next();
        }
    }

    public void reverseOrder() {
        Collections.reverse(players);
        iterator = new PlayerManager.CyclicIterator<>(players);
    }

    public List<Player> getAllPlayers() {
        return Collections.unmodifiableList(players);
    }

    private static class CyclicIterator<T> implements Iterator<T> {
        private List<T> items;
        private int currentIndex = -1;

        public CyclicIterator(List<T> items) {
            this.items = items;
        }

        @Override
        public boolean hasNext() {
            return !items.isEmpty();
        }

        @Override
        public T next() {
            if (items.isEmpty()) throw new NoSuchElementException("No players available.");
            currentIndex = (currentIndex + 1) % items.size();
            return items.get(currentIndex);
        }
    }
}
