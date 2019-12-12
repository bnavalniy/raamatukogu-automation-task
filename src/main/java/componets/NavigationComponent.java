package componets;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NavigationComponent extends BaseComponent {

    private final SelenideElement homeLink = $(By.linkText("Home"));
    private final SelenideElement allBooksLink = $(By.linkText("All books"));
    private final SelenideElement allAuthorsLink = $(By.linkText("All authors"));
    private final SelenideElement allGenresLink = $(By.linkText("All genres"));
    private final SelenideElement allBookInstancesLink = $(By.linkText("All book-instances"));
    private final SelenideElement newAuthorLink = $(By.linkText("Create new author"));
    private final SelenideElement newGenreLink = $(By.linkText("Create new genre"));
    private final SelenideElement newBookLink = $(By.linkText("Create new book"));
    private final SelenideElement newBookInstanceLink = $(By.linkText("Create new book instance (copy)"));

    public NavigationComponent() throws IllegalAccessException {
        this.checkElementsDisplayed();
    }

    public void toHome() {
        this.homeLink.click();
    }

    public void toAddNewBook() {
        this.newBookLink.click();
    }

    public void toAllBooks() {
        this.allBooksLink.click();
    }

    public void toAllAuthors() {
        this.allAuthorsLink.click();
    }

}