package main.java.org.os;

import java.util.Arrays;

public class CommandHandler {

    public void executeCommand(String input) {
        // Check for piping
        if (input.contains("|")) {
            PipeHandler.handlePipe(input);
            return;  // Exit early to avoid further processing
        }

        // Check for redirection
        if (input.contains(">") || input.contains(">>")) {
            RedirectionHandler.handleRedirection(input);
            return;  // Exit early to avoid further processing
        }

        String[] tokens = input.split("\\s+");
        String command = tokens[0];

        switch (command) {
            case "pwd":
                PwdCommand.execute();
                break;

            case "mkdir":
                if (tokens.length > 1) {
                    String[] dirNames = new String[tokens.length - 1];
                    System.arraycopy(tokens, 1, dirNames, 0, tokens.length - 1);
                    MkdirCommand.execute(dirNames);
                } else {
                    System.out.println("mkdir: missing operand");
                }
                break;

            case "rmdir":
                if (tokens.length > 1) {
                    RmdirCommand.execute(tokens[1]);
                } else {
                    System.out.println("rmdir: missing operand");
                }
                break;

            case "ls":
                LsCommand.execute(tokens);
                break;

            case "mv":
                if (tokens.length > 2) {
                    String[] sources = Arrays.copyOfRange(tokens, 1, tokens.length);
                    MvCommand.execute(sources);
                } else {
                    System.out.println("mv: missing operand");
                }
                break;

            case "rm":
                if (tokens.length > 1) {
                    RmCommand.execute(tokens[1]);
                } else {
                    System.out.println("rm: missing operand");
                }
                break;

            case "touch":
                if (tokens.length > 1) {
                    TouchCommand.execute(tokens[1]);
                } else {
                    System.out.println("touch: missing operand");
                }
                break;

            case "cat":
                if (tokens.length > 1) {
                    org.os.CatCommand.execute(tokens[1]);
                } else {
                    System.out.println("cat: missing operand");
                }
                break;
            case "cd":
                if (tokens.length > 1) {
                    CDCommand.execute(tokens[1]);
                } else {
                    System.out.println("cd: missing operand");
                }
                break;
            case "help":
                HelpCommand.execute();
            break;

            default:
                System.out.println("Unknown command: " + command);
        }
    }
}
