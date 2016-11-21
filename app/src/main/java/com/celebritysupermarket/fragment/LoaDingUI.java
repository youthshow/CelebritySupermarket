package com.celebritysupermarket.fragment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.celebritysupermarket.R;
import com.celebritysupermarket.utils.Logger;
import com.celebritysupermarket.utils.UiUtils;


/**
 * Created by tt on 2016/6/17.
 * <p/>
 * 容器:1.加载中,加载失败,加载为空,加载成功
 */
public abstract class LoaDingUI extends FrameLayout {

    private static final int STATE_NOME = 0;//没有状态
    private static final int STATE_LOADING = 1;//加载中
    private static final int STATE_ERROR = 2;//加载失败
    private static final int STATE_SUCCESS = 3;//加载成功
    private TextView reStartData;

    private View mLoadingView;
    private View mErrorView;
    private View mSuccessView;


    private int mCurrentState = STATE_NOME;//记录当前的状态

    public LoaDingUI(Context context) {
        this(context, null);
    }

    public LoaDingUI(Context context, AttributeSet attrs) {
        super(context, attrs);

        //加载中
        if (mLoadingView == null) {
            mLoadingView = View.inflate(getContext(), R.layout.pager_loading, null);
            addView(mLoadingView);
        }

        //加载失败
        if (mErrorView == null) {
            mErrorView = View.inflate(getContext(), R.layout.pager_error, null);
            addView(mErrorView);
            reStartData= (TextView) mErrorView.findViewById(R.id.error_restart);
            reStartData.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadData();
                }
            });
        }

        //加载成功 TODO

        updateUI();

    }

    /**
     * 安全更新UI
     */
    private void safeUpdateUI() {
        UiUtils.post(new Runnable() {
            @Override
            public void run() {
                updateUI();
            }
        });
    }

    private void updateUI() {
        // 加载中的是否显示
        mLoadingView.setVisibility(mCurrentState == STATE_NOME || mCurrentState == STATE_LOADING ? View.VISIBLE : View.GONE);
        // 加载失败是否显示
        mErrorView.setVisibility(mCurrentState == STATE_ERROR ? View.VISIBLE : View.GONE);

        if (mSuccessView == null && mCurrentState == STATE_SUCCESS) {
            mSuccessView = onLoadSuccessView();
            addView(mSuccessView);
        }

        // 加载成功是否显示
        if (mSuccessView != null)
        {
            mSuccessView.setVisibility(mCurrentState == STATE_SUCCESS ? View.VISIBLE : View.GONE);
        }
    }


    public void loadData() {
        // 如果成功时,正在加载中，不做操作
        if (mCurrentState == STATE_LOADING || mCurrentState == STATE_SUCCESS) {
            return;
        }

        // none,error
        // 状态改变
        mCurrentState = STATE_LOADING;
        safeUpdateUI();

        // 耗时操作

        new Thread(new LoadDataTask()).start();
    }


    private class LoadDataTask implements Runnable {

        @Override
        public void run() {

            // 去加载数据
            ResultState resultState = onLoadData();

            // 知道结果
            mCurrentState = resultState.getState();
            Logger.d("load","mCurrentState=="+mCurrentState);

            // 更新UI
            safeUpdateUI();
        }
    }

    /**
     * 加载数据的方法
     *
     * @return 返回结果状态
     */
    protected abstract ResultState onLoadData();

    /**
     * 加载成功的view的方法
     *
     * @return
     */
    protected abstract View onLoadSuccessView();


    public enum ResultState {
        ERROR(STATE_ERROR), SUCCESS(STATE_SUCCESS);

        private int state;

        private ResultState(int state) {
            this.state = state;
        }

        public int getState() {
            return state;
        }
    }


}
