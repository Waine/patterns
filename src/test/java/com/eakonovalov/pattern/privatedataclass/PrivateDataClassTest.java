package com.eakonovalov.pattern.privatedataclass;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Waine on 22.02.2017.
 */
public class PrivateDataClassTest {

    @Test
    public void test() throws Exception {
        ExposesInternalState exposes = new ExposesInternalState("Hello", "world!");
        HidesInternalState hides = new HidesInternalState("Hello", "world!");

        assertEquals(exposes.concat(), hides.concat());
    }

}