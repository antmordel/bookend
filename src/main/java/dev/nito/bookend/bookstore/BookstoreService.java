package dev.nito.bookend.bookstore;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class BookstoreService {

    private final BookstoreRepository bookstoreRepository;

    public Optional<Book> getBook(Integer id) {
        if (isNull(id)) {
            throw new NullPointerException("book.id cannot be null");
        }

        return bookstoreRepository.getBook(id);
    }

    public Collection<Book> getBooks() {
        return bookstoreRepository.getBooks();
    }

    public int createBook(Book book) {
        return bookstoreRepository.saveBook(book);
    }

    public boolean deleteBook(int id) {
        return bookstoreRepository.deleteBook(id);
    }
}
