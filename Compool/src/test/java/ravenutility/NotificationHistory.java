package ravenutility;

import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;
import utility.*;

public class NotificationHistory
{
	public static void choosenotification(String value) throws Exception
	{
		List <WebElement> allnoti = Constant.driver.findElements(By.xpath("//div[@class='PopoutTableColumn_column Record_identityColumn']"));
		int lastrecord = allnoti.size();
		System.out.println("NO OF RECORDS:  "+ lastrecord);


		List<WebElement> dateelements = Constant.driver.findElements(By.xpath("//div[@class='PopoutTableColumn_column Record_insertedDateColumn']"));
		Control.takeScreenshot();

		List<WebElement> dateelements1 = Constant.driver.findElements(By.xpath("//div[@class='PopoutTableColumn_column Record_insertedDateColumn']"));
		String value1 = dateelements1.get(lastrecord-1).getText();
		System.out.println("LAST RECORD VALUE:  "+ value1);

		for(WebElement ele : dateelements) {

			  String noti = ele.getText();
			  System.out.println("IDENTITY:  "+ noti);
			 if(noti.contains(value))
			  { 

		  //WebElement Lastrow =Constant.driver.findElement(By.xpath("//div[@class='PopoutTableColumn_column Record_insertedDateColumn']["+lastrecord+"]"));
		  //ele.click();
		  //Lastrow.click();	  
				  ele.click();
				  break;
			  }
			 
			 if(lastrecord == 0) {	 
				 Control.takeScreenshot();	 
				 break;
			
		/*
		List <WebElement> updated = Constant.driver.findElements(By.xpath("//div[@class='PopoutTableColumn_column Record_updatedDateColumn']"));
		int updatedR = updated.size();
		System.out.println("This is your UPDATED: " + updatedR);
	
		for (WebElement u : updated) {
			List <WebElement> uu = Constant.driver.findElements(By.xpath("//div[@class='PopoutTableColumn_column Record_updatedDateColumn']"));
				for(WebElement uuu : uu) {
					System.out.println("This is your: " + uuu.getText());
					
					if (uuu.getText().equals()) {				
						
						uuu.click();
						
					}
					*/
				}
				
			}
		
	}
}
	
	
	
	
