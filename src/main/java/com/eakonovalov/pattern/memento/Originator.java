package com.eakonovalov.pattern.memento;

/**
 * @author Waine
 * @version 1.0
 * @created 20-���-2017 10:39:00
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
        return new MementoImpl(new StringBuilder(this.content));
    }

    public void restore(Memento memento) {
        MementoImpl internal = (MementoImpl) memento;
        this.content = internal.content;
    }

    private class MementoImpl implements Memento {

        private StringBuilder content;

        public MementoImpl(StringBuilder content) {
            this.content = content;
        }
    }

}
