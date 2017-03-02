package com.eakonovalov.pattern.templatemethod;

/**
 * Created by Waine on 27.02.2017.
 */
public class WorkerThread extends Thread {

    @Override
    public void run() {
        System.out.print("Hello world!");
    }

}
