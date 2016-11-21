package com.celebritysupermarket.fragment;

import android.view.View;

import com.celebritysupermarket.R;
import com.celebritysupermarket.base.BaseFragment;


/**
 * Created by tt on 2016/6/20.
 */

public class ShoppingCartFragment extends BaseFragment {

    @Override
    protected LoaDingUI.ResultState onStartLoadData() {
        return LoaDingUI.ResultState.SUCCESS;
    }

    @Override
    protected View onInitSuccessView() {

        View view = View.inflate(getActivity(), R.layout.publish_fragment, null);

        return view;
    }


}

