package loadingdata.ashish.advocateapp.Adpater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import loadingdata.ashish.advocateapp.Fragments.Cases;
import loadingdata.ashish.advocateapp.Fragments.Evidence;
import loadingdata.ashish.advocateapp.Fragments.Notes;
import loadingdata.ashish.advocateapp.Fragments.Schedule;
import loadingdata.ashish.advocateapp.Fragments.Clients;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
 
    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }
 
    @Override
    public Fragment getItem(int position) {
 
        switch (position) {
            case 0:
                Clients tab1 = new Clients();
                return tab1;
            case 1:
                Cases tab2 = new Cases();
                return tab2;
            case 2:
                Schedule tab3 = new Schedule();
                return tab3;
            case 3:
                Evidence tab4=new Evidence();
                return tab4;
            case 4:
                Notes tab5=new Notes();
                return tab5;
            default:
                return null;
        }
    }
 
    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}