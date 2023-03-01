package NFFunction;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utility.*;

public class NF_NoPromoValidation
{
    public static void test(String MSISDN, String Status) throws Exception
    {
        NFWebToolLibrary.NFwebtoolCheckWithoutPromoAvailment(MSISDN,Status);
        Generic.TestScriptEnds();
    }
}
