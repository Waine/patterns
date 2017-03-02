package com.eakonovalov.pattern.abstractfactory.impl.material;

import com.eakonovalov.pattern.abstractfactory.Button;
import com.eakonovalov.pattern.abstractfactory.Menu;
import com.eakonovalov.pattern.abstractfactory.UI;

/**
 * @author Waine
 * @version 1.0
 * @created 02-���-2017 16:34:59
 */
public class MaterialUI extends UI {

    public Button createButton() {
        return new MaterialButton();
    }

    public Menu createMenu() {
        return new MultiLevelMenu();
    }

}