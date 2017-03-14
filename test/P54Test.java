import org.junit.Test;
import static org.junit.Assert.*;
import tasks.p50.p54.Card;

public class P54Test {
    
    //Card
    @Test
    public void testCard1() {
        Card card = new Card("5H");
        assertEquals(5, card.getValue());
        assertEquals('H', card.getSuit());
    }
    
    @Test
    public void testCard2() {
        Card card = new Card("QS");
        assertEquals(12, card.getValue());
        assertEquals('S', card.getSuit());
    }
    
    @Test
    public void testCompareCards1() {
        Card card1 = new Card("5H");
        Card card2 = new Card("6H");
        assertTrue(card1.compareTo(card2) < 0);
    }
    
    @Test
    public void testCompareCards2() {
        Card card1 = new Card("QH");
        Card card2 = new Card("6H");
        assertTrue(card1.compareTo(card2) > 0);
    }
}
