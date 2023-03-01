package NFFunction;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utility.Constant;
import utility.Control;
import utility.Generic;

public class NFWebToolLibrary
{
	public static void LoginToNFWebtool(String MSISDN, String provisionStatus) throws Exception
	{
		    Control.enterText("NFLoginPage", "NfusernameInputField", Generic.ReadFromExcel("NfUserName", "TestData", 1));
			//Control.takeScreenshot();
	    	Control.enterText("NFLoginPage", "NfPasswordInputField", Generic.ReadFromExcel("NfPassword", "TestData", 1));
	    	Control.takeScreenshot();
	    	Control.click("NFLoginPage", "NfloginButton");
	    	Generic.WriteTestData("Login to NF webtool", "", "", "Should be able to login successfully", "Login Successful", "Pass");
	    	Control.click("NFHomePage", "NFSubscriptionHeader");
	    	Control.takeScreenshot();
	    	Control.click("NFHomePage", "NFCurrentSubscription");
	    	Control.takeScreenshot();
	    	//Control.objExists("NFHomePage","NFCurrentSubscriptionHeader", true);
	    	//String date = LocalDate.now().minusDays(1).toString();
//	    	String date = LocalDate.now().toString();
//	    	Control.enterText("NFHomePage", "Subscription_Calender",date);
	    	Generic.WriteTestData("Enter MSISDN to search", "", "", "Should be able to enter MSISDN successfully", "MSISDN entered successfully", "Pass");
	    	Control.enterText("NFHomePage", "NFMSISDNInputField" ,MSISDN);
	    	Control.takeScreenshot();
	    	//Control.takeScreenshot();
	    	WebElement status=Control.findElement("NFHomePage", "StatusFilter");
	    	if(status!=null)
	    	{
	    		if(provisionStatus.equalsIgnoreCase("active"))
	    			{
	    			Select typeofFilter= new Select(status);
	    			typeofFilter.selectByVisibleText("Active");
	    			Generic.WriteTestData("Selecting the promo status type", "", "", "User should be able to select status as Active", "Active status selected successfully", "Pass");
	    			}
	    		else
	    		{
	    			String CurrentDateofProvision=GetCurrentDate();
	    	        Control.enterText("NFHomePage", "Subscription_Calender",CurrentDateofProvision);
	    			Select typeofFilter= new Select(status);
	    			typeofFilter.selectByVisibleText("Expired");
	    		}
	    	}
	    	Control.click("NFHomePage", "NFApplyFilter");
	    	WebElement Display=Control.findElement("NF_TransactionsPage", "Display_NoOfRows");
	    	if(Display!=null)
	    	{
	    		Select displaynoofrows=new Select(Display);
	    		displaynoofrows.selectByIndex(2);
	    	}
	}
	public static void LoginToTransaction(String MSISDN, String provisionStatus) throws Exception
	{

		    Control.enterText("NFLoginPage", "NfusernameInputField", Generic.ReadFromExcel("NfUserName", "TestData", 1));
			//Control.takeScreenshot();
	    	Control.enterText("NFLoginPage", "NfPasswordInputField", Generic.ReadFromExcel("NfPassword", "TestData", 1));
	    	Control.takeScreenshot();
	    	Control.click("NFLoginPage", "NfloginButton");
	    	Generic.WriteTestData("Login to NF webtool", "", "", "Should be able to login successfully", "Login Successful", "Pass");
	    	Control.click("NF_TransactionsPage", "TransactionsTab");
	    	Control.takeScreenshot();
//	    	Control.click("NF_TransactionsPage", "ProcessedTxns");
//	    	Control.takeScreenshot();
//	    	Control.objExists("NF_TransactionsPage","ProcessedTxnsheader", true);
	    	//String date = LocalDate.now().minusDays(1).toString();
	    	String date = LocalDate.now().toString();
	    	Control.enterText("NF_TransactionsPage", "From_Calender",date);
	    	Control.enterText("NF_TransactionsPage", "To_Calender",date);
	    	Control.enterText("NFHomePage", "NFMSISDNInputField" ,MSISDN);
	    	Control.takeScreenshot();
	    	Control.click("NFHomePage", "NFApplyFilter");
	    	WebElement Display=Control.findElement("NF_TransactionsPage", "Display_NoOfRows");
	    	if(Display!=null)
	    	{
	    		Select displaynoofrows=new Select(Display);
	    		displaynoofrows.selectByIndex(2);
	    	}
	}
	public static void LoginToNFTransactionWebtool(String MSISDN, String provisionStatus) throws Exception
	{

		//Control.OpenApplication(Generic.ReadFromExcel("Browser", "TestData",1 ), Generic.ReadFromExcel("NfwebtoolURL", "TestData",1 ));
//		    Control.enterText("NFLoginPage", "NfusernameInputField", Generic.ReadFromExcel("NfUserName", "TestData", 1));
//			Control.takeScreenshot();
//	    	Control.enterText("NFLoginPage", "NfPasswordInputField", Generic.ReadFromExcel("NfPassword", "TestData", 1));
//	    	Control.takeScreenshot();
//	    	Control.click("NFLoginPage", "NfloginButton");
//	    	Control.takeScreenshot();
			Generic.WriteTestData("NFTransaction Validation", "", "", "Click on Transaction", "Transaction page loaded successfully", "Pass");
	    	Control.click("NF_TransactionsPage", "TransactionsTab");
	    	Control.takeScreenshot();
//	    	Control.click("NF_TransactionsPage", "ProcessedTxns");
//	    	Control.takeScreenshot();
	    	//Control.objExists("NF_TransactionsPage","ProcessedTxnsheader", true);
	    	//String date = LocalDate.now().minusDays(1).toString();
	    	String date = LocalDate.now().toString();
	    	Control.enterText("NF_TransactionsPage", "From_Calender",date);
	    	Control.enterText("NF_TransactionsPage", "To_Calender",date);
	    	Control.enterText("NFHomePage", "NFMSISDNInputField" ,MSISDN);
	    	Control.takeScreenshot();
	    	Control.click("NFHomePage", "NFApplyFilter");
	    	WebElement Display=Control.findElement("NF_TransactionsPage", "Display_NoOfRows");
	    	if(Display!=null)
	    	{
	    		Select displaynoofrows=new Select(Display);
	    		displaynoofrows.selectByIndex(2);
	    	}
	    	
	}
	
