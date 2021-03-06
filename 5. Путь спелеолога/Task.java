import java.util.*;
import java.io.*;
public class Task {
    private static int countCell; // Количество клеток, 1 строка
    private static ArrayList<Integer> allArray = new ArrayList<Integer>(); // Массив со значениями всех клеток
    private static ArrayList<Integer> shortWay = new ArrayList<Integer>(); // Массив для записи всех возможных путей
    private static int arr3 [][][]; // Массив со всеми координатами
    private static int count = 0; // Счетчик для добавления в массив
    private static ArrayList<Integer> start = new ArrayList<Integer>(); // Координаты начальной точки
    private static int minStep; // Кратчайший путь

    static List<Integer> changeSymbols(ArrayList aList, int countCell){ // Замена символов на цифры, преобразование в массив
        int rock = -2; // Клетка с камнем
        int free = -1; // Свободная клетка
        int coverPosition = 0; // Начальная позиция
        for(Object symbol : aList){
            char[] ch = String.valueOf(symbol).toCharArray(); // Перебор всех символов из файла
            if(ch.length == countCell){
                for(int i = 0; i < countCell; i++){
                    // Строка, сформированная по данным файла
                    String strArr = String.valueOf(ch[i]);
                    if (strArr.equals("#")) {
                        strArr = String.valueOf(rock);
                    }else if(strArr.equals(".")){
                        strArr = String.valueOf(free);
                    }else if (strArr.equals("S")){
                        strArr = String.valueOf(coverPosition);
                    }
                    int strArrInt = Integer.valueOf(strArr); // Число, соответствующее заполнению клетки (камень, пусто, начало обхода)
                    allArray.add(strArrInt);
                }
            }
        }
        return allArray;
    }
    static List<Integer> threeDimensionalArray(int arr3[][][], int countCell, ArrayList allArray){ // переписать одномерный массив в трехмерный
            for(int a = 0; a < countCell; a++){
                for(int b = 0; b < countCell; b++) {
                    for (int c = 0; c < countCell; c++) { // Координаты начала обхода
                        arr3[a][b][c] = (int) allArray.get(count);// Поиск координаты для старта обхода графа
                        if(arr3[a][b][c] == 0){
                            start.add(a);
                            start.add(b);
                            start.add(c);
                        }
                        count++;
                    }
                }
            }
        return start;
    }
    private static void aCoordinate(int aPlus, int aMinus, int bNormal, int cNormal, ArrayDeque<Integer> queue, ArrayDeque<Integer> way, ArrayDeque<Integer> countStep, int e, int t){ // 1 координата
        if(aPlus+1 < countCell){
            aPlus++; // Проверка соседней координаты +
            if(arr3[aPlus][bNormal][cNormal] == -1){ // Если клетку еще не посещали
                arr3[aPlus][bNormal][cNormal]= 1; // Отметить клетку посещенной
                queue.addLast(aPlus); // Добавить в очередь 1 координату свободной точки
                queue.addLast(bNormal); // Добавить в очередь 2 координату свободной точки
                queue.addLast(cNormal); // Добавить в очередь 3 координату свободной точки
                way.addFirst(e++); // Счетчик шагов пути (если в очереди есть элементы, то есть еще клетки для проверки)
                countStep.addLast(t); // Добавить в очередь количество шагов до данной клетки
            }
        }
        if(aMinus-1 >= 0){
            aMinus--; // Проверка соседней координаты -
            if(arr3[aMinus][bNormal][cNormal] == -1){
                arr3[aMinus][bNormal][cNormal]= 1;
                queue.addLast(aMinus);
                queue.addLast(bNormal);
                queue.addLast(cNormal);
                way.addFirst(e++);
                countStep.addLast(t);
            }
        }
    }
    private static void bCoordinate(int bPlus, int bMinus, int aNormal, int cNormal, ArrayDeque<Integer> queue, ArrayDeque<Integer> way, ArrayDeque<Integer> countStep, int e, int t){ // 2 координата
        if(bPlus+1 < countCell){
            bPlus++;
            if(arr3[aNormal][bPlus][cNormal] == -1){
                arr3[aNormal][bPlus][cNormal] = 1;
                queue.addLast(aNormal);
                queue.addLast(bPlus);
                queue.addLast(cNormal);
                way.addFirst(e++);
                countStep.addLast(t);
            }
        }
        if(bMinus-1 >= 0){
            bMinus--;
            if(arr3[aNormal][bMinus][cNormal] == -1){
                arr3[aNormal][bMinus][cNormal] = 1;
                queue.addLast(aNormal);
                queue.addLast(bMinus);
                queue.addLast(cNormal);
                way.addFirst(e++);
                countStep.addLast(t);
            }
        }
    }
    private static void cCoordinate(int cPlus, int cMinus, int aNormal, int bNormal, ArrayDeque<Integer> queue, ArrayDeque<Integer> way, ArrayDeque<Integer> countStep, int e, int t){ // 3 координата
        if(cPlus+1 < countCell){
            cPlus++;
            if(arr3[aNormal][bNormal][cPlus] == -1){
                arr3[aNormal][bNormal][cPlus] = 1;
                queue.addLast(aNormal);
                queue.addLast(bNormal);
                queue.addLast(cPlus);
                way.addFirst(e++);
                countStep.addLast(t);
            }
        }
        if(cMinus-1 >= 0){
            cMinus--;
            if(arr3[aNormal][bNormal][cMinus] == -1){
                arr3[aNormal][bNormal][cMinus] = 1;
                queue.addLast(aNormal);
                queue.addLast(bNormal);
                queue.addLast(cMinus);
                way.addFirst(e++);
                countStep.addLast(t);
            }
        }
    }
    private static void shortWay(){ // Сортировка всех путей, выбор самого короткого (первого после сортировки)
        if(!shortWay.isEmpty()){
            Collections.sort(shortWay); // Сортировка коллекции с длиной всех путей
            minStep = shortWay.get(0); // Кратчайший путь
        }else{
            System.out.println("Путей нет!");
        }
    }

