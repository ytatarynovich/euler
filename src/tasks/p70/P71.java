package tasks.p70;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import utils.EulerUtils;

public class P71 {
    public static void main(String[] args) {
        
        IntStream.rangeClosed(1, 1_000_000).flatMap(a ->
        IntStream.rangeClosed(1, a).mapToObj(t -> (double) t / a));
    }
        
//        Set<Fraction> set = new HashSet<>();
//        for (int i = 1; i < 1_000_000; i++) {
//            System.out.println(i);
//            for (int j = 1_000_000; j >= i + 1; j--) {
//                if(i / j > 0.5) {
//                    break;
//                }
//                System.out.println("i:" + i + "; j:" + j);
//                int denom = (int) EulerUtils.getMaxDenominator(i, j);
//                Fraction f = new Fraction(i / denom, j / denom);
//                set.add(f);
//            }
//        }
//        
//        List<Fraction> list = new ArrayList<>(set);
//        Collections.sort(list, new FractionComparator());
//        int index = Collections.binarySearch(list, new Fraction(3, 7), new FractionComparator());
//        System.out.println(list);
//        System.out.println(index);
//        System.out.println(list.get(index - 1));
    }
}


class Fraction {
    public int num;
    public int den;

    public Fraction(int num, int den) {
        this.num = num;
        this.den = den;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        
        boolean result = false;
        if(obj instanceof Fraction) {
            Fraction other = (Fraction) obj;
            if(num == other.num && den == other.den) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.num;
        hash = 37 * hash + this.den;
        return hash;
    }

    @Override
    public String toString() {
        return num + "/" + den;
    }
    
}


class FractionComparator implements Comparator<Fraction>{

    @Override
    public int compare(Fraction o1, Fraction o2) {
        double num1 =  o1.num / (double)o1.den;
        double num2 =  o2.num / (double)o2.den;
        int result = 0;
        if(num1 > num2) {
            result = 1;
        } else if(num2 > num1) {
            result = -1;
        }
        return result;
    }

}
