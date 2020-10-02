package com.bergaz.fundamentals.iteration_one.workwithnulls.optionaltype;

import com.bergaz.fundamentals.iteration_one.workwithnulls.nullobjectpattern.Book;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        if(findBook().isPresent()) {
            System.out.println("Optional value is empty");
        } else {
            System.out.println("Optional value is not empty");
        }
    }
    public static Optional<Book> findBook() {
        return null;
    }
}