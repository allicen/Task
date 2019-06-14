import junit.framework.TestCase;
import org.junit.Test;

public class TestArraySortSort extends TestCase{
    @Test
    public void testArraySortSort(){
            double[] a = {5, 6, 3, 5.5, 10.7};
            int j = a.length;
            for(int i = 0; i < a.length; i++){
                    j = i;
                    j--;
                assertTrue("Тест 4. Ошибка в сортировке массива", i - 1 == j);
            }
    }
}
