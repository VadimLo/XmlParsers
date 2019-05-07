package com.epam.task.parsers.jaxbparser;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class gems {
    private String name;
    private String origin;
    private String preciousness;
    private int value;
    private String color;
    private int cutMethod;
    @XmlAttribute
    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name;
    }

    public String getPreciousness()
    {
        return preciousness;
    }


    @XmlAttribute
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setPreciousness(String preciousness) {
        this.preciousness = preciousness;
    }
    @XmlElement
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCutMethod() {
        return cutMethod;
    }

    public void setCutMethod(int cutMethod) {
        this.cutMethod = cutMethod;
    }
}