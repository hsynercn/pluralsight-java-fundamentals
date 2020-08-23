package com.bergaz.fundamentals.workwithnulls.nullobjectpattern;

public class DRAReadingLevel extends ReadingLevel{
    public DRAReadingLevel(Integer id, String grade, String level) {
        super(id, grade, level);
    }

    @Override
    public String toString() {
        return "DRA reading level " + getLevel() + ", " + getGrade();
    }
}
