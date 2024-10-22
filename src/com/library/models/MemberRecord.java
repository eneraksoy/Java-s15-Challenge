package com.library.models;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class MemberRecord {
    private int memberId;
    private String memberName;
    private String type;
    private Date dateOfMembership;
    private String address;
    private List<Book> borrowedBooks;

    public MemberRecord(int memberId, String memberName, String type, Date dateOfMembership, String address) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.type = type;
        this.dateOfMembership = dateOfMembership;
        this.address = address;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getType() {
        return type;
    }

    public Date getDateOfMembership() {
        return dateOfMembership;
    }

    public String getAddress() {
        return address;
    }

    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }

    public void displayMemberInfo() {
        System.out.println("Üye ID: " + memberId + ", İsim: " + memberName + ", Tür: " + type +
                ", Üyelik Tarihi: " + dateOfMembership + ", Adres: " + address +
                ", Ödünç Alınan Kitap Sayısı: " + borrowedBooks.size());
    }
}
