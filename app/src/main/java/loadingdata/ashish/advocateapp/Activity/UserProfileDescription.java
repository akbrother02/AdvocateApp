package loadingdata.ashish.advocateapp.Activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import loadingdata.ashish.advocateapp.Adpater.PagerAdapter;
import loadingdata.ashish.advocateapp.R;

public class UserProfileDescription extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_description);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Basic Details"));
        tabLayout.addTab(tabLayout.newTab().setText("Cases"));
        tabLayout.addTab(tabLayout.newTab().setText("Schedules"));
        tabLayout.addTab(tabLayout.newTab().setText("Evidence"));
        tabLayout.addTab(tabLayout.newTab().setText("Notes"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(2);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
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

    public String getData()
    {
        Bundle bundle=getIntent().getExtras();
        String name=bundle.getString("Name");
        String Address=bundle.getString("Address");
        String Contact=bundle.getString("Contact");
        String Email=bundle.getString("Email");
        String City=bundle.getString("City");

        return name+"-" +Address+"-"+Contact+"-"+Email+"-"+City;
    }
}
