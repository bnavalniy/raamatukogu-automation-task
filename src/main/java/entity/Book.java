package entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class Book {
    private String title;
    private Author author;
    private String summary;
    private final String ISBN;
    private Genre genre;

}
