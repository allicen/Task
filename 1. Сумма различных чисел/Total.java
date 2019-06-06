import java.util.*;
import java.io.*;
public class Test {
    private static List<Long> allArray = new ArrayList<>();
    private static long summ = 0;
    public static void main(String[] args) throws IOException {
            ArrayList aList = new ArrayList();
            String str;
            FileReader fin = new FileReader("input.txt");
            Scanner src = new Scanner(fin);
            while(src.hasNextLine()){
                str = src.nextLine();
                aList.add(str);
            }
            if(Long.valueOf((String) aList.get(0)) != 0){
                String s = (String) aList.get(1);
                String[] sub = s.split(" ");
                for(String symbol : sub){
                    long symbolInt = Long.parseLong(symbol);
                    allArray.add(symbolInt);
                }
                Collections.sort(allArray);
                for(int i = 0; i < allArray.size(); i++){
                    if(i+1 < allArray.size() && !allArray.get(i).equals(allArray.get(i + 1))){
                        summ = summ + allArray.get(i+1);
                    }
                    if(i==0){
                        summ = summ + allArray.get(0);
                    }
                }
                FileWriter countStep = new FileWriter("output.txt");
                countStep.write(String.valueOf(summ)+"\n");
                countStep.close();

            }else{
                FileWriter countStep = new FileWriter("output.txt");
                countStep.write(0+"\n");
                countStep.close();
            }
        }

}