	public static void LoginToCPSPoolWebtool(String MSISDN, String Type) throws Exception
	{
		    Control.enterText("NFLoginPage", "NfusernameInputField", Generic.ReadFromExcel("CPSUserName", "TestData", 1));
			Control.takeScreenshot();
	    	Control.enterText("NFLoginPage", "NfPasswordInputField", Generic.ReadFromExcel("CPSPassword", "TestData", 1));
	    	Control.takeScreenshot();
	    	Control.click("NFLoginPage", "NfloginButton");
	    	Generic.WriteTestData("Login to CPS Pool Instance Tab", "", "", "Should be able to login successfully", "Login Successful", "Pass");
	    	Control.click("CPSPool", "CPSPoolTab");
	    	Control.takeScreenshot();
	    	//Control.objExists("CPSPool","CPSHeader", true);
	    	if(Type.equalsIgnoreCase("Owner"))
	    	{
	    		Generic.WriteTestData("Enter MSISDN", "", "", "Should be able to enter MSISDN to search", "MSISDN entered Successful", "Pass");
	    		Control.enterText("CPSPool", "OwnerMSISDN" ,MSISDN);
		    	Control.takeScreenshot();
	    	}else if(Type.equalsIgnoreCase("Member"))
	    	{
	    		Generic.WriteTestData("Enter MSISDN", "", "", "Should be able to enter MSISDN to search", "MSISDN entered Successful", "Pass");
	    		Control.enterText("CPSPool", "MemberMSISDN" ,MSISDN);
	    		Control.takeScreenshot();
	    	}
	    	Control.click("CPSPool", "Filter");
	    	
	}
	
