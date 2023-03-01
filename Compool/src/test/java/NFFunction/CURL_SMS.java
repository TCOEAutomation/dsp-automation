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

public class CURL_SMS
{

    public static void main() throws Exception
    {
        Generic.WriteTestCase("TC_01_CURL API","Subscription to Offer","Expected Result", "Actual Result");
        CURL("SURF249","9270990234");
    }

    public static void CURL( String API, String MSISDN )throws Exception
    {
        Generic.WriteTestCase("TC_01_CURL API","Subscription to Offer","Expected Result", "Actual Result");
        if (API.equalsIgnoreCase("SURF249"))
        {
            Control.OpenApplication("Chrome", "http://10.66.9.213:8080/?CSP_Txid=4782506920060&SMS_Message_String=SS249&SUB_Mobtel=63"+MSISDN+"&SMS_SourceAddr=33331&SUB_Device_Details=NOKIA&HPLMN=1");
            Generic.WriteTestData(""+API+" SMS Validation", "", "", "SMS should be triggerred", "Successfully SMS triggerred", "Pass");
            Thread.sleep(2000);
            Control.takeScreenshot();
            Generic.TestScriptEnds();
            Constant.driver.quit();
        }
        else if (API.equalsIgnoreCase("ML"))
        {
            Control.OpenApplication("Chrome", "http://10.66.9.213:8080/?CSP_Txid=4782506920060&SMS_Message_String=ML4A%20149&SUB_Mobtel=63"+MSISDN+"&SMS_SourceAddr=33331&SUB_Device_Details=NOKIA&HPLMN=163");
            Generic.WriteTestData(""+API+" SMS Validation", "", "", "SMS should be triggerred", "Successfully SMS triggerred", "Passed");
            Control.takeScreenshot();
            Generic.TestScriptEnds();
            Constant.driver.quit();
        }
    }
}
