import org.example.UserHandleException;
import org.example.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRegistrationTest {
    UserServiceImpl usi;

    @BeforeEach
    public void init() {
        usi = new UserServiceImpl();
    }

    @Test
    public void checkFirstNameHappyTest() {
        assertTrue(usi.checkFirstName.checkValidation("Joh"));
    }

    @Test
    public void checkFirstNameSadTest() {
        assertThrows(UserHandleException.class, () -> usi.checkFirstName.checkValidation("joh"));
    }

    @Test
    public void checkLastNameHappyTest() {
        assertTrue(usi.checkLastName.checkValidation("Roy"));
    }

    @Test
    public void checkLastNameSadTest() {
        assertThrows(UserHandleException.class, () -> usi.checkLastName.checkValidation("roy"));
    }

    @Test
    public void checkEmailHappyTest() {
        assertTrue(usi.checkEmail.checkValidation("john@gmail.com"));
    }

    @Test
    public void checkEmailSadTest() {
        assertThrows(UserHandleException.class, () -> usi.checkEmail.checkValidation("john@"));
    }

    @Test
    public void checkPhnoHappyTest() {
        assertTrue(usi.checkPhno.checkValidation("9919819801"));
    }

    @Test
    public void checkPhnoSadTest() {
        assertThrows(UserHandleException.class, () -> usi.checkPhno.checkValidation("991981980"));
    }

    @Test
    public void checkPazzwordHappyTest() {
        assertTrue(usi.checkPazzword.checkValidation("John@123"));
    }

    @Test
    public void checkPazzwordSadTest() {
        assertThrows(UserHandleException.class, () -> usi.checkPazzword.checkValidation("john@123"));
    }

}
