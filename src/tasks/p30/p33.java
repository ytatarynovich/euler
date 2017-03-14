package tasks.p30;

import java.util.ArrayList;
import java.util.List;
import utils.EulerUtils;

public class p33 {
    public static void main(String[] args) {
        List<Value> result = new ArrayList<>();
        for (long i = 10; i < 100; i++) {
            for (long j = i + 1; j < 100; j++) {
                if(i % 10 == 0) {
                    continue;
                }
                
                char[] num = EulerUtils.splitNumber(i);
                char[] den = EulerUtils.splitNumber(j);
                String denNumber = String.valueOf(j);
                
                for (int k = 0; k < num.length; k++) {
                    String ch = String.valueOf(num[k]);
                    if(denNumber.contains(ch)) {
                        String numValue;
                        String denValue;
                        if(num[0] == num[1]) {
                            numValue = String.valueOf(num[0]);
                        } else {
                            String numCopy = new String(num);
                            numValue = numCopy.replace(ch, "");
                        }
                        
                        if(den[0] == den[1]){
                            denValue = String.valueOf(den[0]);
                        } else {
                            String denCopy = new String(den);
                            denValue = denCopy.replace(ch, "");
                        }
                        
                        long resultDen = Long.parseLong(denValue);
                        long resultNum = Long.parseLong(numValue);
                        if(resultDen == 0) {
                            continue;
                        }
                        
                        long maxDen = EulerUtils.getMaxDenominator(resultNum, resultDen);
                        long maxDenIJ = EulerUtils.getMaxDenominator(i, j);
                        if((i / maxDenIJ == resultNum / maxDen) && (j / maxDenIJ == resultDen / maxDen)) {
                            Value v = new Value();
                            v.den = j / maxDenIJ;
                            v.num = i / maxDenIJ ;
                            result.add(v);
                        }
                    }
                }
            }
        }
        
        long resultNum = 1;
        long resultDen = 1;
        for (Value value : result) {
            resultNum *= value.num;
            resultDen *= value.den;
        }
        
        long maxResultDen = EulerUtils.getMaxDenominator(resultNum, resultDen);
        System.out.println("Result: " + resultNum / maxResultDen + " / " + resultDen / maxResultDen);
    }
    
    
}

class Value {
   long den;
   long num;
   
   
   @Override
   public String toString() {
      return num + " / " + den; 
   }
}
