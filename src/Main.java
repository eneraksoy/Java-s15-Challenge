import com.library.models.*;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        int readerId = library.getReaders().size() + 1;

        System.out.print("Okuyucu İsmi: ");
        String readerName = scanner.nextLine();

        Date membershipDate = new Date();

        System.out.print("Adres: ");
        String address = scanner.nextLine();

        Reader reader = new Reader(readerId, readerName);
        MemberRecord memberRecord = new MemberRecord(readerId, readerName, "Normal", membershipDate, address);

        library.addReader(reader);

        Librarian librarian = new Librarian("Kütüphaneci", "LIB123");
        Author author1 = new Author("William Golding");
        Author author2 = new Author("George Orwell");
        Author author3 = new Author("Fyodor Dostoyevski");
        Author author4 = new Author("Lev Tolstoy");
        Author author5 = new Author("Miguel de Cervantes");
        Author author6 = new Author("Victor Hugo");
        Author author7 = new Author("Emily Bronte");
        Author author8 = new Author("Harper Lee");
        Author author9 = new Author("Franz Kafka");
        Author author10 = new Author("Antoine de Saint-Exupéry");
        Author author11 = new Author("Alexandre Dumas");
        Author author12 = new Author("Gustave Flaubert");
        Author author13 = new Author("Charlotte Bronte");
        Author author14 = new Author("Honoré de Balzac");
        Author author15 = new Author("Bram Stoker");
        Author author16 = new Author("Mary Shelley");

        Book book1 = new Book(101, "Sineklerin Tanrısı", author1, BookStatus.AVAILABLE, "01/01/2020");
        Book book2 = new Book(102, "1984", author2, BookStatus.AVAILABLE, "01/02/2021");
        Book book3 = new Book(103, "Hayvan Çiftliği", author2, BookStatus.AVAILABLE, "15/03/2021");
        Book book4 = new Book(104, "Suç ve Ceza", author3, BookStatus.AVAILABLE, "10/05/2019");
        Book book5 = new Book(105, "Anna Karenina", author4, BookStatus.AVAILABLE, "20/08/2018");
        Book book6 = new Book(106, "Don Kişot", author5, BookStatus.AVAILABLE, "01/01/2017");
        Book book7 = new Book(107, "Karamazov Kardeşler", author3, BookStatus.AVAILABLE, "12/09/2020");
        Book book8 = new Book(108, "Bir İdam Mahkumunun Son Günü", author6, BookStatus.AVAILABLE, "05/02/2020");
        Book book9 = new Book(109, "Uğultulu Tepeler", author7, BookStatus.AVAILABLE, "01/06/2019");
        Book book10 = new Book(110, "Bülbülü Öldürmek", author8, BookStatus.AVAILABLE, "25/12/2018");
        Book book11 = new Book(111, "Dönüşüm", author9, BookStatus.AVAILABLE, "14/01/2020");
        Book book12 = new Book(112, "Küçük Prens", author10, BookStatus.AVAILABLE, "01/11/2021");
        Book book13 = new Book(113, "Yeraltından Notlar", author3, BookStatus.AVAILABLE, "15/04/2018");
        Book book14 = new Book(114, "Monte Cristo Kontu", author11, BookStatus.AVAILABLE, "30/06/2017");
        Book book15 = new Book(115, "Madame Bovary", author12, BookStatus.AVAILABLE, "20/10/2019");
        Book book16 = new Book(116, "Jane Eyre", author13, BookStatus.AVAILABLE, "10/03/2021");
        Book book17 = new Book(117, "Goriot Baba", author14, BookStatus.AVAILABLE, "05/05/2020");
        Book book18 = new Book(118, "Savaş ve Barış", author4, BookStatus.AVAILABLE, "12/12/2016");
        Book book19 = new Book(119, "Dracula", author15, BookStatus.AVAILABLE, "01/07/2019");
        Book book20 = new Book(120, "Frankenstein", author16, BookStatus.AVAILABLE, "21/09/2020");

        librarian.addBooksToLibrary(library, book1, book2, book3, book4, book5, book6, book7, book8, book9, book10,
                book11, book12, book13, book14, book15, book16, book17, book18, book19, book20);

        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Kütüphane Otomasyonu ---");
            System.out.println("1. Kitapları Listele");
            System.out.println("2. Kitap Adı ile Ara");
            System.out.println("3. Yazar Adı ile Ara");
            System.out.println("4. Kitap Ödünç Al");
            System.out.println("5. Kitap İade Et");
            System.out.println("6. Yeni Kitap Ekle");
            System.out.println("7. Kitap Sil");
            System.out.println("8. Kitap Güncelle");
            System.out.println("9. Çıkış Yap");
            System.out.print("Seçiminiz: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    library.showBooks();
                    break;

                case 2:
                    System.out.print("Aranacak kitap ismi: ");
                    String bookName = scanner.nextLine();
                    library.findBookByName(bookName).forEach(Book::display);
                    break;

                case 3:
                    System.out.print("Aranacak yazar ismi: ");
                    String authorName = scanner.nextLine();
                    library.findBookByAuthor(authorName).forEach(Book::display);
                    break;

                case 4:
                    System.out.print("Ödünç Alınacak Kitap ID: ");
                    int borrowId = scanner.nextInt();
                    Book bookToBorrow = library.findBookById(borrowId);
                    if (bookToBorrow != null) {
                        librarian.issueBook(bookToBorrow, reader, memberRecord);
                    } else {
                        System.out.println("Kitap bulunamadı.");
                    }
                    break;

                case 5:
                    System.out.print("İade Edilecek Kitap ID: ");
                    int returnId = scanner.nextInt();
                    Book bookToReturn = library.findBookById(returnId);
                    if (bookToReturn != null) {
                        librarian.returnBook(bookToReturn, reader, memberRecord);
                    } else {
                        System.out.println("Kitap bulunamadı.");
                    }
                    break;

                case 6:
                    System.out.print("Yeni Kitap ID: ");
                    int newBookId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Yeni Kitap İsmi: ");
                    String newBookName = scanner.nextLine();
                    System.out.print("Yeni Kitap Yazarı: ");
                    String newBookAuthorName = scanner.nextLine();
                    Author newBookAuthor = new Author(newBookAuthorName);
                    System.out.print("Yeni Kitap Satın Alınma Tarihi: ");
                    String newBookDate = scanner.nextLine();
                    Book newBook = new Book(newBookId, newBookName, newBookAuthor, BookStatus.AVAILABLE, newBookDate);
                    librarian.addBooksToLibrary(library, newBook);
                    break;

                case 7:
                    System.out.print("Silinecek Kitap ID: ");
                    int deleteBookId = scanner.nextInt();
                    library.deleteBook(deleteBookId);
                    break;

                case 8:
                    System.out.print("Güncellenecek Kitap ID: ");
                    int updateBookId = scanner.nextInt();
                    scanner.nextLine();
                    Book bookToUpdate = library.findBookById(updateBookId);
                    if (bookToUpdate != null) {
                        System.out.print("Yeni Kitap İsmi: ");
                        String updatedBookName = scanner.nextLine();
                        System.out.print("Yeni Kitap Yazarı: ");
                        String updatedBookAuthorName = scanner.nextLine();
                        Author updatedBookAuthor = new Author(updatedBookAuthorName);
                        System.out.print("Yeni Kitap Durumu (AVAILABLE/BORROWED): ");
                        String updatedBookStatus = scanner.nextLine();
                        bookToUpdate.setBookName(updatedBookName);
                        bookToUpdate.setAuthor(updatedBookAuthor);
                        bookToUpdate.setStatus(BookStatus.valueOf(updatedBookStatus.toUpperCase()));
                        System.out.println("Kitap bilgileri güncellendi.");
                    } else {
                        System.out.println("Kitap bulunamadı.");
                    }
                    break;

                case 9:
                    exit = true;
                    break;

                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }

        scanner.close();
    }
}