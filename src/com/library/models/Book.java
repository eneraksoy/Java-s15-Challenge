package com.library.models;

public class Book implements Lendable {
    private int bookID;
    private String bookName;
    private Author author;
    private BookStatus status;
    private String dateOfPurchase;
    private Reader borrowedBy;

    public Book(int bookID, String bookName, Author author, BookStatus status, String dateOfPurchase) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.author = author;
        this.status = status;
        this.dateOfPurchase = dateOfPurchase;
    }

    public Reader getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(Reader borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    public int getBookID() {
        return bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void display() {
        System.out.println("Kitap ID: " + bookID + ", İsim: " + bookName + ", Yazar: " + author.getName() +
                ", Satın Alınma Tarihi: " + dateOfPurchase + ", Durum: " + status);
    }

    @Override
    public void lend() {
        if (status == BookStatus.AVAILABLE) {
            status = BookStatus.BORROWED;
        } else {
            System.out.println(bookName + " zaten ödünç alınmış.");
        }
    }

    @Override
    public void returnBack() {
        status = BookStatus.AVAILABLE;
    }
}