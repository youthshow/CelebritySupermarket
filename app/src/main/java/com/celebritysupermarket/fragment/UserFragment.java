package com.celebritysupermarket.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.celebritysupermarket.adapter.UserAdapter;
import com.celebritysupermarket.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tt on 2016/6/20.
 */
public class UserFragment extends BaseFragment {


    @Override
    protected LoaDingUI.ResultState onStartLoadData() {


        return LoaDingUI.ResultState.SUCCESS;
    }

    private List<String> mData = new ArrayList<>();
    @Override
    protected View onInitSuccessView() {

        for (int i = 0;i<30;i++) {
            mData.add("user"+i);
        }


        RecyclerView recyclerView = new RecyclerView(getActivity());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        layoutManager.setOrientation(LinearLayout.VERTICAL);

        layoutManager.setReverseLayout(false);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(new UserAdapter(getActivity(),mData));


        return recyclerView;
    }


}
