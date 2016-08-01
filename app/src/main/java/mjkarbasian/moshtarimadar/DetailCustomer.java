package mjkarbasian.moshtarimadar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import mjkarbasian.moshtarimadar.adapters.DetailCustomerAdapter;
import mjkarbasian.moshtarimadar.helper.Samples;

public class DetailCustomer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_customer);
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);

        ((CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout)).setTitle(this.getResources().getString(Samples.customerName[position]));
        ImageView customerAvatar = (ImageView)findViewById(R.id.image_toolbar);

        if(Samples.customerAvatar.size()==0)
        {
            customerAvatar.setImageResource(R.drawable.account);
        }
        else
        {
            if(!(Samples.customerAvatar.size()<=position)){
                customerAvatar.setImageURI(Samples.customerAvatar.get(position));}
            else {
                customerAvatar.setImageResource(R.drawable.account);
            }
        }


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.customer_tab_info)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.customer_tab_dash)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.customer_tab_bill)));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final DetailCustomerAdapter adapter = new DetailCustomerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount(),this,position);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
