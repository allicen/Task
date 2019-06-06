import java.util.*;
import java.io.*;
public class Test3 {
    private static List<Long> allArray = new ArrayList<>();
    private static List<Long> chet = new ArrayList<>();
    private static int one = 0; // Нечетные числа
    private static int zero = 0; // Четные числа
    private static int summ = 0; // Количество перестановок
    private static void check(){ // Проверяем, можно ли расставить все числа, чтобы четные и нечетные чередовались
        for (Long anAllArray : allArray) {
            chet.add(anAllArray % 2);
        }
        for (Long aChet : chet) {
            if (aChet == 1) {
                one = one + 1;
            }
            if (aChet == 0) {
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
            summ = -1;
        }else{
            for(int i = 0; i < allArray.size(); i++){ // Если условие выполнимое
                if(i - 1 >= 0){
                    if(allArray.get(i) % 2 == allArray.get(i-1) % 2 ){
                        queue.addLast(allArray.get(i)); // Добавляем в очередь числа, если четность совпадает с предыдущим числом
                    }else{
                        newArrayQueue.addLast(allArray.get(i));
                    }
                }else{
                    newArrayQueue.addLast(allArray.get(i)); // Добавляем первый элемент в конечный список
                }
            }
            while (!queue.isEmpty()){ // Пока непустая вспомогательная очередь, запускаем условие
                if(
                        queue.size() == 1 &&
                                queue.getFirst() % 2 == newArrayQueue.getLast() % 2 &&
                                newArrayQueue.getFirst() % 2 != queue.getFirst() %2 // Если в промежуточной очереди отсался 1 элемент, четность которого совпадает с конечным элементом итоговой очереди
                ){
                    newArrayQueue.addFirst(queue.getFirst()); // Добавляем элемент в начало итоговой очереди
                    queue.removeFirst(); // Удаляем из вспомогательной очереди
                }else{
                    if(newArrayQueue.getLast() % 2 != queue.getFirst() % 2){ // Если четность 1 элемента вспом. очереди не равна четности посл. элемента итоговой очереди
                        newArrayQueue.addLast(queue.getFirst());
                        queue.removeFirst();
                        summ = summ - 1;
                    }else{
                        queue.addLast(queue.getFirst()); // Отправляем элемент из вспом. очереди в конец вспомогат. очереди
                        queue.removeFirst();
                    }
                    summ = summ + 1;
                }
            }
        }
        String outputNumbers = String.valueOf(newArrayQueue).replaceAll(",", " ").replaceAll("^\\[|\\]$", ""); // Удаляем лишние элементы из строки
        String outputFile = String.valueOf(summ) + "\n" +outputNumbers; // Сборка итоговой строки
        FileWriter countStep = new FileWriter("output.txt");
        countStep.write(outputFile); // Запись в файл
        countStep.close();
    }
}