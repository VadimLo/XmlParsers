package com.epam.task.parsers.saxparser;

import com.epam.task.classes.Diamond;
import com.epam.task.classes.Gem;
import com.epam.task.classes.Mineral;
import com.epam.task.enums.Color;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;


public class GemsHandler extends DefaultHandler {
    private ArrayList<Gem> gems;

    private Gem current = null;
    private GemEnum currentEnum ;
    private EnumSet<GemEnum> withText;
    public GemsHandler() {
        gems = new ArrayList<Gem>();
        withText = EnumSet.range(GemEnum.NAME, GemEnum.COLOR);
    }

    public ArrayList<Gem> getGems() {
        return gems;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {

        if ("gem".equals(localName)) {
            current = new Gem();
            current.setName(attrs.getValue(0));
            if (attrs.getLength() == 2) {
                current.setOrigin(attrs.getValue(1));
            }

        } else {
            GemEnum temp = GemEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
        if ("diamond".equals(localName)) {
            current = new Diamond();
            current.setName(attrs.getValue(0));
            if (attrs.getLength() == 2) {
                current.setOrigin(attrs.getValue(1));
            }

        } else {
            GemEnum temp = GemEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }

        if ("mineral".equals(localName)) {
            current = new Mineral();
            current.setName(attrs.getValue(0));
            if (attrs.getLength() == 2) {
                current.setOrigin(attrs.getValue(1));
            }

        } else {
            GemEnum temp = GemEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }


    }

    public void endElement(String uri, String localName, String qName) {
        if ("gem".equals(localName)||"diamond".equals(localName)||"mineral".equals(localName) ) {
            gems.add(current);
        }

    }

    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case NAME:
                    current.setName(s);
                    break;
                case ORIGIN:
                    current.setOrigin(s);
                    break;
                case VALUE:
                    current.setValue(Integer.parseInt(s));
                    break;

                case PRECIOUSNESS:
                    current.setPreciousness(s);
                    break;
                case TRANSPARENCY:
                    break;
                case CUTMETHOD:
                    current.setCutMethod(Integer.parseInt(s));
                    break;
                case COLOR:
                    current.setColor(Color.getValue(s));
                    break;
                case VISUALPARAMETERS:
                    break;
                default:


                    throw new EnumConstantNotPresentException(
                            currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
}
