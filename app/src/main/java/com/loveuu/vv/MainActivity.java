package com.loveuu.vv;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.loveuu.vv.base.eventbus.EventObject;
import com.loveuu.vv.mvp.fragment.BookFragment;
import com.loveuu.vv.mvp.fragment.GameFragment;
import com.loveuu.vv.mvp.fragment.HomeFragment;
import com.loveuu.vv.mvp.fragment.MusicFragment;
import com.loveuu.vv.utils.ActivityManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;

    private ArrayList<Fragment> fragments;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUnbinder = ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        init();
    }

    public void init() {
//        bottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
//        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.homelan, "首页")
                .setActiveColorResource(R.color.main_home_color))
                .addItem(new BottomNavigationItem(R.mipmap.houselan, "房源")
                        .setActiveColorResource(R.color.main_house_color))
                .addItem(new BottomNavigationItem(R.mipmap.tongxunlan, "联系人")
                        .setActiveColorResource(R.color.main_contract_color))
                .addItem(new BottomNavigationItem(R.mipmap.mycenterlan, "个人中心")
                        .setActiveColorResource(R.color.main_center_color))
                .setFirstSelectedPosition(0)
                .setBarBackgroundColor(R.color.bottom_bar_color)
                .setInActiveColor(R.color.bottom_bar_def_icon)
                .initialise();

        fragments = getFragments();
        setDefaultFragment();
        bottomNavigationBar.setTabSelectedListener(this);
    }

    private ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(HomeFragment.newInstance("Home"));
        fragments.add(BookFragment.newInstance("House"));
        fragments.add(MusicFragment.newInstance("Contract"));
        fragments.add(GameFragment.newInstance("Center"));
        return fragments;
    }

    /**
     * 设置默认的
     */
    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.main_layFrame, HomeFragment.newInstance("Home"));
        transaction.commit();
    }

    @Subscribe
    public void onEvent(EventObject eo){
    }

    @Override
    public void onBackPressed() {
        ActivityManager.getInstances().finishAll();
        super.onBackPressed();
    }

    @Override
    public void onTabSelected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                if (fragment.isAdded()) {
                    ft.replace(R.id.main_layFrame, fragment);
                } else {
                    ft.add(R.id.main_layFrame, fragment);
                }
                ft.commitAllowingStateLoss();
            }
        }
    }

    @Override
    public void onTabUnselected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                ft.remove(fragment);
                ft.commitAllowingStateLoss();
            }
        }
    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null)
            mUnbinder.unbind();
        EventBus.getDefault().unregister(this);
    }
}
