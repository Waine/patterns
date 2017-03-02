package com.eakonovalov.pattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Waine
 * @version 1.0
 * @created 09-���-2017 21:16:15
 */
public class Container extends Component {

    private List<Component> children = new ArrayList<>();

    /**
     * @param c
     */
    public void add(Component c) {
        if (!children.contains(c)) children.add(c);
        c.setParent(this);
    }

    /**
     * @param index
     */
    public Component getChild(int index) {
        return children.get(index);
    }

    /**
     * @param c
     */
    public Component remove(Component c) {
        if (children.remove(c)) {
            c.setParent(null);
            return c;
        }

        return null;
    }

    public void show() {
        setVisible(true);
        children.forEach(Component::show);
    }

    public void hide() {
        setVisible(false);
        children.forEach(Component::hide);
    }

}
