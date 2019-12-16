// Задача A. Дробь-2
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Fraction{
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        int n = sc.nextInt();

        int top = 0;
        int bottom = 0;

        Map<Integer, Integer>numbers = new TreeMap<>(Collections.reverseOrder());
        for(int i = 0; i < n / 2; i++){
            top = n / 2 - i;
            bottom = n - top;
            numbers.put(top, bottom);
        }

        StringBuilder result = new StringBuilder();

        for(int i : numbers.keySet()){
            int a = i, b = numbers.get(i);
            if(a != b){
                while(a != b){
                    if(a > b) a = a - b;
                    else b = b - a;
                }
                if (a == 1){
                    result.append(i).append(" ").append(numbers.get(i));
                    break;
                }
            }

        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
