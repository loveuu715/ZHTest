package com.loveuu.vv.mvp.fragment;

import android.os.Bundle;

import com.loveuu.vv.R;
import com.loveuu.vv.base.BaseFragment;

/**
 * Created by VV on 2016/9/21.
 */

public class MusicFragment extends BaseFragment {
    @Override
    protected int bindLayout() {
        return R.layout.fragment_music;
    }

    @Override
    protected void init() {

    }

    public static MusicFragment newInstance(String tag) {

        Bundle args = new Bundle();

        MusicFragment fragment = new MusicFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
