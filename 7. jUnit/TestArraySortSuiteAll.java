import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;

public class TestArraySortSuiteAll extends TestCase{
    @Test
    public static TestSuite suite() {
        TestSuite totalSuite = new TestSuite("Все тесты для класса ArraySort");
        totalSuite.addTestSuite(TestArraySortLess.class);
        totalSuite.addTestSuite(TestArraySortExch.class);
        totalSuite.addTestSuite(TestArraySortCompExch.class);
        totalSuite.addTestSuite(TestArraySortSort.class);
        return totalSuite;
    }
}
