package utils;

import com.google.common.math.DoubleMath;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class EulerUtils {

    private static Map<Long, List<Long>> cache2 = new HashMap<>();
//
//    public static boolean isPrime(long candidate) {
//        int candidateRoot = (int) Math.sqrt((double) candidate);
//        return IntStream.rangeClosed(2, candidateRoot)
//        .noneMatch(i -> candidate % i == 0);
//    }
    
    public static List<Long> getDistinctDivisors(long v) {
        long value = v;
        List<Long> divisors = new ArrayList<>();
        long current = 2;
        while (value > 1) {
            synchronized(cache2) {
                if (cache2.containsKey(value)) {
                    divisors.addAll(cache2.get(value));
                    break;
                }
            }
            if (value % current == 0) {
                value /= current;
                divisors.add(current);
                current = 2;
            } else {
                current++;
            }
        }
        synchronized(cache2) {
            cache2.put(v, divisors);
        }
        
        return divisors;
    }
    public static Set<Long> getDivisors(long v) {
        List<Long> divisors = getDistinctDivisors(v);

        Set<Long> result = new HashSet<>();
        int size = divisors.size();
        Long[] divs = divisors.toArray(new Long[0]);
        int threshold = (int) Math.pow(2, size);
        for (int i = 1; i < threshold; i++) {
            long resultDiv = 1;
            long value = i;
            for (int j = 0; j < size && value > 0; j++) {
                    if(value % 2 == 1) {
                        long currentDiv = divs[j];
                        resultDiv *= currentDiv;
                        result.add(resultDiv);
                    }
                    value /= 2;
                }
            }

        result.add(1L);
        return result;
    }

    public static String rotateNumber(String str) {
        return str.substring(1, str.length()) + str.charAt(0);
    }
    
    public static String truncateRightNumber(String number) {
        return number.substring(1, number.length());
    }
    
    public static String truncateLeftNumber(String number) {
        return number.substring(0, number.length() - 1);
    }
 
    public static long max(long num1, long num2) {
        long result;
        if (num1 > num2) {
            result = num1;
        } else if (num1 < num2) {
            result = num2;
        } else {
            result = num1;
        }

        return result;
    }

    public static int getDigitsSum(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            int digit = number.charAt(i) - 64;
            sum += new Integer(digit);

        }

        return sum;
    }

    public static long sum(List<Long> list) {
        long sum = 0;
        for (Long number : list) {
            sum += number;
        }
        return sum;
    }

    public static char[] splitNumber(Long number) {
        return number.toString().toCharArray();
    }

    private static final Map<Long, Long> cache = new HashMap<>();

    public static long factorial(long value) {
        long result;
        if (value <= 1) {
            result = 1;
        } else {
            result = factorial(value - 1) * value;
        }

        return result;
    }

    public static boolean isPalindrome(String value) {

        String current;
        String poly = "";

        current = value;
        int length = current.length();
        String start;
        String end;
        int sub;
        if (length % 2 == 0) {
            sub = length / 2;
            start = current.substring(0, sub);
            end = new StringBuilder(current.substring(sub, length)).reverse().toString();
        } else {
            sub = length / 2;
            start = current.substring(0, sub);
            end = new StringBuilder(current.substring(sub + 1, length)).reverse().toString();
        }

        boolean result = false;
        if (start.compareTo(end) == 0) {
            poly = current;
            result = true;
        }

        return result;
    }

    public static boolean isPandigital(String number, char start) {
        boolean result = true;
        char[] digits = number.toCharArray();
        Arrays.sort(digits);
        char current = start;
        for (char digit : digits) {
            if (current != digit) {
                result = false;
                break;
            }
            current++;
        }

        return result;
    }

    public static boolean isPrime(long value) {
        if (value % 2 == 0 || value % 3 == 0) {
            return true;
        }
        
        if(value < 1) {
            return false;
        }
        
        boolean result = true;

        for (int i = 3; i < value; i += 2) {
            if (value % i == 0) {
                result = false;
                break;
            }
        }

        return result;
    }

    public static long triangleNumber(long n) {
        return n * (n + 1) / 2;
    }
    
    public static long pentagonalNumber(long n) {
        return n * (3 * n - 1) / 2;
    }

    public static long hexagonalNumber(long n) {
        return n * (2 * n - 1);
    }

    public static boolean isEquals(Long num1, Long num2) {
        char[] ch1 = splitNumber(num1);
        Arrays.sort(ch1);
        char[] ch2 = splitNumber(num2);
        Arrays.sort(ch2);
        boolean result = Arrays.equals(ch1, ch2);
        return result;
    }

    public static boolean isInt(double number) {
        return DoubleMath.isMathematicalInteger(number);
    }

    public static int[][] getData(String fileName, int size) {
        int[][] data = new int[size][];
        File file = new File(fileName);
        int lineIndex = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] res = line.split(" ");
                int[] lineNumbers = new int[lineIndex + 1];
                data[lineIndex] = lineNumbers;
                int i = 0;
                for (String r : res) {
                    lineNumbers[i] = Integer.parseInt(r);
                    i++;
                }
                lineIndex++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    
    public static List<String> getData(String fileName) {
        List<String> result = new ArrayList<>();
        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static long nextDifNumber(long value) {
            String str = String.valueOf(value);
            int length = str.length();
            long result = value;
            boolean isIncremented = true;
            String number = String.valueOf(result);
            for (int j = length - 1; j > -1; j--) {
                char currentDigit = number.charAt(j);
                int index = number.substring(0, j).indexOf(currentDigit);
                if (index > -1) {
                    result += Math.pow(10, (length - j - 1));
                    isIncremented = false;
                    break;
                }
            }

            if (isIncremented) {
                result++;
            }
            
            return result;
    }
    
    public static synchronized  long getMaxDenominator(long x, long y) {
        Set<Long> xDivs = getDivisors(x);
        Set<Long> yDivs = getDivisors(y);
        
        yDivs.retainAll(xDivs);
        List<Long> list = new ArrayList<>(yDivs);
        Collections.sort(list);
            
        return list.get(list.size() - 1);
    }
    
    public static boolean isPrime(int value) {
        int root = (int) Math.sqrt(value);

        return IntStream.rangeClosed(2, root).noneMatch(i -> value % i == 0);
    }
}
