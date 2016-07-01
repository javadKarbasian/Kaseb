package mjkarbasian.moshtarimadar.adapters;

import android.app.ActionBar;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.DecimalFormat;

import mjkarbasian.moshtarimadar.CustomerSamples;
import mjkarbasian.moshtarimadar.R;
import mjkarbasian.moshtarimadar.Utility;

/**
 * Created by family on 6/27/2016.
 */
public class DebatorAdapter extends BaseAdapter {
    Context mContext;
    public DebatorAdapter(Context context){
        mContext = context;
    }
    @Override
    public int getCount() {
        return CustomerSamples.debatorName.length;
    }

    @Override
    public Object getItem(int position) {
        return CustomerSamples.debatorName[position];
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
            view = inflater.inflate(R.layout.list_item_debators,parent,false);
        }

        TextView debatorNameText = (TextView)view.findViewById(R.id.item_card_debator_name);
        debatorNameText.setText(mContext.getString(CustomerSamples.customerName[position]));

        TextView debatorBalanceText =(TextView)view.findViewById(R.id.item_card_balance_amount);
        DecimalFormat format = new DecimalFormat();
        format.setDecimalSeparatorAlwaysShown(true);
        String balanceAmount =(String)format.format(CustomerSamples.customerDebateBalance[position]);
        balanceAmount = Utility.formatPurchase(mContext, balanceAmount);
        debatorBalanceText.setText(balanceAmount);

        TableLayout balanceTable = (TableLayout) view.findViewById(R.id.table_balance_debators);

        for(int i = 0;i<CustomerSamples.debtorsCodeNums[position];i++)
        {
            if(balanceTable.getChildCount()<=CustomerSamples.debtorsCodeNums[position]){
            TableRow tableRow = new TableRow(mContext);
            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(0, 4, 0, 0);
            tableRow.setLayoutParams(layoutParams);
            TextView codeText = new TextView(mContext);
            TextView dueText = new TextView(mContext);
            TextView balanceText = new TextView(mContext);
            codeText.setText(CustomerSamples.debtorsCode[position][i]);
            dueText.setText(CustomerSamples.debtorsDue[position][i]);
            balanceText.setText(Utility.DecimalSeperation(mContext, CustomerSamples.debtorBalance[position][i]));
            codeText.setGravity(Gravity.CENTER);
            dueText.setGravity(Gravity.CENTER);
            balanceText.setGravity(Gravity.CENTER);

                int dpValue = 40; // margin in dips
                float d = mContext.getResources().getDisplayMetrics().density;
                int height = (int)(dpValue * d); // margin in pixels

            TableRow.LayoutParams layoutParams1 = new  TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,height,1.0f);
            TableRow.LayoutParams layoutParams2 = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, height,1.0f);
            TableRow.LayoutParams layoutParams3 = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, height,2.0f);
            codeText.setLayoutParams(layoutParams1);
            dueText.setLayoutParams(layoutParams2);
            balanceText.setLayoutParams(layoutParams3);
            tableRow.addView(codeText);
            tableRow.addView(dueText);
            tableRow.addView(balanceText);
            balanceTable.addView(tableRow);}
        }


        return view;
    }
}
