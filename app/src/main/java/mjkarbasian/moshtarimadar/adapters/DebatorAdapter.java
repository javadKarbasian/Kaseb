package mjkarbasian.moshtarimadar.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

import mjkarbasian.moshtarimadar.CustomerSamples;
import mjkarbasian.moshtarimadar.R;

import static mjkarbasian.moshtarimadar.CustomerSamples.customerDebateBalance;
import static mjkarbasian.moshtarimadar.CustomerSamples.customerName;
import static mjkarbasian.moshtarimadar.CustomerSamples.debatorName;
import static mjkarbasian.moshtarimadar.CustomerSamples.debtorsCode;
import static mjkarbasian.moshtarimadar.CustomerSamples.debtorsMobileNumber;
import static mjkarbasian.moshtarimadar.helper.Utility.formatPurchase;

/**
 * Created by family on 6/27/2016.
 */
public class DebatorAdapter extends BaseExpandableListAdapter {
    Context mContext;
    public DebatorAdapter(Context context){
        mContext = context;
    }

    @Override
    public int getGroupCount() {
        return CustomerSamples.debatorName.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return CustomerSamples.debtorsCode[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return debatorName[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return debtorsCode[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = convertView;

        if(convertView==null)
        {
            view = inflater.inflate(R.layout.list_item_debators,parent,false);
        }


        TextView debatorNameText = (TextView)view.findViewById(R.id.item_card_debator_name);
        debatorNameText.setText(mContext.getString(customerName[groupPosition]));

        TextView debatorBalanceText =(TextView)view.findViewById(R.id.item_card_balance_amount);
        DecimalFormat format = new DecimalFormat();
        format.setDecimalSeparatorAlwaysShown(true);
        String balanceAmount =(String)format.format(customerDebateBalance[groupPosition]);
        balanceAmount = formatPurchase(mContext, balanceAmount);
        debatorBalanceText.setText(balanceAmount);

        //Card actions click handler
        ImageView phoneImage = (ImageView) view.findViewById(R.id.debtor_call);
        phoneImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", debtorsMobileNumber[groupPosition], null));
                mContext.startActivity(intent);
            }
        });

        ImageView messageImage = (ImageView) view.findViewById(R.id.debtor_message);
        messageImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.fromParts("sms", debtorsMobileNumber[groupPosition], null));
                mContext.startActivity(intent);
            }
        });

        ImageView shareImage = (ImageView) view.findViewById(R.id.debtor_share);
        final String finalBalanceAmount;
        finalBalanceAmount = String.format("%s%s", mContext.getResources().getString(R.string.debtor_share_text_to_send), balanceAmount);
        shareImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, finalBalanceAmount);
                mContext.startActivity(Intent.createChooser(intent, "Share with"));
            }
        });
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = convertView;

        if(convertView==null)
        {
            view = inflater.inflate(R.layout.list_item_debtors_history,parent,false);
        }
        TextView codeText = (TextView)view.findViewById(R.id.debtor_history_invoice_code);
        codeText.setText(Integer.toString((int)CustomerSamples.debtorsCode[groupPosition][childPosition]));

        TextView dueText =(TextView) view.findViewById(R.id.debtor_history_due_date);
        dueText.setText(CustomerSamples.debtorsDue[groupPosition][childPosition]);

        TextView balanceText = (TextView) view.findViewById(R.id.debtor_history_balance);
        balanceText.setText(Integer.toString((int) CustomerSamples.debtorBalance[groupPosition][childPosition]) );

        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}

