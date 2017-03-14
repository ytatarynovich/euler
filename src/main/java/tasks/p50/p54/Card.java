package tasks.p50.p54;

public class Card implements Comparable<Card> {
    int value;
    char suit;
    
    public Card(String data) {
        switch(data.charAt(0)) {
            case 'T': value =  10;  break; 
            case 'J': value =  11;  break;  
            case 'Q': value =  12;  break;  
            case 'K': value =  13;  break;  
            case 'A': value =  14;  break;  
            default: value = data.charAt(0) - 48;
        }
        suit = data.charAt(1);
    }

    @Override
    public int compareTo(Card card) {
        return value - card.value;
    }

    public int getValue() {
        return value;
    }

    public char getSuit() {
        return suit;
    }
    
}