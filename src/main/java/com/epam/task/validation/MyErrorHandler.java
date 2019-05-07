package com.epam.task.validation;

import java.io.IOException;

import org.apache.log4j.FileAppender;
import org.apache.log4j.SimpleLayout;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;
import org.apache.log4j.Logger;
public class MyErrorHandler implements ErrorHandler {
    private final static Logger LOG = Logger.getLogger(Validator.class);

    public MyErrorHandler(String log) throws IOException {

        LOG.addAppender(new FileAppender(
                new SimpleLayout(), log));
    }
    public void warning(SAXParseException e) {
        LOG.warn(getLineAddress(e) + "-" +
                e.getMessage());
    }
    public void error(SAXParseException e) {
        LOG.error(getLineAddress(e) + " - "
                + e.getMessage());
    }
    public void fatalError(SAXParseException e) {
        LOG.fatal(getLineAddress(e) + " - "
                + e.getMessage());
    }
    private String getLineAddress(SAXParseException e) {
        return e.getLineNumber() + " : "
                + e.getColumnNumber();
    }
}
