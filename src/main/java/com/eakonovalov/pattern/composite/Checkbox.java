package com.eakonovalov.pattern.composite;


/**
 * @author Waine
 * @version 1.0
 * @created 09-���-2017 21:16:12
 */
public class Checkbox extends Component {

    private boolean checked;

    public boolean isChecked() {
        return checked;
    }

    /**
     * @param checked
     */
    public void setChecked(boolean checked) {
        this.checked = checked;
    }

}
