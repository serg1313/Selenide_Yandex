package helper.assertion;
import io.qameta.allure.Step;

/**
 * @author Администратор
 * @date 26.08.2022
 */

public class Assertions {
    /**
     * автор Сергей Костенко
     * переопределяет assert JUnit
     * @param condition
     * @param message
     */
    @Step("Проверка условия")
    public static void assertTrue(boolean condition, String message) {
        org.junit.jupiter.api.Assertions.assertTrue(condition, message);
    }
}
