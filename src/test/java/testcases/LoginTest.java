package testcases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseClass {
	
	
	@Test
	public void TC001_LoginTest() throws IOException {
		LoginPage lp=new LoginPage(driver);
		logger.info("running test case TC001");
		lp.usName(username);
		logger.info("entered username");
		lp.pwName(password);
		logger.info("entered password");
		lp.logIn();
		logger.info("submitted login button");
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
			Assert.assertTrue(true);
			System.out.println("test case passed");
			logger.info("test case passed");
		}
		else {
			screenShot(driver,"TC001");
			System.out.println("test case failed");
			logger.warn("test case failed");
			Assert.assertTrue(false);
		}
		
	}

}
