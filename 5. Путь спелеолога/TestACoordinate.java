import junit.framework.*;
import java.util.ArrayList;
import java.util.Arrays;
public class TestACoordinate extends TestCase {
    public void testACoordinate(){
        ArrayList<Integer> testIn = new ArrayList<>(Arrays.asList(1,1,2));
        ArrayList<Integer> testArrIn = new ArrayList<Integer>();
        ArrayList<Integer> testArrOut = new ArrayList<>(Arrays.asList(2,1,2,0,1,2));
        int number = 3;
        int a = testIn.get(0);
        int b = testIn.get(1);
        int c = testIn.get(2);;
        if(a+1 < number){
            a++;
            testArrIn.add(a);
            testArrIn.add(b);
            testArrIn.add(c);
            a--;
        }
        if(a-1 >=0){
            a--;
            testArrIn.add(a);
            testArrIn.add(b);
            testArrIn.add(c);
        }
      assertEquals("Координата 1 точки определена неверно", testArrIn, testArrOut);
    }
}

