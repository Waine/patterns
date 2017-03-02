package com.eakonovalov.pattern.interpreter;

import org.antlr.v4.runtime.*;

/**
 * Created by Waine on 28.02.2017.
 */
public class ExceptionThrowingErrorHandler extends DefaultErrorStrategy {

    @Override
    public void recover(Parser recognizer, RecognitionException e) {
        throw new RuntimeException(e);
    }

    @Override
    public Token recoverInline(Parser recognizer) throws RecognitionException {
        throw new RuntimeException(new InputMismatchException(recognizer));
    }

    @Override
    public void sync(Parser recognizer) throws RecognitionException {
    }

}
