package com.Euspacetech.bakery.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.Euspacetech.bakery.R;
import com.Euspacetech.bakery.fragment.LoginFragment;
import com.Euspacetech.bakery.fragment.SignUpFragment;
import com.Euspacetech.bakery.adapter.ViewPagerAdapter;

public class LoginActivity extends FragmentActivity {
    private PagerAdapter mPagerAdapter;
    ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

      /*  //initialsie the pager
        this.initialisePaging();*/


  /*  private void initialisePaging() {

        List<Fragment> fragments = new Vector<Fragment>();
        //        fragments.add(Fragment.instantiate(this, LoginFragment.class.getName()));
        //        fragments.add(Fragment.instantiate(this, SignUpFragment.class.getName()));
        //       // fragments.add(Fragment.instantiate(this, Tab3Fragment.class.getName()));
        //        mPagerAdapter  = new com.Euspacetech.bakery.model.PagerAdapter(getSupportFragmentManager(),fragments);
        //        //
        pager =findViewById(R.id.viewpager);
        pager.setAdapter(this.mPagerAdapter);
    }*/


        viewPager = (ViewPager) findViewById(R.id.viewpager);

        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new LoginFragment(), "LOGIN");
        adapter.addFragment(new SignUpFragment(), "SIGN UP");
        viewPager.setAdapter(adapter);
    }

}

