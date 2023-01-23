package testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelLibrary;

public class LoginTestDDT extends BaseClass {
	
	ExcelLibrary ex=new ExcelLibrary();
	
	@Test(dataProvider="DDT")
	public void TC_002_LoginTestDDT(String us, String pw) throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		
		logger.info("running test case LoginTestDDT");
		lp.usName(us);
		logger.info("entered username");
		lp.pwName(pw);
		logger.info("entered password");
		lp.logIn();
		logger.info("submitted login btn");
		Thread.sleep(2000);;
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			System.out.println("test case failed");
			logger.info("test case failed");
			Assert.assertTrue(false);
		}else {
			
			lp.logOut();
			logger.info("entered logout button");
			Thread.sleep(2000);
			Assert.assertTrue(true);
			System.out.println("test case passed");
			logger.info("test case passed");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
	
	
	@DataProvider(name="DDT")
	public Object[][] dataType(){
		return new Object[][] {
			{ex.exceLib("Sheet1", 0, 0),ex.exceLib("Sheet1", 0, 1)},
			{ex.exceLib("Sheet1", 1, 0),ex.exceLib("Sheet1", 1, 1)},
			{ex.exceLib("Sheet1", 2, 0),ex.exceLib("Sheet1", 2, 1)},
			{ex.exceLib("Sheet1", 3, 0),ex.exceLib("Sheet1", 3, 1)},
			{ex.exceLib("Sheet1", 4, 0),ex.exceLib("Sheet1", 4, 1)},
			{ex.exceLib("Sheet1", 5, 0),ex.exceLib("Sheet1", 5, 1)},
			
			
	};
	
	
	}
}
