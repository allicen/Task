import java.util.*;
public class WordCorrect {
    private static List<Integer> indexChangeSymbol = new ArrayList<Integer>(); // Добавление id символов для замены в массив
    private static List<Integer> indexErrorSymbol = new ArrayList<Integer>();
    private static String[] wordFlag = {"ж", "ш", "ч", "щ"}; // Символы, после которых проверяем ошибки
    private static String[] wordRight = {"и", "а", "у"}; // Правильные символы
    private static String[] wordError = {"ы", "я", "ю"}; // Ошибочные символы
    private static String newString; // Новая строка с исправлением ошибок
    private static int index; // Индексы для счетчиков
    private static int a = 0;
    public static void main(String[] args) {
        System.out.println("Введите строку, в которой допущена ошибка с жи/ши, ча/ща, чу/щу");
        Scanner sc = new Scanner(System.in); // Ввод строки пользователем
        String random  = sc.nextLine();
        char[] ch =  random.toCharArray(); // Формирование массивов на основ введеных данных
        String[] randomArray = new String[ch.length];
        String[] nextCh = new String[ch.length];
        for(index = 0; index < ch.length; index++){ // Поиск id ошибочных символов
            for(int j = 0; j < wordFlag.length; j++){
                randomArray[index] = String.valueOf(ch[index]);
                if(randomArray[index].equals(wordFlag[j])){
                    if(index+1 < ch.length){
                        nextCh[index] = String.valueOf(ch[index+1]);
                        for(int a = 0; a < wordError.length; a++){
                            if(nextCh[index].equals(wordError[a])){
                                indexChangeSymbol.add(index+1);
                                indexErrorSymbol.add(a);
                            }
                        }
                    }
                }
            }
        }
        for(int temp : indexChangeSymbol){ // Заменя символов по id
            newString = random.replace(String.valueOf(ch[indexChangeSymbol.get(a)]), wordRight[indexErrorSymbol.get(a)]);
            random = newString;
            a++;
        }
        if(indexErrorSymbol.isEmpty()){ // Вывод результата
            System.out.println("Ошибок нет: ");
            System.out.println(ch);
        }else{
            System.out.println("В строке были исправлены ошибки: ");
            System.out.println(newString);
        }
    }
}
