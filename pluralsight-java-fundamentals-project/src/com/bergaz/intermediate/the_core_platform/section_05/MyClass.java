package com.bergaz.intermediate.the_core_platform.section_05;

public class MyClass {
    String label, value;

    public MyClass(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        MyClass other = (MyClass) obj;
        return value.equalsIgnoreCase(other.value);
    }
}
