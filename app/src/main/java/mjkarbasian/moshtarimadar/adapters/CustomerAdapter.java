package mjkarbasian.moshtarimadar.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

import mjkarbasian.moshtarimadar.helper.Samples;
import mjkarbasian.moshtarimadar.R;
import mjkarbasian.moshtarimadar.helper.Utility;


/**
 * Created by family on 6/23/2016.
 */
public class CustomerAdapter extends BaseAdapter {

    private Context mContext;

    public CustomerAdapter(Context c) {
        mContext = c;
    }
    @Override
    public int getCount() {
        return Samples.customerName.length;
    }

    @Override
    public Object getItem(int position) {
        return Samples.customerName[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = convertView;
        if(convertView==null)
        {
            view = inflater.inflate(R.layout.list_item_customers,parent,false);
        }
        TextView customerNameText = (TextView)view.findViewById(R.id.item_list_customer_name);
        customerNameText.setText(mContext.getString(Samples.customerName[position]));
//        RatingBar customerRate = (RatingBar) view.findViewById(R.id.item_list_rating_bar);
//        customerRate.setRating(customerRating[position]);
        TextView customerPurchaseAmountText =(TextView)view.findViewById(R.id.item_list_purchase_amount);
        DecimalFormat format = new DecimalFormat();
        format.setDecimalSeparatorAlwaysShown(true);
        String purchaseAmount =(String)format.format(Samples.customerPurchaseAmount[position]);
        purchaseAmount = Utility.formatPurchase(mContext, purchaseAmount);
        customerPurchaseAmountText.setText(purchaseAmount);
        ImageView customerState =(ImageView)view.findViewById(R.id.item_list_customer_state);
        setCustomerState(customerState, Samples.customerPurchaseAmount[position]);
        return view;
    }

    private void setCustomerState(ImageView customerState, double purchaseAmount) {
        if(purchaseAmount>6000000) {customerState.setColorFilter(Color.argb(255, 255, 223, 0));}
        else if(purchaseAmount>2000000&&purchaseAmount<6000000){customerState.setColorFilter(Color.argb(255,169, 169, 169));}
        else{customerState.setColorFilter(Color.argb(255,207, 125, 50));}

    }

    //Dummy data references;



}
