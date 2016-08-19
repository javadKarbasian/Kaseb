package mjkarbasian.moshtarimadar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.text.ParseException;

import mjkarbasian.moshtarimadar.adapters.SaleAdapter;
import mjkarbasian.moshtarimadar.helper.Samples;
import mjkarbasian.moshtarimadar.helper.Utility;

import static mjkarbasian.moshtarimadar.helper.Samples.sales;
import static mjkarbasian.moshtarimadar.helper.Samples.salesCode;
import static mjkarbasian.moshtarimadar.helper.Samples.salesDue;
import static mjkarbasian.moshtarimadar.helper.Samples.setSale;
import static mjkarbasian.moshtarimadar.helper.Samples.setSaleDueDate;
import static mjkarbasian.moshtarimadar.helper.Samples.setSaleFinalAmount;
import static mjkarbasian.moshtarimadar.helper.Samples.setSaleOffTaxList;
import static mjkarbasian.moshtarimadar.helper.Samples.setSalePaymentList;
import static mjkarbasian.moshtarimadar.helper.Samples.setSaleProductList;
import static mjkarbasian.moshtarimadar.helper.Samples.setSalesAmount;
import static mjkarbasian.moshtarimadar.helper.Samples.setSalesCode;
import static mjkarbasian.moshtarimadar.helper.Samples.setSalesCustomer;


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

        if(Samples.productCode.size()==0){
            Samples.setProductCode();
            Samples.setProductName(getActivity());
            Samples.setProductDate();
            Samples.setProductPrice();
            Samples.setProducts();

        }

        if(salesCode.size()==0)
        {

            setSalesCode();
            setSaleDueDate();
            setSalesCustomer(getActivity());
            setSalesAmount();
            setSaleProductList();
            try {
                setSalePaymentList(getActivity());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            setSaleOffTaxList(getActivity());
            setSaleFinalAmount(getActivity());
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
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                if (id == 0) {

                    if (position < sales.get(1).size()) {
                        intent = new Intent(getActivity(), DetailSale.class).putExtra("saleCode", sales.get(1).get(position));
                    } else {
                        intent = new Intent(getActivity(), DetailSale.class).putExtra("saleCode", sales.get(1).get(sales.get(1).size()-1));

                    }
                    startActivity(intent);
                }
            }
        });
            return rootView;
        }
    }
