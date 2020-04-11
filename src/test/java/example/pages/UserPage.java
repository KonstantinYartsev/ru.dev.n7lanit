package example.pages;

import Intefaces.NameOfElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage extends BasePage{

    @NameOfElement("Имя_Пользователя")
    @FindBy(xpath = "//h5[text()='Konstantin']")
    public WebElement userHeader;

}
