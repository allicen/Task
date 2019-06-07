import junit.framework.*;
public class NumberTest extends TestCase{
    public void testNumberTest(){
        int[][] cases = {{3,153}, {3,407}, {4,1634}};
        for(int i = 0; i < cases.length; i++) {
            assertEquals("Неверное число Армстронга", cases[i][0], Number.armstrong(cases[i][1]));
        }
    }
}