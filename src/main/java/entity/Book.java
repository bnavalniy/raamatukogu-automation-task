package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Book {
    private String title;
    private Author author;
    private String summary;
    private final String ISBN;
    private Genre genre;

}
