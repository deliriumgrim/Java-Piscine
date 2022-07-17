package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class ParseImage {

    private char black;

    private char white;

    public ParseImage(char black, char white) {
        this.black = black;
        this.white = white;
    }

    public String[] unparsedArray() throws IOException {
        InputStream inputStream = ParseImage.class.getResourceAsStream("/resources/it.bmp");
        BufferedImage bmpImage = ImageIO.read(inputStream);
        char [][] unparsedChars = new char[bmpImage.getHeight()][bmpImage.getWidth()];
        String[] unpairedString = new String[bmpImage.getHeight()];
        for (int i = 0; i < bmpImage.getHeight(); i++) {
            for (int j = 0; j < bmpImage.getWidth(); j++) {
                int color = bmpImage.getRGB(j, i);
                if (color == Color.BLACK.getRGB()) {
                    unparsedChars[i][j] = black;
                } else {
                    unparsedChars[i][j] = white;
                }
            }
            unpairedString[i] = new String(unparsedChars[i]);
        }
        inputStream.close();
        return unpairedString;
    }
}
