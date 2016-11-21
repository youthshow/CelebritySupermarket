package com.celebritysupermarket.base;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.celebritysupermarket.fragment.LoaDingUI;
import com.celebritysupermarket.utils.Logger;
import com.celebritysupermarket.utils.UiUtils;



/**
 * Created by tt on 2016/6/13.
 */
public abstract class BaseFragment extends Fragment {


    private LoaDingUI mLoadingUI;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (mLoadingUI==null) {
            mLoadingUI = new LoaDingUI(UiUtils.getContext()) {


                @Override
                protected ResultState onLoadData() {
                    Logger.d("BaseFra","++++++++++++++++++++++++++++++++");
                    return onStartLoadData();
                }

                @Override
                protected View onLoadSuccessView() {
                    Logger.d("BaseFra","successView++++++++");
                    return onInitSuccessView();
                }
            };
        }else {
            ViewParent parent = mLoadingUI.getParent();

            if (parent instanceof ViewGroup)
            {
                ((ViewGroup) parent).removeView(mLoadingUI);
            }
        }
        //返回加载中的View
        return mLoadingUI;
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        loadData();
    }


    /**
     * 加载数据的方法
     */
    public void loadData()
    {
        if (mLoadingUI != null)
        {
            // 去网络加载数据--->
            mLoadingUI.loadData();
        }
    }



    /**
     * 当加载数据时的回调
     *
     * @return
     */
    protected abstract LoaDingUI.ResultState onStartLoadData();

    /**
     * 显示成功的view
     *
     * @return
     */
    protected abstract View onInitSuccessView();

}
