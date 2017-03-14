package tasks.p90;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import utils.EulerUtils;

public class P99 {
    public static void main(String[] args) {
        List<String> data = EulerUtils.getData("base_exp.txt");
        List<Case> cases = new ArrayList<>();
        for(int i = 0; i < data.size(); i++) {
            String line = data.get(i);
            String[] parts = line.split(",");
            cases.add(new Case(parts[0], parts[1], i));
        }
        
        Collections.sort(cases);
        System.out.println(cases.get(cases.size() - 1).getLine());
    }
}

class Case implements Comparable<Case> {
    long number;
    long degree;
    int line;
    public Case(String number, String degree, int line) {
        this.number = Long.parseLong(number);
        this.degree = Long.parseLong(degree);
        this.line = line;
    }

    @Override
    public int compareTo(Case otherCase) {
        if(number > otherCase.number && degree > otherCase.degree) {
            return 1;
        } else {
            
            return -1;
        }
    }
    
    public int getLine() {
        return line;
    }
}
