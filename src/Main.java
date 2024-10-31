import main.java.org.os.LsCommand;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        LsCommand.execute(new String[]{"ls", "*"});



    }
}

//return type
//ls -r
//ls -r *
//pwd in the root will it bring root or cd
//touch
//> overwrites