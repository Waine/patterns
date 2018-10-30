package com.eakonovalov.pattern.decorator.impl;

import com.eakonovalov.pattern.decorator.Email;

/**
 * @author Waine
 * @version 1.0
 * @created 10-Feb-2017 19:50:39
 */
public class TextEmail implements Email {

    private String content;
    private String subject;

    public TextEmail(String subject, String content) {
        this.subject = subject;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    /**
     * @param subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

}
