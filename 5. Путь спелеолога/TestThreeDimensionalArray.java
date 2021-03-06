import junit.framework.*;
import java.util.ArrayList;
import java.util.Arrays;
public class TestThreeDimensionalArray extends TestCase{
    public void testChangeSymbols(){
        // Входные данные
        ArrayList<Integer> testIn = new ArrayList<Integer>();
        int number = 3;
        int[][][] arrTest = new int[][][]{{{-2, -2, -2}, {-2, -2, -2}, {-1, -2, -2}}, {{-1, -2, -1}, {-1, -2, 0}, {-1, -2, -1}}, {{-2, -2, -2}, {-1, -1, -1}, {-2, -2, -2}}};
        int[] intArrOut = {-2, -2, -2, -2, -2, -2, -1, -2, -2, -1, -2, -1, -1, -2, 0, -1, -2, -1, -2, -2, -2, -1, -1, -1, -2, -2, -2};
        for(Integer line : intArrOut){
            testIn.add(line);
        }
        // Выходные данные
        ArrayList<Integer> testOut = new ArrayList<>(Arrays.asList(1,1,2));
        assertEquals("Начальная точка обхода графа определена неверно", testOut, Task.threeDimensionalArray(arrTest, number, testIn));
    }
}