    public static void main(String[] args) throws IOException {
        ArrayDeque<Integer> queue = new ArrayDeque<>(); // Очередь со всеми координатами свободных точек
        ArrayDeque<Integer> way = new ArrayDeque<>(); // Очередь, которая хранит данные о наличии пути
        ArrayDeque<Integer> countStep = new ArrayDeque<>(); // Очередь с количеством шагов из начальной позиции
        ArrayList aList = new ArrayList(); // Массив для записи данных из файла
        // Считывание данных из файла
        String str;
        FileReader fin = new FileReader("input.txt");
        Scanner src = new Scanner(fin);
        while(src.hasNextLine()){
            str = src.nextLine();
            aList.add(str);
        }
        // Количество клеток
        countCell = Integer.valueOf((String) aList.get(0));
        arr3 = new int [countCell][countCell][countCell];
        changeSymbols(aList, countCell);
        threeDimensionalArray(arr3, countCell, allArray);

        // Начало обхода графа
        int aPlus = start.get(0), aMinus = start.get(0), aNormal = start.get(0);
        int bPlus = start.get(1), bMinus = start.get(1), bNormal = start.get(1);
        int cPlus = start.get(2), cMinus = start.get(2), cNormal = start.get(2);
        int e = 0; // Произвольное число
        way.addFirst(e); // Добавить в очередь произвольное число, чтобы очередь была непустой
        int t = 1; // Число шагов до 1 свободной клетки (1 шаг по условию задачи)
        while(!way.isEmpty()){
            way.removeFirst(); // Удалить первый элемент из очереди пути
            aCoordinate(aPlus, aMinus, bNormal, cNormal, queue, way, countStep, e, t); // Координата 1
            bCoordinate(bPlus, bMinus, aNormal, cNormal, queue, way, countStep, e, t); // Координата 2
            cCoordinate(cPlus, cMinus, aNormal, bNormal, queue, way, countStep, e, t); // Координата 3
            if(!countStep.isEmpty()){
                t = countStep.getFirst() + 1; // Количество шагов до следующей клетки
            }
            if(queue.isEmpty()){
                break;
            }else{
                aPlus = aMinus = aNormal = queue.getFirst(); // Переопределение 1 переменной
                if(queue.getFirst() == 0){
                    shortWay.add(countStep.getFirst()); // Если дошли до поверхности, добавляем количество шагов в очередь
                }
                queue.removeFirst(); // Удаляем 1 точку из очереди
                bPlus = bMinus = bNormal = queue.getFirst(); // 2 точка
                queue.removeFirst();
                cPlus = cMinus = cNormal = queue.getFirst(); // 3 точка
                queue.removeFirst();
                countStep.removeFirst(); // Удаляем из очереди количество шагов до удаленной точки
            }
        }
        shortWay(); // Получаем короткий путь
        System.out.println(minStep);
        FileWriter countStepFinish = new FileWriter("output.txt");// Запись результата в файл
        countStepFinish.write(String.valueOf(minStep));
        countStepFinish.close();
    }
}
