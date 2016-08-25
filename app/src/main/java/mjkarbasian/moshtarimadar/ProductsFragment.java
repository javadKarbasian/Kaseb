package mjkarbasian.moshtarimadar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

        mProductAdapter = new ProductAdapter(getActivity());
        View rootView = inflater.inflate(R.layout.fragment_products, container, false);
        mListView = (ListView)rootView.findViewById(R.id.list_view_products);
        mListView.setAdapter(mProductAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),DetailProducts.class).putExtra("productCode",Samples.products.get(1).get(position))
                        .putExtra("position",position);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
