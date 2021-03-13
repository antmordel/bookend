package dev.nito.bookend.bookstore;


import java.util.Optional;

public interface BookstoreRepository {

    Optional<Book> getBook(int id);

    int saveBook(Book book);

    boolean deleteBook(int id);
}
