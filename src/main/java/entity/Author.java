package entity;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class Author {

    private String secondName;
    private String firstName;

    public Author(String secondName, String firstName) {
        this.secondName = secondName;
        this.firstName = firstName;
    }

}
