package mjkarbasian.moshtarimadar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import mjkarbasian.moshtarimadar.adapters.SaleAdapter;


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
        if(CustomerSamples.salesCode.size()==0)
        {CustomerSamples.setSalesCode();        }

        for (int i = 0; i < CustomerSamples.salesCode.size(); i++) {
            mSalesAdapter.addItem(CustomerSamples.salesCode.get(i));
            if (i % 4 == 1) {
                switch (i){
                    case 5:
                        mSalesAdapter.addSectionHeaderItem(getActivity().getResources().getString(R.string.header_this_week));
                        break;
                    default:
                        mSalesAdapter.addSectionHeaderItem(getActivity().getResources().getString(R.string.header_older));
                }
            }
        }
            View rootView = inflater.inflate(R.layout.fragment_sales, container, false);
            mListView = (ListView) rootView.findViewById(R.id.list_view_sales);
            mListView.setAdapter(mSalesAdapter);
            return rootView;
        }
    }
