package componets;

import com.codeborne.selenide.SelenideElement;

import java.lang.reflect.Field;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class BaseComponent implements ElementsCustomTool {

    @Override
    public void checkElementsDisplayed() throws IllegalAccessException {
        for (Field field : getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object obj = field.get(this);
            if (obj instanceof SelenideElement) {
                SelenideElement element = (SelenideElement) obj;
                assertTrue(element.isDisplayed(), format("Element not found %s ", obj.toString()));
            }
        }

    }

}
