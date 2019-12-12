package pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import componets.BaseComponent;
import componets.NavigationComponent;
import entity.Author;
import entity.Book;
import entity.Genre;

import java.util.Random;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Condition.attribute;

public class CreateBookPage extends BaseComponent {

    private final SelenideElement titleInput = $("#title");
    private final SelenideElement authorDropDown = $("#author");
    private final SelenideElement summaryInput = $("#summary");
    private final SelenideElement isbnInput = $("#isbn");
    private final SelenideElement genreNonFictionCheckBox = $$(".checkbox-input").find(attribute("value", "5b6714c73809970014e31c99"));;
    private final SelenideElement genreFictionCheckBox = $$(".checkbox-input").find(attribute("value", "5b6714c93809970014e31c9a"));;
    private final SelenideElement submitButton = $(".btn");

    public CreateBookPage() throws IllegalAccessException {
        this.checkElementsDisplayed();
    }

    public void setTitleInput(String title) {
        this.titleInput.setValue(title);
    }

    public void selectAuthor(Author author) {
        this.authorDropDown.selectOptionContainingText( author.getFirstName());
    }

    public void setSummary(String summary) {
        this.summaryInput.setValue(summary);
    }

    public void setIsbnInput(String isbn) {
        this.isbnInput.setValue(isbn);
    }

    public void chooseGenre(Genre genre) {
        if(genre.getGenre().equals(Genre.NON_FICTION.getGenre())){
            genreNonFictionCheckBox.click();
        }
        else if(genre.getGenre().equals(Genre.FICTION.getGenre())){
            genreFictionCheckBox.click();
        }
    }

    public void submit() {
        this.submitButton.click();
    }

    public void fillNewBookForm(Book book) {
        this.setTitleInput(book.getTitle());
        this.selectAuthor(book.getAuthor());
        this.setSummary(book.getSummary());
        this.setIsbnInput(book.getISBN());
        this.chooseGenre(book.getGenre());
    }


}
