package com.loveuu.vv.mvp.fragment;

import android.os.Bundle;
import android.view.View;

import com.loveuu.vv.R;
import com.loveuu.vv.base.BaseFragment;
import com.loveuu.vv.utils.SceneManager;
import com.loveuu.vv.widget.citypicker.CityPickerActivity;

/**
 * Created by VV on 2016/9/21.
 */

public class BookFragment extends BaseFragment implements View.OnClickListener {

    @Override
    protected int bindLayout() {
        return R.layout.fragment_book;
    }

    @Override
    protected void init() {
        mView.findViewById(R.id.iv_house_toolbar_right).setOnClickListener(this);
    }

    public static BookFragment newInstance(String tag) {
        Bundle args = new Bundle();
        BookFragment fragment = new BookFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_house_toolbar_right:
                SceneManager.toScene(mContext, CityPickerActivity.class, null);
                break;
        }
    }
}
