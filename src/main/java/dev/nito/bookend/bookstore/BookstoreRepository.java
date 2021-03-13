package dev.nito.bookend.bookstore;


import java.util.Collection;
import java.util.Optional;

public interface BookstoreRepository {

    Optional<Book> getBook(int id);

    Collection<Book> getBooks();

    int saveBook(Book book);

    boolean deleteBook(int id);
}
