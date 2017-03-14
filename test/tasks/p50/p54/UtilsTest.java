package tasks.p50.p54;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class UtilsTest {
    
    private List<Card> cards;
    
    @Before
    public void setUp() {
        cards = new ArrayList<>();
    }
    
    @Test
    public void testHasSameSuit() {
        cards.add(new Card("5H"));
        cards.add(new Card("6H"));
        cards.add(new Card("TH"));
        assertTrue(Utils.hasSameSuit(cards));
    }
    
    @Test
    public void testHasNotSameSuit() {
        cards.add(new Card("5H"));
        cards.add(new Card("6S"));
        cards.add(new Card("TH"));
        assertFalse(Utils.hasSameSuit(cards));
    }
    
    @Test
    public void testIsConsecutive() {
        cards.add(new Card("5H"));
        cards.add(new Card("6H"));
        cards.add(new Card("7H"));
        assertTrue(Utils.isConsecutive(cards));
    }
    
    @Test
    public void testIsNotConsecutive() {
        cards.add(new Card("5H"));
        cards.add(new Card("6H"));
        cards.add(new Card("8H"));
        assertFalse(Utils.isConsecutive(cards));
    }
    
    @Test
    public void testHasSameValuePair() {
        cards.add(new Card("5H"));
        cards.add(new Card("8S"));
        cards.add(new Card("9S"));
        cards.add(new Card("8H"));
        assertTrue(Utils.hasSameValue(cards, 2));
    }
        
    @Test
    public void testHasSameValueThree() {
        cards.add(new Card("5H"));
        cards.add(new Card("8S"));
        cards.add(new Card("9S"));
        cards.add(new Card("8H"));
        cards.add(new Card("8G"));
        assertTrue(Utils.hasSameValue(cards, 3));
    }
    
    @Test
    public void testRemovePair() {
        cards.add(new Card("5H"));
        cards.add(new Card("8S"));
        cards.add(new Card("9S"));
        cards.add(new Card("8H"));
        
        Utils.removePair(cards);
        
        assertEquals(2, cards.size());
        assertEquals(5, cards.get(0).getValue());
        assertEquals('H', cards.get(0).getSuit());
        assertEquals(9, cards.get(1).getValue());
        assertEquals('S', cards.get(1).getSuit());
    }
    
    
    @Test
    public void testRemoveThree1() {
        cards.add(new Card("5H"));
        cards.add(new Card("8S"));
        cards.add(new Card("5S"));
        cards.add(new Card("8H"));
        cards.add(new Card("8G"));
        
        Utils.removeThree(cards);
        
        assertEquals(2, cards.size());
        assertEquals(5, cards.get(0).getValue());
        assertEquals('H', cards.get(0).getSuit());
        assertEquals(5, cards.get(1).getValue());
        assertEquals('S', cards.get(1).getSuit());
    }
    
    @Test
    public void testRemoveThree2() {
        cards.add(new Card("5H"));
        cards.add(new Card("8S"));
        cards.add(new Card("5S"));
        cards.add(new Card("8H"));
        cards.add(new Card("5G"));
        
        Utils.removeThree(cards);
        
        assertEquals(2, cards.size());
        assertEquals(8, cards.get(0).getValue());
        assertEquals('S', cards.get(0).getSuit());
        assertEquals(8, cards.get(1).getValue());
        assertEquals('H', cards.get(1).getSuit());
    }
}
