/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ksm
 */
public class Sub {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        byte algorithmId, loopType;
        int n;
        try{
        algorithmId = Byte.parseByte("2");
        loopType = Byte.parseByte("3");
        n = Integer.parseInt("3");
        // Выбор типа алгоритма
        switch (algorithmId){
            case 1:
                Fibonacci fib = new Fibonacci(loopType, n);
                break;
            case 2:
                Factorial fac = new Factorial(loopType, n);
                break;
            default:
                System.out.println("Invalid value!");
                System.out.println("Valid values:");
                System.out.println("1. Form the Fibonacci series;");
                System.out.println("2. Calculate the factorial.");
        }

    }catch(RuntimeException e){
        System.out.println("Only integer values ​​are allowed.");
        System.out.println("An exception occurred." + e);
    }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ksm
 */
class Fibonacci {
    int i;
      public Fibonacci(byte loopType, int n){
        long fibonacciSeries[] = new long[n];
        try {
        fibonacciSeries[0] = 0;
        fibonacciSeries[1] = 1;
        i = 1;
        switch(loopType){
            case 1:
                while(i<=n-2) {
                fibonacciSeries[i+1] = fibonacciSeries[i-1]+fibonacciSeries[i];
                i++;
                }
                System.out.println("The Fibonacci series has formed by cycle 'while':");
                for(i=0;i<n;i++)
                    System.out.print(fibonacciSeries[i]+" ");
                break;
            case 2:
                if (n == 2){
                    System.out.println("The Fibonacci series has formed by cycle 'do-while':");
                    System.out.println(fibonacciSeries[0] + " " + fibonacciSeries[1]);
                    }else{
                    do{
                    fibonacciSeries[i+1] = fibonacciSeries[i-1]+fibonacciSeries[i];
                    i++;
                    }while(i<=n-2);
                    System.out.println("The Fibonacci series has formed by cycle 'do-while':");
                    for(i=0;i<n;i++)
                        System.out.print(fibonacciSeries[i]+" ");
                }
                break;
            case 3:
                for(i=1;i<=n-2;i++)
                    fibonacciSeries[i+1] = fibonacciSeries[i-1]+fibonacciSeries[i];
                System.out.println("The Fibonacci series has formed by cycle 'for':");
                for(i=0;i<n;i++)
                    System.out.print(fibonacciSeries[i]+" ");
                break;
            default:
                System.out.println("There is no any cycle to form the Fibonacci series.");
                System.out.println("Valid values:");
                System.out.println("1. Cycle 'while';");
                System.out.println("2. Cycle 'do-while';");
                System.out.println("3. Cycle 'for'.");
        }

    }catch(ArrayIndexOutOfBoundsException e){
        System.out.println("Minimal lenth to form The Fibonacci series is 2.");
        System.out.println("An exception occurred." + e);
        }
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ksm
 */
class Factorial {
        int i;
        long result;
    public Factorial(byte loopType, int n) {
            i = 1;
            result = 1;
            switch (loopType) {
                case 1:
                    if (n != 0){
                    while(i<=n){
                        result *= i;
                        i++;
                    }
                    System.out.println("The factorial is calculated by cycle 'while':");
                    System.out.println(result);
                    }else{
                        System.out.println("The factorial is calculated by cycle 'while':");
                        System.out.println(result);
                    }
                    break;
                case 2:
                    if (n !=0){
                     do{
                        result *= i;
                        i++;
                    }while(i<=n);
                    System.out.println("The factorial is calculated by cycle 'do-while':");
                    System.out.println(result);
                    }else{
                        System.out.println("The factorial is calculated by cycle 'do-while':");
                        System.out.println(result);
                    }
                    break;
                case 3:
                    if (n !=0) {
                    for (i=1; i<=n; i++)
                        result *= i;
                    System.out.println("The factorial is calculated by cycle 'for':");
                    System.out.println(result);
                    }else{
                        System.out.println("The factorial is calculated by cycle 'for':");
                        System.out.println(result);
                    }
                    break;
                default:
                    System.out.println("There is no any cycle to calculate the factorial.");
                    System.out.println("Valid values:");
                    System.out.println("1. Cycle 'while'");
                    System.out.println("2. Cycle 'do-while'");
                    System.out.println("3. Cycle 'for'");
            }
        }
}