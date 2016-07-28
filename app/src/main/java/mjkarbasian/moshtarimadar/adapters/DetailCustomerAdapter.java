package mjkarbasian.moshtarimadar.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import mjkarbasian.moshtarimadar.DetailCustomerBill;
import mjkarbasian.moshtarimadar.DetailCustomerDash;
import mjkarbasian.moshtarimadar.DetailCustomerInfo;

public class DetailCustomerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public DetailCustomerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                DetailCustomerInfo tab1 = new DetailCustomerInfo();
                return tab1;
            case 1:
                DetailCustomerBill tab2 = new DetailCustomerBill();
                return tab2;
            case 2:
                DetailCustomerDash tab3 = new DetailCustomerDash();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}