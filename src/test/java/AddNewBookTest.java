import componets.NavigationComponent;
import entity.Author;
import entity.Book;
import entity.Genre;
import extensions.TestExt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.CreateBookPage;

import java.util.Random;


@ExtendWith(TestExt.class)
public class AddNewBookTest {
    private CreateBookPage createBookPage;
    private NavigationComponent navigation;
    private final String DEFAULT_ISBN = "978-2-16-148410-0";

    @BeforeEach
    void setup() throws IllegalAccessException {
        navigation = new NavigationComponent();
    }

    @Test
    @DisplayName("Test add new book with existing author")
    void addNewBookTest() throws IllegalAccessException {
        navigation.toAddNewBook();
        createBookPage = new CreateBookPage();
        createBookPage.fillNewBookForm(generateBookRandomTitleForAuthor("Gladwell","Malcolm"));
        createBookPage.submit();
    }

    private Book generateBookRandomTitleForAuthor(String authorSecondName, String authorFirstName) {
        return new Book(getRandomSting(), provideExistingAuthor(authorSecondName,authorFirstName), getRandomSting(), DEFAULT_ISBN, Genre.FICTION);
    }

    private Author provideExistingAuthor(String secondName, String firstName) {
        return new Author(secondName, firstName);
    }

    private String getRandomSting() {
        int leftLetterLimit = 97;
        int rightLetterLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLetterLimit + (int)
                    (random.nextFloat() * (rightLetterLimit - leftLetterLimit + 1));
            stringBuilder.append((char) randomLimitedInt);
        }
        return stringBuilder.toString();
    }

}
