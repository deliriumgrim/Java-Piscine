package edu.school21.classes;

import edu.school21.interfaces.PreProcessor;
import edu.school21.interfaces.Renderer;

public class RendererStandardImpl implements Renderer {

    private PreProcessor preProcessor;

    public RendererStandardImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void render(String str) {
        System.out.println(preProcessor.preProcess(str));
    }
}
