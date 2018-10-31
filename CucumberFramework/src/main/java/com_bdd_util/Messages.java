package com_bdd_util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com_bdd_base.TestBase;


public class Messages extends TestBase
{
	public static WebElement ErrorMessage()
	{
		WebElement SaveMessage= driver.findElement(By.xpath("//span[@class='toast-msg ng-binding ng-scope']"));
		return  SaveMessage;

	}
	public static WebElement SaveSucessfullyMessage()
	{
		WebElement Error= driver.findElement(By.xpath("//span[@class='toast-msg ng-binding ng-scope']"));
		return Error;
	
	}

}
