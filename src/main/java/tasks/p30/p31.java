package tasks.p30;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

//In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
//1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
//It is possible to make £2 in the following way:
//1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
//How many different ways can £2 be made using any number of coins?

enum Coin {

    C1(1, new ArrayList<>()),
    C2(2, Arrays.asList(C1, C1)),
    C5(5, Arrays.asList(C2, C2, C1)),
    C10(10, Arrays.asList(C5, C5)),
    C20(20, Arrays.asList(C10, C10)),
    C50(50, Arrays.asList(C20, C20, C10)),
    C100(100, Arrays.asList(C50, C50)),
    C200(200, Arrays.asList(C100, C100));

    private int value;
    private List<Coin> sum;

    Coin(int value, List<Coin> sum) {
        this.value = value;
        this.sum = sum;
    }

    public int getValue() {
        return value;
    }

    public List<Coin> getSum() {
        return sum;
    }
}

public class p31 {

    final static List<Integer> money = new ArrayList<>();

    public static void main(String[] args) {

        List<List<Coin>> result = new ArrayList<>();
        Coin c = Coin.C10;
        for(int i = 0; i < c.getSum().size(); i++) {
            Coin current = c.getSum().get(i);
            List<Coin> row = new ArrayList<>();
            row.add(current);

        }



//        money.addAll(Arrays.asList(1, 2, 5, 10, 20, 100, 200));
//
//        Leaf target = new Leaf(5);
//        target.split();
//
//        List<Object> result = new ArrayList<>();
//        List<Leaf> alt = target.getAlt();
//        for(int i = 0; i < alt.size(); i++) {
//            Leaf currentAlt = alt.get(i).split();
//            for(Leaf z : currentAlt.getAll()) {
//                List<Object> l = new ArrayList<>();
//                result.add(l);
//                l.add(z);
//                for(int j = 0; j < alt.size(); j++) {
//                    if(i != j) {
//                        l.add(alt.get(j));
//                    }
//                }
//            }
//        }

//        System.out.println(result);
    }
//
//    private static void process(int x) {
//        Leaf leaf = new Leaf(x);
//
//    }
}

//class Multi {
//
//    private List<Leaf> multi;
//
//    public Multi() {
//        multi = new ArrayList<>();
//    }
//
//    void addMulti(Leaf l) {
//        multi.add(l);
//    }
//
//    public List<Leaf> getMulti() {
//        return multi;
//    }
//}

//class Leaf {
//
//    private int current;
//
//    private List<Leaf> alt;
//
//    public Leaf(int x) {
//        this.current = x;
//        this.alt = new ArrayList<>();
//    }
//
//    public boolean hasAlt() {
//        return alt.size() > 0;
//    }
//
//    public void setCurrent(int x) {
//        this.current = x;
//    }
//
//    public Integer getCurrent() {
//        return current;
//    }
//
//    public List<Leaf> getAlt() {
//        return alt;
//    }
//
//    public List<Leaf> getAll() {
//        List<Leaf> all = new ArrayList<>();
//        all.add(this);
//        all.addAll(alt);
//
//        return all;
//    }
//
//    Leaf split() {
//        int index = p31.money.indexOf(current);
//
//        if(current > 1) {
//            int prev = p31.money.get(index - 1);
//            int remainder = current % prev;
//            if(remainder > 0) {
//                alt.add(new Leaf(p31.money.get(index - 2)));
//            }
//
//            alt.add(new Leaf(prev));
//            alt.add(new Leaf(prev));
//        }
//
//        return this;
//    }
//
//    @Override
//    public String toString() {
//        return String.valueOf(current);
//    }
}
