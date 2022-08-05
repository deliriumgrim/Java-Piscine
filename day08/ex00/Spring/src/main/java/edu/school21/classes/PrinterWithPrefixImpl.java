package edu.school21.classes;

import edu.school21.interfaces.Printer;
import edu.school21.interfaces.Renderer;

public class PrinterWithPrefixImpl implements Printer {

    private Renderer renderer;

    private String prefix;

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public PrinterWithPrefixImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void print(String str) {
        renderer.render(prefix + " " + str);
    }
}
