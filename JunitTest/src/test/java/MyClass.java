import org.junit.jupiter.api.*;

public class MyClass {

    @Test
    public void test() {
        System.out.println("Hello World!");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("===== BeforeEach =====");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("===== AfterEach =====");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("===== Before All =====");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("===== After All =====");
    }

    @Disabled
    public void disabled() {
        System.out.println("===== Disabled =====");
    }


    public void tag() {
        System.out.println("===== Tag =====");
    }

}
