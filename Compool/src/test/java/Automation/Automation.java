package Automation;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.channels.Channel;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
//import java.io.File;
import org.testng.annotations.BeforeClass;
//import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import NFFunction.*;
import utility.*;

public class Automation
{
    @BeforeClass
    public void setUp() throws Exception
    {
        Generic.TestScriptStart("NFWebtool",System.getProperty("Folder"));
    }

    @Test
    public  void main() throws Exception
    {
        if (System.getProperty("API").equalsIgnoreCase("CPSPromo"))
        {
            CPS_PromoValidation.test(System.getProperty("MSISDN"),System.getProperty("Type"));
        }
        else if (System.getProperty("API").equalsIgnoreCase("CPSNoPromo"))
        {
            CPS_NoPromoValidation.test(System.getProperty("MSISDN"),System.getProperty("Type"));
        }
        else if (System.getProperty("API").equalsIgnoreCase("NFPromo"))
        {
            NF_PromoValidation.test(System.getProperty("MSISDN"),System.getProperty("Status"), System.getProperty("Value"),System.getProperty("Type"));
        }
        else if (System.getProperty("API").equalsIgnoreCase("NFNoPromo"))
        {
            NF_NoPromoValidation.test(System.getProperty("MSISDN"),System.getProperty("Type"));
        }
        else if (System.getProperty("API").equalsIgnoreCase("CURLProvision"))
        {
            CURL_API.CURL(System.getProperty("Brand"),System.getProperty("Type"),System.getProperty("Offer"), System.getProperty("MSISDN"));
        }
        else if (System.getProperty("API").equalsIgnoreCase("CURLSMS"))
        {
            CURL_SMS.CURL(System.getProperty("Offer"), System.getProperty("MSISDN"));
        }
        else if (System.getProperty("API").equalsIgnoreCase("CURLVerify"))
        {
            CURL_Verification.CURL(System.getProperty("Type"), System.getProperty("MSISDN"),System.getProperty("Message"));
        }
        else if (System.getProperty("API").equalsIgnoreCase("Raven"))
        {
            Ravencall.raven(System.getProperty("MSISDN"),System.getProperty("DateFrom"));
        }
    }

    @AfterClass
    public void closure() throws Exception
    {
        Control.GeneratePDFReport();
    }
}