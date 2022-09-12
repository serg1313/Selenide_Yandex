package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.switchTo;

/**
 * @author Администратор
 * @date 25.08.2022
 */

public class YandexMainPaig extends BasePage{
    /**
     * автор Костенко Сергей
     * метод осуществляет переход на указанный сервис в главной странице Яндекса
     * @param query наименование сервиса
     * @param typeNextPage страница сервиса
     * @param <T>
     * @return
     */
    @Step("Переходим в сервис {query}")
    public <T extends BasePage> T   searchService(String query, Class<T> typeNextPage){
        ElementsCollection serviceNamesLocator = $$x("//div[@class='services-new__item-title']");
        serviceNamesLocator.find(exactText(query)).click();
        switchTo().window(1);
        return typeNextPage.cast(page(typeNextPage));
    }
}
