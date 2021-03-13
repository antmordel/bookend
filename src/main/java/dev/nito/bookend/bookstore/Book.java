package dev.nito.bookend.bookstore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.With;

@Data
@AllArgsConstructor
public class Book {

    @With
    private Integer id;
    private String title;
    private String author;

}
