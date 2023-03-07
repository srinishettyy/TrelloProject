import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLoginPage extends BaseClass{
	FileUtility fileutils = new FileUtility();
	WebDriver driver;
	public TrelloLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user")
	private WebElement emailIDTextField;
	
	@FindBy(id="login")
	private WebElement continueButton;
	
	@FindBy(className="signupLink")
	private WebElement signupLink;
	
	public WebElement getSignupLink() {
		return signupLink;
	}

	public WebElement getEmailIDTextField() {
		return emailIDTextField;
	}
	
	public WebElement getContinueButton() {
		return continueButton;
	}

	public TrelloLoginToContinuePage login() throws EncryptedDocumentException, IOException {
		driver.switchTo().activeElement().sendKeys(fileutils.readStringDataFromExcel("Sheet1", 3, 1));
		continueButton.click();
		return new TrelloLoginToContinuePage(driver);
	}

}
