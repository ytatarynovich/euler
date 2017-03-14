package tasks.p50.p54;

import org.junit.Test;
import static org.junit.Assert.*;

import static tasks.p50.p54.Hand.*;

public class JudgeTest {
    
    private Player player;
    private Player competitor;
    
    @Test
    public void testDetermineNothing() {
        player = new Player("8C TS KC 9H 4S");
        assertEquals(NOTHING, Judge.determineHand(player));
    }
    
    @Test
    public void testDetermineOnePair() {
        player = new Player("8C TS KC 8H 4S");
        assertEquals(ONE_PAIR, Judge.determineHand(player));
    }
    
    @Test
    public void testDetermineTwoPairs() {
        player = new Player("8C 9S 8C 9H 4S");
        assertEquals(TWO_PAIRS, Judge.determineHand(player));
    }
    
    @Test
    public void testDetermineRoyalFlush() {
        player = new Player("AC KC QC JC TC");
        assertEquals(ROYAL_FLUSH, Judge.determineHand(player));
    }
    
    @Test
    public void testIsWinnerRoyalFlushVsNothing() {
        player = new Player("AC KC QC JC TC");
        competitor = new Player("8C TS KC 9H 4S");
        assertTrue(Judge.isWinner(player, competitor));
    }
    
    @Test
    public void testIsWinnerRoyalFlushVsStraightFlush() {
        player = new Player("AC KC QC JC TC");
        competitor = new Player("9C KC QC JC TC");
        assertTrue(Judge.isWinner(player, competitor));
    }
    
    @Test
    public void testIsWinnerNothingVsOnePair() {
        player = new Player("8C TS KC 9H 4S");
        competitor = new Player("9C KD QC JD JC");
        assertFalse(Judge.isWinner(player, competitor));
    }
}
