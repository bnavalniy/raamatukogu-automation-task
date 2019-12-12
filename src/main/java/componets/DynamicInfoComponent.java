package componets;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;

public class DynamicInfoComponent extends BaseComponent {
    private final ElementsCollection libraryInfo = $$(".col-sm-10 strong");
}
