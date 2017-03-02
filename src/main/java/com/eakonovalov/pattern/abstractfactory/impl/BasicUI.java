package com.eakonovalov.pattern.abstractfactory.impl;

import com.eakonovalov.pattern.abstractfactory.Button;
import com.eakonovalov.pattern.abstractfactory.Menu;
import com.eakonovalov.pattern.abstractfactory.UI;

/**
 * @author Waine
 * @version 1.0
 * @created 02-���-2017 16:34:20
 */
public class BasicUI extends UI {

    public Button createButton() {
        return new ButtonImpl();
    }

    public Menu createMenu() {
        return new FlatMenu();
    }

}
