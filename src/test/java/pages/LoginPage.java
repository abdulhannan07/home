package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="uid")
	WebElement txtusername;
	
	@FindBy(name="password")
	WebElement txtpassword;
	
	@FindBy(name="btnLogin")
	WebElement clickLogin;
	
	@FindBy(linkText="Log out")
	WebElement clickLogout;
	
	public void usName(String us) {
		txtusername.sendKeys(us);
	}
	
	public void pwName(String pw) {
		txtpassword.sendKeys(pw);
	}
	
	public void logIn() {
		clickLogin.click();
	}
	
	public void logOut() {
		clickLogout.click();
	}
	
	
	
	
	
	

}
