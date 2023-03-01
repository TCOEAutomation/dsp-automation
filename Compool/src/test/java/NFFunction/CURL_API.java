package NFFunction;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import utility.*;

public class CURL_API 
{





public static void CURL(String Type, String Brand, String API, String MSISDN )throws Exception
{
	System.out.println("API:"+ API);
	System.out.println("MSISDN:"+ MSISDN);
	System.out.println("TYPE:"+ Type);
	System.out.println("BRAND:"+ Brand);
	String old_baseurl = Generic.ReadFromExcel("NfwebtoolURL", "TestData",1 );
	String[] new_baseurl = old_baseurl.split("/");
	String baseurl = new_baseurl[2];
	System.out.println(baseurl);
	
	if (Type.equalsIgnoreCase("Provision"))
	{
			// System.out.println(baseurl);
			// return;	
			WebElement B=null;
			Generic.WriteTestCase("CURL API","Subscription to Offer","Expected Result", "Actual Result");
			if(Brand.equalsIgnoreCase("GHP" ))
			{
				if (API.equalsIgnoreCase("SURF249"))
				{
					Control.OpenApplication("Chrome", "http://10.66.9.213:8082/?Operation=1&ServiceID=9955&Param=DEFAULT&Silent=0&SUB_Mobtel=63"+MSISDN+"");
					try
					{
						B=Constant.driver.findElement(By.xpath("//*[contains(text(),'ERR_CODE: 0')]"));
					}	
					catch(Exception e)
					{
						System.out.println(e);
					}
						if (!(B== null))
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "should be able to subscribe", "Successful in offer subscription", "Pass");
							Control.takeScreenshot();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}else
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "Should be able to subscribe", "Issue in offer subscription", "Fail");
							Control.takeScreenshot();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}
								
				}
				else if (API.equalsIgnoreCase("SURF99"))
				{
					Generic.WriteManualTestStep("Provision SURF4ALL99 via SMS or API", "", "", "Should be successful", "", "TBD");
					Control.OpenApplication("Chrome", "http://10.66.9.213:8082/?Operation=1&ServiceID=7367&Param=DEFAULT&Silent=0&SUB_Mobtel=63"+MSISDN+"");
					try
					{
						B=Constant.driver.findElement(By.xpath("//*[contains(text(),'ERR_CODE: 0')]"));
					}	
					catch(Exception e)
					{
						System.out.println(e);
					}
					if (!(B== null))
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "should be able to subscribe", "Successful in offer subscription", "Pass");
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}else
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "Should be able to subscribe", "Issue in offer subscription", "Fail");
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}
					
				}
				else if (API.equalsIgnoreCase("ML"))
				{
					Generic.WriteManualTestStep("Provision ML offer via SMS or API", "", "", "Should be successful", "", "TBD");
					Control.OpenApplication("Chrome", "http://"+baseurl+":8082/?Operation=1&ServiceID=10644&Param=DEFAULT&Silent=0&SUB_Mobtel=63"+MSISDN+"");
					try
					{
						B=Constant.driver.findElement(By.xpath("//*[contains(text(),'ERR_CODE: 0')]"));
					}	
					catch(Exception e)
					{
						System.out.println(e);
					}
					if (!(B== null))
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "should be able to subscribe", "Successful in offer subscription", "Pass");
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}else
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "Should be able to subscribe", "Issue in offer subscription", "Fail");
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}
					
				}
				else if (API.equalsIgnoreCase("SURF4ALL99"))
				{
					Generic.WriteManualTestStep("Provision SURF4ALL99 with WNP offer via SMS or API", "", "", "Should be successful", "", "TBD");
					Control.OpenApplication("Chrome", "http://"+baseurl+":8082/?Operation=1&ServiceID=10634&Param=DEFAULT&Silent=0&SUB_Mobtel=63"+MSISDN+"");
					try
					{
						B=Constant.driver.findElement(By.xpath("//*[contains(text(),'ERR_CODE: 0')]"));
					}	
					catch(Exception e)
					{
						System.out.println(e);
					}
					if (!(B== null))
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "should be able to subscribe", "Successful in offer subscription", "Pass");
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}else
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "Should be able to subscribe", "Issue in offer subscription", "Fail");
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}
					
				}
				else if (API.equalsIgnoreCase("Go90"))
				{
					Generic.WriteManualTestStep("Provision Go90 offer via SMS or API", "", "", "Should be successful", "", "TBD");
					Control.OpenApplication("Chrome", "http://10.66.9.213:8082/?Operation=1&ServiceID=10672&Param=DEFAULT&Silent=0&SUB_Mobtel=63"+MSISDN+"");
					try
					{
						B=Constant.driver.findElement(By.xpath("//*[contains(text(),'ERR_CODE: 0')]"));
					}	
					catch(Exception e)
					{
						System.out.println(e);
					}
					if (!(B== null))
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "should be able to subscribe", "Successful in offer subscription", "Pass");
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}else
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "Should be able to subscribe", "Issue in offer subscription", "Fail");
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}
				}
			}
			else if(Brand.equalsIgnoreCase("TM" ))
			{
				if (API.equalsIgnoreCase("SURF249"))
				{
					Generic.WriteManualTestStep("Provision SURF249 offer via SMS or API", "", "", "Should be successful", "", "TBD");
					Control.OpenApplication("Chrome", "http://10.66.9.213:8082/?Operation=1&ServiceID=9800&Param=DEFAULT&Silent=0&SUB_Mobtel=63"+MSISDN+"");
					try
					{
						B=Constant.driver.findElement(By.xpath("//*[contains(text(),'ERR_CODE: 0')]"));
					}	
					catch(Exception e)
					{
						System.out.println(e);
					}
					if (!(B== null))
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "should be able to subscribe", "Successful in offer subscription", "Pass");
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}else
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "Should be able to subscribe", "Issue in offer subscription", "Fail");
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}
					
				}
				else if (API.equalsIgnoreCase("SURF99"))
				{
					Generic.WriteManualTestStep("Provision SURF99 offer via SMS or API", "", "", "Should be successful", "", "TBD");
					Control.OpenApplication("Chrome", "http://10.66.9.213:8082/?Operation=1&ServiceID=10635&Param=DEFAULT&Silent=0&SUB_Mobtel=63"+MSISDN+"");
					try
					{
						B=Constant.driver.findElement(By.xpath("//*[contains(text(),'ERR_CODE: 0')]"));
					}	
					catch(Exception e)
					{
						System.out.println(e);
					}
					if (!(B== null))
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "should be able to subscribe", "Successful in offer subscription", "Pass");
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}else
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "Should be able to subscribe", "Issue in offer subscription", "Fail");
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}
					
				}
				else if (API.equalsIgnoreCase("ML"))
				{
					Generic.WriteManualTestStep("Provision ML offer via SMS or API", "", "", "Should be successful", "", "TBD");
					Control.OpenApplication("Chrome", "http://"+baseurl+":8082/?Operation=1&ServiceID=10645&Param=DEFAULT&Silent=0&SUB_Mobtel=63"+MSISDN+"");
					try
					{
						B=Constant.driver.findElement(By.xpath("//*[contains(text(),'ERR_CODE: 0')]"));
					}	
					catch(Exception e)
					{
						System.out.println(e);
					}
					if (!(B== null))
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "should be able to subscribe", "Successful in offer subscription", "Pass");
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}else
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "Should be able to subscribe", "Issue in offer subscription", "Fail");
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}
					
				}
				
			}
			else if(Brand.equalsIgnoreCase("Postpaid" ))
			{
				if (API.equalsIgnoreCase("SURF249"))
				{
					Generic.WriteManualTestStep("Provision SURF249 offer via SMS or API", "", "", "Should be successful", "", "TBD");
					Control.OpenApplication("Chrome", "http://10.66.9.213:8082/?Operation=1&ServiceID=10103&Param=DEFAULT&Silent=0&SUB_Mobtel=63"+MSISDN+"");
					try
					{
						B=Constant.driver.findElement(By.xpath("//*[contains(text(),'ERR_CODE: 0')]"));
					}	
					catch(Exception e)
					{
						System.out.println(e);
					}
					if (!(B== null))
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "should be able to subscribe", "Successful in offer subscription", "Pass");
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}else
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "Should be able to subscribe", "Issue in offer subscription", "Fail");
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}
					
				}
				else if (API.equalsIgnoreCase("SURF4ALL99"))
				{
					Generic.WriteManualTestStep("Provision SURF4ALL99 with WNP offer via SMS or API", "", "", "Should be successful", "", "TBD");
					Control.OpenApplication("Chrome", "http://"+baseurl+":8082/?Operation=1&ServiceID=10635&Param=DEFAULT&Silent=0&SUB_Mobtel=63"+MSISDN+"");
					try
					{
						B=Constant.driver.findElement(By.xpath("//*[contains(text(),'ERR_CODE: 0')]"));
					}	
					catch(Exception e)
					{
						System.out.println(e);
					}
					if (!(B== null))
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "should be able to subscribe", "Successful in offer subscription", "Pass");
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}else
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "Should be able to subscribe", "Issue in offer subscription", "Fail");
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}
					
				}
				else if (API.equalsIgnoreCase("GoSURF599"))
				{
					Generic.WriteManualTestStep("Provision GoSURF599 offer via SMS or API", "", "", "Should be successful", "", "TBD");
					Control.OpenApplication("Chrome", "http://10.66.9.213:8082/?Operation=1&ServiceID=10663&Param=DEFAULT&Silent=0&SUB_Mobtel=63"+MSISDN+"");
					try
					{
						B=Constant.driver.findElement(By.xpath("//*[contains(text(),'ERR_CODE: 0')]"));
					}	
					catch(Exception e)
					{
						System.out.println(e);
					}
					if (!(B== null))
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "should be able to subscribe", "Successful in offer subscription", "Pass");
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}else
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "Should be able to subscribe", "Issue in offer subscription", "Fail");
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}
					
				}
				else if (API.equalsIgnoreCase("SURF99"))
				{
					Generic.WriteManualTestStep("Provision SURF99 offer via SMS or API", "", "", "Should be successful", "", "TBD");
					Control.OpenApplication("Chrome", "http://10.66.9.213:8082/?Operation=1&ServiceID=10637&Param=DEFAULT&Silent=0&SUB_Mobtel=63"+MSISDN+"");
					try
					{
						B=Constant.driver.findElement(By.xpath("//*[contains(text(),'ERR_CODE: 0')]"));
					}	
					catch(Exception e)
					{
						System.out.println(e);
					}
					if (!(B== null))
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "should be able to subscribe", "Successful in offer subscription", "Pass");
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}else
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "Should be able to subscribe", "Issue in offer subscription", "Fail");
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}
					
					
				}
				else if (API.equalsIgnoreCase("ML"))
				{
					Generic.WriteManualTestStep("Provision ML offer via SMS or API", "", "", "Should be successful", "", "TBD");
					Control.OpenApplication("Chrome", "http://10.66.9.213:8082/?Operation=1&ServiceID=10647&Param=DEFAULT&Silent=0&SUB_Mobtel=63"+MSISDN+"");
					try
					{
						B=Constant.driver.findElement(By.xpath("//*[contains(text(),'ERR_CODE: 0')]"));
					}	
					catch(Exception e)
					{
						System.out.println(e);
					}
					if (!(B== null))
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "should be able to subscribe", "Successful in offer subscription", "Pass");
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}else
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "Should be able to subscribe", "Issue in offer subscription", "Fail");
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}
					
				}
			}
			if(Brand.equalsIgnoreCase("PW" ))
			{
				if (API.equalsIgnoreCase("SURF249"))
				{
					Generic.WriteManualTestStep("Provision SURF249 offer via SMS or API", "", "", "Should be successful", "", "TBD");
					Control.OpenApplication("Chrome", "http://10.66.9.213:8082/?Operation=1&ServiceID=9957&Param=DEFAULT&Silent=0&SUB_Mobtel=63"+MSISDN+"");
					try
					{
						B=Constant.driver.findElement(By.xpath("//*[contains(text(),'ERR_CODE: 0')]"));
					}	
					catch(Exception e)
					{
						
					}
					if (!(B== null))
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "should be able to subscribe", "Successful in offer subscription", "Pass");
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}else
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "Should be able to subscribe", "Issue in offer subscription", "Fail");
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}
					
				}
				else if (API.equalsIgnoreCase("SURF99"))
				{
					Generic.WriteManualTestStep("Provision SURF99 offer via SMS or API", "", "", "Should be successful", "", "TBD");
					Control.OpenApplication("Chrome", "http://10.66.9.213:8082/?Operation=1&ServiceID=10636&Param=DEFAULT&Silent=0&SUB_Mobtel=63"+MSISDN+"");
					try
					{
						B=Constant.driver.findElement(By.xpath("//*[contains(text(),'ERR_CODE: 0')]"));
					}	
					catch(Exception e)
					{
						
					}
					if (!(B== null))
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "should be able to subscribe", "Successful in offer subscription", "Pass");
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}else
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "Should be able to subscribe", "Issue in offer subscription", "Fail");
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}
					
				}
				else if (API.equalsIgnoreCase("ML"))
				{
					Generic.WriteManualTestStep("Provision ML offer via SMS or API", "", "", "Should be successful", "", "TBD");
					Control.OpenApplication("Chrome", "http://10.66.9.213:8082/?Operation=1&ServiceID=10646&Param=DEFAULT&Silent=0&SUB_Mobtel=63"+MSISDN+"");
					try
					{
						B=Constant.driver.findElement(By.xpath("//*[contains(text(),'ERR_CODE: 0')]"));
					}	
					catch(Exception e)
					{
						
					}
					if (!(B== null))
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "should be able to subscribe", "Successful in offer subscription", "Pass");
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}else
						{
							Generic.WriteTestData(""+API+" Subscription", "", "", "Should be able to subscribe", "Issue in offer subscription", "Fail");
							Control.takeScreenshot();
							Generic.EndManualTestStep();
							Generic.TestScriptEnds();
							Constant.driver.quit();
						}
					
				} 
			}
	}
	else if(Brand.equalsIgnoreCase("AddMember"))
	{
		WebElement B=null;
		System.out.println("ADD MEMBER HERE");
		Generic.WriteManualTestStep("Add Member via SMS or API", "", "", "Should be successful", "", "TBD");
		Control.OpenApplication("Chrome", "http://10.66.9.211:8070/?CSP_Txid=4782506920081&SMS_Message_String=ADD%20"+API+"&SUB_Mobtel=63"+MSISDN+"&SMS_SourceAddr=33332&SUB_Device_Details=NOKIA&HPLMN=1");
		try
		{
			B=Constant.driver.findElement(By.xpath("//*[contains(text(),'Request queued')]"));
		}	
		catch(Exception e)
		{
			
		}
			if (!(B== null))
			{
				Generic.WriteTestData(""+API+" Member", "", "", "Should be able to add", "Successful in adding member", "Pass");
				Control.takeScreenshot();
				Generic.EndManualTestStep();
				Generic.TestScriptEnds();
				Constant.driver.quit();
			}else
			{
				Generic.WriteTestData(""+API+" Member", "", "", "Should be able to add", "Issue in adding member", "Fail");
				Control.takeScreenshot();
				Generic.EndManualTestStep();
				Generic.TestScriptEnds();
				Constant.driver.quit();
			}
		
	}else if(Brand.equalsIgnoreCase("SetLimit"))
	{
		WebElement B=null;
		Generic.WriteManualTestStep("SetLimit via SMS or API", "", "", "Should be successful", "", "TBD");
		Control.OpenApplication("Chrome", "http://10.66.9.211:8070/?CSP_Txid=4782506920060&SMS_Message_String=LIMIT%20CPGS%20"+API+"%201%20GB&SUB_Mobtel=63"+MSISDN+"&SMS_SourceAddr=33331&SUB_Device_Details=NOKIA&HPLMN=1");
		try
		{
			B=Constant.driver.findElement(By.xpath("//*[contains(text(),'ERR_CODE: 0')]"));
		}	
		catch(Exception e)
		{
			
		}
			if (!(B== null))
			{
				Generic.WriteTestData(""+API+" Subscription", "", "", "should be able to subscribe", "Successful in offer subscription", "Pass");
				Control.takeScreenshot();
				Generic.EndManualTestStep();
				Generic.TestScriptEnds();
				Constant.driver.quit();
			}else
			{
				Generic.WriteTestData(""+API+" Subscription", "", "", "Should be able to subscribe", "Issue in offer subscription", "Fail");
				Control.takeScreenshot();
				Generic.EndManualTestStep();
				Generic.TestScriptEnds();
				Constant.driver.quit();
			}
		
	}else if(Brand.equalsIgnoreCase("RemoveMember"))
	{
		WebElement B=null;
		Generic.WriteManualTestStep("Remove Member via SMS or API", "", "", "Should be successful", "", "TBD");
		Control.OpenApplication("Chrome", "http://10.66.9.211:8070/?CSP_Txid=4782506920060&SMS_Message_String=REMOVE%20"+API+"&SUB_Mobtel=63"+MSISDN+"&SMS_SourceAddr=33332&SUB_Device_Details=NOKIA&HPLMN=1");
		try
		{
			B=Constant.driver.findElement(By.xpath("//*[contains(text(),'Request queued')]"));
		}	
		catch(Exception e)
		{
			
		}
			if (!(B== null))
			{
				Generic.WriteTestData(""+API+" Member", "", "", "Should be able to remove", "Successful in removing member", "Pass");
				Control.takeScreenshot();
				Generic.EndManualTestStep();
				Generic.TestScriptEnds();
				Constant.driver.quit();
			}else
			{
				Generic.WriteTestData(""+API+" Member", "", "", "Should be able to remove", "Issue in removing member", "Fail");
				Control.takeScreenshot();
				Generic.EndManualTestStep();
				Generic.TestScriptEnds();
				Constant.driver.quit();
			}
	}
	else if(Type.equalsIgnoreCase("DeProvision"))
	{	
				WebElement B=null;	
				Generic.WriteTestCase("CURL API","De-Provisioning Offer","Expected Result", "Actual Result");
				if(Brand.equalsIgnoreCase("GHP" ))
				{
					if (API.equalsIgnoreCase("SURF249"))
					{
						Control.OpenApplication("Chrome", "http://10.66.9.213:8082/?Operation=1&ServiceID=9955&Param=DEFAULT&Silent=0&SUB_Mobtel=63"+MSISDN+"");
						try
						{
							B=Constant.driver.findElement(By.xpath("//*[contains(text(),'ERR_CODE: 0')]"));
						}	
						catch(Exception e)
						{
							System.out.println(e);
						}
							if (!(B== null))
							{
								Generic.WriteTestData(""+API+" De-Provision", "", "", "should be able to De-Provision", "Successful in offer De-Provision", "Pass");
								Control.takeScreenshot();
								Generic.TestScriptEnds();
								Constant.driver.quit();
							}else
							{
								Generic.WriteTestData(""+API+" De-Provision", "", "", "Should be able to De-Provision", "Issue in offer De-Provision", "Fail");
								Control.takeScreenshot();
								Generic.TestScriptEnds();
								Constant.driver.quit();
							}
									
					}
					else if (API.equalsIgnoreCase("SURF99"))
					{
						Generic.WriteManualTestStep("De-Provision SURF4ALL99 via SMS or API", "", "", "Should be successful", "", "TBD");
						Control.OpenApplication("Chrome", "http://10.66.9.225:8082/?Operation=1&ServiceID=7367&Param=DEFAULT&Silent=0&SUB_Mobtel=63"+MSISDN+"");
						try
						{
							B=Constant.driver.findElement(By.xpath("//*[contains(text(),'ERR_CODE: 0')]"));
						}	
						catch(Exception e)
						{
							System.out.println(e);
						}
						if (!(B== null))
							{
								Generic.WriteTestData(""+API+" De-Provision", "", "", "should be able to De-Provision", "Successful in offer De-Provision", "Pass");
								Control.takeScreenshot();
								Generic.EndManualTestStep();
								Generic.TestScriptEnds();
								Constant.driver.quit();
							}else
							{
								Generic.WriteTestData(""+API+" De-Provision", "", "", "Should be able to De-Provision", "Issue in offer De-Provision", "Fail");
								Control.takeScreenshot();
								Generic.EndManualTestStep();
								Generic.TestScriptEnds();
								Constant.driver.quit();
							}
						
					}
					else if (API.equalsIgnoreCase("ML"))
					{
						Generic.WriteManualTestStep("De-Provision ML offer via SMS or API", "", "", "Should be successful", "", "TBD");
						Control.OpenApplication("Chrome", "http://"+baseurl+":8082/?Operation=2&ServiceID=10644&Param=DEFAULT&Silent=0&SUB_Mobtel=63"+MSISDN+"");
						try
						{
							B=Constant.driver.findElement(By.xpath("//*[contains(text(),'ERR_CODE: 0')]"));
						}	
						catch(Exception e)
						{
							System.out.println(e);
						}
						if (!(B== null))
							{
								Generic.WriteTestData(""+API+" De-Provision", "", "", "should be able to De-Provision", "Successful in De-Provision", "Pass");
								Control.takeScreenshot();
								Generic.EndManualTestStep();
								Generic.TestScriptEnds();
								Constant.driver.quit();
							}else
							{
								Generic.WriteTestData(""+API+" De-Provision", "", "", "Should be able to De-Provision", "Issue in De-Provision", "Fail");
								Control.takeScreenshot();
								Generic.EndManualTestStep();
								Generic.TestScriptEnds();
								Constant.driver.quit();
							}
						
					}
					else if (API.equalsIgnoreCase("Go90"))
					{
						Generic.WriteManualTestStep("De-Provision Go90 offer via SMS or API", "", "", "Should be successful", "", "TBD");
						Control.OpenApplication("Chrome", "http://10.66.9.213:8082/?Operation=1&ServiceID=10672&Param=DEFAULT&Silent=0&SUB_Mobtel=63"+MSISDN+"");
						try
						{
							B=Constant.driver.findElement(By.xpath("//*[contains(text(),'ERR_CODE: 0')]"));
						}	
						catch(Exception e)
						{
							System.out.println(e);
						}
						if (!(B== null))
							{
								Generic.WriteTestData(""+API+" De-Provision", "", "", "should be able to De-Provision", "Successful in offer De-Provision", "Pass");
								Control.takeScreenshot();
								Generic.EndManualTestStep();
								Generic.TestScriptEnds();
								Constant.driver.quit();
							}else
							{
								Generic.WriteTestData(""+API+" De-Provision", "", "", "Should be able to De-Provision", "Issue in offer De-Provision", "Fail");
								Control.takeScreenshot();
								Generic.EndManualTestStep();
								Generic.TestScriptEnds();
								Constant.driver.quit();
							}
					}else if (API.equalsIgnoreCase("SURF4ALL99"))
					{
						Generic.WriteManualTestStep("Provision SURF4ALL99 with WNP offer via SMS or API", "", "", "Should be successful", "", "TBD");
						Control.OpenApplication("Chrome", "http://"+baseurl+":8082/?Operation=2&ServiceID=10634&Param=DEFAULT&Silent=0&SUB_Mobtel=63"+MSISDN+"");
						try
						{
							B=Constant.driver.findElement(By.xpath("//*[contains(text(),'ERR_CODE: 0')]"));
						}	
						catch(Exception e)
						{
							System.out.println(e);
						}
						if (!(B== null))
							{
								Generic.WriteTestData(""+API+" Subscription", "", "", "should be able to subscribe", "Successful in offer subscription", "Pass");
								Control.takeScreenshot();
								Generic.EndManualTestStep();
								Generic.TestScriptEnds();
								Constant.driver.quit();
							}else
							{
								Generic.WriteTestData(""+API+" Subscription", "", "", "Should be able to subscribe", "Issue in offer subscription", "Fail");
								Control.takeScreenshot();
								Generic.EndManualTestStep();
								Generic.TestScriptEnds();
								Constant.driver.quit();
							}
						
					}
				}//end ghp		
	}
}
}
	


