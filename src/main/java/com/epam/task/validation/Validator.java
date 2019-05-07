package com.epam.task.validation;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.apache.log4j.Logger;

import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

import java.io.IOException;

public class Validator {
    private final static Logger LOG = Logger.getLogger(Validator.class);
    public boolean checkXMLFile(String filename){
        DOMParser parser = new DOMParser();
        try {
            parser.setErrorHandler(new MyErrorHandler("log_file.txt"));

            parser.setFeature(
                    "http://xml.org/sax/features/validation", true);
            parser.setFeature(
                    "http://apache.org/xml/features/validation/schema", true);
            parser.parse(filename);
        } catch (SAXNotRecognizedException e) {
            LOG.error(e);

        } catch (SAXNotSupportedException e) {

            LOG.error(e);

        } catch (SAXException e) {

            LOG.error(e);

        } catch (IOException e) {
            LOG.error(e);

        }
        return true;
    }
}
