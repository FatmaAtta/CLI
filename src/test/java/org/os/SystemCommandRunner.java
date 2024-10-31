package test.java.org.os;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.assertTrue;

public class SystemCommandRunner {
    public static String runCommand(String command) throws IOException, InterruptedException {
        if (command.equals("ls")) {
            command = "dir";
        }
        else if (command.equals("mv")) {
            command = "move";
            String command2 = "ren";
        }
        ProcessBuilder builder = new ProcessBuilder();
        builder.command("cmd.exe", "/c", command); //runs the command on cmd
        Process process = builder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while((line = reader.readLine())!=null){
            output.append(line).append("\n");
        }
        process.waitFor();
        return output.toString();
    }

    @Test
    public void testLS() throws IOException, InterruptedException {
        String command = "dir";
        String output = SystemCommandRunner.runCommand(command);
        assertTrue(output.contains("src"));
    }
}
