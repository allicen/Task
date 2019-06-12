import java.util.*;
import java.io.*;
public class Test5 {
    private static ArrayList<Long> allArray = new ArrayList<>();
    private static ArrayList<Long> chet = new ArrayList<>();
    private static int min = 0;
    private static int min2 = 0;
    private static int size = 0;
    private static int control = 0;
    private static int one = 0; // Нечетные числа
    private static int zero = 0; // Четные числа
    public static void check(){ // Проверяем, можно ли расставить все числа, чтобы четные и нечетные чередовались
        for(int i = 0; i < allArray.size(); i++){
            chet.add(allArray.get(i) % 2);
        }
        for(int i = 0; i < chet.size(); i++){
            if(chet.get(i) == 1){
                one = one + 1;
            }
            if(chet.get(i) == 0){
                zero = zero + 1;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        ArrayDeque<Long> queue = new ArrayDeque<>(); // Промежуточная очередь
        ArrayDeque<Long> newArrayQueue = new ArrayDeque<>(); // Итоговая очередь
        ArrayList aList = new ArrayList(); //
        String str;
        FileReader fin = new FileReader("input.txt");
        Scanner src = new Scanner(fin);
        while(src.hasNextLine()){
            str = src.nextLine();
            aList.add(str);
        }
        String s = (String) aList.get(1); // Отбрасываем число из первой строки
        String[] sub = s.split(" "); // Разделяем строку по пробелам
        for(String symbol : sub){ // Формируем новый массив для работы с ним
            long symbolInt = Long.parseLong(symbol);
            allArray.add(symbolInt);
        }
        check(); // Проверка возможности выполнения начального условия
        if(zero - one > 1|| one - zero > 1){ // Если условие выполнить нельзя
            size = -1;
        }else{
            for(int i = 0; i < allArray.size(); i++){ // Если условие выполнимое
                if(i - 1 >= 0){
                    if(allArray.get(i) % 2 == allArray.get(i-1) % 2 ){
                        queue.addLast(allArray.get(i)); // Добавляем в очередь числа, если четность совпадает с предыдущим числом
                        // size = size + 1;
                    }else{
                        newArrayQueue.addLast(allArray.get(i));
                    }
                }else{
                    newArrayQueue.addLast(allArray.get(i)); // Добавляем первый элемент в конечный список
                }
            }
            if(queue.size()>1 && !queue.isEmpty() && !newArrayQueue.isEmpty() && newArrayQueue.getLast()%2 == queue.getFirst()%2){
                size = size + 1;
            }
            for (int j = 0; j < queue.size(); j++){
                if(queue.size() == 1 &&
                        queue.getFirst() % 2 == newArrayQueue.getLast() % 2 &&
                        newArrayQueue.getFirst() % 2 != queue.getFirst() %2 // Если в промежуточной очереди отсался 1 элемент, четность которого совпадает с конечным элементом итоговой очереди
                ){
                    newArrayQueue.addFirst(queue.getFirst()); // Добавляем элемент в начало итоговой очереди
                    queue.removeFirst(); // Удаляем из вспомогательной очереди
                    size = size + 1;
                }
                if(!queue.isEmpty() && !newArrayQueue.isEmpty() ){
                    if( queue.getFirst() % 2 == newArrayQueue.getLast() % 2){
                        queue.addLast(queue.getFirst());
                        queue.removeFirst();
                    }else{
                        newArrayQueue.addLast(queue.getFirst());
                        queue.removeFirst();
                    }
                }
                if(!queue.isEmpty()){
                    j--;
                }else{
                    break;
                }
                // Счетчик перемещений
                if(!queue.isEmpty() && !newArrayQueue.isEmpty() && newArrayQueue.getLast()%2 == queue.getFirst()%2 && queue.size() > 1){
                    if(control == 0){
                        size = size + 1;
                        control = 1;
                    }
                }else{
                    if(control == 1){
                        // size = size + 1;
                        control = 0;
                    }
                }
            }
        }
        ArrayList<Long> allArray2 = new ArrayList<>(); // Проверка, если перемещений 0, но итоговый вариант не совпадает с исходным
        for(Long line : newArrayQueue){
            allArray2.add(line);
        }
        if(size == 0 && !allArray.equals(allArray2)){
            size = size + 1;
        }
        String outputNumbers = String.valueOf(newArrayQueue).replaceAll(",", " ").replaceAll("^\\[|\\]$", ""); // Удаляем лишние элементы из строки
        String outputFile = String.valueOf(size) + "\r\n" +outputNumbers; // Сборка итоговой строки
        FileWriter countStep = new FileWriter("output.txt");
        countStep.write(outputFile); // Запись в файл
        countStep.close();
    }

}
