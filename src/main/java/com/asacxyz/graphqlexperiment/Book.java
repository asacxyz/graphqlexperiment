package com.asacxyz.graphqlexperiment;

import java.util.Arrays;
import java.util.List;

public record Book(String id, String name, int pageCount, String authorId) {

    private static final List<Book> books = Arrays.asList(
            new Book("book-1", "Clean Code", 425, "author-1"),
            new Book("book-2", "Working Effectively with Legacy Code", 464, "author-2"),
            new Book("book-3", "Becoming a Better Programmer", 362, "author-3"));

    public static Book getById(String id) {
        return Book.books.stream()
                .filter(b -> b.id.equals(id))
                .findFirst()
                .get();
    }
}
