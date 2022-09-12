package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import helper.assertion.Assertions;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.*;

/**
 * @author Администратор
 * @date 25.08.2022
 */

public class YandexMarketSearchPage extends BasePage {

    /**
     * автор Костенко Сергей
     * производит поиск наименования производителя товара путем ввода в поле поиска названия производителя
     *
     * @param brand
     * @return
     */
    @Step("Выбор производителя по наименованию {brand}")
    public YandexMarketSearchPage chooseManufacturer(String brand) {
        SelenideElement count = $x("//span[@data-auto='intent-link']");
        String countBefore = count.getText();

        SelenideElement btnSelect = $x("//span[text()='Показать всё']");
        btnSelect.click();
        SelenideElement fieldSelect = $x("//label[text()='Найти производителя']/following-sibling::input");
        fieldSelect.click();
        fieldSelect.setValue(brand);
        SelenideElement result = $x("//span[text()='" + brand + "']");
        result.click();
        count.shouldNot(Condition.exactText(countBefore));
        return this;
    }

    @Step("Дождаться результатов поиска.")
    public YandexMarketSearchPage waitResults() {
        SelenideElement wait = $x("//*[@aria-label='Загрузка...']");
        wait.should(disappear);
        return page(YandexMarketSearchPage.class);
    }

    /**
     * автор Костенко Сергей
     * Получает все товары на всех страницах поиска
     *
     * @return список с названиями товаров
     */
    private List<String> getAllItems() {
        ElementsCollection names = $$x("//*[contains(@data-zone-name, 'title')]");
        SelenideElement moreButton = $x("//button[@data-auto='pager-more']");
        List<String> namesList = new ArrayList<>();
if(!moreButton.exists()){
    namesList.addAll(names.texts());
    return namesList;
}
        int count=0;
        while (moreButton.exists()) {

            if (!moreButton.exists()|| count>1000) {
                break;
            }
            moreButton.scrollTo();
            namesList.addAll(names.texts());
            moreButton.click();
            waitResults();
            count++;
        }
        return namesList;
    }

    /**
     * автор Костенко Сергей
     * производит сравнение списка найденных товаров с условием переданном в параметре
     *
     * @param containsText
     * @return
     */
    @Step("Проверка полученного списка товаров по указанному производителю - {containsText} ")
    public YandexMarketSearchPage checkingSearchResults(String containsText) {
        List<String> items = getAllItems();
        boolean isAllMatch = items.stream().allMatch(x -> x.contains(containsText));
        Assertions.assertTrue(isAllMatch, "В выборку попали не только " + containsText);
        return this;
    }
}
