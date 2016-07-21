package mjkarbasian.moshtarimadar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import mjkarbasian.moshtarimadar.adapters.ProductAdapter;
import mjkarbasian.moshtarimadar.helper.Samples;

/**
 * A placeholder fragment containing a simple view.
 */
public class ProductsFragment extends Fragment {

    ProductAdapter mProductAdapter;
    ListView mListView;
    public ProductsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(Samples.productCode.size()==0){
            Samples.setProductCode();
            Samples.setProductName(getActivity());
            Samples.setProductDate();
            Samples.setProductPrice();
            Samples.setProducts();
        }
        mProductAdapter = new ProductAdapter(getActivity());
        View rootView = inflater.inflate(R.layout.fragment_products, container, false);
        mListView = (ListView)rootView.findViewById(R.id.list_view_products);
        mListView.setAdapter(mProductAdapter);
        return rootView;
    }
}
