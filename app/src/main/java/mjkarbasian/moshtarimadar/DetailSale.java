package mjkarbasian.moshtarimadar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import mjkarbasian.moshtarimadar.adapters.DetailSaleItems;
import mjkarbasian.moshtarimadar.adapters.DetailSalePayment;
import mjkarbasian.moshtarimadar.helper.Utility;

public class DetailSale extends AppCompatActivity {
    ListView itemsList;
    ListView paymentList;
    ListView offTaxList;

    DetailSaleItems itemsAdapter;
    DetailSalePayment paymentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sale);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String saleCode = intent.getStringExtra("saleCode");

        itemsList = (ListView)findViewById(R.id.listview_sale_items);
        paymentList = (ListView)findViewById(R.id.listview_sale_payments);
        offTaxList = (ListView)findViewById(R.id.listview_sale_tax_discount);

        itemsAdapter = new DetailSaleItems(this,saleCode);
        itemsList.setAdapter(itemsAdapter);

        paymentAdapter = new DetailSalePayment(this,saleCode);
        paymentList.setAdapter(paymentAdapter);

        //dynamically change cards height but it must modify
        CardView itemCard =(CardView)findViewById(R.id.card_detail_sale_items_list);
        ViewGroup.LayoutParams layoutParams = itemCard.getLayoutParams();
        layoutParams.height = Utility.dipConverter(itemsList.getCount() * 48 + 30 ,this);//this is in pixels Must item height recognize dynamically
        itemCard.setLayoutParams(layoutParams);

        //dynamically change cards height but it must modify
        CardView paymentCard =(CardView)findViewById(R.id.card_detail_sale_payments);
        ViewGroup.LayoutParams layoutParamsPaymet = paymentCard.getLayoutParams();
        layoutParamsPaymet.height = Utility.dipConverter(paymentList.getCount() * 48 + 30 ,this);//this is in pixels Must item height recognize dynamically
        paymentCard.setLayoutParams(layoutParamsPaymet);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
