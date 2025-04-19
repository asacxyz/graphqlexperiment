package com.asacxyz.graphqlexperiment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@GraphQlTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void shouldGetFirstBook() {
            this.graphQlTester.documentName("bookDetails")
                .variable("id", "book-1")
                .execute()
                .path("bookById")
                .matchesJson("""
                        {
                            "id": "book-1",
                            "name": "Clean Code",
                            "pageCount": 425,
                            "author": {
                                "firstName": "Robert",
                                "lastName": "Martin"
                            }
                        }
                        """);
    }
}
