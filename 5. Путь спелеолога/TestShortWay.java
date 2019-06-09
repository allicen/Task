import junit.framework.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class TestShortWay extends TestCase {
    public void testShortWay(){
        ArrayList testIn = new ArrayList(Arrays.asList(4,5,6,3,2,4,100,1));
        int min = 1;
        Collections.sort(testIn);
        assertEquals("Неверный расчет минимального пути", testIn.get(0), min);
    }
}

