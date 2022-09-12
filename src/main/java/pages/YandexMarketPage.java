package pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

/**
 * @author Администратор
 * @date 25.08.2022
 */

public class YandexMarketPage extends BasePage {
    /**
     * автор Костенко Сергей
     * метод переходит в каталог Яндекса Маркета
     * @return
     */
    @Step("Переход в каталог")
    public YandexMarketPage selectCatalog() {
        SelenideElement btnCatalog = $x("//button[@aria-label='Каталог']");
        btnCatalog.click();
        return this;
    }

    /**
     * автор Костенко Сергей
     * производит наведение курсора мышки для выделения необходимой секции
     * @param section
     * @return
     */
    @Step("Переход в секцию {section}")
    public YandexMarketPage selectSection(String section) {
        $$x("//li[@data-zone-name='category-link']/a/span").find(exactText(section)).hover();
        return this;
    }

    /**
     * автор Костенко Сергей
     * осуществляет переход на указанную подсекцию
     * @param subSection
     * @return
     */
    @Step("Переходим в подсекцию {subSection}")
    public YandexMarketSearchPage selectSubSection(String subSection) {
        SelenideElement serviceNamesLocator = $x("//a[text()='" + subSection + "']");
        serviceNamesLocator.click();
        return new YandexMarketSearchPage();
    }

}
