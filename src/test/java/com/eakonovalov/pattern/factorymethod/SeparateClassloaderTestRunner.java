package com.eakonovalov.pattern.factorymethod;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

import java.net.URLClassLoader;

/**
 * Created by Waine on 13.02.2017.
 */
public class SeparateClassloaderTestRunner extends BlockJUnit4ClassRunner {

    public SeparateClassloaderTestRunner(Class<?> clazz) throws InitializationError {
        super(getFromTestClassloader(clazz));
    }

    private static Class<?> getFromTestClassloader(Class<?> clazz) throws InitializationError {
        try {
            ClassLoader testClassLoader = new TestClassLoader();
            return Class.forName(clazz.getName(), true, testClassLoader);
        } catch (ClassNotFoundException e) {
            throw new InitializationError(e);
        }
    }

    public static class TestClassLoader extends URLClassLoader {
        public TestClassLoader() {
            super(((URLClassLoader) getSystemClassLoader()).getURLs());
        }

        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            return name.startsWith("java") || name.startsWith("org.junit") ? super.loadClass(name) : super.findClass(name);
        }
    }

}
