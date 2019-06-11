import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;
public class TestRunAll extends TestCase{
    @Test
    public static TestSuite suite(){
        TestSuite totalSuite = new TestSuite("Все тесты для программы");
        totalSuite.addTestSuite(TestChangeSymbols.class);
        totalSuite.addTestSuite(TestThreeDimensionalArray.class);
        totalSuite.addTestSuite(TestACoordinate.class);
        totalSuite.addTestSuite(TestShortWay.class);
        return totalSuite;
    }
}