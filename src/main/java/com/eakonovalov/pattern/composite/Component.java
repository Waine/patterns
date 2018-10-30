package com.eakonovalov.pattern.composite;


/**
 * @author Waine
 * @version 1.0
 * @created 09-Feb-2017 21:16:14
 */
public abstract class Component {

    private boolean visible = true;
    private Component parent;

    /**
     * @param c
     */
    public void add(Component c) {
        throw new UnsupportedOperationException("add");
    }

    /**
     * @param index
     */
    public Component getChild(int index) {
        throw new UnsupportedOperationException("getChild");
    }

    /**
     * @param c
     */
    public Component remove(Component c) {
        throw new UnsupportedOperationException("remove");
    }

    public void show() {
        if (parent != null && parent.isVisible()) setVisible(true);
    }

    public void hide() {
        setVisible(false);
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Component getParent() {
        return parent;
    }

    public void setParent(Component parent) {
        this.parent = parent;
    }

}
