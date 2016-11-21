package com.celebritysupermarket.fragment;

import android.view.View;

import com.celebritysupermarket.R;
import com.celebritysupermarket.base.BaseFragment;

/**
 * Created by diandian on 2016/11/21.
 */

public class LiveFragment extends BaseFragment {


    @Override
    protected LoaDingUI.ResultState onStartLoadData() {
        return LoaDingUI.ResultState.SUCCESS;
    }

    @Override
    protected View onInitSuccessView() {

        View view = View.inflate(getActivity(), R.layout.livefragment, null);



        return view;
    }
}
