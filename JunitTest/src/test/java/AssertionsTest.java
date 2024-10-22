import org.example.Population;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AssertionsTest {
    Population population;

    @BeforeEach
    public void beforeEach() {
        population = new Population();
    }

    @Test
    public void assertEqualsTest() {
        int expected = 7;
        int result = 4 + 3;
        assertEquals(expected, result);
    }

    @Test
    public void assertNotEqualsTest() {
        int expected = 5;
        int result = 4 + 3;
        assertNotEquals(expected, result);
    }

    @Test
    public void assertTrueTest() {
        int num = 8;
        //    assertTrue(true);
    }

    @Test
    public void findPopulation() {
        String city = "Mumbai";
        int expectedPopulation = 35000;
        int count = population.getPopulation(city);
        assertEquals(expectedPopulation, count);
    }

    @Test
    public void findPopulationCount() {
        String city = "Delhi";
        int expectedPopulation = 30000;
        int count = population.getPopulation(city);
        assertEquals(expectedPopulation, count);
    }
}
