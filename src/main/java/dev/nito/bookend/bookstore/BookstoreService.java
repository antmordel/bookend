package dev.nito.bookend.bookstore;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.sun.tools.javac.util.Assert.check;
import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class BookstoreService {

    private final BookstoreRepository bookstoreRepository;

    public int createBook(Book book) {
        return bookstoreRepository.saveBook(book);
    }

    public Optional<Book> getBook(Integer id) {
        check(nonNull(id), "book.id cannot be null");

        return bookstoreRepository.getBook(id);
    }

    public boolean deleteBook(int id) {
        return bookstoreRepository.deleteBook(id);
    }
}
