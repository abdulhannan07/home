package testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;

public class BaseClass {
	
	public Logger logger;

	ReadConfig rd=new ReadConfig();

	public WebDriver driver;

	String Baseurl=rd.baseUrl();
	String username=rd.userName();
	String password=rd.passWord();



	@BeforeClass
	public void startUrl() {
		
		logger=Logger.getLogger("automation project");
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.chrome.driver", rd.chrome());
		logger.info("launched browser");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Baseurl);
		logger.info("launched url");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}


	@AfterClass
	public void closeBrowser() {
		driver.quit();
		logger.info("closed browser");
	}

	public void screenShot(WebDriver driver, String testcaseName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File(System.getProperty("user.dir")+"//Screenshots//"+testcaseName+".png");
		FileUtils.copyFile(source, destination);
		System.out.println("screenshot taken");
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}catch
		(Exception e){
			return false;

		}

	}

}
