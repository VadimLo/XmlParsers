package com.epam.task.parsers.saxparser;


public enum GemEnum {
    LOGIN("login"),
    FACULTY("faculty"),
    GEMS("gems"),
    GEM("gem"),
    TRANSPARENCY("transparency"),
    CUTMETHOD("cutMethod"),
    DIAMOND("diamond"),
    COURSE("course"),
    MINERAL("mineral"),
    NAME("name"),
    ORIGIN("origin"),
    VALUE("value"),
    VISUALPARAMETERS("visualParameters"),
    PRECIOUSNESS("preciousness"),
    COLOR("color");
    private String value;
    private GemEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
