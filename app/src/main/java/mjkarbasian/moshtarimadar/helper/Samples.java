package mjkarbasian.moshtarimadar.helper;

import android.content.Context;
import android.net.Uri;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

import mjkarbasian.moshtarimadar.R;

/**
 * Created by family on 6/27/2016.
 */
public class Samples {
    public static Integer[] customerName = {R.string.sample_ali_ghorbani,R.string.sample_mohammad_alikhani,R.string.sample_sima_saberzadeh};
    public static ArrayList<Uri> customerAvatar = new ArrayList<Uri>();

    public static Integer[] debatorName = {customerName[0],customerName[2]};
    public static Integer[] debtorsCodeNums  = {3,4};
    public static double[] debatorOneCodes = {12430,13450,13900};
    public static double[] debatorTwoCodes = {10253,11276,13438,14864};
    public static Integer[] numberOfPurchase = {2,3,4};

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
    public static String[] customerEmail={"a.ghorbani@yahoo.com","maA1367@gmail.com","saberzade.sima@gmail.com"};
    public static double[] customerPurchaseAmount ={5590000,8320000,732000};
    public static double[] customerDebateBalance = {1500000,1200000};
    public static String[] customerDebtAmount={"0","455,000","100,000"};
    public static String[] debtorsMobileNumber={"09124381232","09124543212"};
    public static ArrayList<String> salesCode = new ArrayList<String>();
    public static ArrayList<String> salesDue = new ArrayList<String>();
    public static ArrayList<ArrayList<String>> sales = new ArrayList<ArrayList<String>>();
    public static ArrayList<String> salesCustomer = new ArrayList<String>();
    public static ArrayList<String> salesAmount = new ArrayList<String>();
    public static double[] productsPrice={600000,900000,1200000,332000,400000};
    public static ArrayList<String> costNames = new ArrayList<String>();
    public static ArrayList<String> costsDue = new ArrayList<String>();
    public static ArrayList<String> costsCode = new ArrayList<String>();
    public static ArrayList<String> costsAmount =new ArrayList<String>();
    public static ArrayList<ArrayList<String>> costs = new ArrayList<ArrayList<String>>();
    public static ArrayList<String> productName = new ArrayList<String>();
    public static ArrayList<String> productCode = new ArrayList<String>();
    public static ArrayList<String> productDate = new ArrayList<String>();
    public static ArrayList<String> productPrice = new ArrayList<String>();
    public static ArrayList<ArrayList<String>> products = new ArrayList<ArrayList<String>>();


    public static void setSalesCode(){
        salesCode.add("12430");
        salesCode.add("12431");
        salesCode.add("12432");
        salesCode.add("12433");
        salesCode.add("12434");
        salesCode.add("12435");
        salesCode.add("12436");
        salesCode.add("12437");
        salesCode.add("12438");
    }
    public static void setSaleDueDate() {
        Calendar calendar = Calendar.getInstance();
        //add today
        Date today_time = calendar.getTime();
        String today = Utility.formatDate(calendar);
        salesDue.add(today);
        //add today two hours ago
        calendar.roll(Calendar.HOUR_OF_DAY, -2);
        String todayTwoHourAgo = Utility.formatDate(calendar);
        salesDue.add(todayTwoHourAgo);
        //add yesterday;
        calendar.roll(Calendar.DAY_OF_MONTH, -1);
        String yesterday = Utility.formatDate(calendar);
        salesDue.add(yesterday);
        //add two days ago
        calendar.roll(Calendar.DAY_OF_MONTH, -2);
        String twoDaysAgo = Utility.formatDate(calendar);
        salesDue.add(twoDaysAgo);
        //add three days ago
        calendar.roll(Calendar.DAY_OF_WEEK, -3);
        String threeDaysAgo = Utility.formatDate(calendar);
        salesDue.add(threeDaysAgo);
        //add last weeks ago
        calendar.roll(Calendar.WEEK_OF_MONTH,-2);
        String lastWeek = Utility.formatDate(calendar);
        salesDue.add(lastWeek);
        //add last weeks 2 days ago
        calendar.roll(Calendar.DAY_OF_WEEK,-2);
        String lastWeekDays = Utility.formatDate(calendar);
        salesDue.add(lastWeekDays);
        //add last weeks 1 days ago
        calendar.roll(Calendar.DAY_OF_WEEK,-1);
        String lastWeek2Days = Utility.formatDate(calendar);
        salesDue.add(lastWeek2Days);
        //add last month and before
        calendar.roll(Calendar.MONTH,-1);
        String lastMonthDays = Utility.formatDate(calendar);
        salesDue.add(lastMonthDays);

    }
    public static void setSalesCustomer(Context context){
        salesCustomer.add(context.getString(customerName[0]));
        salesCustomer.add(context.getString(customerName[2]));
        salesCustomer.add(context.getString(customerName[1]));
        salesCustomer.add(context.getString(customerName[1]));
        salesCustomer.add(context.getString(customerName[2]));
        salesCustomer.add(context.getString(customerName[0]));
        salesCustomer.add(context.getString(customerName[1]));
        salesCustomer.add(context.getString(customerName[2]));
        salesCustomer.add(context.getString(customerName[2]));

    }
    public static void setSalesAmount(){
        salesAmount.add("900000");
        salesAmount.add("450000");
        salesAmount.add("220000");
        salesAmount.add("175000");
        salesAmount.add("430000");
        salesAmount.add("250000");
        salesAmount.add("780000");
        salesAmount.add("980000");
        salesAmount.add("235000");
    }
    public static void setSale() {
        Collections.reverse(salesCode);
        sales.add(salesDue);
        sales.add(salesCode);
        sales.add(salesCustomer);
        sales.add(salesAmount);
    }

