package pages;

import com.codeborne.selenide.Selenide;
import helper.properties.Properties;
import io.qameta.allure.Step;


/**
 * @author Администратор
 * @date 25.08.2022
 */

public abstract class BasePage {
    /**
     * автор Костенко Сергей
     * метод базового класса для открытия основной страницы браузера
     */
    @Step("Осуществляем вход на страницу Яндекса")
    public YandexMainPaig open() {
        Selenide.open(Properties.urlProperties.yandexExchangeUrl());
        return new YandexMainPaig();
    }
}
