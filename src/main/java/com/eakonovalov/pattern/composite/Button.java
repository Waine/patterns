package com.eakonovalov.pattern.composite;


/**
 * @author Waine
 * @version 1.0
 * @created 09-Feb-2017 21:16:11
 */
public class Button extends Component {

    private String caption;

    public String getCaption() {
        return caption;
    }

    /**
     * @param caption
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }

}
