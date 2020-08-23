package com.bergaz.fundamentals.workwithnulls.optionaltype;

import java.util.ArrayList;
import java.util.List;


public class BookService {
    private BookRepository bookRepository = new BookRepository();

    public List<String> getAuthorTitlesWithReadingLevel(Integer authorId) {
        List<Book> books = bookRepository.findByAuthorId(authorId);
        List<String> titlesWithReadingLevel = new ArrayList<>();

        books.forEach(book -> {
            titlesWithReadingLevel.add(
                    book.getTitle()
                            + " - "
                            + book.getReadingLevel().map(readingLevel -> readingLevel.toString())
                            .orElse("No reading level set"));
        });

        return titlesWithReadingLevel;
    }
}
