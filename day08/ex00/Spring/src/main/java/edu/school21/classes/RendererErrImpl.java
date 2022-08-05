package edu.school21.classes;

import edu.school21.interfaces.PreProcessor;
import edu.school21.interfaces.Renderer;

public class RendererErrImpl implements Renderer {

    private PreProcessor preProcessor;

    public RendererErrImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void render(String str) {
        System.err.println(preProcessor.preProcess(str));
    }
}
