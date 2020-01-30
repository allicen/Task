import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Test16 {
    private static StringBuilder result = new StringBuilder();

    /**
     * Метод, в котором считываются данные из файла и конвертируются в двоичный код
     * @return Конструктор строки, в котором сохранены данные из файла в бинарном формате
     * */

    private static StringBuilder convertDataToBinary()throws IOException{
        StringBuilder bytes = new StringBuilder();
        Scanner sc = new Scanner(new FileReader("base64.in"));
        int line = 0;
        while (sc.hasNextLine()){
            String sample = sc.nextLine();
            if(line != 0){
                StringTokenizer st = new StringTokenizer(sample, " ");
                while (st.hasMoreTokens()){
                    String str = st.nextToken();
                    Integer number = Integer.parseInt(str, 16);
                    String convert = Integer.toBinaryString(number);

                    int zeroCount = 8 - convert.length();
                    StringBuilder up = new StringBuilder();
                    while (zeroCount > 0){
                        up.append("0");
                        zeroCount--;
                    }
                    up.append(convert);
                    bytes.append(up);
                }
            }
            line = 1;
        }
        return bytes;
    }


    /**
     * Метод формирует допстроку из символов "=", которая добавляется в конец
     * @param bytes строка в бинарном формате
     * @param wait количество символов, которое должно быть в итоге после конвертации
     * @param added количество добавляемых знаков "="
     * @return Конструктор строки с необходимым количеством знаков "="
     * */

    private static StringBuilder splitStringIntoSixCharacters(StringBuilder bytes, double wait, int added){
        String dop = "=";
        int j = added;

        StringBuilder addedString = new StringBuilder();
        while (j > 0){
            addedString.append(dop);
            j--;
        }

        while (wait > 0){
            bytes.append("0");
            wait--;
        }
        return addedString;
    }


    /**
     * Метод ищет символы для замены по индексу и записывает из в строку
     * @param bytes Строка бинарных символов
     * */

    private static void searchSymbolsForConvert(StringBuilder bytes){
        String code = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

        int index = 0;
        char[] ch = String.valueOf(bytes).toCharArray();

        StringBuilder search = new StringBuilder();

        for (int i = 0; i < bytes.length(); i++){
            search.append(ch[i]);
            if(index < 5){
                index++;
            }else {
                Integer number = Integer.parseInt(String.valueOf(search), 2);
                String convert = Integer.toString(number, 10);
                result.append(code.charAt(Integer.valueOf(convert)));
                search = new StringBuilder();
                index = 0;
            }
        }
    }


    public static void main(String[] args)throws IOException {
        StringBuilder bytes = convertDataToBinary();
        int plus = bytes.length()% 24 != 0 ? 1 : 0;
        double wait = (24 * (bytes.length()/24 + plus)) - bytes.length();
        int added = (int) (wait / 6);

        StringBuilder addedString = splitStringIntoSixCharacters(bytes, wait, added);
        searchSymbolsForConvert(bytes);

        String finish = String.valueOf(result.replace(result.length()-added, result.length(), String.valueOf(addedString)));
        FileWriter out = new FileWriter("base64.out");
        out.write(finish);
        out.close();
    }
}