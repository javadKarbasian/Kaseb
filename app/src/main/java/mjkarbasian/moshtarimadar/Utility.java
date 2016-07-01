package mjkarbasian.moshtarimadar;

import android.content.Context;

import java.text.DecimalFormat;
import java.util.Calendar;


/**
 * Created by family on 6/24/2016.
 */
public class Utility {
    public static String formatPurchase(Context context,String purcahseAmount){

        return context.getString(R.string.format_purchase_amount,purcahseAmount);
    }
    public static String DecimalSeperation(Context context,double number){
        DecimalFormat format = new DecimalFormat();
        format.setDecimalSeparatorAlwaysShown(true);
        String decNumber =(String)format.format(number);
        return decNumber;
    }
}
