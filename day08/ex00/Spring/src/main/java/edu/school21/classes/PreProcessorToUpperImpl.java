package edu.school21.classes;

import edu.school21.interfaces.PreProcessor;

public class PreProcessorToUpperImpl implements PreProcessor {

    @Override
    public String preProcess(String str) {
        return str.toUpperCase();
    }
}
