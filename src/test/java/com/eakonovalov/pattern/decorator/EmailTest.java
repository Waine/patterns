package com.eakonovalov.pattern.decorator;

import com.eakonovalov.pattern.decorator.impl.Disclaimer;
import com.eakonovalov.pattern.decorator.impl.Signature;
import com.eakonovalov.pattern.decorator.impl.TextEmail;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Waine on 10.02.2017.
 */
public class EmailTest {

    @Test
    public void test() throws Exception {
        Email email = new TextEmail("Subject", "Content");
        assertEquals("Content", email.getContent());
        email = new Signature(email);
        assertEquals("Content\nSignature", email.getContent());
        email = new Disclaimer(email);
        assertEquals("Content\nSignature\nDisclaimer", email.getContent());
    }

}
