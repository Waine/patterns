package com.eakonovalov.pattern.decorator.impl;

import com.eakonovalov.pattern.decorator.Email;

/**
 * @author Waine
 * @version 1.0
 * @created 10-Feb-2017 19:50:37
 */
public class Signature extends AbstractDecorator {

    public Signature(Email email) {
        super(email);
    }

    public String getContent() {
        return email.getContent() + "\n" + "Signature";
    }

    public String getSubject() {
        return email.getSubject();
    }

}
