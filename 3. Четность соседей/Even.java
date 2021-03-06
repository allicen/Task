import java.util.*;
import java.io.*;
public class Test5 {
    private static ArrayList<Long> allArray = new ArrayList<>();
    private static ArrayList<Long> chet = new ArrayList<>();
    private static int minChangeCount = 0;
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
            minChangeCount = -1;
        }else{
            for(int i = 0; i < allArray.size(); i++){ // Если условие выполнимое
                if(i - 1 >= 0){
                    if(allArray.get(i) % 2 == allArray.get(i-1) % 2 ){
                        queue.addLast(allArray.get(i)); // Добавляем в очередь числа, если четность совпадает с предыдущим числом;
                        if(minChangeCount == 0){
                            minChangeCount++;
                        }
                    }else{
                        newArrayQueue.addLast(allArray.get(i));
                    }
                }else{
                    newArrayQueue.addLast(allArray.get(i)); // Добавляем первый элемент в конечный список
                }
            }
            while(!queue.isEmpty()){
                if((newArrayQueue.getLast()%2) != queue.getFirst()%2){
                    newArrayQueue.addLast(queue.getFirst());
                    queue.removeFirst();
                    for(Long line : queue){
                        if(line%2 != newArrayQueue.getLast()%2){
                            newArrayQueue.addLast(line);
                            queue.remove(line);
                        }
                    }
                }else{
                    if(queue.size() == 1){
                        newArrayQueue.addFirst(queue.getFirst());
                        queue.removeFirst();
                        //minChangeCount++;
                    }else{
                        queue.addLast(queue.getFirst());
                        queue.removeFirst();
                    }
                }
                if(queue.size() > 1){
                    minChangeCount++;
                }
            }
        }
        String outputNumbers = String.valueOf(newArrayQueue).replaceAll(",", " ").replaceAll("^\\[|\\]$", ""); // Удаляем лишние элементы из строки
        String outputFile = String.valueOf(minChangeCount) + "\r\n" +outputNumbers; // Сборка итоговой строки
        FileWriter countStep = new FileWriter("output.txt");
        countStep.write(outputFile); // Запись в файл
        countStep.close();
    }
}