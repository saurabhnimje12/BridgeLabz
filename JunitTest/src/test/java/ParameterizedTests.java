import org.example.Population;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParameterizedTests {
    Population population = new Population();
    @ParameterizedTest
    @ValueSource(strings = {"Pune", "Bangalore"})
    public void parameterizedTests(String city) {
        int count = population.getPopul(city);
        assertNotNull(count, "Population count should not be null");
        assertTrue(count > 0, "Population should be greater than 0");
    }
}
