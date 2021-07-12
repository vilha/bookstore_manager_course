package com.vilha.bookstoremanager.utils;

import com.vilha.bookstoremanager.dto.BookDTO;
import com.vilha.bookstoremanager.entity.Book;

import static com.vilha.bookstoremanager.utils.AuthorUtils.createFakeAuthor;
import static com.vilha.bookstoremanager.utils.AuthorUtils.createFakeAuthorDTO;

public class BookUtils {

    private static final Faker faker = Faker.instance();

    public static BookDTO createFakeABookDTO() {
        return BookDTO.builder()
                .id(faker.number().randomNumber())
                .name(faker.book().title())
                .pages(faker.number().numberBetween(0, 200))
                .chapters(faker.number().numberBetween(1, 20))
                .isbn("0--596-52068-9")
                .publisherName(faker.book().publisher())
                .autheor(createFakeAuthorDTO())
                .build();
    }

    public static Book createFakeBook() {
        return Book.builder()
                .id(faker.number().randomNumber())
                .name(faker.book().title())
                .pages(faker.number().numberBetween(0, 200))
                .chapters(faker.number().numberBetween(1, 20))
                .isbn("0--596-52068-9")
                .publisherName(faker.book().publisher())
                .autheor(createFakeAuthor())
                .build();
    }
}
