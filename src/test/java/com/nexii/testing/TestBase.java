package com.nexii.testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import Testutils.Helper;

public class TestBase {
	public static WebDriver driver;
	public static Properties or;
	public static Properties config;
	public static Workbook wb;
	public static Sheet sheetid;
	public static Helper h;
	
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
  
  @BeforeSuite
  public void beforeSuite() throws IOException, Exception {
	  h= new Helper();	  
	  log.debug("Starting the test suite......");
	  log.debug("Loading the config files.....");
	  or = new Properties();
	  config = new Properties();
	  log.debug("Loading the Object repository files.....");
	  or.load(new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\java\\ConfigFiles\\or.properties"));
	  config.load(new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\ConfigFiles\\config.properties"));
	  FileInputStream fp = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\java\\testdata\\NexiiJenkins_or.xls");
	  wb = Workbook.getWorkbook(fp);
	  sheetid = wb.getSheet(0);
	  System.out.println("Choosing the browser: "+ config.getProperty("browsertype"));
		
  }

}
			


