package mjkarbasian.moshtarimadar.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.TreeSet;

import mjkarbasian.moshtarimadar.CustomerSamples;
import mjkarbasian.moshtarimadar.R;

import static mjkarbasian.moshtarimadar.helper.Utility.JalaliDatePicker;
import static mjkarbasian.moshtarimadar.helper.Utility.doubleFormatter;
import static mjkarbasian.moshtarimadar.helper.Utility.formatPurchase;
import static mjkarbasian.moshtarimadar.helper.Utility.getLocale;

/**
 * Created by family on 7/12/2016.
 */
public class SaleAdapter extends BaseAdapter {
    Context mContext;
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_SEPARATOR = 1;

    private ArrayList<String> mData = new ArrayList<String>();
    private TreeSet<Integer> sectionHeader = new TreeSet<Integer>();
    LayoutInflater mInflater;


    public SaleAdapter(Context context) {
        mContext = context;
        mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public void addItem(final String item) {
        if(mData.size()<11){
        mData.add(item);
        notifyDataSetChanged();
        }
    }

    @Override
    public int getItemViewType(int position) {
        return sectionHeader.contains(position) ? TYPE_SEPARATOR : TYPE_ITEM;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    public void addSectionHeaderItem(final String item) {
        if (sectionHeader.size()<2){
        mData.add(item);
        sectionHeader.add(mData.size() - 1);
        notifyDataSetChanged();}
    }

    @Override
    public int getCount() {
     return mData.size();

    }

    @Override
    public Object getItem(int position) {
        return  mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int rowType = getItemViewType(position);
        View view = convertView;
        if(convertView==null)
        {
            switch (rowType) {
                case TYPE_ITEM:
                    view = mInflater.inflate(R.layout.list_item_sales, null);
                    TextView customerName = (TextView)view.findViewById(R.id.item_list_sale_customer_name);
                    TextView saleCode =(TextView)view.findViewById(R.id.item_list_sale_code);
                    TextView saleAmount = (TextView)view.findViewById(R.id.item_list_sale_purchase_amount);
                    TextView saleDue = (TextView)view.findViewById(R.id.item_list_sale_due_date);

                    //set Customer Name and due date
                    if(position<4)
                    {
                        customerName.setText(CustomerSamples.customerName[0]);
                        if(position==3)
                        {
                            if(!getLocale(mContext).equals("IR")){
                                saleDue.setText(CustomerSamples.debtorOneDue[position-1]);}
                            else {
                                saleDue.setText(JalaliDatePicker(CustomerSamples.debtorOneDue[position-1]));
                            }
                            saleAmount.setText(formatPurchase(mContext, doubleFormatter(CustomerSamples.salesAmount[position - 1])));
                            saleCode.setText(CustomerSamples.salesCode.get(position-1));
                        }
                        else
                        {
                            if(!getLocale(mContext).equals("IR")){
                                saleDue.setText(CustomerSamples.debtorOneDue[position]);}
                            else {
                                saleDue.setText(JalaliDatePicker(CustomerSamples.debtorOneDue[position]));
                            }
                            saleAmount.setText(formatPurchase(mContext,doubleFormatter(CustomerSamples.salesAmount[position])));
                            saleCode.setText(CustomerSamples.salesCode.get(position));
                        }

                    }
                    else if(position>3&&position<9)
                    {
                        customerName.setText(CustomerSamples.customerName[1]);
                        if(position==8)
                        {
                            if(!getLocale(mContext).equals("IR")){
                                saleDue.setText(CustomerSamples.debtorTwoDue[position-5]);}
                            else {
                                saleDue.setText(JalaliDatePicker(CustomerSamples.debtorTwoDue[position-5]));
                            }
                            saleAmount.setText(formatPurchase(mContext, doubleFormatter(CustomerSamples.salesAmount[position - 5])));
                            saleCode.setText(CustomerSamples.salesCode.get(position-5));
                        }
                        else
                        {
                            if(!getLocale(mContext).equals("IR")){
                                saleDue.setText(CustomerSamples.debtorTwoDue[position-4]);}
                            else {
                                saleDue.setText(JalaliDatePicker(CustomerSamples.debtorTwoDue[position-4]));
                            }
                            saleAmount.setText(formatPurchase(mContext, doubleFormatter(CustomerSamples.salesAmount[position - 4])));
                            saleCode.setText(CustomerSamples.salesCode.get(position - 4));

                        }

                    }
                    else
                        {
                        customerName.setText(CustomerSamples.customerName[2]);

                            if(!getLocale(mContext).equals("IR")){
                                saleDue.setText(CustomerSamples.debtor3oDue[position-9]);}
                            else {
                                saleDue.setText(JalaliDatePicker(CustomerSamples.debtor3oDue[position-9]));
                            }
                        saleAmount.setText(formatPurchase(mContext, doubleFormatter(CustomerSamples.salesAmount[position - 9])));
                        saleCode.setText(CustomerSamples.salesCode.get(position - 9));
                    }



                    break;
                case TYPE_SEPARATOR:
                    view = mInflater.inflate(R.layout.list_item_sales_header, null);
                    TextView headerText = (TextView)view.findViewById(R.id.header_list_sale);
                    headerText.setText(mData.get(position));
                    break;
            }
        }
        return view;
    }
}
