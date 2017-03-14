package tasks.p80;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class P82 {

    static final int SIZE = 5;
    
    public static void main(String[] args) throws IOException {
        long[][] data = readData();
        long[][] d = new long[SIZE][SIZE];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                d[i][j] = data[i][j];
            }
        }
        
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                long current = data[i][j];
                
                int upIndex = i - 1;
                int downIndex = i + 1;
                int rightIndex = j - 1;
                
                if(upIndex >= 0) {
                    
                } 
                
                if(downIndex < SIZE) {
                    
                }
                
            }
        }
    }

    static long[][] readData() throws FileNotFoundException, IOException {
        long[][] data = new long[SIZE][SIZE];
        
        File file = new File("matrix.txt");
        
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while((line = br.readLine() )!= null) {
                String[] numbers = line.split(",");
                int j = 0;
                for(String number : numbers) {
                    data[i][j] = Long.parseLong(number);
                    j++;
                }
                i++;
            }
        }
        return data;
    }
}