package dev.nito.bookend.bookstore;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Objects.isNull;

@Repository
public class MapBookstoreRepository implements BookstoreRepository {

    private final ConcurrentMap<Integer, Book> store;
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
    public Collection<Book> getBooks() {
        return store.values();
    }

    @Override
    public int saveBook(Book book) {
        if (isNull(book)) {
            throw new NullPointerException("Null values not allowed in Repository");
        }

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
