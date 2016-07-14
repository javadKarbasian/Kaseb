package mjkarbasian.moshtarimadar;

import java.util.ArrayList;

/**
 * Created by family on 6/27/2016.
 */
public class CustomerSamples {
    public static Integer[] customerName = {R.string.sample_ali_ghorbani,R.string.sample_mohammad_alikhani,R.string.sample_sima_saberzadeh};
    public static Integer[] debatorName = {customerName[0],customerName[2]};
    public static Integer[] debtorsCodeNums  = {3,4};
    public static double[] debatorOneCodes = {12430,13450,13900};
    public static double[] debatorTwoCodes = {10253,11276,13438,14864};
    public static double[][] debtorsCode = {debatorOneCodes,debatorTwoCodes};
    public static String[] debtorOneDue = {"2016/6/30","2016/10/8","2016/12/9"};
    public static String[] debtorTwoDue = {"2016/6/15","2016/9/11","2016/10/13","2016/11/27"};
    public static String[] debtor3oDue = {"2016/2/10","2016/3/11"};
    public static String[][] debtorsDue = {debtorOneDue, debtorTwoDue, debtor3oDue};
    public static double[] debtorOneBalance={900000,250000,350000};
    public static double[] debtorTwoBalance={600000,250000,250000,100000};
    public static double[][] debtorBalance = {debtorOneBalance,debtorTwoBalance};
    public static Float[]customerRating = new Float[]{4.4f,3.2f,2.5f};
    public static String[] customerPhoneNumber={"09124383454","09121343254","09122515237"};
    public static double[] customerPurchaseAmount ={5590000,8320000,732000};
    public static double[] customerDebateBalance = {1500000,1200000};
    public static String[] customerDebtAmount={"0","455,000","100,000"};
    public static String[] debtorsMobileNumber={"09124381232","09124543212"};
    public static ArrayList<String> salesCode = new ArrayList<String>();
    public static double[] salesAmount = {2000000,1190000,2400000,3200000,1100000,2000000,2020000,332000,400000};
    public static String[] products={"pr01","pr02","pr03","pr04","pr05"};
    public static double[] productsPrice={600000,900000,1200000,332000,400000};
    public static Integer[] productImages={R.raw.pr01,R.raw.pr02,R.raw.pr03,R.raw.pr04,R.raw.pr05};
    public static String[][] salesProduct={{products[0],products[3]},{products[0]},{products[3],products[4]},{products[3]},
            {products[1],products[2]},{products[2]},{products[3],products[4]},{products[0]},{products[1]}};
    public static void setSalesCode(){
        salesCode.add("Inv-12430");
        salesCode.add("Inv-13450");
        salesCode.add("Inv-13900");
        salesCode.add("Inv-10253");
        salesCode.add("Inv-11276");
        salesCode.add("Inv-13438");
        salesCode.add("Inv-14864");
        salesCode.add("Inv-14868");
        salesCode.add("Inv-14900");
    }


}

