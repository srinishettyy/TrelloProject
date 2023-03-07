import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

public class TrelloEndToEndTest extends BaseClass{
	@Test
	public void login() throws EncryptedDocumentException, IOException {
		TrelloHomePage home = new TrelloHomePage(driver);
		TrelloLoginPage login;
		TrelloLoginToContinuePage password;
		TrelloBoardsPage boardsPage;
		TrelloYourBoardPage createNewBoard;
		TrelloBoardTermination boardTerminate;
		login=home.clickOnLoginOption();
		password=login.login();
		boardsPage=password.loginToContinue();
		createNewBoard=boardsPage.createNewBoard();
		boardTerminate=createNewBoard.createNewList();
		boardTerminate.deleteCreatedBoard();
	}

}
