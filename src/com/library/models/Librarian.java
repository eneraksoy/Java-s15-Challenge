package com.library.models;

public class Librarian extends Person {
    private String employeeId;

    public Librarian(String name, String employeeId) {
        super(name);
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void verifyMember(MemberRecord member) {
        System.out.println(member.getMemberName() + " üyesi doğrulandı.");
    }

    public void searchBook(Library library, int bookID) {
        Book book = library.findBookById(bookID);
        if (book != null) {
            System.out.println(book.getBookName() + " kitabı bulundu.");
            book.display();
        } else {
            System.out.println("Kitap bulunamadı.");
        }
    }

    public void issueBook(Book book, Reader reader, MemberRecord member) {
        if (book.getStatus() == BookStatus.AVAILABLE) {
            reader.borrowBook(book);
            book.lend();
            book.setBorrowedBy(reader);
            member.addBorrowedBook(book);
            System.out.println(book.getBookName() + " kitabı " + reader.getName() + " tarafından ödünç alındı. Fatura kesildi: 10 TL");
        } else {
            System.out.println("Kitap zaten ödünç alınmış.");
        }
    }

    public void returnBook(Book book, Reader reader, MemberRecord member) {
        if (book.getBorrowedBy() != null && book.getBorrowedBy().equals(reader)) {
            reader.returnBook(book);
            book.returnBack();
            book.setBorrowedBy(null);
            member.returnBorrowedBook(book);
            System.out.println(book.getBookName() + " kitabı " + reader.getName() + " tarafından iade edildi. Ücret geri ödendi: 10 TL");
        } else {
            System.out.println("Bu kitap bu okuyucuda mevcut değil.");
        }
    }

    public void addBooksToLibrary(Library library, Book... books) {
        for (Book book : books) {
            library.addBook(book);
            System.out.println("Kitap kütüphaneye eklendi: " + book.getBookName());
        }
    }

    @Override
    public void whoYouAre() {
        System.out.println("Ben bir kütüphaneciyim. İsim: " + getName() + ", Çalışan ID: " + employeeId);
    }
}