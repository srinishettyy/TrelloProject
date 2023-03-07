import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloBoardsPage extends BaseClass{
	WebDriver driver;
	public TrelloBoardsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Create new board']")
	private WebElement createNewBoardOption;
	
	@FindBy(css = "input[data-testid='create-board-title-input']")
	private WebElement boardTitleTextField;
	
	@FindBy(xpath = "//button[text()='Create']")
	private WebElement createButton;
	
	@FindBy(className = "list-name-input")
	private WebElement listTextField;
	
	@FindBy(css = "button[aria-label='Open member menu']")
	private WebElement profileIcon;
	
	@FindBy(xpath = "//span[text()='Log out']")
	private WebElement logoutOption;
	
	@FindBy(xpath = "//span[@class='css-178ag6o']")
	private WebElement logoutButton;
	
	public WebElement getCreateNewBoardOption() {
		return createNewBoardOption;
	}
	
	public WebElement getBoardTitleTextField() {
		return boardTitleTextField;
	}
	
	public WebElement getCreateButton() {
		return createButton;
	}

	public WebElement getListTextField() {
		return listTextField;
	}
	
	public WebElement getProfileIcon() {
		return profileIcon;
	}
	
	private WebElement getLogoutOption() {
		return logoutOption;
	}
	
	private WebElement getLogoutButton() {
		return logoutButton;
	}
	
	public TrelloYourBoardPage createNewBoard() throws EncryptedDocumentException, IOException {
		webutils.elementVisibility(driver, createNewBoardOption);
		createNewBoardOption.click();
		webutils.elementVisibility(driver, boardTitleTextField);
		driver.switchTo().activeElement().sendKeys(fileutils.readStringDataFromExcel("Sheet1", 9, 1));
		createButton.click();
		return new TrelloYourBoardPage(driver);
	}

}
