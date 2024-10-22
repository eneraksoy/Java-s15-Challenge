package com.library.models;

import java.util.*;

public class Library {
    private Map<Integer, Book> books;
    private Map<Integer, Reader> readers;

    public Library() {
        books = new HashMap<>();
        readers = new HashMap<>();
    }

    public Map<Integer, Reader> getReaders() {
        return readers;
    }

    public Map<Integer, Book> getBooks() {
        return books;
    }

    public void deleteBook(int bookId) {
        if (books.containsKey(bookId)) {
            books.remove(bookId);
            System.out.println("Kitap başarıyla silindi.");
        } else {
            System.out.println("Kitap bulunamadı.");
        }
    }

    public void addBook(Book book) {
        books.put(book.getBookID(), book);
        System.out.println(book.getBookName() + " kütüphaneye eklendi.");
    }

    public Book findBookById(int id) {
        return books.get(id);
    }

    public void addReader(Reader reader) {
        readers.put(reader.getReaderID(), reader);
        System.out.println(reader.getName() + " kütüphaneye kaydedildi.");
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("Kütüphanede kitap yok.");
        } else {
            books.values().forEach(Book::display);
        }
    }

    public List<Book> findBookByName(String bookName) {
        List<Book> bookList = new ArrayList<>();
        books.values().stream()
                .filter(book -> book.getBookName().equalsIgnoreCase(bookName))
                .forEach(bookList::add);
        return bookList;
    }

    public List<Book> findBookByAuthor(String authorName) {
        List<Book> authorBooks = new ArrayList<>();
        books.values().stream()
                .filter(book -> book.getAuthor().getName().equalsIgnoreCase(authorName))
                .forEach(authorBooks::add);
        return authorBooks;
    }

    public void showReaders() {
        if (readers.isEmpty()) {
            System.out.println("Kütüphanede kayıtlı okuyucu yok.");
        } else {
            readers.values().forEach(reader -> System.out.println("Okuyucu ID: " + reader.getReaderID() + ", İsim: " + reader.getName()));
        }
    }

    public void lendBook(int bookID, Reader reader) {
        Book book = findBookById(bookID);
        if (book == null) {
            System.out.println("Kitap kütüphanede mevcut değil.");
            return;
        }

        if (book.getStatus() == BookStatus.AVAILABLE) {
            book.lend();
            reader.borrowBook(book);
        } else {
            System.out.println("Kitap zaten ödünç alınmış.");
        }
    }

    public void takeBackBook(int bookID, Reader reader) {
        Book book = findBookById(bookID);
        if (book == null) {
            System.out.println("Kitap kütüphanede mevcut değil.");
            return;
        }

        if (reader.getBooks().contains(book)) {
            reader.returnBook(book);
            book.returnBack();
        } else {
            System.out.println("Bu kitap bu okuyucuda mevcut değil.");
        }
    }
}