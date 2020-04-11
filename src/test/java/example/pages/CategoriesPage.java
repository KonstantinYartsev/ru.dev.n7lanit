package example.pages;

import Intefaces.NameOfElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoriesPage extends BasePage {

    @NameOfElement("Заголовок_Категории")
    @FindBy(xpath = "//h1[text()='Категории']")
    public WebElement categoriesHeader;
}
