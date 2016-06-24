package mjkarbasian.moshtarimadar;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * A placeholder fragment containing a simple view.
 */
public class CustomersFragment extends Fragment {

    CustomerAdapter mCustomerAdapter;
    ListView mListView;
    public CustomersFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mCustomerAdapter = new CustomerAdapter(getActivity());
        View rootView = inflater.inflate(R.layout.fragment_customers, container, false);
        mListView = (ListView)rootView.findViewById(R.id.list_view_customers);
        mListView.setAdapter(mCustomerAdapter);
        return rootView;
    }
}
