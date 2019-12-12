package entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Author {

    private String secondName;
    private String firstName;

    public Author(String secondName, String firstName) {
        this.secondName = secondName;
        this.firstName = firstName;
    }

}
