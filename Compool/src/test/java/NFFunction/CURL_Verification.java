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

public class CURL_Verification
{
    public static void main() throws Exception
    {
        Generic.WriteTestCase("TC_01_CURL API","Subscription to Offer","Expected Result", "Actual Result");
        // CURL("SURF249","9270990234");
    }

    public static void CURL( String API, String MSISDN, String Message)throws Exception
    {
        WebElement B=null;
        Generic.WriteTestCase("TC_01_CURL API","Subscription to Offer","Expected Result", "Actual Result");
        if (API.equalsIgnoreCase("DataBal"))
        {
            Generic.WriteManualTestStep("Send DATA BAL via SMS or API", "", "", "Should be successful", "", "TBD");
            Control.OpenApplication("Chrome", "http://10.66.9.211:8070/?CSP_Txid=4782506920060&SMS_Message_String=DATA%20BAL&SUB_Mobtel=63"+MSISDN+"&SMS_SourceAddr=33332&SUB_Device_Details=NOKIA&HPLMN=1");
            try
            {
                Thread.sleep(2000);
                B=Constant.driver.findElement(By.xpath("//*[contains(text(),'Request queued')]"));
            }
            catch(Exception e)
            {
                System.out.println(e);
            }

            if (B==null)
            {
                Generic.WriteTestData(""+API+" Verification", "", "", "DataBal API", "Issue in DataBal", "Fail");
                Control.takeScreenshot();
                Generic.EndManualTestStep();
                Generic.TestScriptEnds();
                Constant.driver.quit();
            }
            else
            {
                Generic.WriteTestData(""+API+" Subscription", "", "", "Should be successful", "Successful in offer subscription", "Pass");
                Control.takeScreenshot();
                Generic.EndManualTestStep();
                Generic.TestScriptEnds();
                Constant.driver.quit();
                Generic.WriteTestCase("NF Verification","Verification in NFTool","Expected Result", "Actual Result");
                Generic.WriteManualTestStep("Validate DATA BAL SMS notification", "", "", "", "", "TBD");
                NFWebToolLibrary.NFwebtoolCheckSMS(MSISDN, Message, API);
                Generic.EndManualTestStep();
                Generic.TestScriptEnds();
            }
        }
        else if (API.equalsIgnoreCase("GroupStatus"))
        {
            Generic.WriteManualTestStep("Send GROUP STATUS via SMS or API", "", "", "Should be successful", "", "TBD");
            Control.OpenApplication("Chrome", "http://10.66.9.211:8070/?CSP_Txid=4782506920060&SMS_Message_String=GROUP%20STATUS&SUB_Mobtel=63"+MSISDN+"&SMS_SourceAddr=33332&SUB_Device_Details=NOKIA&HPLMN=1");
            try
            {
                B=Constant.driver.findElement(By.xpath("//*[contains(text(),'Request queued')]"));
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
                Generic.WriteTestCase("NF Verification","Verification in NFTool","Expected Result", "Actual Result");
                Generic.WriteManualTestStep("Validate GROUP STATUS SMS notification", "", "", "", "", "TBD");
                NFWebToolLibrary.NFwebtoolCheckSMS(MSISDN, Message, API);
                Generic.EndManualTestStep();
                Generic.TestScriptEnds();
            }
            else
            {
                Generic.WriteTestData(""+API+" Verification", "", "", "GroupStatus shoube be triggerred", "Issue in groupstatus", "Fail");
                Control.takeScreenshot();
                Generic.EndManualTestStep();
                Generic.TestScriptEnds();
                Constant.driver.quit();
            }
        }
    }
}
