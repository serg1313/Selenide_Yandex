package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.YandexMainPaig;
import pages.YandexMarketPage;
import pages.YandexMarketSearchPage;
import tests.yandex.BaseTest;

public class StepDefenition {
    private YandexMainPaig yandexMainPaig;
    private YandexMarketPage marketPage;
    private YandexMarketSearchPage yandexMarketSearchPage;

    /**
     * Открывает браузер с настройками
     */
    @Before
    public void openBrowser() {
        BaseTest.init();
    }

    /**
     * Закрывает браузер с настройками
     */
    @After
    public void closeBrowser() {
        BaseTest.close();
    }

    @Given("Открываем сайт Yandex")
    public void openYandex() {
        yandexMainPaig = new YandexMainPaig().open();
    }


    @When("выбираем сервис Маркет")
    public void goYandexMarket() {
        marketPage = yandexMainPaig.searchService("Маркет", YandexMarketPage.class);
    }

    @Then("Нажимаем меню каталога")
    public void openCatalog() {
        marketPage.selectCatalog();
    }


    @When("Переход в секцию {string}")
    public void selectCategory(String category) {
        marketPage.selectSection(category);
    }

    @When("Переходим в подсекцию {string}")
    public void selectSubCategory(String subcategory) {
        yandexMarketSearchPage = marketPage.selectSubSection(subcategory);
    }

    @When("Выбор производителя по наименованию {string}")
    public void selectManufacturer(String manufacturer) {
        yandexMarketSearchPage.chooseManufacturer(manufacturer);
    }

    @When("Проверка полученного списка товаров на наличие указанной модели {string}")
    public void waitsSearchResult(String results) {
        yandexMarketSearchPage.checkingSearchResults(results);
    }

}
