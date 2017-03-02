package com.eakonovalov.pattern.nullobject;

import org.junit.Test;

/**
 * Created by Waine on 16.02.2017.
 */
public class ClientTest {
    @Test
    public void testPrintNulls() throws Exception {
        Client c = new Client();
        c.setName("John Doe");
        printNull(c);

        c.setAddress(NullAddress.INSTANCE);
        printNullObject(c);
    }

    private void printNull(Client c) {
        System.out.println(c.getName());
        System.out.println(c.getAddress() != null ? c.getAddress().getStreet() : "");
        System.out.println(c.getAddress() != null ? c.getAddress().getCity() : "");
        System.out.println(c.getAddress() != null ? c.getAddress().getCountry() : "");
        System.out.println(c.getAddress() != null ? c.getAddress().getZip() : "");
    }

    private void printNullObject(Client c) {
        System.out.println(c.getName());
        System.out.println(c.getAddress().getStreet());
        System.out.println(c.getAddress().getCity());
        System.out.println(c.getAddress().getCountry());
        System.out.println(c.getAddress().getZip());
    }

}
