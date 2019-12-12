package pages;

import com.codeborne.selenide.ElementsCollection;
import componets.BaseComponent;
import entity.Author;
import entity.Book;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$;

public class AllBookListPage extends BaseComponent {
    private final ElementsCollection selenideCollectionOfBooks = $$(".col-sm-10 li");
    private List<Book> storedBooks;

    public List<Book> convertToListOfBooks() {

        return selenideCollectionOfBooks.texts().stream()
                .map(this::book)
                .collect(Collectors.toList());
    }

    private Book book(String element) {
        String[] parts = element.split(" ");
        return Book.builder()
                .title(parts[0])
                .author(Author.builder()
                        .firstName(parts[1].replaceAll("\\W",""))
                        .secondName(parts[2].replaceAll("\\W",""))
                        .build())
                .build();
    }

}
