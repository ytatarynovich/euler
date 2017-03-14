package tasks.p50;

import java.util.List;
import tasks.p50.p54.Player;
import tasks.p50.p54.Judge;
import utils.EulerUtils;

public class P54 {

    public static void main(String[] args) {
        List<String> data = EulerUtils.getData("poker.txt");
        int wins = 0;
        for(String line : data) {
            Player player1 = new Player(line.substring(0, 15));
            Player player2 = new Player(line.substring(15));
            if(Judge.isWinner(player1, player2)) {
                wins++;
            }
        }
        
        System.out.println("Wins: " + wins);
    }
}





