package mjkarbasian.moshtarimadar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.text.ParseException;

import mjkarbasian.moshtarimadar.adapters.SaleAdapter;
import mjkarbasian.moshtarimadar.helper.Utility;


/**
 * A placeholder fragment containing a simple view.
 */
public class SalesFragment extends Fragment {
    SaleAdapter mSalesAdapter;
    ListView mListView;

    public SalesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mSalesAdapter = new SaleAdapter(getActivity());
        Boolean todayCheck;
        int todayCounter = 0;
        Boolean weekCheck;
        int weekCounter = 0;
        Boolean monthCheck;
        int monthCounter = 0;
        int olderCounter = 0;

        if(CustomerSamples.salesCode.size()==0)
        {
            CustomerSamples.setSalesCode();
            CustomerSamples.setSaleDueDate();
        }

        for (String date : CustomerSamples.salesDue)
        {
            try {
              todayCheck = Utility.isToday(date);
                if(todayCheck) todayCounter++;
              weekCheck = Utility.isThisWeek(date);
                if(weekCheck && !todayCheck) weekCounter++;
              monthCheck = Utility.isThisMonth(date);
                if(monthCheck && !weekCheck && !todayCheck) monthCounter++;
                if(!monthCheck&& !weekCheck && !todayCheck) olderCounter++;
            } catch (ParseException e) {e.printStackTrace();}

        }
        if(todayCounter>0){ mSalesAdapter.addSectionHeaderItem(getString(R.string.header_today));
        for(String date : CustomerSamples.salesDue)
        {
            try {
                if(Utility.isToday(date))mSalesAdapter.addItem(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }}
        if(weekCounter>0) {mSalesAdapter.addSectionHeaderItem(getString(R.string.header_this_week));
        for(String date : CustomerSamples.salesDue)
        {
            try {
                if(Utility.isThisWeek(date))mSalesAdapter.addItem(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }}
        if(monthCounter>0){ mSalesAdapter.addSectionHeaderItem(getString(R.string.header_this_month));
        for(String date : CustomerSamples.salesDue)
        {
            try {
                if(Utility.isThisMonth(date))mSalesAdapter.addItem(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }}
        if(olderCounter>0)
        {
        mSalesAdapter.addSectionHeaderItem(getString(R.string.header_older));
        for(String date : CustomerSamples.salesDue)
        {
            try {
                if(!Utility.isThisMonth(date))mSalesAdapter.addItem(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        }

            View rootView = inflater.inflate(R.layout.fragment_sales, container, false);
            mListView = (ListView) rootView.findViewById(R.id.list_view_sales);
            mListView.setAdapter(mSalesAdapter);
            return rootView;
        }
    }
