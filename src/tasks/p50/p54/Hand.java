
package tasks.p50.p54;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

enum Hand {
    
    NOTHING {
        @Override
        public int highestCard(Player player) {
            List<Card> cards = player.getCards();
            int highestCard = 0;
            for(Card card : cards) {
                int value = card.getValue();
                if(value > highestCard) {
                    highestCard = value;
                }
            }
            return highestCard;
        }
    },
    
    ONE_PAIR {
         @Override
         public boolean hasHand(Player player) {
            return Utils.hasSameValue(player.getCards(), 2);
        }
         
        @Override
        public int highestCard(Player player) {
            List<Card> cards = player.getCards();
            Collections.sort(cards);
            int highestCard = 0;
            int previousValue = 0;
            for (int i = cards.size() - 1; i > -1; i--) {
                Card card = cards.get(i);
                int value = card.getValue();
                if(previousValue == value) {
                    highestCard = value;
                    break;
                } else {
                    previousValue = value;
                }
            }
            return highestCard;
        }
    },
    
    TWO_PAIRS {
         @Override
         public boolean hasHand(Player player) {
            boolean result = false;
            List<Card> cards = player.getCards();
            if(Utils.hasSameValue(cards, 2)) {
               List<Card> copyOfCards = new ArrayList<>(cards);
               Utils.removePair(copyOfCards);
               if(Utils.hasSameValue(copyOfCards, 2)) {
                   result = true;
               }
            }
            return result;
        }
         
        @Override
        public int highestCard(Player player) {
            return ONE_PAIR.highestCard(player);
        }
    },
    THREE_OF_A_KIND {
         @Override
         public boolean hasHand(Player player) {
            return Utils.hasSameValue(player.getCards(), 3);
        }
         
        @Override
        public int highestCard(Player player) {
            List<Card> cards = player.getCards();
            Collections.sort(cards);
            Card middleCard = cards.get(2);
            return middleCard.getValue();
        }
    },
    
    STRAIGHT {
         @Override
         public boolean hasHand(Player player) {
            return Utils.isConsecutive(player.getCards());
        }
         
        @Override
        public int highestCard(Player player) {
            List<Card> cards = player.getCards();
            Collections.sort(cards);
            return cards.get(4).getValue();
        }
    },
    FLUSH {
         @Override
         public boolean hasHand(Player player) {
            return Utils.hasSameSuit(player.getCards());
        }
         
        @Override
        public int highestCard(Player player) {
            return NOTHING.highestCard(player);
        }
    },
    FULL_HOUSE {
         @Override
         public boolean hasHand(Player player) {
             boolean result = false;
             List<Card> cards = player.getCards();
             if (Utils.hasSameValue(cards, 3)) {
                 List<Card> copyOfCards = new ArrayList<>(cards);
                 Utils.removeThree(copyOfCards);
                 if (Utils.hasSameValue(copyOfCards, 2)) {
                     result = true;
                 }
             }
             return result;
        }
         
        @Override
        public int highestCard(Player player) {
            return THREE_OF_A_KIND.highestCard(player);
        }
    },
    FOUR_OF_A_KIND {
         @Override
         public boolean hasHand(Player player) {
            return Utils.hasSameValue(player.getCards(), 4);
        }
         
        @Override
        public int highestCard(Player player) {
            return ONE_PAIR.highestCard(player);
        }
    },
    STRAIGHT_FLUSH {
         @Override
         public boolean hasHand(Player player) {
            List<Card> cards = player.getCards();
            boolean hasHand = true;
            if(!Utils.hasSameSuit(cards) || !Utils.isConsecutive(cards)) {
                return  false;
            }
            
            return hasHand;
        }
         
        @Override
        public int highestCard(Player player) {
            return STRAIGHT.highestCard(player);
        }
    },
    ROYAL_FLUSH {
         @Override
         public boolean hasHand(Player player) {
            List<Card> cards = player.getCards();
            boolean hasHand = true;
            for(Card card : cards) {
                if(card.value < 10) {
                    return false;
                } 
            }
            
            if(!Utils.hasSameSuit(cards) || !Utils.isConsecutive(cards)) {
                return  false;
            }

            return hasHand;
        }
    };
    
    public boolean hasHand(Player player) {
        return true;
    }
    
    public int highestCard(Player player) {
        return 0;
    }
}

