package mjkarbasian.moshtarimadar;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import mjkarbasian.moshtarimadar.adapters.CustomerBillAdapter;

/**
 * Created by family on 7/27/2016.
 */
public class DetailCustomerBill extends Fragment {
    protected final Integer customerPostion;
    public DetailCustomerBill(Integer position) {
        super();
        customerPostion = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.customer_bill, container, false);
        ListView customerBills = (ListView)view.findViewById(R.id.list_view_customer_bills);
        CustomerBillAdapter adaper = new CustomerBillAdapter(getActivity(),customerPostion);
        customerBills.setAdapter(adaper);
        return view;
    }
}
