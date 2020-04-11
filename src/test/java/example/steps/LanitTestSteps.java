package example.steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import example.LanitTest;
import io.qameta.allure.Attachment;
import example.pages.*;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.ru.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import webDriver.WebDriverManager;

import java.io.IOException;
import java.nio.file.Files;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;


public class LanitTestSteps  {
    private final Logger log = LogManager.getRootLogger();
    private WebDriver webDriver;
    private WebDriverWait waiter;
    MainPage mainPage = new MainPage();
    MenuBar menuBar = new MenuBar();
    CategoriesPage categoriesPage = new CategoriesPage();
    UsersPage usersPage = new UsersPage();
    UserPage userPage = new UserPage();


    @Before
    public void beforeTests(Scenario scenario){

        log.info("Запуск теста "+ scenario.getName());
        webDriver = WebDriverManager.getDriver();
        waiter = new WebDriverWait(webDriver, 5);
    }


    @After
    public void afterTests(Scenario scenario){
        log.info("Тест заветшен "+ scenario.getName());
        WebDriverManager.quit();
        waiter = null;
    }

    @Пусть("открыт браузер и введен адрес \"(.*)\"$")
    public void browserIsOpenAndAddressIsEntered(String url) {
        mainPage.openPage(url);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }


    @И("пользователь нажмет {string}")
    public void userPressCategoriesButton(String name) {
        try {
            waiter.until(elementToBeClickable(menuBar.get(name)));
            menuBar.get(name).click();
        }catch (TimeoutException e){
            Assert.fail(name + " не доступна!" + e.getMessage());
        }
    }
    @Когда("откроется страница с {string}")
    public void categoriesPageIsOpened(String name) {
        try {
            waiter.until(visibilityOfAllElements(categoriesPage.get(name)));
        }catch (TimeoutException e){
            Assert.fail("Элемент " + name + " не отобразился" + e.getMessage());
        }
    }

    @Когда("будет открыта страница с {string}")
    public void usersPageIsOpened(String name) {
        try {
            waiter.until(visibilityOfAllElements(usersPage.get(name)));
        }catch (TimeoutException e){
            Assert.fail("Элемент " + name + " не отобразился" + e.getMessage());
        }
    }


    @И("пользователь вводит {string} {string}")
    public void userEntersUsersUsername(String name, String userName) {
        try {
            waiter.until(elementToBeClickable(menuBar.get(name)));
            menuBar.get(name).sendKeys(userName);
        }catch (TimeoutException e){
            Assert.fail(name + " не доступно!" + e.getMessage());
        }
    }


    @Тогда("откроется страница пользователя с заголовком {string}")
    public void userPageOpens(String name) {
        try {
            waiter.until(visibilityOfAllElements(userPage.get(name)));
        }catch (TimeoutException e){
            Assert.fail("Элемент " + name + " не отобразился" + e.getMessage());
        }
    }

    @Когда("будетут доступно {string}")
    public void fieldIsVisibility(String name) {
        try {
            waiter.until(visibilityOfAllElements(menuBar.get(name)));
        }catch (TimeoutException e){
            Assert.fail("Элемент " + name + " не отобразился" + e.getMessage());
        }
    }
}
