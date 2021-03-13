package dev.nito.bookend.bookstore;

import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static com.sun.tools.javac.util.Assert.check;
import static java.util.Objects.nonNull;

@Repository
public class MapBookstoreRepository implements BookstoreRepository {

    private final ConcurrentHashMap<Integer, Book> store;
    private final AtomicInteger idSequence;

    public MapBookstoreRepository() {
        store = new ConcurrentHashMap<>();
        idSequence = new AtomicInteger();
    }

    @Override
    public Optional<Book> getBook(int id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public int saveBook(Book book) {
        check(nonNull(book));

        Integer nextId = idSequence.incrementAndGet();
        store.put(nextId, book.withId(nextId));
        return nextId;
    }

    @Override
    public boolean deleteBook(int id) {
        if (store.get(id) == null) {
            return false;
        } else {
            store.remove(id);
            return true;
        }
    }
}
