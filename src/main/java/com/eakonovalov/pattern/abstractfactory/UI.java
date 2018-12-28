package com.eakonovalov.pattern.abstractfactory;

import com.eakonovalov.pattern.abstractfactory.impl.BasicUI;
import com.eakonovalov.pattern.abstractfactory.impl.material.MaterialUI;

/**
 * @author Waine
 * @version 1.0
 * @created 02-Feb-2017 16:10:38
 */
public abstract class UI {

    public static String UI_CLASS_NAME;

    static {
        UI_CLASS_NAME = BasicUI.class.getName();
    }

    public static UI getInstance() {
        if (MaterialUI.class.getName().equals(UI_CLASS_NAME)) return new MaterialUI();
        return new BasicUI();
    }

    public abstract Button createButton();

    public abstract Menu createMenu();

}
