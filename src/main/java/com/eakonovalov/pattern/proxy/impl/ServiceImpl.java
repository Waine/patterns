package com.eakonovalov.pattern.proxy.impl;

import com.eakonovalov.pattern.proxy.Service;

/**
 * @author Waine
 * @version 1.0
 * @created 22-Feb-2017 20:40:09
 */
public class ServiceImpl implements Service {

    public String generate() {
        return "Hello world!";
    }

}
