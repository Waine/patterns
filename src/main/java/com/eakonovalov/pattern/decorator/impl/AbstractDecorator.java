package com.eakonovalov.pattern.decorator.impl;

import com.eakonovalov.pattern.decorator.Email;

/**
 * Created by Waine on 10.02.2017.
 */
public abstract class AbstractDecorator implements Email {

    protected Email email;

    public AbstractDecorator(Email email) {
        this.email = email;
    }

}
