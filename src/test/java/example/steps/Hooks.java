package example.steps;

import example.LanitTest;
import example.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import webDriver.WebDriverManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Hooks {
    private final Logger log = LogManager.getRootLogger();
    final Random random = new Random();
    private int s = random.nextInt();

    @Before
    public void beforeTests(Scenario scenario){
        log.info("Запуск теста "+ scenario.getName());
        LanitTestSteps.startWaiter();
    }


    @After
    public void afterTests(Scenario scenario) throws IOException{

        ++s;
        scenario.embed(takeScreenShotAsByte(WebDriverManager.getDriver()), "image/png", "FullPageScreenshot"+s+".png");
        Screenshot screenshot = new AShot().takeScreenshot(WebDriverManager.getDriver());
        ImageIO.write(screenshot.getImage(),"PNG",new File("target/allure-results/FullPageScreenshot"+s+".png"));

        log.info("Тест завершен "+ scenario.getName());
        WebDriverManager.quit();
        LanitTestSteps.stopWaiter();
        ++s;
    }
    @AfterStep
    public void afterStep(Scenario scenario) throws IOException {
        ++s;
        scenario.embed(takeScreenShotAsByte(WebDriverManager.getDriver()), "image/png", "FullPageScreenshot"+s+".png");
    }

    @Attachment(value = "Скриншот", type = "image/png")
    private static byte[] takeScreenShotAsByte(WebDriver webDriver) throws IOException {
        return takeFullPageScreenShotAsByte(webDriver);
    }


    private static byte[] takeFullPageScreenShotAsByte(WebDriver webDriver) throws IOException {
        Screenshot fpScreenshot = new AShot().takeScreenshot(webDriver);

        BufferedImage originalImage = fpScreenshot.getImage();

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(originalImage, "png", baos);
            baos.flush();
            return baos.toByteArray();
        }
    }
}
