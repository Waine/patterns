package com.eakonovalov.pattern.decorator.impl;

import com.eakonovalov.pattern.decorator.Email;

/**
 * @author Waine
 * @version 1.0
 * @created 10-���-2017 19:50:29
 */
public class Disclaimer extends AbstractDecorator {

    public Disclaimer(Email email) {
        super(email);
    }

    public String getContent() {
        return email.getContent() + "\n" + "Disclaimer";
    }

    public String getSubject() {
        return email.getSubject();
    }

}
