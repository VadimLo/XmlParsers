package com.epam.task.parsers.saxparser;
import com.epam.task.classes.Gem;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.ArrayList;

public class GemsSAXParser {
    private final static Logger LOG = Logger.getLogger(GemsSAXParser.class);
    private ArrayList<Gem> gems;
    private GemsHandler handler;
    private XMLReader reader;
    public GemsSAXParser() {
        handler = new GemsHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
        } catch (SAXException e) {
            LOG.error(e);
        }
    }
    public ArrayList<Gem> getGems() {
        return gems;
    }
    public void buildSetStudents(String fileName) {
        try {
            reader.parse(fileName);
        } catch (SAXException e) {
            LOG.error(e);
        } catch (IOException e) {
            LOG.error(e);
        }
        gems = handler.getGems();
    }
}
