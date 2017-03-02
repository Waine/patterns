package com.eakonovalov.pattern.flyweight;

import java.io.InputStream;

/**
 * Created by Waine on 15.02.2017.
 */
public interface ProcessingThreadListener {

    void onFinish(InputStream is, ProcessingThread t);

    void onEOF(InputStream is, ProcessingThread t);

}
