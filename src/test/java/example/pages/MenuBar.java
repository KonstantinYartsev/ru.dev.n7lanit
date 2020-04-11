package example.pages;

import Intefaces.NameOfElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webDriver.WebDriverManager;

import java.util.List;


public class MenuBar extends BasePage{

        @NameOfElement("Кнопка_Категории")
        @FindBy(xpath = "//a[contains(text(),'Категории')]")
        public WebElement categoriesButton;

        @NameOfElement("Кнопка_Пользователи")
        @FindBy(xpath = "//a[contains(text(),'Пользователи')]")
        public WebElement usersButton;

        @NameOfElement("Кнопка_Поиска")
        @FindBy(xpath = "//i[text()='search']")
        public WebElement searchButton;

        @NameOfElement("Строка_Поиска")
        @FindBy(xpath = "//input[@placeholder=\"Поиск\"]")
        public WebElement usersSearchingField;

        @NameOfElement("Кнопка_Вход")
        @FindBy(xpath = "//button[text()='Войти']")
        public WebElement loginButton;

        @NameOfElement("Поле_Ввода_Логина")
        @FindBy(xpath = "//*[@id=\"id_username\"]")
        public WebElement userNameInput;

        @NameOfElement("Поле_Ввода_Пароля")
        @FindBy(xpath = "//*[@id=\"id_password\"]")
        public WebElement passwordInput;

        @NameOfElement("Кнопка_Входа_Пользователя")
        @FindBy(xpath = "//*[@id=\"modal-mount\"]//button[contains(text(),'Войти')]")
        public WebElement userLoginButton;

        @NameOfElement("Иконка_Пользователя")
        @FindBy(xpath = "//*[@id=\"user-menu-mount\"]//img")
        public WebElement userAvatar;




}
