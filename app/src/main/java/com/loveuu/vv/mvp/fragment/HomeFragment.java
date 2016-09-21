package com.loveuu.vv.mvp.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.loveuu.vv.R;
import com.loveuu.vv.base.BaseFragment;
import com.loveuu.vv.mvp.activity.SettingActivity;
import com.loveuu.vv.utils.SceneManager;
import com.loveuu.vv.utils.TipUtil;

/**
 * Created by VV on 2016/9/21.
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener {

    private RelativeLayout mToolbarRightRoot;
    private TextView mTitle;

    @Override
    protected int bindLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init() {
        mTitle = (TextView) mView.findViewById(R.id.tv_home_toolbar_title);
        mView.findViewById(R.id.rl_home_toolbar_right_root).setOnClickListener(this);
        mView.findViewById(R.id.iv_home_toolbar_right).setOnClickListener(this);
        mTitle.setText("首页");

    }

    public static HomeFragment newInstance(String tag) {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_home_toolbar_right_root:
                TipUtil.showToast("点击了城市");
                break;
            case R.id.iv_home_toolbar_right:
                SceneManager.toScene(mContext, SettingActivity.class, null);
                break;
        }
    }
}
