package com.loveuu.vv.mvp.fragment;

import android.os.Bundle;

import com.loveuu.vv.R;
import com.loveuu.vv.base.BaseFragment;

/**
 * Created by VV on 2016/9/21.
 */

public class BookFragment extends BaseFragment {
    @Override
    protected int bindLayout() {
        return R.layout.fragment_book;
    }

    @Override
    protected void init() {

    }

    public static BookFragment newInstance(String tag) {
        Bundle args = new Bundle();
        BookFragment fragment = new BookFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