	public static String GetCurrentDate()
	{
		String CurrentDate;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
    	 LocalDateTime now = LocalDateTime.now();  
    	 CurrentDate= dtf.format(now);
    	 return CurrentDate;
	}
		public static boolean enterMSISDN()
		{
			try
			{

				WebElement textFieldMSISDN=Constant.driver.findElement(By.cssSelector(".tblfilter > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(2) > input:nth-child(1)"));
				
				if(textFieldMSISDN!=null)
				{
					textFieldMSISDN.clear();
					textFieldMSISDN.sendKeys("09451926523");
					return true;
				}
				else
				{
					System.out.println("textFieldMSISDN is null");

				}
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return false;
			
		}
	
		public static boolean setDropDown()
		{
			try
			{
				Select dropdown = new Select(Constant.driver.findElement(By.name("nrecs")));
				
				if(dropdown!=null)
				{
					dropdown.selectByValue("50");
					return true;
				}
				else
				{
					System.out.println("Dropdown is null");
				}

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
			return false;
		}
			
		public static boolean ApplyFilter()
		{
			try
			{
				WebElement applyFilter=Constant.driver.findElement(By.id("search3"));
				
				if(applyFilter!=null)
				{
					applyFilter.click();
					return true;
				}
				else
				{
					System.out.println("Apply filter is null");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return false;
		}
	
		public static boolean initialSetup()
		{
			Constant.driver.get(Constant.NFSubscriptionLink);
			if(enterMSISDN())
			{
				if(setDropDown())
				{
					System.out.println("Drop down value set");
				}
				else
				{
					System.out.println("Unable to set Dropdown value");
				}
				
				if(ApplyFilter())
				{
					System.out.println("Filter Applied successfully");
					return true;
				}
				
			}
			return false;
		}
		
		public static boolean initialSetupWithRetries()
		{
			int ctr=-1;
			while(++ctr<3)
			{
				if(initialSetup())
					return true;
			}
			Generic.WriteTestData("Unable to filter data in NF Webtool. Status will not be fetched", "", "", "Should be able to filter data in NF Webtool & fetch status", "Unable to filter data in NF Webtool", "Fail");
			return false;
		}

		public static boolean getColumnPosition(String columnName)
		{
			WebElement table=Constant.driver.findElement(By.className("tbllist"));
			WebElement tbody=null;
			//table shall atleast be present
			if(table==null)
				return false;
			else
			{
				if((tbody=table.findElement(By.tagName("tbody")))!=null)
				{
					WebElement row=tbody.findElement(By.tagName("tr"));
					if(row!=null)
					{
						List<WebElement> tags= row.findElements(By.tagName("th"));
						int ctr=-1;
						Constant.matchingColumnIndex=-1;
						for(WebElement tag:tags)
						{
							++ctr;
							if(tag.getText().equalsIgnoreCase(columnName))
							{
								Constant.matchingColumnIndex=ctr;
								return true;
							}
						}

					}
					
				}
			}
		return false;	
		}
		
		public static boolean checkStatus(String inputBulkServiceText,String expectedStatus)
		{
			int retryCtr=-1;
			String exception="";
			while(++retryCtr<3)
			{
				try
				{
					List<WebElement> AllRows1=Constant.driver.findElements(By.className("row0"));
					List<WebElement> AllRows2=Constant.driver.findElements(By.className("row1"));

					String actualStatus="";
					Constant.indexBulkService=Constant.columnNumberForBulkIndex-1;
					Constant.indexStatus=Constant.columnNumberForStatus-1;
					
					//iterate over all rows
					for(WebElement row:AllRows1)
					{
						//get all elements in the row
						List<WebElement> rowElements=row.findElements(By.tagName("td"));			
						
						String actualBulkServiceText=rowElements.get(Constant.indexBulkService).getText();
						
						inputBulkServiceText=inputBulkServiceText.toLowerCase();
						actualBulkServiceText=actualBulkServiceText.toLowerCase();
						
						if(actualBulkServiceText.contains(inputBulkServiceText))
						{
							//now check for status
							actualStatus=rowElements.get(Constant.indexStatus).getText().toLowerCase();
							if(actualStatus.contains(expectedStatus.toLowerCase()))
							{
								Generic.WriteTestData("Status matched", "", "", "Expected and Actual status is same", "Expected status : "+expectedStatus+" is same as actual : "+actualStatus, "Pass");
								return true;
							}
						}
						else
						{
							System.out.println("Bulk Service Text does not match");
							Generic.WriteTestData("Status didn't match", "", "", "Expected and Actual status should be same", "Expected status : "+expectedStatus+" is not same as actual : "+actualStatus, "Pass");

							return false;
						}
						
					}
					
					for(WebElement row:AllRows2)
					{
						//get all elements in the row
						List<WebElement> rowElements=row.findElements(By.tagName("td"));			
						
						String actualBulkServiceText=rowElements.get(Constant.indexBulkService).getText();
						
						inputBulkServiceText=inputBulkServiceText.toLowerCase();
						actualBulkServiceText=actualBulkServiceText.toLowerCase();
						
						if(actualBulkServiceText.contains(inputBulkServiceText))
						{
							//now check for status
							actualStatus=rowElements.get(Constant.indexStatus).getText().toLowerCase();
							if(actualStatus.contains(expectedStatus.toLowerCase()))
							{
								Generic.WriteTestData("Status matched", "", "", "Expected and Actual status is same", "Expected status : "+expectedStatus+" is same as actual : "+actualStatus, "Pass");
								return true;
							}
							else
							{
								Generic.WriteTestData("Status didn't match", "", "", "Expected and Actual status should be same", "Expected status : "+expectedStatus+" is not same as actual : "+actualStatus, "Pass");
								return false;
							}
						}
						
					}
					
				}

				catch(Exception e)
				{
					exception=e.getMessage();
					e.printStackTrace();
				}
				

			}
			
			if(!exception.equals(""))
				Generic.WriteTestData("Exception while checking status", "", "", "Exception shall not occur", "Exception:"+exception, "Fail");
			
			else
				Generic.WriteTestData("Status verification failed", "", "", "Should be able to verify status", "Unable to verify status", "Fail");
	
			return false;
		}

		public static boolean NFToolVerifyStatusUsingBulkServiceText(String inputBulkServiceText,String expectedStatus)
		{
			
			if(!initialSetupWithRetries())
			{
				System.out.println("Initial Setup failed, despite retries, cant continue");
				return false;
			}
			else
			{
				System.out.println("Initial Setup Successful");
			}
			

			if(checkStatus(inputBulkServiceText, expectedStatus))
			{
				System.out.println("Scenario Pass");
				return true;
			}
			else
			{
				System.out.println("Scenario Fail");
				return false;
			}

		}
		
		public static void NFwebtoolCheckWithoutPromoAvailment(String MSISDN,String InputValue) throws Exception
		{
			Generic.WriteTestCase("NF Validation","Offer Subscription validation","Expected Result", "Actual Result");
			Generic.WriteManualTestStep("Login to NF webtool", "", "", "Able to login successfully", "", "TBD");
			Constant.desktopscreeshotstatus=true;
			String provisionStatus=InputValue;
			Control.OpenApplication("Chrome", Generic.ReadFromExcel("NfwebtoolURL", "TestData",1 ));
			try
			{
				    LoginToNFWebtool(MSISDN,provisionStatus);
				   Generic.EndManualTestStep();
				   Generic.WriteManualTestStep("Search test number in the Subscriptions tab", "", "", "", "", "TBD");
					int RowCount= Constant.driver.findElements(By.xpath("//tr[contains(@class,'row')]")).size();
			    	if(RowCount<=0)
			    	{
			    		Generic.WriteTestData("Search for Active Promo Availment", "", "", "No promos should be in active status", "No Promos are in active status", "Pass");
			    		Control.takeScreenshot();
			    	}
			    	else
			    	{
//			    		for(int i=1;i<=RowCount;i++)
//			    		{
			    			WebElement elem=Constant.driver.findElement(By.xpath("(//tr[contains(@class,'row')]/td[4])[1]"));
			     			String PromoName=elem.getText().split(" ")[1].replace("(", "").replace(")", "");
			    			Generic.WriteTestData("Search for Active Promo", "", "", "No promos should be in active status", "Active Promos: "+PromoName, "Fail");
//			    		}
//			    		String TransID="";
//			        	try
//			        	{
//			        		TransID=Constant.driver.findElement(By.xpath("(//tr[contains(@class,'row')]/td[1])[1]")).getText();
//			        	}
//			        	catch(Exception e)
//			        	{
//			        		
//			        	}
//			    		Generic.WriteToExcel_BulkService("TransactionID_CurrentSubscriptions", TransID, "MaxToStore", 1);
		    		
			    	}
			    	Control.click("NFHomePage", "Logout");
			    	Generic.EndManualTestStep();
			    	Constant.desktopscreeshotstatus=false;
					Constant.driver.quit(); 
					Constant.flag=false;
			    	
			}
			catch(Exception e)
			{
				e.printStackTrace();
				Generic.EndManualTestStep();
				Constant.desktopscreeshotstatus=false;
				Constant.driver.quit(); 
				Constant.flag=false;
				
			}
				}
	
		public static void NFwebtoolCheckWithPromoAvailment(String MSISDN,String InputValue,String value, String Type) throws Exception 
		{
			Generic.WriteTestCase("NF Validation","Offer Subscription validation","Expected Result", "Actual Result");
			Generic.WriteManualTestStep("Login to NF webtool", "", "", "Able to login successfully", "", "TBD");
			Constant.desktopscreeshotstatus=true;
			String provisionStatus=InputValue;			
			{
				Control.OpenApplication("Chrome", Generic.ReadFromExcel("NfwebtoolURL", "TestData",1 ));
				try
				{
					    LoginToNFWebtool(MSISDN,provisionStatus);
					    Generic.EndManualTestStep();
					    Generic.WriteManualTestStep("Search test number in the Subscriptions tab", "", "", "", "", "TBD");
						int rowNumber =1;
				    	int RowCount= Constant.driver.findElements(By.xpath("//tr[contains(@class,'row')]")).size();
				    	System.out.println(RowCount);
//					    for(int j=1;j<=RowCount;j++)
//					    	{
					    if(!(RowCount==0))
					    	{
					    		WebElement element=Constant.driver.findElement(By.xpath("(//tr[contains(@class,'row')]/td[4])[1]"));
					    		String capturedPromo = element.getText().split(" ")[1].replace("(", "").replace(")", "");
					    		if(Constant.list.contains(capturedPromo));
					    		{
					    			Control.takeScreenshot();
		        					Generic.WriteTestData("Bulk Service Validation","", "", "Should be able to find Bulk Services", "Bulk Services Available:" +capturedPromo, "Pass");
	        					    
	        					    element = Constant.driver.findElement(By.xpath("(//tr[contains(@class,'row')]/td[15])[1]"));
	        					   // System.out.println("element.getText()"+element.getText());
	        					    if(element.getText().contains(provisionStatus.toUpperCase()))
	        					    {
	        					        Constant.flag=true;
	        					    	Control.takeScreenshot();
	        					    	Generic.WriteTestData("Status of the Bulk Service", capturedPromo, "", "Should be able to find status of "+capturedPromo, "Able to find the status of "+capturedPromo+" with status as "+provisionStatus.toUpperCase(), "Pass");
	        					    }
	        					    
	        					    	String elements = Constant.driver.findElement(By.xpath("(//tr[contains(@class,'row')]/td[7])[1]")).getText();
	        					    	Date NewDate= new Date();
	        				    		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd"); //, Locale.ENGLISH6
	        				    		String Date = date.format(NewDate);
	        				    		System.out.println(Date);
		        					   // System.out.println("element.getText()"+element.getText());
		        					    if(elements.contains(Date))
		        					    {
		        					        Constant.flag=true;
		        					    	Control.takeScreenshot();
		        					    	Generic.WriteTestData("Subscription Date validation","", "", "Expected subscription start date of "+capturedPromo+ " is " +Date, "Actual subscription start date of "+capturedPromo+" id "+elements, "Pass");
		        					    }
		        					    else
		        					    {
		        					    	Control.takeScreenshot();
		        					    	Generic.WriteTestData("Subscription Date validation","", "", "Expected subscription start date of "+capturedPromo+ " is " +Date, "Actual subscription start date of "+capturedPromo+" id "+elements, "Fail");
		        					    }
		        					    elements = Constant.driver.findElement(By.xpath("(//tr[contains(@class,'row')]/td[8])[1]")).getText();
		        					    int values = Integer. parseInt(value);
		        					    SimpleDateFormat dates = new SimpleDateFormat("yyyy-MM-dd");
		        			    	    Calendar c = Calendar.getInstance();
		        			    	    c.setTime(new Date()); // Using today's date
		        			    	    c.add(Calendar.DATE, values); // Adding 7days
		        			    	    String output = dates.format(c.getTime());
		        			    	    System.out.println(output);
		        					    if(elements.contains(output))
		        					    {
		        					        Constant.flag=true;
		        					    	Control.takeScreenshot();
		        					    	Generic.WriteTestData("Subscription End Date validation","", "", "Expected Subscription end date of "+capturedPromo+ " is " +output, "Actual Subscription End Date of "+capturedPromo+" is "+elements, "Pass");
		        					    }
		        					    else
		        					    {
		        					    	Control.takeScreenshot();
		        					    	Generic.WriteTestData("Subscription End Date validation","", "", "Expected Subscription end date of "+capturedPromo+ " is " +output, "Actual Subscription End Date of "+capturedPromo+" is "+elements, "Fail");
		        					    }
	        					    
					    		}//end of if loop
					    			
//					    	}//end of j loop
					    	}else
					    	{
					    		Generic.WriteTestData("Bulk Service", "","", "Should be able to find Bulk Services:", "Not Able to find Bulk Services:", "Fail");	
					    	}
					    Generic.EndManualTestStep();
					  //end of i loop
					    Constant.desktopscreeshotstatus=false;
						Constant.flag=false;
				    }//end of try statement
				
				catch(Exception e)
				{
					e.printStackTrace();
					Constant.desktopscreeshotstatus=false;
					Constant.driver.quit();
					Constant.flag=false;
				}//end of catch statement

			}
			
			try
			{
				Constant.desktopscreeshotstatus=true;
				Generic.WriteManualTestStep("Search test number in the Transaction tab", "", "", "", "", "TBD");
				LoginToNFTransactionWebtool(MSISDN,provisionStatus);
				    int rowNumber =1;
			    	int RowCount= Constant.driver.findElements(By.xpath("//tr[contains(@class,'row')]")).size();
			    	System.out.println(RowCount);
//				    for(int j=1;j<=RowCount;j++)
//				     {
			    	if(!(RowCount==0))
			    	{
				    	System.out.println("found");
				    	Thread.sleep(2000);
			    		String origin=Constant.driver.findElement(By.xpath("(//tr[contains(@class,'row')]/td[18])[1]")).getText().trim();
			    		if (origin.equalsIgnoreCase(Type))
			    		{
			    			System.out.println("found");
			    			WebElement element=Constant.driver.findElement(By.xpath("(//tr[contains(@class,'row')]/td[7])[1]"));
				    		String capturedPromo = element.getText().split(" ")[1].replace("(", "").replace(")", "");
				    		System.out.println(capturedPromo);
				    		//if(Constant.list.contains(capturedPromo))
				    		{
				    			System.out.println("found");
				    			Control.takeScreenshot();
	        					Generic.WriteTestData("Bulk Service validation", "", "", "Should be able to find Bulk Services", "Able to find Bulk Services:"+capturedPromo, "Pass");
	        					WebElement D= Constant.driver.findElement(By.xpath("(//tr[contains(@class,'row')]/td[20])[1]"));
    							JavascriptExecutor js = (JavascriptExecutor) Constant.driver;
    							js.executeScript("arguments[0].scrollIntoView(true);", D);
        					    String element1 = Constant.driver.findElement(By.xpath("(//tr[contains(@class,'row')]/td[20])[1]")).getText();
        					   // System.out.println("element.getText()"+element.getText());
        					    if(element1.contains("No Error"))
        					    {
        					    	System.out.println("found");
        					    	Constant.flag=true;
        					    	Control.takeScreenshot();
        					    	Generic.WriteTestData("BulkService Status validation" ,"", "", "Should be able to find status of "+capturedPromo, "Able to find the status of "+capturedPromo+" with status as "+element1, "Pass");
        					    }
        					    else
        					    {
        					    	System.out.println("found");
        					    	Control.takeScreenshot();
        					    	Generic.WriteTestData("BulkService Status validation" ,"" , "", "Should be able to find status of "+capturedPromo, "Found the status of "+capturedPromo+" with status as "+element1, "Fail");
        					    }
				    		} 
				    		}else
				    		{
				    			Control.takeScreenshot();
				    			Generic.WriteTestData("Bulk Service", "","", "Should be able to find Bulk Services:", "Not Able to find Bulk Services with the type: "+Type+"", "Fail");
				    		}//end of if loop
				    	}	else
				    		{
				    			Control.takeScreenshot();
				    			Generic.WriteTestData("Bulk Service", "","", "Should be able to find Bulk Services:", "Not Able to find Bulk Services:", "Fail");
				    		}
//				    	}//end of j loop
				    	
				    	Control.click("NFHomePage", "Logout");
				  //end of i loop
				    Generic.EndManualTestStep();
				    Constant.desktopscreeshotstatus=false;
					Constant.driver.quit(); 
					Constant.flag=false;
			    }//end of try statement
			
			catch(Exception e)
			{
				e.printStackTrace();
				Control.takeScreenshot();
    			Generic.WriteTestData("Bulk Service", "","", "Should be able to find Bulk Services:", "Not Able to find Bulk Services:", "Fail");
				Constant.desktopscreeshotstatus=false;
				Constant.driver.quit();
				Constant.flag=false;
			}//end of catch statement

		
		}

		public static void NFwebtoolCheckSMS(String MSISDN,String InputValue, String Type) throws Exception 
		{
			Constant.desktopscreeshotstatus=true;
			String provisionStatus=null;
			if(InputValue.equalsIgnoreCase("Promo")){
				provisionStatus = "No Error";
				System.out.println("PROMO DATABAL");
			}else if(InputValue.equalsIgnoreCase("NoPromo")){
				provisionStatus = "Group Status No Active Subscription";
				System.out.println("NoPROMO DATABAL");
			}
			System.out.println(provisionStatus);
			// String provisionStatus=InputValue;	
			try
			{
				Control.OpenApplication("Chrome", Generic.ReadFromExcel("NfwebtoolURL", "TestData",1 ));				
				LoginToTransaction(MSISDN,provisionStatus);
				    int rowNumber =1;
			    	int RowCount= Constant.driver.findElements(By.xpath("//tr[contains(@class,'row')]")).size();
			    	System.out.println(RowCount);
				    //for(int j=1;j<=RowCount;j++)
				    	//{
				    		String origin=Constant.driver.findElement(By.xpath("(//tr[contains(@class,'row')]/td[18])[1]")).getText();
				    		if (origin.equalsIgnoreCase("SMS"))
				    		{
					    		//WebElement element=Constant.driver.findElement(By.xpath("(//tr[contains(@class,'row')]/td[7])[1]"));
					    		//String capturedPromo = element.getText().split(" ")[1].replace("(", "").replace(")", "");
//					    		if(Constant.list.contains(capturedPromo));
//					    		{
					    			Control.takeScreenshot();
		        					//Generic.WriteTestData("Bulk Service", capturedPromo, "", "Should be able to find Bulk Services:"+capturedPromo, "Able to find Bulk Services:"+capturedPromo, "Pass");
	        					    
		        					 String element1 = Constant.driver.findElement(By.xpath("(//tr[contains(@class,'row')]/td[5])[1]")).getText();
		        					   // System.out.println("element.getText()"+element.getText());
		        					    if(!(element1==null))
		        					    {
		        					        Constant.flag=true;
		        					    	Control.takeScreenshot();
		        					    	Generic.WriteTestData("Message Verification", "", "", "SMS sent", "Message: "+element1, "Pass");
		        					    }
		        					    else
		        					    {
		        					    	Control.takeScreenshot();
		        					    	Generic.WriteTestData("Message Verification" ,"", "", "SMS sent", "Not Able to find the message "+element1, "Fail");
		        					    }
		        					    WebElement F= Constant.driver.findElement(By.xpath("(//tr[contains(@class,'row')]/td[20])[1]"));
		    							JavascriptExecutor js = (JavascriptExecutor) Constant.driver;
		    							js.executeScript("arguments[0].scrollIntoView(true);", F);
		        					String element2 = Constant.driver.findElement(By.xpath("(//tr[contains(@class,'row')]/td[20])[1]")).getText();
	        					   // System.out.println("element.getText()"+element.getText());
	        					    if(element2.contains(provisionStatus)) //NO ERROR changed 11/23/2022 create new variable 
	        					    {
	        					        Constant.flag=true;
	        					    	Control.takeScreenshot();
	        					    	Generic.WriteTestData("Status of the Bulk Service", "", "", "Should be able to find status ", "Able to find the status as "+element2, "Pass");
	        					    }
	        					    else
	        					    {
	        					    	Control.takeScreenshot();
	        					    	Generic.WriteTestData("Status of the Bulk Service", "", "", "Should be able to find status ", "Status found as "+element2, "Fail");
	        					    }
        					    
					    		//}//end of if loop
				    		}else
				    		{
				    			Generic.WriteTestData("SMS Validation", "","", "SMS transaction should be generated in NF", "No Entry of SMS", "Fail");
				    		}
				    		//}//end of j loop
				    Control.click("NFHomePage", "Logout");
				    Constant.desktopscreeshotstatus=false;
					Constant.driver.quit(); 
					Constant.flag=false;
			    }//end of try statement
			
			catch(Exception e)
			{
				e.printStackTrace();
				Constant.desktopscreeshotstatus=false;
				Constant.driver.quit();
				Constant.flag=false;
			}//end of catch statement

		
		}
		
		public static void NFwebtool(String MSISDN,String InputValue, String Type) throws Exception 
		{
			System.out.println("NFWEBTOOL FUNC");
			Constant.desktopscreeshotstatus=true;
			String provisionStatus=InputValue;	
			try
			{
				Control.OpenApplication("Chrome", Generic.ReadFromExcel("NfwebtoolURL", "TestData",1 ));				
				LoginToTransaction(MSISDN,provisionStatus);
				    int rowNumber =1;
			    	int RowCount= Constant.driver.findElements(By.xpath("//tr[contains(@class,'row')]")).size();
			    	System.out.println(RowCount);
			    	if(Type.equalsIgnoreCase("DataBal"))
			    	{
			    		Type = "data bal";
			    	}else if(Type.equalsIgnoreCase("GroupStatus"))
			    	{
			    		Type = "group status";
			    	}
			    	if(!(RowCount==0))
			    	{
				    //for(int j=1;j<=RowCount;j++)
				    	//{
			    			System.out.println("Entered");
			    			Type = Type.toLowerCase();
				    		String origin=Constant.driver.findElement(By.xpath("(//tr[contains(@class,'row')]/td[5])[1]")).getText().trim().toLowerCase();
				    		if (!(origin.equals(null)))
				    		{
				    			origin = origin.replace("\\s+","");	
				    			System.out.println(origin);
						    		System.out.println(Type);
						    		
						    		if (Type.equalsIgnoreCase(origin))
						    		{
							    		//WebElement element=Constant.driver.findElement(By.xpath("(//tr[contains(@class,'row')]/td[7])[1]"));
							    		//String capturedPromo = element.getText().split(" ")[1].replace("(", "").replace(")", "");
		//					    		if(Constant.list.contains(capturedPromo));
		//					    		{
						    			System.out.println("found");
							    			Control.takeScreenshot();
				        					//Generic.WriteTestData("Bulk Service", capturedPromo, "", "Should be able to find Bulk Services:"+capturedPromo, "Able to find Bulk Services:"+capturedPromo, "Pass");
			        					    
				        					 //String element1 = Constant.driver.findElement(By.xpath("(//tr[contains(@class,'row')]/td[5])[1]")).getText();
				        					   // System.out.println("element.getText()"+element.getText());
				        					   // if(!(element1==null))
				        					    {
				        					        //Constant.flag=true;
				        					    	Control.takeScreenshot();
				        					    	Generic.WriteTestData("NF Verification", "", "", "Transaction Found", "Message: "+origin, "Pass");
				        					    }
		//		        					    else
		//		        					    {
		//		        					    	Control.takeScreenshot();
		//		        					    	Generic.WriteTestData("Message Verification" ,"", "", "SMS sent", "Not Able to find the message "+element1, "Fail");
		//		        					    }
				        					    WebElement F= Constant.driver.findElement(By.xpath("(//tr[contains(@class,'row')]/td[20])[1]"));
				    							JavascriptExecutor js = (JavascriptExecutor) Constant.driver;
				    							js.executeScript("arguments[0].scrollIntoView(true);", F);
				        					String element2 = Constant.driver.findElement(By.xpath("(//tr[contains(@class,'row')]/td[20])[1]")).getText();
			        					   // System.out.println("element.getText()"+element.getText());
			        					    if(element2.contains("No Error"))// No Error changed 11/23/2022
			        					    {
			        					        Constant.flag=true;
			        					    	Control.takeScreenshot();
			        					    	Generic.WriteTestData("Status of the Bulk Service", "", "", "Should be able to find status ", "Able to find the status as "+element2, "Pass");
			        					    }
			        					    else
			        					    {
			        					    	Control.takeScreenshot();
			        					    	Generic.WriteTestData("Status of the Bulk Service", "", "", "Should be able to find status ", "Status found as "+element2, "Fail");
			        					    }
        					    
					    		}//end of if loop
				    		}else
				    		{
				    			Generic.WriteTestData("NF Validation", "","", "Transaction should be generated in NF", "No Entry found for "+origin+"", "Fail");
				    		}
				    	}//end of if loop
			    		else
				    	{
			    			Generic.WriteTestData("NF Validation", "","", "Transaction should be generated in NF", "No Entry in Transaction", "Fail");
				    	}
				    Control.click("NFHomePage", "Logout");
				    Constant.desktopscreeshotstatus=false;
					Constant.driver.quit(); 
					Constant.flag=false;
			    }//end of try statement
			
			catch(Exception e)
			{
				e.printStackTrace();
				Constant.desktopscreeshotstatus=false;
				Constant.driver.quit();
				Constant.flag=false;
			}//end of catch statement

		
		}

		
		public static void CPSPoolValidation(String MSISDN, String InputValue) throws Exception 
		{
			try
			{
					Generic.WriteTestCase("CPSPool Validation","Offer Subscription validation","Expected Result", "Actual Result");
					Generic.WriteManualTestStep("Validate CPS Pool Instance Tab", "", "", "", "", "TBD");
					Constant.desktopscreeshotstatus=true;
					Control.OpenApplication("Chrome", Generic.ReadFromExcel("CPSwebtoolURL", "TestData",1 ));
					LoginToCPSPoolWebtool(MSISDN,InputValue);
					Control.takeScreenshot();
					WebElement SI=Control.findElement("CPSPool", "IDLink");
					if(!(SI==null))
		    		{
					String	SID=Control.findElement("CPSPool", "IDLink").getText();
						String SubscriptionID = SID.split(" ")[0].replace("(", "").replace(")", "");
						if(InputValue.equalsIgnoreCase("owner"))
						{
			    			Generic.WriteTestData("SubscriptionID","", "", "Should be able to find SubscriptionID:"+SubscriptionID, "Able to find SubscriptionID:"+SubscriptionID, "Pass");
							Constant.driver.findElement(By.xpath("//table[contains(@class,'tbllist')]//td//a")).click();
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.WriteManualTestStep("Validate CPS wallet usage", "", "", "", "", "TBD");
							Constant.driver.findElement(By.xpath("//table[contains(@class,'tbllist')]//td//a//button")).click();
							Control.takeScreenshot();
							ArrayList<String> tabs2 = new ArrayList<String> (Constant.driver.getWindowHandles());
							Constant.driver.switchTo().window(tabs2.get(1));
							Control.takeScreenshot();
							Constant.driver.findElement(By.xpath("//select[contains(@name,'change-unit')]")).click();
							Constant.driver.findElement(By.xpath("//option[contains(@value,'MiB')]")).click();
							Constant.driver.findElement(By.xpath("//select[contains(@name,'change-unit')]")).click();
							Thread.sleep(2000);
							Control.takeScreenshot();
							WebElement B = null;
							try
							{
								B= Constant.driver.findElement(By.xpath("//*[contains(text(),'Owner Usage')]/../..//div[contains(text(),'No member usages found')]"));
							}
							catch (Exception e)
							{
								System.out.println(e);
							}
							if (B==null)
							{
								WebElement e= Constant.driver.findElement(By.xpath("//*[contains(text(),'Member Usages')]/../../table"));
								JavascriptExecutor js = (JavascriptExecutor) Constant.driver;
								js.executeScript("arguments[0].scrollIntoView(true);", e);
								String Allocated = Constant.driver.findElement(By.xpath("//table//td//h3[contains(text(),'"+MSISDN+"')]/../..//div[contains(text(),'Volume Remaining')]/..//div[contains(@class,'data-col')]")).getText();
								Generic.WriteTestData("Volume Remaining Value Validation","", "", "Owner MSISDN volume remaining validation", "Owner: "+MSISDN+ " having " +Allocated+" MB", "Pass");
								String Usage = Constant.driver.findElement(By.xpath("//table//td//h3[contains(text(),'"+MSISDN+"')]/../..//div[contains(text(),'Volume Used')]/..//div[contains(@class,'data-col')]")).getText();
								Generic.WriteTestData("Usage Value validation","", "", "Owner MSISDN volume used validation", "Owner: "+MSISDN+ " used " +Usage+" MB", "Pass");
								Control.takeScreenshot();
								Constant.driver.close();
								
							}
							else
							{
								Control.takeScreenshot();
								Generic.WriteTestData("Owner Usage validation","", "", "Owner MSISDN total allocation validation", "Issue with fetching the usage details", "Fail");
								
							}
						}
						else if(InputValue.equalsIgnoreCase("member"))
						{
							Generic.WriteTestData("SubscriptionID","", "", "Should be able to find SubscriptionID:"+SubscriptionID, "Able to find SubscriptionID:"+SubscriptionID, "Pass");
							Constant.driver.findElement(By.xpath("//table[contains(@class,'tbllist')]//td//a")).click();
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.WriteManualTestStep("Validate CPS wallet usage", "", "", "", "", "TBD");
							//Control.scroll(SID, SubscriptionID)c
//							WebElement es= Constant.driver.findElement(By.xpath("((//table[contains(@class,'tbllist')]//tr)[4]//td)[4]"));
//							JavascriptExecutor jse = (JavascriptExecutor) Constant.driver;
//							jse.executeScript("arguments[0].scrollIntoView(true);", es);
							int totalrow=Constant.driver.findElements(By.xpath("//div[@id='members']/table/tbody/tr")).size();
							System.out.println(totalrow);						
							String member ="null";
							String status ="null";
							for(int i=2; i<=totalrow;i++)
							{
								member=Constant.driver.findElement(By.xpath("((//div[@id='members']/table/tbody/tr)["+i+"]//td)[1]")).getText();
								System.out.println(member);	
								if(!(member.equals(MSISDN)))
								{
									continue;
									//Generic.WriteTestData("Member Validation","", "", "Member "+member+ "should be added", "Added Member:"+MSISDN, "Pass");
								}
								
								else if(member.equals(MSISDN))
								{
									member=MSISDN;
									System.out.println(member);	
									status=Constant.driver.findElement(By.xpath("((//div[@id='members']/table/tbody/tr)["+i+"]//td)[2]")).getText();
									if(status.equalsIgnoreCase("Active"))
										{
											status="Active";
										}
									break;
									//Generic.WriteTestData("Member Validation","", "", "Member "+member+ "should be added", "Member:"+MSISDN, "Fail");
								}
							}//End i loop
							if(member.equals(MSISDN))
							{
								
								Generic.WriteTestData("Member Validation","", "", "Member "+member+ "should be added", "Added Member:"+MSISDN, "Pass");
							}
							
							else
							{
								
								Generic.WriteTestData("Member Validation","", "", "Member "+member+ "should be added", "Member:"+MSISDN, "Fail");
							}
							if(status.equalsIgnoreCase("Active"))
							{
								Generic.WriteTestData("Member status validation","", "", "Member status should be active", "Status of Member:"+MSISDN+ "is" +status, "Pass");
							}
							else
							{
								Generic.WriteTestData("Member status validation","", "", "Member status should be active", "Status of Member:"+MSISDN+ "is" +status, "Fail");
							}
							
							Constant.driver.findElement(By.xpath("//table[contains(@class,'tbllist')]//td//a//button")).click();
							Control.takeScreenshot();
							ArrayList<String> tabs2 = new ArrayList<String> (Constant.driver.getWindowHandles());
							Constant.driver.switchTo().window(tabs2.get(1));
							Control.takeScreenshot();
							Constant.driver.findElement(By.xpath("//select[contains(@name,'change-unit')]")).click();
							Constant.driver.findElement(By.xpath("//option[contains(@value,'MiB')]")).click();
							Constant.driver.findElement(By.xpath("//select[contains(@name,'change-unit')]")).click();
							Thread.sleep(2000);
							Control.takeScreenshot();
							WebElement B = null;
							try
							{
								B= Constant.driver.findElement(By.xpath("//*[contains(text(),'Member Usage')]/../..//div[contains(text(),'No member usages found')]"));
							}
							catch (Exception e)
							{
								System.out.println(e);
							}
							if (B==null)
							{
								WebElement e= Constant.driver.findElement(By.xpath("//*[contains(text(),'Member Usages')]/../../table"));
								JavascriptExecutor js = (JavascriptExecutor) Constant.driver;
								js.executeScript("arguments[0].scrollIntoView(true);", e);
								
								String Allocated = Constant.driver.findElement(By.xpath("//table//td//h3[contains(text(),'"+MSISDN+"')]/../..//div[contains(text(),'Total Allocated')]/..//div[contains(@class,'data-col')]")).getText();
								if (Allocated.equalsIgnoreCase(null))
								{
									Generic.WriteTestData("Member Allocated validation","", "", "Member MSISDN total allocation validation", "Member:"+MSISDN+ "having" +Allocated+" MB", "Fail");
									Control.takeScreenshot();
									Constant.driver.close();
								} else {
								String Remaining = Constant.driver.findElement(By.xpath("//table//td//h3[contains(text(),'"+MSISDN+"')]/../..//div[contains(text(),'Volume Remaining')]/..//div[contains(@class,'data-col')]")).getText();
								Generic.WriteTestData("Member Allocated validation","", "", "Member MSISDN total allocation validation", "Member:"+MSISDN+ "having" +Remaining+" MB", "Pass");
								String Usage = Constant.driver.findElement(By.xpath("//table//td//h3[contains(text(),'"+MSISDN+"')]/../..//div[contains(text(),'Volume Used')]/..//div[contains(@class,'data-col')]")).getText();
								Generic.WriteTestData("Member Allocated validation","", "", "Member MSISDN total allocation validation", "Member:"+MSISDN+ " used " +Usage+" MB", "Pass");
								Control.takeScreenshot();
								Constant.driver.close();
								}
							} else
							{
								Control.takeScreenshot();
								Generic.WriteTestData("Member Allocated validation","", "", "Member MSISDN total allocation validation", "Issue with fetching the usage details", "Fail");
								
							}
							
						}
						
		    		}else
		    		{
		    			Generic.WriteTestData("SubscriptionID","", "", "Should be able to find SubscriptionID", "Not Able to find SubscriptionID:", "Fail");
		    			
		    		}
					    Generic.EndManualTestStep();
					//Control.click("NFHomePage", "Logout");
					Constant.desktopscreeshotstatus=false;
						Constant.driver.quit(); 
						Constant.flag=false;
				    }//end of try statement
				
				catch(Exception e)
				{
					e.printStackTrace();
					Constant.desktopscreeshotstatus=false;
					Constant.driver.quit();
					Constant.flag=false;
					//Generic.TestScriptEnds();
					Generic.EndManualTestStep();
				}//end of catch statement		
		
		}

		public static void CPSPoolNoPromoValidation(String MSISDN, String InputValue) throws Exception 
		{
			Generic.WriteTestCase("CPSPool Validation","Offer Subscription validation","Expected Result", "Actual Result");
			Constant.desktopscreeshotstatus=true;
			Control.OpenApplication("Chrome", Generic.ReadFromExcel("CPSwebtoolURL", "TestData",1 ));
			Generic.WriteManualTestStep("Validate CPS Pool Instance Tab", "", "", "", "", "TBD");
			try
				{
					LoginToCPSPoolWebtool(MSISDN,InputValue);
					Control.takeScreenshot();
					Boolean SID=Control.objExists("CPSPool", "NoOffer",true);
					if(SID==true)
		    		{
		    			
    					Generic.WriteTestData("No Offer Validation","", "", "Offer should not be available:", "No offer available", "Pass");
						
		    		}else
		    		{
		    			WebElement SI=Control.findElement("CPSPool", "IDLink");
		    			if(!(SI==null))
			    		{
		    				String Status =Constant.driver.findElement(By.xpath("(//table[@class='tbllist']//td)[3]")).getText();
		    				if(Status.equalsIgnoreCase("Active"))
		    				{
		    					Control.takeScreenshot();
		    					Generic.WriteTestData("No Offer Validation","", "", "Offer should not be available:", "offer available", "Fail");	
		    				}else
		    				{
		    					Generic.WriteTestData("No Offer Validation","", "", "Offer should not be available:", "No offer available in active status", "Pass");
		    				}
			    		}
		    		}
					  
					Control.takeScreenshot();
					Control.click("NFHomePage", "Logout");
					Generic.EndManualTestStep();
					Constant.desktopscreeshotstatus=false;
						Constant.driver.quit(); 
						Constant.flag=false;
				    }//end of try statement
				
				catch(Exception e)
				{
					e.printStackTrace();
					Generic.EndManualTestStep();
					Constant.desktopscreeshotstatus=false;
					Constant.driver.quit();
					Constant.flag=false;
				}//end of catch statement		
		
		}

		
		public static void main(String[] args) throws Exception
		{
			//add this function in keyword
			//NFToolVerifyStatusUsingBulkServiceText("2376","EXPIRED");
			//NFwebtoolCheckWithoutPromoAvailment();
			//BulkServiceValidation(InputValue);
		}
	
}
