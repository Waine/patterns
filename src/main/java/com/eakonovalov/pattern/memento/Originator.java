package com.eakonovalov.pattern.memento;

/**
 * @author Waine
 * @version 1.0
 * @created 20-Feb-2017 10:39:00
 */
public class Originator {

    private StringBuilder content = new StringBuilder();
    private String fileName;

    public StringBuilder getContent() {
        return content;
    }

    /**
     * @param newVal
     */
    public void setContent(StringBuilder newVal) {
        content = newVal;
    }

    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return this.content.toString();
    }

    public Memento save() {
        return new MementoImpl(this.content.toString());
    }

    public void restore(Memento memento) {
        MementoImpl internal = (MementoImpl) memento;
        this.content = new StringBuilder(internal.content);
    }

    private class MementoImpl implements Memento {

        private String content;

        public MementoImpl(String content) {
            this.content = content;
        }
    }

}
