package com.bergaz.fundamentals.workwithnulls.optionaltype;

public class ReadingLevel {
    private Integer id;
    private String grade;
    private String level;

    public ReadingLevel(Integer id, String grade, String level) {
        this.id = id;
        this.grade = grade;
        this.level = level;
    }

    public ReadingLevel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
