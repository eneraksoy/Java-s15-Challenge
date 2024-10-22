package com.library.models;

import java.util.ArrayList;
import java.util.List;

public class Reader extends Person {
    private int readerID;
    private List<Book> books;
    public static final int MAX_BORROW_LIMIT = 5;

    public Reader(int readerID, String name) {
        super(name);
        this.readerID = readerID;
        this.books = new ArrayList<>();
    }

    public int getReaderID() {
        return readerID;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void borrowBook(Book book) {
        if (books.size() >= MAX_BORROW_LIMIT) {
            System.out.println("Kitap limitine ulaşıldı, daha fazla kitap alamazsınız.");
            return;
        }
        if (!books.contains(book)) {
            books.add(book);

        } else {
            System.out.println(book.getBookName() + " zaten ödünç alınmış.");
        }
    }

    public void returnBook(Book book) {
        books.remove(book);

    }

    @Override
    public void whoYouAre() {
        System.out.println("Ben bir okuyucuyum. İsim: " + getName());
    }
}