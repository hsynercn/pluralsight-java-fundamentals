package com.bergaz.fundamentals.iteration_one.workwithnulls.optionaltype;

public class DRAReadingLevel extends ReadingLevel {
    public DRAReadingLevel(Integer id, String grade, String level) {
        super(id, grade, level);
    }

    @Override
    public String toString() {
        return "DRA reading level " + getLevel() + ", " + getGrade();
    }
}
