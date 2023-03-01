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

public class CPS_NoPromoValidation
{
    public static void test(String MSISDN, String Value ) throws Exception
    {
        NFWebToolLibrary.CPSPoolNoPromoValidation(MSISDN,Value);
        Generic.TestScriptEnds();
    }
}
