package mjkarbasian.moshtarimadar.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import mjkarbasian.moshtarimadar.CustomerSamples;
import mjkarbasian.moshtarimadar.R;

/**
 * Created by family on 7/4/2016.
 */
public class DebtorHistoryAdapter extends BaseAdapter {

    Context mContext;
     int mDebtorCardPosition;
    double[] mList;
    public DebtorHistoryAdapter(Context context,int cardPosition){
        mContext = context;
        mDebtorCardPosition = cardPosition;
        mList = CustomerSamples.debtorsCode[mDebtorCardPosition];

    }
    @Override
    public int getCount() {
        return mList.length;
    }

    @Override
    public Object getItem(int position) {
        return mList[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = convertView;

        if(convertView==null)
        {
            view = inflater.inflate(R.layout.list_item_debtors_history,parent,false);
        }
        TextView codeText = (TextView)view.findViewById(R.id.debtor_history_invoice_code);
        codeText.setText(Integer.toString((int)mList[position]));

        TextView dueText =(TextView) view.findViewById(R.id.debtor_history_due_date);
        dueText.setText(CustomerSamples.debtorsDue[mDebtorCardPosition][position]);

        TextView balanceText = (TextView) view.findViewById(R.id.debtor_history_balance);
        balanceText.setText(Integer.toString((int) CustomerSamples.debtorBalance[mDebtorCardPosition][position]) );

        return view;
    }
}
