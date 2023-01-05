package testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import seleniumproject.pageobjects.Login;

public class Base {
	
	
		public WebDriver driver;
		public Login login;
	    public WebDriver initializeDriver() throws IOException {
	    	
	    	
	    Properties prop = new Properties();
	    FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\seleniumproject\\resources\\GlobalData.properties");
	    prop.load(fis);
	    String browser = prop.getProperty("browser");
	    		
	    if(browser.equalsIgnoreCase("chrome")) 
	    {
	    driver = new ChromeDriver();
	    }
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
	}
	    @BeforeMethod(alwaysRun=true)
	    public Login startWebsite() throws IOException {
	    	driver = initializeDriver();
	    	login = new Login(driver);
			login.url();
			return login;
	    }
	    
	    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
	    	TakesScreenshot ts = (TakesScreenshot)driver;
	    	File source = ts.getScreenshotAs(OutputType.FILE);
	    	File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
	    	FileUtils.copyFile(source, file);
	    	return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	    }
	    
	    @AfterMethod(alwaysRun=true)
	    public void closeBrowser()
	    {
	    	driver.quit();
	    }
}
	