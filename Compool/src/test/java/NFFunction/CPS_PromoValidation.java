package NFFunction;
import utility.*;

public class CPS_PromoValidation
{
    public static void test(String MSISDN, String Value) throws Exception
    {
        NFWebToolLibrary.CPSPoolValidation(MSISDN,Value);
        Generic.TestScriptEnds();
    }
}
