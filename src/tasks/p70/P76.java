//package tasks.p70;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import static tasks.p70.P76.splitCoin;
//
///*
// In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
// 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
// It is possible to make £2 in the following way:
// 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
// How many different ways can £2 be made using any number of coins?
// */
//public class P76 {
//
//    static List<Integer> coins = Arrays.asList(1, 2, 5, 10, 20, 100, 200);
//    static Map<Integer, List<Integer>> map = new HashMap<>();
//
//    public static void main(String[] args) {
//        Coin coin = splitCoin(1);
//    }
//
//    public static Coin splitCoin(int value) {
//        Coin coin = new Coin(value);
//        if (value > 1) {
//            int index = coins.indexOf(value);
//            int diff = 0;
//            while(true){
//                int child = coins.get(index - 1);
//                diff = value - child;
//                if(diff == 0) {
//                    coin.addChild(new Coin(child));
//                    break;
//                } else if(diff < 0) {
//                    index--;
//                } else {
//                    coin.addChild(new Coin(child));
//                    value = diff;
//                }
//            }
//        }    
//        return coin;
//    }
//    
//    static List<List<Integer>> getComb() {
//        
//        int result = 1;
//        if(childs.size() > 0) {
//            int prod = 1;
//            for (Coin child : childs) {
//                prod *= child.getComb();
//            }
//            
//            result += prod;
//        }
//        
//        return result;
//    }
//}
//
//class Coin {
//    List<Coin> childs = new ArrayList<>();
//    int value;
//    
//    Coin(int value) {
//        this.value = value;
//    }
//    void addChild(Coin coin) {
//        coin = splitCoin(coin.value);
//        childs.add(coin);
//    }
//
//    @Override
//    public String toString() {
//        System.out.println(value);
//        for (Coin coin : childs) {
//            System.out.print(coin);
//        }
//        return "";
//    }
//}
