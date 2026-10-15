import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/**
 * Starter JUnit 5 test class for GradeBook.
 * 
 * TODO for students:
 *  - Complete the test methods using appropriate assertions.
 *  - Add any additional tests you think are necessary.
 */
public class GradeBookTest {

    // Test fixtures: shared objects used in multiple tests
    private GradeBook g1;
    private GradeBook g2;

    /**
     * setUp runs BEFORE each @Test method.
     * Use it to create fresh GradeBook objects for every test.
     */
    @BeforeEach
    public void setUp() {
        // TODO: initialize g1 and g2 with capacity 5
        // and add several scores to each using addScore

        g1 = new GradeBook(7);
        g2 = new GradeBook(4);

        g1.addScore(22.0);
        g1.addScore(55.3);
        g1.addScore(77.99);
        g1.addScore(100.0);
        g1.addScore(55.6);
        g1.addScore(0.0);
        g1.addScore(66.7);

        g2.addScore(18.0);
        g2.addScore(9.3);
        g2.addScore(8.6);
        g2.addScore(0.1);
    }

    /**
     * tearDown runs AFTER each @Test method.
     * Use it to clean up any objects if needed.
     */
    @AfterEach
    public void tearDown() {
        g1 = null;
        g2 = null;
    }

    /**
     * Test addScore and toString.
     * 
     * Goal:
     *  - Verify that the scores are stored correctly.
     *  - Verify that toString returns the expected string
     *    (each score followed by a space, in the order added).
     */
    @Test
    public void testAddScoreAndToString() {
        assertEquals("22.0 55.3 77.99 100.0 55.6 0.0 66.7 ", g1.toString());
        assertEquals("18.0 9.3 8.6 0.1 ", g2.toString());
    }

    /**
     * Test getScoreSize.
     * 
     * Goal:
     *  - Verify that getScoreSize returns the number of scores
     *    actually added to each GradeBook.
     */
    @Test
    public void testGetScoreSize() {
        assertEquals(7, g1.getScoreSize());
        assertEquals(4, g2.getScoreSize());
    }

    /**
     * Test sum.
     * 
     * Goal:
     *  - Verify that sum() returns the correct total of all scores.
     */
    @Test
    public void testSum() {
        assertEquals(377.59, g1.sum(), 0.0001);
        assertEquals(36.0, g2.sum(), 0.0001);
    }

    /**
     * Test minimum.
     * 
     * Goal:
     *  - Verify that minimum() returns the smallest score.
     *  - Optionally test behavior when there are no scores.
     */
    @Test
    public void testMinimum() {
        assertEquals(0.0, g1.minimum(), 0.0001);
        assertEquals(0.1, g2.minimum(), 0.0001);
    }

    /**
     * Test finalScore.
     * 
     * Goal:
     *  - Verify that finalScore() drops the lowest score
     *    when there are at least two scores.
     *  - Verify behavior when there is exactly one score
     *    and when there are no scores.
     */
    @Test
    public void testFinalScore() {
        assertEquals(377.59, g1.finalScore(), 0.0001);
        assertEquals(35.9, g2.finalScore(), 0.0001);

        GradeBook empty = new GradeBook(2);
        assertEquals(0.0, empty.finalScore(), 0.0001);

        GradeBook single = new GradeBook(7);
        single.addScore(77.7);
        assertEquals(77.7, single.finalScore(), 0.0001);
    }
}
