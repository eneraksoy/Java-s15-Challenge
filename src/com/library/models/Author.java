package com.library.models;

import java.util.HashSet;
import java.util.Set;

public class Author extends Person {
    private Set<Book> books;

    public Author(String name) {
        super(name);
        this.books = new HashSet<>();
    }

    public Set<Book> getBooks() {
        return books;
    }


    @Override
    public void whoYouAre() {
        System.out.println("Ben bir yazarım. İsim: " + getName());
    }
}