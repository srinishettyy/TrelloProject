import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloBoardTermination extends BaseClass {
	WebDriver driver;
	public TrelloBoardTermination(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(@class,'list-header-extras-menu')]")
	private WebElement listMeatballsMenu;
	
	@FindBy(xpath = "//a[text()='Archive this list']")
	private WebElement archivethislistButton;
	
	@FindBy(xpath = "//button[contains(@class,'frrHNIWnTojsww GDunJzzgFqQY_3')]/span")
	private WebElement boardsMeatballsMenu;
	
	@FindBy(css = "a[class='board-menu-navigation-item-link js-open-more']")
	private WebElement moreOption;
	
	@FindBy(xpath = "//li[@class='board-menu-navigation-item']/a[contains(@class,'board-menu-navigation-item-link js-close-board')]")
	private WebElement closeboardButton;
	
	@FindBy(css = "input[value='Close']")
	private WebElement closeButton;
	
	@FindBy(xpath = "//button[text()='Permanently delete board']")
	private WebElement permanentlydeleteboardLink;
	
	@FindBy(xpath = "//button[text()='Delete']")
	private WebElement deleteButton;
	
	public void deleteCreatedBoard() {
		boardsMeatballsMenu.click();
		webutils.elementVisibility(driver, moreOption);
		moreOption.click();
		webutils.elementVisibility(driver, closeboardButton);
		closeboardButton.click();
		webutils.elementVisibility(driver, closeButton);
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", closeButton);
		//closeButton.click();
		webutils.elementVisibility(driver, permanentlydeleteboardLink);
		permanentlydeleteboardLink.click();
		webutils.elementVisibility(driver, deleteButton);
		deleteButton.click();
	}

}
