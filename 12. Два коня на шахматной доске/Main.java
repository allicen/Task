import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    /**
     * Метод проверяет все возможные ходы коня из заданной точки
     * @param queue Очередь ходов
     * @param possibleMove Возможные ходы коня
     * @param m Одна сторона поля
     * @param n Вторая сторона поля
     * */

    private static ArrayList<int[]> ways(int[] queue, int[][] possibleMove, int m, int n){
        ArrayList<int[]> array = new ArrayList<>();
        for (int[] aPossibleMove : possibleMove) {
            if (aPossibleMove[0] + queue[0] >= 0 && aPossibleMove[0] + queue[0] < m && aPossibleMove[1] + queue[1] >= 0 && aPossibleMove[1] + queue[1] < n) {
                int x = aPossibleMove[0] + queue[0];
                int y = aPossibleMove[1] + queue[1];
                array.add(new int[]{x, y});
            }
        }
        return array;
    }

    public static void main(String[] args) throws IOException {
        int step = -1; // По умолчанию кони не могут встать на одну клетку
        int m = 0, n = 0; // Размеры поля
        int[] playerWhite = new int[2], playerBlack = new int[2]; // Положение 1 и 2 коня
        ArrayDeque<int[]> queue = new ArrayDeque<>(); // Очередь ходов
        int[][] field = new int[0][]; // Шахматное поле
        int[][] possibleMove = new int[][]{{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}}; // Возможные ходы коня

        Scanner sc = new Scanner(new FileReader("knight.in")); // Считываем данные
        int index = 0;
        while (sc.hasNextLine()){
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            while (st.hasMoreTokens()){
                if(index == 0){
                    m = Integer.valueOf(st.nextToken());
                    n = Integer.valueOf(st.nextToken());
                    field = new int[m][n];
                }else if(index == 1){
                    playerWhite = new int[]{Integer.valueOf(st.nextToken())-1, Integer.valueOf(st.nextToken())-1};
                }else {
                    playerBlack = new int[]{Integer.valueOf(st.nextToken())-1, Integer.valueOf(st.nextToken())-1};
                }
            }
            index++;
        }

        int a, b, c, d; // Координаты коней

        a = playerWhite[0] + 1;
        b = playerWhite[1] + 1;
        c = playerBlack[0] + 1;
        d = playerBlack[1] + 1;

        if((a != c && b != d)){ // Проверяем, что кони не в одной клетке
            for(int i = 0; i < m; i++){ // Находим точки старта на поле
                for(int j = 0; j < n; j++){
                    if(i == playerWhite[0] && j == playerWhite[1]){
                        field[i][j] = -1;
                    }else if(i == playerBlack[0] && j == playerBlack[1]){
                        field[i][j] = -2;
                    }else {
                        field[i][j] = 0;
                    }
                }
            }
            queue.addLast(playerWhite); // Добавляем первый ход в очередь
            boolean stop = false;

            while (!stop && !queue.isEmpty()){ // Проверяем каждую клетку из очереди
                int[] start = queue.getFirst(); // Берем первый элемент очереди
                ArrayList<int[]> temp = ways(start, possibleMove, m, n); // Пробиваем допустимые ходы

                for (int[] arr : temp){
                    int cell = field[start[0]][start[1]];
                    int val = field[arr[0]][arr[1]];
                    if(val == 0){ // Учитываем только непосещенные клетки
                        if(cell == -1){
                            cell = 0;
                        }
                        cell += 1;
                        field[arr[0]][arr[1]] = cell;
                        queue.addLast(arr);
                    }else if(val == -2){ // Если кони встретились
                        stop = true;
                        step = cell + 1;
                        break;
                    }
                }
                queue.removeFirst(); // Удаляем проверенный элемент
            }
        }else {
            step = 0;
        }

        FileWriter out = new FileWriter("knight.out"); // Выводим результат
        out.write(String.valueOf(step));
        out.close();
    }
}