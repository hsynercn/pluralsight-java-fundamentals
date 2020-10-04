package com.bergaz.intermediate.the_core_platform.section_05;

import java.util.Comparator;

public class MyComparator implements Comparator<MyClass> {
    @Override
    public int compare(MyClass x, MyClass y) {
        return x.getLabel().compareToIgnoreCase(y.getLabel());
    }
}
