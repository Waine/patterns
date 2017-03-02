package com.eakonovalov.pattern.proxy.impl;

import com.eakonovalov.pattern.proxy.Service;

/**
 * @author Waine
 * @version 1.0
 * @created 22-���-2017 20:40:29
 */
public class SecurityProxy implements Service {

    private Service service;

    public SecurityProxy(Service service) {
        this.service = service;
    }

    public String generate() {
        String result = service.generate();
        int index = result.indexOf(" ");
        return result.substring(0, index) + " secure" + result.substring(index);
    }

}
