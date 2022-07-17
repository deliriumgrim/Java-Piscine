package edu.school21.printer.app;

import edu.school21.printer.logic.ParseImage;

import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        if (args.length != 3 || args[0].length() != 1 || args[1].length() != 1) {
            System.out.println("Wrong arguments");
            System.exit(-1);
        }
        char black = args[0].charAt(0);
        char white = args[1].charAt(0);
        String path = args[2];

        ParseImage parseImage = new ParseImage(black, white, path);
        String[] imageToTerminal = null;
        imageToTerminal = parseImage.unparsedArray();
        if (imageToTerminal != null) {
            for (String s : imageToTerminal) {
                System.out.println(s);
            }
        }
    }
}
