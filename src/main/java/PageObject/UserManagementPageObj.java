import org.openqa.selenium.By;

public class UserManagementPageObj {
	
	//Knowledge
	public By KnowledgeTopLink = By.linkText("Knowledge");

	//Company
	public By CompanySaveButton = By.id("pii-admin-cust-button-save");
	public By CompanySaveConfirmButton = By.id("pii-admin-cust-dialog-confirmed");
	//Errors
	public By CompanyIdError = By.id("pii-admin-cust-cid-error");
	public By CompanyNameError = By.id("pii-admin-cust-name-error");
	public By CompanyAddressError = By.id("pii-admin-cust-address-error");
	public By CompanyPhoneError = By.id("pii-admin-cust-tel-error");
	public By CompanyBusinessContactError = By.id("pii-admin-cust-busCts-error");
	public By CompanyTechnicalContactError = By.id("pii-admin-cust-tecCts-error");
	//Create user
	public By CreateUserLoginName = By.id("pii-admin-user-loginname");
	public By CreateUserPassword = By.id("pii-admin-user-password");
	public By CreateUserReTypePassword = By.id("pii-admin-user-password-again");
	//Edit user
	public By EditUserMessageOnTop = By.xpath(".//*[@id='pii-admin-user-messages']/div");
	//User Profile
	public By UserProfileEmailField = By.id("pii-admin-user-email");
	public By UserProfileSaveButton = By.id("pii-admin-user-button-save");
	public By UserProfileSavePopupTitle = By.id("pii-admin-user-dialog-title");
	public By UserProfileSavePopupConfirmButton = By.id("pii-admin-user-dialog-confirmed");
	//Edit group
	public By EditGroupMessageOnTop = By.xpath(".//*[@id='pii-admin-group-messages']/div");
}
