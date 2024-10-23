import org.example.UserHandleException;
import org.example.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserParameterisedTest {
    UserServiceImpl usi;

    @BeforeEach
    public void init() {
        usi = new UserServiceImpl();
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc@yahoo.com", "abc-100@yahoo.com", "abc.100@yahoo.com", "abc111@abc.com", "abc-100@abc.net", "abc.100@abc.com.au", "abc@1.com", "abc@gmail.com.com", "abc+100@gmail.com"})
    public void checkAllEmaillHappyTest(String email) {
        assertTrue(usi.checkEmail.checkValidation(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", ".abc@.com.my", "abc123@gmail.a", "abc123@.com", ".abc123@.com.com", ".abc@abc.com", "abc()*@gmail.com", "abc@%*.com", "abc..2002@gmail.com", "abc.@gmail.com", "abc@abc@gmail.com", "abc@gmail.com.1a", "abc@gmail.com.aa.au"})
    public void checkAllEmaillSadTest(String email) {
        assertThrows(UserHandleException.class, () -> usi.checkAllEmail.checkValidation(email));
    }
}
