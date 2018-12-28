package com.eakonovalov.pattern.composite;


/**
 * @author Waine
 * @version 1.0
 * @created 09-Feb-2017 21:16:17
 */
public class Label extends Component {

    private String text;

    public String getText() {
        return text;
    }

    /**
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

}
