package com.epam.task.director;

import com.epam.task.classes.Gem;
import com.epam.task.parsers.domparser.GemDomParser;
import com.epam.task.parsers.jaxbparser.gems;
import com.epam.task.parsers.saxparser.GemsSAXParser;
import com.epam.task.validation.Validator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Director {
    private Validator validator =new Validator();
    public List<Gem> saxParse(){
        if(validator.checkXMLFile("src\\main\\resources\\gems.xml")){
            GemsSAXParser saxBuilder = new GemsSAXParser();
            saxBuilder.buildSetStudents("src\\main\\resources\\gems.xml");
            return saxBuilder.getGems();
        }
        return null;
    }
    public List<Gem> DOMParse(){
        if(validator.checkXMLFile("src\\main\\resources\\gems.xml")){
        GemDomParser domBuilder = new GemDomParser();
        domBuilder.buildSetGem("src\\main\\resources\\gems.xml");
        return domBuilder.getGems();
        }
        return null;
    }
    public List<Gem> parse() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(gems.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            FileReader reader = new FileReader("src\\main\\resources\\gems.xml");
            Gem gem = (Gem) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
