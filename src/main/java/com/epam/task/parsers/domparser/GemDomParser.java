package com.epam.task.parsers.domparser;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.epam.task.classes.Diamond;
import com.epam.task.classes.Gem;
import com.epam.task.classes.Mineral;
import com.epam.task.validation.Validator;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class GemDomParser {
    private final static Logger LOG = Logger.getLogger(Validator.class);
    private ArrayList<Gem> gems;
    private DocumentBuilder docBuilder;
    private static  final int INDEX = 0;
    public GemDomParser() {
        this.gems = new ArrayList<Gem>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOG.error(e);
        }
    }

    public ArrayList<Gem> getGems() {
        return gems;
    }

    public void buildSetGem(String fileName) {
        Document doc ;
        try {

            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();

            NodeList gemsList = root.getElementsByTagName("gem");
            for (int i = 0; i < gemsList.getLength(); i++) {
                Element gemElement = (Element) gemsList.item(i);
                Gem gem = buildGem(gemElement);
                gems.add(gem);
            }
            NodeList diamondList = root.getElementsByTagName("diamond");
            for (int i = 0; i < diamondList.getLength(); i++) {
                Element gemElement = (Element) gemsList.item(i);
                Gem gem =  buildDiamond(gemElement);

                gems.add(gem);
            }
            NodeList mineralList = root.getElementsByTagName("mineral");
            for (int i = 0; i < mineralList.getLength(); i++) {
                Element gemElement = (Element) gemsList.item(i);
                Gem gem = buildMineral(gemElement);
                gems.add(gem);
            }
        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (SAXException e) {
            System.err.println("Parsing failure: " + e);
        }
    }

    private Gem buildGem(Element gemElement) {

        Gem gem = new Gem();

       build(gem,gemElement);
        return gem;
    }
    public  void  build(Gem gem,Element gemElement){
        gem.setName(gemElement.getAttribute("name"));
        gem.setPreciousness(getElementTextContent(gemElement, "preciousness"));
        Element visualParametersElement = (Element) gemElement.getElementsByTagName("visualParameters").item(INDEX);
        gem.setColor(getElementTextContent(visualParametersElement, "color"));
        gem.setCutMethod(Integer.parseInt(getElementTextContent(visualParametersElement, "cutMethod")));
        gem.setTransparency(Integer.parseInt(getElementTextContent(visualParametersElement, "transparency")));
        gem.setValue(Integer.parseInt(getElementTextContent(gemElement, "value")));
        gem.setOrigin(gemElement.getAttribute("origin"));
    }
    private Gem buildMineral(Element gemElement) {
        Gem gem = new Mineral();
        build(gem,gemElement);
        return gem;
    }
    private Gem buildDiamond(Element gemElement) {
        Gem gem = new Diamond();

        build(gem,gemElement);
        return gem;
    }
    private  String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(INDEX);
        return node.getTextContent();
    }

}