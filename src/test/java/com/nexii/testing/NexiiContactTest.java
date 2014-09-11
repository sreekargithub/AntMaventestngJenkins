package com.nexii.testing;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Testutils.Helper;

public class NexiiContactTest extends Helper 
{

  @Test
  public void contactUs() throws IOException {
	  
	  h.choosebrowser();
	  driver.get(config.getProperty("testurl"));
	  driver.manage().window().maximize();
	  driver.findElement(By.id(or.getProperty("name_id"))).sendKeys(sheetid.getCell(0, 0).getContents());
	  driver.findElement(By.id(or.getProperty("email_id"))).sendKeys(sheetid.getCell(0, 1).getContents());
	  driver.findElement(By.id(or.getProperty("website_id"))).sendKeys(sheetid.getCell(0, 2).getContents());
	  driver.findElement(By.id(or.getProperty("message_id"))).sendKeys(sheetid.getCell(0, 3).getContents());
	  h.takeScreenShots("file1");
  }
}
