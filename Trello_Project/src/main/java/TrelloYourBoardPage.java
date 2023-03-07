import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloYourBoardPage extends BaseClass{
	WebDriver driver;
	public TrelloYourBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = "input[class='list-name-input']")
	private WebElement listTextField;
	
	@FindBy(css = "input[type='submit']")
	private WebElement addListButton;
	
	
	
	public WebElement getListTextField() {
		return listTextField;
	}
	
	public WebElement getAddListButton() {
		return addListButton;
	}
	
	
	public TrelloBoardTermination createNewList() throws EncryptedDocumentException, IOException {
		webutils.elementVisibility(driver, listTextField);
		driver.switchTo().activeElement().sendKeys(fileutils.readStringDataFromExcel("Sheet1", 10, 1));
		addListButton.click();
		return new TrelloBoardTermination(driver);
	}

}
