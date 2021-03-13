package dev.nito.bookend.bookstore;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.notFound;


@RestController
@RequiredArgsConstructor
public class BookstoreController {

    private final BookstoreService bookstoreService;

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Integer id) {
        return bookstoreService.getBook(id).map(ResponseEntity::ok)
                .orElse(notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> createBook(@RequestBody Book book) {

        validateRequest(book);
        Integer bookId = bookstoreService.createBook(book);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(bookId)
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        boolean successfulDeletion = bookstoreService.deleteBook(id);

        if (successfulDeletion) {
            return noContent().build();
        } else {
            return notFound().build();
        }
    }


    private static void validateRequest(Book book) {
        if (book.getId() != null) {
            throw new IllegalArgumentException("book.id must be null");
        }
    }
}
