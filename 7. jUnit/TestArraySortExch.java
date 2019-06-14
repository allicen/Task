import junit.framework.TestCase;
import org.junit.Test;

public class TestArraySortExch extends TestCase{
    @Test
    public void testArraySortExch(){
        double[] a = {3, 5, 9.4};
        double[] j = {2, 7, 29};
        int index = 0;
        for(int i = 0; i < a.length; i++){
            double elOne = a[i];
            double elTwo = j[i];
            double t = a[i]; a[i] = j[i]; j[i] = t;
            assertTrue("Тест 2. Ошибка, элементы не меняются", elOne == j[i] && elTwo == a[i]);
        }
    }
}
