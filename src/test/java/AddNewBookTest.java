import componets.NavigationComponent;
import entity.Author;
import entity.Book;
import entity.Genre;
import extensions.TestExt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.AllBookListPage;
import pages.CreateBookPage;
import pages.CreatedBookPage;

import java.util.List;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@ExtendWith(TestExt.class)

public class AddNewBookTest {
    private NavigationComponent navigation;
    private CreateBookPage createBookPage;
    private AllBookListPage allBookListPage;
    private CreatedBookPage createdBookPage;
    private final String DEFAULT_ISBN = "978-2-16-148410-0";

    @BeforeEach
    void setup() throws IllegalAccessException {
        navigation = new NavigationComponent();
    }

    @Test
    @DisplayName("Test add new book with existing author - assert created book info")
    void addNewBookTest() throws IllegalAccessException {
        navigation.toAddNewBook();
        createBookPage = new CreateBookPage();
        //Book newBook = new Book(getRandomSting(),provideExistingAuthor("London", "Jack"),getRandomSting(),DEFAULT_ISBN,Genre.FICTION);
        Book newBook = Book.builder()
                .title(getRandomSting())
                .summary(getRandomSting())
                .genre(Genre.NON_FICTION)
                .ISBN(DEFAULT_ISBN)
                .author(Author.builder()
                        .firstName("London")
                        .secondName("Jack")
                        .build())
                .build();

        createBookPage.fillNewBookForm(newBook).submit();
        createdBookPage = new CreatedBookPage();

        Book actual = Book.builder()
                .title(createdBookPage.getTitle())
                .summary(createdBookPage.getSummary())
                .author(createdBookPage.getAuthor())
                .genre(createdBookPage.getGenre())
                .ISBN(createdBookPage.getIsbn())
                .build();

        assertBook(newBook, actual);

    }

    @Test
    @DisplayName("Test add new book - assert is book exist catalog")
    void addNewBookAndAssert() throws IllegalAccessException, InterruptedException {
        navigation.toAddNewBook();
        createBookPage = new CreateBookPage();
        Book createdBook = Book.builder()
                .ISBN(DEFAULT_ISBN)
                .genre(Genre.FICTION)
                .title(getRandomSting())
                .summary(getRandomSting())
                .author(Author.builder()
                        .firstName("London")
                        .secondName("Jack")
                        .build())
                .build();
        createBookPage.fillNewBookForm(createdBook).submit();
        navigation.toAllBooks();
        allBookListPage = new AllBookListPage();
        List<Book> list = allBookListPage.convertToListOfBooks();

        Book filteredBookFromCatalog = list.stream().filter(book -> book.getTitle()
                .equals(createdBook.getTitle()))
                .findAny()
                .orElse(null);

        assertThat("Cannot find created book at catalog",filteredBookFromCatalog, is(notNullValue()));
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

    private void assertBook(Book actual, Book expected) {
        assertThat("Title is not matched",actual.getTitle(), equalToIgnoringWhiteSpace(expected.getTitle()));
        assertThat("Genre is not matched",actual.getGenre().getGenre(), equalToIgnoringWhiteSpace(expected.getGenre().getGenre()));
        assertThat("ISBN is not matched",actual.getISBN(), equalToIgnoringWhiteSpace(expected.getISBN()));
        assertThat("Author is not matched",actual.getAuthor().toString(), hasToString(expected.getAuthor().toString()));
    }

}
