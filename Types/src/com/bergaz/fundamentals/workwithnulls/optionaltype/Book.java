package com.bergaz.fundamentals.workwithnulls.optionaltype;

import java.util.Optional;

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

    public Optional<ReadingLevel> getReadingLevel() {
        return Optional.ofNullable(readingLevel);
    }

    public String getTitle() {
        return title;
    }
}
