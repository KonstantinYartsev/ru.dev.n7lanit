package example;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;
@Test
@CucumberOptions(
        glue = "example.steps",
        features = "src/test/resources/feature"
)

public class LanitTest extends AbstractTestNGCucumberTests {


}
