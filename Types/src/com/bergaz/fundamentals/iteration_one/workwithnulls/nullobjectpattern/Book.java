package com.bergaz.fundamentals.iteration_one.workwithnulls.nullobjectpattern;

public class Book {
    private Integer id;
    private Integer authorId;
    private ReadingLevel readingLevel;
    private String title;

    public Book(Integer id, Integer authorId, ReadingLevel readingLevel, String title) {
        this.id = id;
        this.authorId = authorId;
        this.readingLevel = readingLevel;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public ReadingLevel getReadingLevel() {
        return readingLevel == null ? NullReadingLevel.getInstance() : readingLevel;
    }

    public String getTitle() {
        return title;
    }
}
