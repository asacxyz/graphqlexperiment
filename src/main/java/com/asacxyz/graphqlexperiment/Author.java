package com.asacxyz.graphqlexperiment;

import java.util.Arrays;
import java.util.List;

public record Author(String id, String firstName, String lastName) {

    private static final List<Author> authors = Arrays.asList(
            new Author("author-1", "Robert", "Martin"),
            new Author("author-2", "Michael", "Feathers"),
            new Author("author-3", "Pete", "Goodliffe"));

    public static Author getById(String id) {
        return Author.authors.stream()
                .filter(a -> a.id.equals(id))
                .findAny()
                .get();
    }
}
