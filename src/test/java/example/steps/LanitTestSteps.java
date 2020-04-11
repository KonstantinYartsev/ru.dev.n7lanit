package example.steps;

import example.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.ru.*;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import webDriver.WebDriverManager;;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;


public class LanitTestSteps  {

    private static WebDriverWait waiter;
    MainPage mainPage = new MainPage();
    MenuBar menuBar = new MenuBar();
    CategoriesPage categoriesPage = new CategoriesPage();
    UsersPage usersPage = new UsersPage();
    UserPage userPage = new UserPage();


    @Пусть("открыт браузер и введен адрес \"(.*)\"$")
    public void browserIsOpenAndAddressIsEntered(String url) {
        mainPage.openPage(url);
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
            waiter.until(visibilityOf(categoriesPage.get(name)));
        }catch (TimeoutException e){
            Assert.fail("Элемент " + name + " не отобразился" + e.getMessage());
        }
    }

    @Когда("будет открыта страница с {string}")
    public void usersPageIsOpened(String name) {
        try {
            waiter.until(visibilityOf(usersPage.get(name)));
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
            waiter.until(visibilityOf(userPage.get(name)));
        }catch (TimeoutException e){
            Assert.fail("Элемент " + name + " не отобразился" + e.getMessage());
        }
    }

    @Когда("будет доступно {string}")
    public void fieldIsVisibility(String name) {
        try {
            waiter.until(visibilityOf(menuBar.get(name)));
        }catch (TimeoutException e){
            Assert.fail("Элемент " + name + " не отобразился" + e.getMessage());
        }
    }

    public static void startWaiter(){waiter = new WebDriverWait(WebDriverManager.getDriver(), 5);}
    public static void stopWaiter(){
        waiter = null;
    }
}
