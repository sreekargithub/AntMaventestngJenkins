package Testutils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.nexii.testing.TestBase;

public class Helper extends TestBase {
  
  public void choosebrowser() {
	  if (config.getProperty("browsertype").equalsIgnoreCase("ie")) {
		 System.getProperty("webdriver.ie.driver", System.getProperty("user.dir")+ "\\src\\test\\java\\Drivers\\IEDriverServer.exe");
		 driver = new InternetExplorerDriver();
	  } 
	  else if (config.getProperty("browsertype").equalsIgnoreCase("chrome")) {
		System.getProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\java\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	  }
	  else {
		driver = new FirefoxDriver();
	  }
	  
  }
  
  public void takeScreenShots(String filename) throws IOException{
	  File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(scrfile, new File(System.getProperty("user.dir")+"\\src\\test\\java\\Screenshots\\"+filename+".jpg"));
	  
  }
}
