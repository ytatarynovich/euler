package tasks.p50.p54;

import static tasks.p50.p54.Hand.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class HandTest {
    
    private Player player;
    
    @Test
    public void testOnePairTrue() {
        player = new Player("8C TS KC 8H 4S");
        assertTrue(ONE_PAIR.hasHand(player));
    }
    
    @Test
    public void testOnePairFalse() {
        player = new Player("8C TS KC 9H 4S");
        assertFalse(ONE_PAIR.hasHand(player));
    }
    
    @Test
    public void testTwoPairsTrue() {
        player = new Player("8C TS KC 8H KS");
        assertTrue(TWO_PAIRS.hasHand(player));
    }
    
    @Test
    public void testTwoPairsFalse() {
        player = new Player("8C 8D KC 9H 8S");
        assertFalse(TWO_PAIRS.hasHand(player));
    }
    
    @Test
    public void testThreeOfKindTrue1() {
        player = new Player("KC TS KC 8H KS");
        assertTrue(THREE_OF_A_KIND.hasHand(player));
    }
    
    @Test
    public void testThreeOfKindTrue2() {
        player = new Player("KC TS KC KH KS");
        assertTrue(THREE_OF_A_KIND.hasHand(player));
    }
    
    @Test
    public void testThreeOfKindFalse() {
        player = new Player("KC 8D KC 8H QS");
        assertFalse(THREE_OF_A_KIND.hasHand(player));
    }
    
    @Test
    public void testStraightTrue() {
        player = new Player("KC AS QC JH TS");
        assertTrue(STRAIGHT.hasHand(player));
    }
    
    @Test
    public void testStraightTrue2() {
        player = new Player("7H 8C 9S TC JH");
        assertTrue(STRAIGHT.hasHand(player));
    }
    
    @Test
    public void testStraightFalse() {
        player = new Player("2C 5S 4C 3H 7S");
        assertFalse(STRAIGHT.hasHand(player));
    }
    
    @Test
    public void testFlushTrue() {
        player = new Player("KC AC QC 2C TC");
        assertTrue(FLUSH.hasHand(player));
    }
    
    @Test
    public void testFlushFalse() {
        player = new Player("KC AS QC JC TC");
        assertFalse(FLUSH.hasHand(player));
    }
    
    @Test
    public void testFullHouseTrue() {
        player = new Player("TH TC JH JC TD");
        assertTrue(FULL_HOUSE.hasHand(player));
    }
    
    @Test
    public void testFullHouseFalse() {
        player = new Player("TH TC TR JC TD");
        assertFalse(FULL_HOUSE.hasHand(player));
    }
    
    @Test
    public void testFourOfKindTrue() {
        player = new Player("KC TS KC KH KS");
        assertTrue(FOUR_OF_A_KIND.hasHand(player));
    }
    
    @Test
    public void testFourOfKindFalse() {
        player = new Player("KC 8D KC KH QS");
        assertFalse(FOUR_OF_A_KIND.hasHand(player));
    }
    
    @Test
    public void testStraightFlushTrue() {
        player = new Player("2C 4C 6C 5C 3C");
        assertTrue(STRAIGHT_FLUSH.hasHand(player));
    }
    
    @Test
    public void testStraightFlushFalse1() {
        player = new Player("2C 4C 6C 7C 3C");
        assertFalse(STRAIGHT_FLUSH.hasHand(player));
    }
    
    @Test
    public void testStraightFlushFalse2() {
        player = new Player("2C 4C 6C 5D 3C");
        assertFalse(STRAIGHT_FLUSH.hasHand(player));
    }
    
    @Test
    public void testRoyalFlushTrue() {
        player = new Player("AC TC KC QC JC");
        assertTrue(ROYAL_FLUSH.hasHand(player));
    }
    
    @Test
    public void testRoyalFlushFalse1() {
        player = new Player("AC TC 9C QC JC");
        assertFalse(ROYAL_FLUSH.hasHand(player));
    }
    
    @Test
    public void testRoyalFlushFalse2() {
        player = new Player("AC TC KD QC JC");
        assertFalse(ROYAL_FLUSH.hasHand(player));
    }
    
    @Test
    public void testNothingHighestCard() {
        player = new Player("8C TS KC 7H 4S");
        assertTrue(NOTHING.hasHand(player));
        assertEquals(13, NOTHING.highestCard(player));
    }
    
    @Test
    public void testOnePairHighestCard() {
        player = new Player("8C TS JC 8H 4S");
        assertTrue(ONE_PAIR.hasHand(player));
        assertEquals(11, NOTHING.highestCard(player));
    }
    
    @Test
    public void testTwoPairsHighestCard() {
        player = new Player("8C 8C AC AH 4S");
        assertTrue(TWO_PAIRS.hasHand(player));
        assertEquals(14, TWO_PAIRS.highestCard(player));
    }
    
    @Test
    public void testThreeOfKindHighestCard() {
        player = new Player("8C 8S KC 8H 4S");
        assertTrue(THREE_OF_A_KIND.hasHand(player));
        assertEquals(8, THREE_OF_A_KIND.highestCard(player));
    }
    
    
    @Test
    public void testStraightHighestCard() {
        player = new Player("QC 9S TC JH 8S");
        assertTrue(STRAIGHT.hasHand(player));
        assertEquals(12, STRAIGHT.highestCard(player));
    }
    
    @Test
    public void testFlushHighestCard() {
        player = new Player("8C TC KC 7C 4C");
        assertTrue(FLUSH.hasHand(player));
        assertEquals(13, FLUSH.highestCard(player));
    }
    
    @Test
    public void testFullHouseHighestCard() {
        player = new Player("8C 8S 8C JH JS");
        assertTrue(FULL_HOUSE.hasHand(player));
        assertEquals(8, FULL_HOUSE.highestCard(player));
    }
    
    @Test
    public void testFourOfKindHighestCard() {
        player = new Player("8C 8S 8C TH 8S");
        assertTrue(FOUR_OF_A_KIND.hasHand(player));
        assertEquals(8, FOUR_OF_A_KIND.highestCard(player));
    }
    
    @Test
    public void testStraightFlushHighestCard() {
        player = new Player("QC 9C TC JC 8C");
        assertTrue(STRAIGHT_FLUSH.hasHand(player));
        assertEquals(12, STRAIGHT_FLUSH.highestCard(player));
    }
}
