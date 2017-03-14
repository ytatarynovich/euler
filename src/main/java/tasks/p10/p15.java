package tasks.p10;

public class p15 {
    public String a;
    public static void main(String[] args) {
        p15 p = new p15();
        p.a = "Hanna";
        foo(p);
        System.out.println(p.a);
//        Long a1 = new Long(1);
//        Long a2 = new Long(1);
//        System.out.println(a1 == a2);
//        System.out.println(a1.equals(a2));
//        int SIZE = 21;
//        long[][] field = new long[SIZE][SIZE];
//        field[0][0] = 1;
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                if(j == SIZE - 1 && i == SIZE - 1) {
//                  break;
//                } else if(i == SIZE - 1) {
//                    field[i][j + 1] += field[i][j]; 
//                } else if(j == SIZE - 1) {
//                    field[i + 1][j] += field[i][j];
//                } else {
//                    field[i + 1][j] += field[i][j];
//                    field[i][j + 1] += field[i][j];
//                }
//            }
//        }
//        
//        System.out.println("Result: " + field[SIZE - 1][SIZE - 1]);
    }
    
    public static void foo(p15 p) {
        p = new p15();
        p.a = "Yury";
    }
}
