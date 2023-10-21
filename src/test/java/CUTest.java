import org.example.CU;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CUTest {
    private CU cu;

    @BeforeEach
    public void setUp() {
        cu = new CU("QS", 3);
    }

    @ParameterizedTest
    @CsvSource({
            "44123, 9.0",
            "44234, 8.5",
            "44345, 10.0",
    })
    public void testInsertMarkCU(int numStudent, double mark) {
        cu.insertMarkCU(numStudent, mark);
        assertEquals(mark, cu.searchStudent(numStudent));
    }

    @ParameterizedTest
    @CsvSource({
            "44123, 9.0, false",
            "44234, 8.5, false",
            "44345, 10.0, true",
    })
    public void testIsApproved(int numStudent, double mark, boolean expected) {
        cu.insertMarkCU(numStudent, mark);
        assertEquals(expected, cu.isApproved(numStudent));
    }

    @Test
    public void testAverageCU() {
        cu.insertMarkCU(44123, 9.0);
        cu.insertMarkCU(44234, 8.5);
        cu.insertMarkCU(44345, 10.0);

        double expectedAverage = (9.0 + 8.5 + 10.0) / 3;

        assertEquals(expectedAverage, cu.averageCU(), 0.01);
    }
}
