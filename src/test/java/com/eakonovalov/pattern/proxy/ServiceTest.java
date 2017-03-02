package com.eakonovalov.pattern.proxy;

import com.eakonovalov.pattern.proxy.impl.SecurityProxy;
import com.eakonovalov.pattern.proxy.impl.ServiceImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Waine on 22.02.2017.
 */
public class ServiceTest {

    @Test
    public void testGenerate() throws Exception {
        Service service = new ServiceImpl();
        assertEquals("Hello world!", service.generate());
    }

    @Test
    public void testGenerateSecure() throws Exception {
        Service service = new SecurityProxy(new ServiceImpl());
        assertEquals("Hello secure world!", service.generate());
    }

}
