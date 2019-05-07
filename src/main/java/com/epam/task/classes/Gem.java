package com.epam.task.classes;

public class Gem {
    private String name;
    private String origin;
    private String preciousness;
    private int value;
    private String color;
    private int cutMethod;
 int transparency;
    public String getName() {
        return name;
    }

    public int getCutMethod() {
        return cutMethod;
    }

    public String getColor() {
        return color;
    }

    public String getPreciousness() {
        return preciousness;
    }

    public int getValue() {
        return value;
    }


    public String getOrigin() {
        return origin;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCutMethod(int cutMethod) {
        this.cutMethod = cutMethod;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setPreciousness(String preciousness) {
        this.preciousness = preciousness;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setTransparency(int transparency) {
        this.transparency=transparency;
    }
}
