import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Test2 {
    private static String s;
    private static char[] ch;
    private static int summ = 0;
    public static void main(String[] args) throws IOException {
        ArrayList aList = new ArrayList();
        String str;
        FileReader fin = new FileReader("input.txt");
        Scanner src = new Scanner(fin);
        while(src.hasNextLine()){
            str = src.nextLine();
            aList.add(str);
        }
        for(Object line : aList){
            s = String.valueOf(line);
            ch = s.toCharArray();
            for(int i = 0; i < ch.length; i++){
                if(Character.isLetter(ch[i])){
                    summ = summ + 1; // Добавляем буквы в сумму
                }
            }
            String stringAll = (String) line;
            Pattern p = Pattern.compile("-?\\d+"); // Выделяем число из строки
            Matcher m = p.matcher(stringAll); // Выделяем число из строки
            while (m.find()) {
                int a = Integer.parseInt(m.group());
                summ = summ + a - 1; // Добавляем число и вычитаем букву
            }
        }
            FileWriter countStep = new FileWriter("output.txt");
            countStep.write(summ+"\n");
            countStep.close();
        }
}
