package com.eakonovalov.pattern.flyweight;

import java.io.InputStream;

/**
 * Created by Waine on 16.02.2017.
 */
public interface InputStreamListener {

    void onReceived(InputStream is, int len);

}
