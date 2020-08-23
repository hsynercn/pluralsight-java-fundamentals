package com.bergaz.fundamentals.workwithnulls.nullobjectpattern;

import java.util.ArrayList;
import java.util.List;


public class BookService {
    private BookRepository bookRepository = new BookRepository();

    public List<String> getAuthorTitlesWithReadingLevel(Integer authorId) {
        List<Book> books = bookRepository.findByAuthorId(authorId);
        List<String> titlesWithReadingLevel = new ArrayList<>();

        for (Book book : books) {
            titlesWithReadingLevel.add(book.getTitle() + " - " + book.getReadingLevel());
            /**
             * In case of a null reading level we can check it manually and add a default description at this service
             * class, but also we can return a null value from book class itself
             * For a null value generally we use a default explanation or print message, for this default behaviour
             * we can use a default class
             */
            /*String description = book.getTitle() + " - ";
            if(book.getReadingLevel() != null) {
                description += book.getReadingLevel();
            } else {
                description += "No reading level set";
            }
            titlesWithReadingLevel.add(description);*/
        }

        return titlesWithReadingLevel;
    }
}
