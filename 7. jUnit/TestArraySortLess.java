import junit.framework.*;
public class TestArraySortLess extends TestCase{
    public void testArraySortLess(){
        double[][] number = {{0.1, 0.2}, {2.4, 3.6}, {6.0, 4000.015487}};
        for (int i = 0; i < number.length; i++) {
            assertEquals("Тест 1. Ошибка, неправильно сортируем", true, ((number[i][0] < number[i][1]) && (ArraySort.less(number[i][0], number[i][1]))));
        }
    }
}
