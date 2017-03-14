package tasks.p50.p54;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Card> cards = new ArrayList<>();

    public Player(String line) {
        String[] data = line.split(" ");
        for(String card : data) {
            cards.add(new Card(card));
        }
    }

    public List<Card> getCards() {
        return cards;
    }
}
