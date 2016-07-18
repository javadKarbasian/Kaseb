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

import static mjkarbasian.moshtarimadar.helper.Samples.*;


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

        if(salesCode.size()==0)
        {
            setSalesCode();
            setSaleDueDate();
            setSalesCustomer(getActivity());
            setSalesAmount();
            setSale();
        }

        for (String date : salesDue)
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
        for(int i=0;i< sales.get(0).size();i++)
        {
            try {
                if(Utility.isToday(sales.get(0).get(i)))mSalesAdapter.addItem(sales.get(1).get(i));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }}
        if(weekCounter>0) {
            mSalesAdapter.addSectionHeaderItem(getString(R.string.header_this_week));
            for(int i=0;i< sales.get(0).size();i++)
            {
                try {
                    if(!Utility.isToday(sales.get(0).get(i))&&Utility.isThisWeek(sales.get(0).get(i)))mSalesAdapter.addItem(sales.get(1).get(i));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }}
        if(monthCounter>0){ mSalesAdapter.addSectionHeaderItem(getString(R.string.header_this_month));
            for(int i=0;i< sales.get(0).size();i++)
            {
                try {
                    if(!Utility.isToday(sales.get(0).get(i))&&!Utility.isThisWeek(sales.get(0).get(i))&&Utility.isThisMonth(sales.get(0).get(i)))mSalesAdapter.addItem(sales.get(1).get(i));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }}
        if(olderCounter>0)
        {
        mSalesAdapter.addSectionHeaderItem(getString(R.string.header_older));
            for(int i=0;i< sales.get(0).size();i++)
            {
                try {
                    if(!Utility.isToday(sales.get(0).get(i))&&!Utility.isThisWeek(sales.get(0).get(i))&&!Utility.isThisMonth(sales.get(0).get(i)))mSalesAdapter.addItem(sales.get(1).get(i));
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
