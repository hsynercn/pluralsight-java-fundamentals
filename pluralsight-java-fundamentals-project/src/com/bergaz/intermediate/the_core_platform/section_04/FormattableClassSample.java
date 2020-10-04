package com.bergaz.intermediate.the_core_platform.section_04;

import java.util.Formattable;
import java.util.Formatter;

public class FormattableClassSample implements Formattable {
    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        formatter.format("This is a formattable example string");
    }
}
