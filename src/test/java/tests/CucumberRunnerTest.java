package tests;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Чтобы запустить через консоль, нужно прописать команду: mvn test -Dcucumber.options="--tags @Run"
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm", "pretty", "json:target/cucumber-report/report.json"},
        features = "src/test/java/tests/features",
        tags = {"@Run"}
)
public class CucumberRunnerTest {
}
