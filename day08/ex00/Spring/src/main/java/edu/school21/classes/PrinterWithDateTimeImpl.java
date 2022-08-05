package edu.school21.classes;

import edu.school21.interfaces.Printer;
import edu.school21.interfaces.Renderer;

import java.time.LocalDateTime;

public class PrinterWithDateTimeImpl implements Printer {

    private Renderer renderer;

    public PrinterWithDateTimeImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void print(String str) {
        LocalDateTime dateTime = LocalDateTime.now();
        renderer.render(dateTime.toString() + " " + str);
    }
}
