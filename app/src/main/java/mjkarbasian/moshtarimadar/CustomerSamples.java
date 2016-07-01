package mjkarbasian.moshtarimadar;

/**
 * Created by family on 6/27/2016.
 */
public class CustomerSamples {
    public static Integer[] customerName = {R.string.sample_ali_ghorbani,R.string.sample_mohammad_alikhani,R.string.sample_sima_saberzadeh};
    public static Integer[] debatorName = {customerName[0],customerName[2]};
    public static Integer[] debtorsCodeNums  = {3,4};
    public static String[] debatorOneCodes = {"12430","13450","13900"};
    public static String[] debatorTwoCodes = {"10253","11276","13438","14864"};
    public static String[][] debtorsCode = {debatorOneCodes,debatorTwoCodes};
    public static String[] detorOneDue = {"6/30/16","8/10/16","9/2/16"};
    public static String[] detorTwoDue = {"6/07/16","9/11/16","10/17/16","11/27/16"};
    public static String[][] debtorsDue = {detorOneDue,detorTwoDue};
    public static double[] debtorOneBalance={900000,250000,350000};
    public static double[] debtorTwoBalance={600000,250000,250000,100000};
    public static double[][] debtorBalance = {debtorOneBalance,debtorTwoBalance};
    public static Float[]customerRating = new Float[]{4.4f,3.2f,2.5f};
    public static String[] customerPhoneNumber={"09124383454","09121343254","09122515237"};
    public static double[] customerPurchaseAmount ={5590000,8320000,732000};
    public static double[] customerDebateBalance = {1500000,1200000};
    public static String[] customerDebtAmount={"0","455,000","100,000"};
}
