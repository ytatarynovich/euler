package tasks.p50.p54;

import java.util.Arrays;
import java.util.List;
import static tasks.p50.p54.Hand.*;
import tasks.p50.p54.Utils;

public class Judge {
    
    public static Hand determineHand(Player player) {
        Hand result = NOTHING;
        Hand[] hands = Hand.values();
        for (int i = hands.length - 1; i > -1; i--) {
            Hand hand = hands[i];
            if(hand.hasHand(player)) {
                result = hand;
                break;
            }
        }
        return result;
    }
    
    public static boolean isWinner(Player player1, Player player2) {
        boolean result = false;
        Hand hand1 = determineHand(player1);
        Hand hand2 = determineHand(player2);
        if(hand1.compareTo(hand2) > 0) {
            result = true;
        } else if(hand1.compareTo(hand2) == 0) {
            int diff = 0;
            List<Hand> hands = Arrays.asList(NOTHING, STRAIGHT,
                                             FLUSH, FULL_HOUSE,
                                             FOUR_OF_A_KIND, STRAIGHT_FLUSH);
            
            diff = comparePlayers(player1, player2, hand1);
            
            if(diff == 0) {
                if(hands.contains(hand1)) {
                        diff = comparePlayers(player1, player2, hand1);
                } else {
                    if(hand1 == ONE_PAIR) {
                        Utils.removePair(player1.getCards());
                        Utils.removePair(player2.getCards());
                        diff = comparePlayers(player1, player2, NOTHING);
                    } else if(hand1 == TWO_PAIRS) {
                        Utils.removePair(player1.getCards());
                    } else if(hand1 == THREE_OF_A_KIND) {
                        Utils.removeThree(player1.getCards());
                        Utils.removeThree(player2.getCards());
                        diff = comparePlayers(player1, player2, NOTHING);
                    }
                }
            } else if (diff > 0) {
                result = true;
            }
        }
        
        return result;
        
        
    }
    
    private static int comparePlayers(Player player1, Player player2, Hand hand) {
        int value1 = hand.highestCard(player1);
        int value2 = hand.highestCard(player2);
        return value1 - value2;
    }
}