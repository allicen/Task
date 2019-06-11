import junit.framework.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TestChangeSymbols extends TestCase{
    public void testChangeSymbols(){
        ArrayList<Integer> testOut = new ArrayList<>();
        // Входные данные
        String[] stringArrIn = {"3","###","###",".##",".#.",".#S",".#.","###","...","###"};
        int number = 3;
        ArrayList<String> testIn = new ArrayList<String>(Arrays.asList(stringArrIn));
        // Выходыне данные
        int[] intArrOut = {-2, -2, -2, -2, -2, -2, -1, -2, -2, -1, -2, -1, -1, -2, 0, -1, -2, -1, -2, -2, -2, -1, -1, -1, -2, -2, -2};
        for(Integer line : intArrOut){
            testOut.add(line);
        }
        assertEquals("Неверная замена символов", testOut, Task.changeSymbols(testIn, number));
    }
}

