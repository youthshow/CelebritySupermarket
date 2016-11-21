package com.celebritysupermarket.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.celebritysupermarket.adapter.HomeAdapter;
import com.celebritysupermarket.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tt on 2016/6/17.
 */
public class HomePageFragment extends BaseFragment {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private HomeAdapter mHomeAdapter;
    private List<String> mData;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:

                    mData.clear();
                    for (int i = 0; i < 50; i++) {
                        mData.add("item" + i);
                    }
                    mSwipeRefreshLayout.setRefreshing(false);
                    mHomeAdapter.notifyDataSetChanged();
                    break;

                default:
                    break;
            }
        }
    };


    @Override
    protected LoaDingUI.ResultState onStartLoadData() {

        return LoaDingUI.ResultState.SUCCESS;
    }

    @Override
    protected View onInitSuccessView() {

        mData = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            mData.add("item" + i);
        }
        mSwipeRefreshLayout = new SwipeRefreshLayout(getActivity());

        mRecyclerView = new RecyclerView(getActivity());
        //布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        //设置是否反向显示
        layoutManager.setReverseLayout(false);
        //设置显示的方向
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mHomeAdapter = new HomeAdapter(getActivity(), mData);
        mRecyclerView.setAdapter(mHomeAdapter);
        //下拉刷新
        mSwipeRefreshLayout.addView(mRecyclerView);
        mSwipeRefreshLayout.setLayoutParams(new SwipeRefreshLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mHandler.sendEmptyMessageAtTime(1, 3000);
            }
        });
        return mSwipeRefreshLayout;
    }
}
