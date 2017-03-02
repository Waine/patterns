package com.eakonovalov.pattern.abstractfactory;

import com.eakonovalov.pattern.abstractfactory.impl.ButtonImpl;
import com.eakonovalov.pattern.abstractfactory.impl.FlatMenu;
import com.eakonovalov.pattern.abstractfactory.impl.material.MaterialButton;
import com.eakonovalov.pattern.abstractfactory.impl.material.MaterialUI;
import com.eakonovalov.pattern.abstractfactory.impl.material.MultiLevelMenu;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

/**
 * Created by Waine on 02.02.2017.
 */
public class AbstractFactoryTest {

    @Test
    public void test() throws Exception {
        UI ui = UI.getInstance();
        assertThat(ui.createButton(), instanceOf(ButtonImpl.class));
        assertThat(ui.createMenu(), instanceOf(FlatMenu.class));

        UI.UI_CLASS_NAME = MaterialUI.class.getName();
        ui = UI.getInstance();
        assertThat(ui.createButton(), instanceOf(MaterialButton.class));
        assertThat(ui.createMenu(), instanceOf(MultiLevelMenu.class));
    }

}
