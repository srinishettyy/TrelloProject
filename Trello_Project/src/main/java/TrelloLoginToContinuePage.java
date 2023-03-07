import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLoginToContinuePage extends BaseClass{
	WebDriver driver;
	public TrelloLoginToContinuePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="password")
	private WebElement passwordTextField;
	
	@FindBy(xpath = "//span[text()='Log in']")
	private WebElement loginButton;
	
	
	
	public WebElement getPasswordTextField() {
		return passwordTextField;
	}
	
	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public TrelloBoardsPage loginToContinue() throws EncryptedDocumentException, IOException {
		webutils.elementVisibility(driver, passwordTextField);
		driver.switchTo().activeElement().sendKeys(fileutils.readStringDataFromExcel("Sheet1", 4, 1));
		loginButton.click();
		return new TrelloBoardsPage(driver);
	}

}
