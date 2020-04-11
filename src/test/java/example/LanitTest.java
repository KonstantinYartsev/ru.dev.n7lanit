package example;

import com.codeborne.selenide.Selenide;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import java.io.IOException;

@CucumberOptions(
        glue = "example.steps",
        features = "src/test/resources/feature"
)

public class LanitTest extends AbstractTestNGCucumberTests {


}
