package tasks.p50.p54;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utils {

    public static boolean hasSameSuit(List<Card> cards) {
        Card firstCard = cards.get(0);
        char suit = firstCard.getSuit();
        boolean result = true;
        for (Card card : cards) {
            if (card.getSuit() != suit) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean isConsecutive(List<Card> cards) {
        Collections.sort(cards);
        Card firstCard = cards.get(0);
        int previousValue = firstCard.value;
        boolean result = true;
        for (Card card : cards) {
            if (card.getValue() != previousValue++) {
                result = false;
                break;
            }
        }

        return result;
    }

    public static boolean hasSameValue(List<Card> cards, int count) {
        Collections.sort(cards);
        int currentCount = 0;
        int maxSameCount = 0;
        Card firstCard = cards.get(0);
        int previousValue = firstCard.getValue();
        for (Card card : cards) {
            if (card.getValue() == previousValue) {
                currentCount++;
            } else {
                if (currentCount > maxSameCount) {
                    maxSameCount = currentCount;
                }
                currentCount = 1;
                previousValue = card.getValue();
            }
        }
        
        if (currentCount > maxSameCount) {
            maxSameCount = currentCount;
        }
        
        return count <= maxSameCount;
    }

    public static void removePair(List<Card> cards) {
        Collections.sort(cards);
        List<Card> listToRemove = new ArrayList<>();
        int previousValue = -1;
        Card previousItem = null;
        for (Card card : cards) {
            if (card.getValue() == previousValue) {
                listToRemove.add(card);
                listToRemove.add(previousItem);
                break;
            } else {
                previousValue = card.getValue();
                previousItem = card;
            }
        }

        cards.removeAll(listToRemove);
    }

    public static void removeThree(List<Card> cards) {
        Collections.sort(cards);
        List<Card> listToRemove = new ArrayList<>();
        Card first = cards.get(0);
        Card middle = cards.get(2);
        if (first.compareTo(middle) != 0) {
            listToRemove.addAll(cards.subList(2, 5));
        } else {
            listToRemove.addAll(cards.subList(0, 3));
        }

        cards.removeAll(listToRemove);
    }
}
