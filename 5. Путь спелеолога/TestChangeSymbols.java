import junit.framework.*;
import java.util.ArrayList;
public class TestChangeSymbols extends TestCase{
    public void testChangeSymbols(){
        ArrayList testIn = new ArrayList();
        ArrayList testOut = new ArrayList();
        // Входные данные
        String[] stringArrIn = {"3","###","###",".##",".#.",".#S",".#.","###","...","###"};
        int number = 3;
        for(String line : stringArrIn){
            testIn.add(line);
        }
        // Выходыне данные
        int[] intArrOut = {-2, -2, -2, -2, -2, -2, -1, -2, -2, -1, -2, -1, -1, -2, 0, -1, -2, -1, -2, -2, -2, -1, -1, -1, -2, -2, -2};
        for(Integer line : intArrOut){
            testOut.add(line);
        }
        assertEquals("Неверная замена символов", testOut, Task.changeSymbols(testIn, number));
    }
}