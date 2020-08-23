package com.bergaz.fundamentals.workwithnulls.optionaltype;

public class LexileReadingLevel extends ReadingLevel {
    public LexileReadingLevel(Integer id, String grade, String level) {
        super(id, grade, level);
    }

    @Override
    public String toString() {
        return "Lexile reading level " + getLevel() + "L, " + getGrade();
    }
}
