package pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import componets.BaseComponent;
import entity.Author;
import entity.Genre;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Condition.attribute;
import org.openqa.selenium.By;

public class CreatedBookPage {
    private final SelenideElement title = $(".col-sm-10 h1");
    private final SelenideElement author = $("p:nth-child(2) > a");
    private final SelenideElement summary = $("p:nth-child(3)");
    private final SelenideElement isbn = $("p:nth-child(4)");
    private final SelenideElement genre =  $("p:nth-child(5)");

    public String getTitle() {
        String[] part  = this.title.getText().split(":");
        return part[1];
    }

    public Author getAuthor() {
        String[] parts = this.author.getText().split(",");
        return Author.builder()
                .firstName(parts[0])
                .secondName(parts[1].replaceAll("\\s",""))
                .build();
    }

    public String getSummary() {
        String[] part  = this.summary.getText().split(":");
        return part[1];
    }

    public String getIsbn() {
        String[] part  = this.isbn.getText().split(":");
        return part[1];
    }

    public Genre getGenre() {
        String[] part  = this.genre.getText().split(":");
        return part[1].contentEquals(Genre.FICTION.getGenre()) ? Genre.FICTION : Genre.NON_FICTION;
    }
}
