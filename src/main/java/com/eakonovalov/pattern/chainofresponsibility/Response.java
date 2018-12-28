package com.eakonovalov.pattern.chainofresponsibility;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Waine
 * @version 1.0
 * @created 08-Feb-2017 18:52:22
 */
public class Response {

    private Map<Integer, Integer> banknotes = new LinkedHashMap<>();

    public Map<Integer, Integer> getBanknotes() {
        return banknotes;
    }

    /**
     * @param banknotes
     */
    public void setBanknotes(Map<Integer, Integer> banknotes) {
        this.banknotes = banknotes;
    }

}
