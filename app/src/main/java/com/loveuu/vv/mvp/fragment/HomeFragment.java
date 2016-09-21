package com.loveuu.vv.mvp.fragment;

import android.os.Bundle;

import com.loveuu.vv.R;
import com.loveuu.vv.base.BaseFragment;

/**
 * Created by VV on 2016/9/21.
 */

public class HomeFragment extends BaseFragment {
    @Override
    protected int bindLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init() {

    }

    public static HomeFragment newInstance(String tag) {
        
        Bundle args = new Bundle();
        
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