    public static void setCostNames(Context context){
        costNames.add(context.getString(R.string.sample_cost_name));
        costNames.add(context.getString(R.string.sample_cost_name_2));
        costNames.add(context.getString(R.string.sample_cost_name_3));
        costNames.add(context.getString(R.string.sample_cost_name_4));
    }
    public static void setCostDue(){
        Calendar calendar = Calendar.getInstance();
        //add today
        Date today_time = calendar.getTime();
        String today = Utility.formatDate(calendar);
        costsDue.add(today);
        //add today two hours ago
        calendar.roll(Calendar.HOUR_OF_DAY, -2);
        String todayTwoHourAgo = Utility.formatDate(calendar);
        costsDue.add(todayTwoHourAgo);
        //add last weeks 2 days ago
        calendar.roll(Calendar.DAY_OF_MONTH,-2);
        String lastWeekDays = Utility.formatDate(calendar);
        costsDue.add(lastWeekDays);
        //add last month and before
        calendar.roll(Calendar.MONTH,-1);
        String lastMonthDays = Utility.formatDate(calendar);
        costsDue.add(lastMonthDays);
    }
    public static void setCostCode(){
        costsCode.add("102");
        costsCode.add("103");
        costsCode.add("104");
        costsCode.add("105");
    }
    public static void setCostAmount(){
        costsAmount.add("17500");
        costsAmount.add("43000");
        costsAmount.add("25000");
        costsAmount.add("78000");
    }
    public static void setCost(Context context){
        Collections.reverse(costsCode);
        costs.add(costsDue);
        costs.add(costsCode);
        costs.add(costNames);
        costs.add(costsAmount);

    }

    public static void setProductName(Context context) {
        productName.add(context.getString(R.string.sample_product_name));
        productName.add(context.getString(R.string.sample_product_name_2));
        productName.add(context.getString(R.string.sample_product_name_3));
        productName.add(context.getString(R.string.sample_product_name_4));
        productName.add(context.getString(R.string.sample_product_name_5));
        productName.add(context.getString(R.string.sample_product_name_6));
    }
    public static void setProductCode(){
        productCode.add("110");
        productCode.add("111");
        productCode.add("112");
        productCode.add("113");
        productCode.add("114");
        productCode.add("115");
    }
    public static void setProductDate(){
        Calendar calendar = Calendar.getInstance();
        //add today
        Date today_time = calendar.getTime();
        String today = Utility.formatDate(calendar);
        productDate.add(today);
        //add today two hours ago
        calendar.roll(Calendar.HOUR_OF_DAY, -2);
        String todayTwoHourAgo = Utility.formatDate(calendar);
        productDate.add(todayTwoHourAgo);
        //add yesterday;
        calendar.roll(Calendar.DAY_OF_MONTH, -1);
        String yesterday = Utility.formatDate(calendar);
        productDate.add(yesterday);
        //add two days ago
        calendar.roll(Calendar.DAY_OF_MONTH, -2);
        String twoDaysAgo = Utility.formatDate(calendar);
        productDate.add(twoDaysAgo);
        //add three days ago
        calendar.roll(Calendar.DAY_OF_WEEK, -3);
        String threeDaysAgo = Utility.formatDate(calendar);
        productDate.add(threeDaysAgo);
        //add last weeks ago
        calendar.roll(Calendar.WEEK_OF_MONTH,-2);
        String lastWeek = Utility.formatDate(calendar);
        productDate.add(lastWeek);
    }
    public static void setProductPrice(){
        productPrice.add("1300000");
        productPrice.add("670000");
        productPrice.add("230000");
        productPrice.add("120000");
        productPrice.add("560000");
        productPrice.add("760000");
    }
    public static void setProducts(){
        Collections.reverse(productCode);
        products.add(productDate);
        products.add(productCode);
        products.add(productName);
        products.add(productPrice);
    }
}

