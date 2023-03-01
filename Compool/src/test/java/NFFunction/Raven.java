package NFFunction;


import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import ravenutility.NotificationHistory;
import utility.*;

public class Raven
{
    private static String LoginName;
    private static String Password;
    private static String DateTo;
    private static String RavenPattern_ID;
    private static String ContentPreview;
    private static String Response_Code;
    private static String AdditionalParameters;
    private static String Inserted;

    public static void TC1 (String MSISDN, String DateFrom) throws Exception
    {

        Generic.WriteTestCase("CSDAC Verification","Verify Raven sms logs","Expected Result", "Actual Result");

        Control.click("Raven", "Menu");
        Control.takeScreenshot();
        Control.click("Raven", "Communications");
        Control.takeScreenshot();
        Control.click("Raven", "NotificationHistory");
        Control.takeScreenshot();
        WebElement msisdn = Control.findElement("Raven", "Identitytextbox");
        if(msisdn!=null)
        {
            Generic.WriteTestData("Verify MSISDN input box", " ", " ","Results match provided", "MSISDN is displayed" , "Pass");
        }
        else
        {
            Generic.WriteTestData("Verify MSISDN input box", " ", " ","No results match provided", "MSISDN is not displayed" , "Fail");
        }
        Control.click("Raven", "Identitytextbox");
        Control.enterText("Raven", "Identitytextbox", "63" + MSISDN);
        Control.takeScreenshot();

        WebElement dfrom = Control.findElement("Raven", "DateFrom");
        if(dfrom!=null)
        {
            Generic.WriteTestData("Verify Date From input box", " ", " ","Results match provided", "MSISDN input box is displayed" , "Pass");
        }
        else
        {
            Generic.WriteTestData("Verify Date From input box", " ", " ","No results match provided", "MSISDN input box is not displayed" , "Fail");
        }
        Control.enterText("Raven","DateFrom", DateFrom);
        Control.takeScreenshot();

        WebElement applybtn = Control.findElement("Raven", "Applybutton");
        if(applybtn!=null)
        {
            Generic.WriteTestData("Verify apply button", " ", " ","Results match provided", "Apply Button is displayed" , "Pass");
        }
        else
        {
            Generic.WriteTestData("Verify apply button", " ", " ","Results match provided", "Apply Button is not displayed" , "Fail");
        }
        Control.click("Raven", "Applybutton");
        Control.takeScreenshot();


        WebElement B = null;
        try
        {
            B = Constant.driver.findElement(By.xpath("//div[@class='ItemsTable_welcome']//div[contains(text(),'No results match provided filter')]"));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        if (B == null)
        {
            int test1 = Constant.driver.findElements(By.xpath("//div[contains(@class,'Paper_paper Paper_zDepth_1 PopoutTableRow_root PopoutTableRow_withPointer')]")).size();
            Constant.driver.findElement(By.xpath("//div[contains(@class,'Paper_paper Paper_zDepth_1 PopoutTableRow_root PopoutTableRow_withPointer')]["+test1+"]")).click();
            Control.takeScreenshot();

            Control.click("Raven", "ContentPreview");
            WebElement contentpreview = Control.findElement("Raven", "ContentPreview");
            if(contentpreview!=null)
            {
                Generic.WriteTestData("Verify Content Preview", " ", " ","Results match provided", "Content Preview is displayed" , "Pass");
            }
            else
            {
                Generic.WriteTestData("Verify Content Preview", " ", " ","Results match provided", "Content Preview is not displayed" , "Fail");
            }
            Control.takeScreenshot();
        }
        else
        {
            String errormsg = Control.findElement("Raven", "NoResults").getText();
            Generic.WriteTestData("Verify the MESSAGE  details ", " ", " ","No results match provided filter", "Error message is displayed :" + errormsg, "Fail");
        }
        Generic.TestScriptEnds();
    }
}
