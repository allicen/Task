import junit.framework.TestCase;
import org.junit.Test;

public class TestArraySortCompExch extends TestCase{
    @Test
    public void testArraySortCompExch(){
         double[] array = {1, 4, 3.4, 8.5, 6, 20};
         int j = 0;
            for(int i = 0; i < array.length; i++){
                j = j+1;
                double a = 0;
                if(j < array.length){
                     if(array[i] > array[j]) {
                         a = array[i];
                         array[i] = array[j];
                         array[j] = a;
                     }
                    assertTrue("Тест 3. Ошибка, массив не сортируется", array[i] <= array[j]);
                }
            }
        }
}
