package NFFunction;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utility.*;

public class Ravencall
{
    public static void raven(String MSISDN,String DateFrom) throws Exception
    {
        Control.OpenApplication("Chrome",Generic.ReadFromExcel("RavenURL", "TestData", 1));
        Constant.driver.manage().window().maximize();
        Control.click("Raven", "username");
        Control.enterText("Raven", "username", Generic.ReadFromExcel("RavenUsername", "TestData", 1));
        Control.takeScreenshot();
        Control.click("Raven", "Password");
        Control.enterText("Raven", "Password", Generic.ReadFromExcel("RavenPassword", "TestData", 1));
        Control.takeScreenshot();
        Control.click("Raven", "signin");

        Raven.TC1(MSISDN, DateFrom);

        Control.click("Raven", "Menu");

        Control.takeScreenshot();
        Control.click("Raven", "Logout");
        Control.takeScreenshot();
        Constant.driver.close();

        Control.GeneratePDFReport();
    }
}
