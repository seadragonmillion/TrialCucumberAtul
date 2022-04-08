package PageObjects;

import org.openqa.selenium.By;


public class LoginPageObj {

	public By LoginButton = By.id("pii-login-button");
	public By UserName = By.id("pii-un");
	public By Password = By.id("pii-pw");
	public By SignInButton = By.id("pii-signin-button");
	public By SignInMessage = By.id("pii-signin-message");
	public By StickyNote = By.className("sticky-note");
	public By StickyClose = By.className("sticky-close");
	public By LoginNameOnTopRight = By.id("pii-user-loginname");
	public By LoginNameMenuRight = By.id("user-menu");
	public By LogOutButton = By.id("pii-signout-button");
	public By WebPageMessage = By.className("pii-slogan");
	public By AgreeTermsButton = By.xpath(".//*[@id='pii-license-checkbox-div']/fieldset/div/div/label");
	public By Iframe = By.xpath("//iframe[@name='pii-iframe-main']");
	public By StickySuccessPopup = By.cssSelector(".sticky.border-top-right.sticky-success");
	public By StickyWarningPopup = By.cssSelector(".sticky.border-top-right.sticky-warning");
	public By KALELogo = By.className("pii-logo-div-element-kale");
	public By piiLabelClass = By.cssSelector(".pii-label");
	public By piiDivBlockA = By.className("ui-block-a");
	public By piiDivBlockB = By.className("ui-block-b");
	public By piiDivBlockC = By.className("ui-block-c");
	
	public By LoginExpiringMessage = By.id("pii-header-message-div");
}
