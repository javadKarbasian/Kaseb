package mjkarbasian.moshtarimadar;

import android.content.Context;

/**
 * Created by family on 6/24/2016.
 */
public class Utility {
    static String formatPurchase(Context context,String purcahseAmount){

        return context.getString(R.string.format_purchase_amount,purcahseAmount);
    }
}
