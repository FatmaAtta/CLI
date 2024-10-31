package test.java.org.os;

import main.java.org.os.PwdCommand;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PwdCommandTest {

    @Test
    void testPwdCommand() {
        String expectedDir = System.getProperty("user.dir");
        assertEquals(expectedDir, PwdCommand.getCurrentDirectory());
    }
}
