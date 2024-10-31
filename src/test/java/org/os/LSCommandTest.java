package test.java.org.os;

import main.java.org.os.LsCommand;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class LSCommandTest {

//    captures the result of the command in a variable instead of printing into the console
    private String captureOutput(Runnable command) {
//    the variable that stores the result of the output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));
        command.run();
        System.setOut(originalOut);
        return out.toString();
    }

    @Test
    public void ls() {
//        LsCommand.execute(new String[]{"ls", "*"});
        String output = captureOutput(() -> LsCommand.execute(new String[]{"ls", "*"}));
        assertTrue(output.contains("OS_ASSIG.iml"));
        assertTrue(output.contains("pom.xml"));
        assertTrue(output.contains("src"));
    }

    @Test
    public void lsMagicCard() {
//        LsCommand.execute(new String[]{"ls", "*.xml"});
        String output = captureOutput(() -> LsCommand.execute(new String[]{"ls", "*.xml"}));
        assertTrue(output.contains(".xml")); // Example XML file in the directory
        assertTrue(!output.contains(".txt")); // Ensure it excludes non-XML files
    }

    @Test
    public void lsRelativePath() {
//        LsCommand.execute(new String[]{"ls", "../"});
        String output = captureOutput(() -> LsCommand.execute(new String[]{"ls", "../"}));
        assertTrue(output.contains("parentDirectoryFile.txt"));
    }

    @Test
    public void lsRelativePath2() {
//        LsCommand.execute(new String[]{"ls", "../../"});
        String output = captureOutput(() -> LsCommand.execute(new String[]{"ls", "../../"}));
        assertTrue(output.contains("rootFile.txt"));
    }

    @Test
    public void lsRelativePath3() {
        LsCommand.execute(new String[]{"ls", "../"});
    }
}

//make the tests more general, dont give hard coded values of the expected output