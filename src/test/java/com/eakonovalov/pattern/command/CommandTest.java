package com.eakonovalov.pattern.command;

import com.eakonovalov.pattern.command.impl.Light;
import com.eakonovalov.pattern.command.impl.Radio;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Waine on 09.02.2017.
 */
public class CommandTest {

    @Test
    public void execute() {

        RemoteControl rc = new RemoteControl();
        Radio radio = new Radio();
        rc.setDevice(radio);

        assertTrue(!radio.isOn());
        rc.execute(new OnCommand());
        assertTrue(radio.isOn());
        rc.execute(new OffCommand());
        assertTrue(!radio.isOn());

        Light light = new Light();
        rc.setDevice(light);

        rc.execute(new OnCommand());
        assertTrue(!radio.isOn());
        assertTrue(light.isOn());

    }

}