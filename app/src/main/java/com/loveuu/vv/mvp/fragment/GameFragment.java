package com.loveuu.vv.mvp.fragment;

import android.os.Bundle;

import com.loveuu.vv.R;
import com.loveuu.vv.base.BaseFragment;

/**
 * Created by VV on 2016/9/21.
 */

public class GameFragment extends BaseFragment {
    @Override
    protected int bindLayout() {
        return R.layout.fragment_game;
    }

    @Override
    protected void init() {

    }

    public static GameFragment newInstance(String tag) {
        
        Bundle args = new Bundle();
        
        GameFragment fragment = new GameFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
