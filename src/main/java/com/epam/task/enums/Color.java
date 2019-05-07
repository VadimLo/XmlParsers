package com.epam.task.enums;

public enum Color {
    GRENN("grenn"),
    WHITE("white"),
    BLUE("blue"),
    RED("red");
    String value;
    Color(String value) {
        this.value = value;
    }
    public static String getValue(String s) {
        return s;
    }

}

