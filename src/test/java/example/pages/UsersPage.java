package example.pages;

import Intefaces.NameOfElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPage extends BasePage{

    @NameOfElement("Заголовок_Пользователи")
    @FindBy(xpath = "//h1[text()='Пользователи']")
    public WebElement usersHeader;

}
