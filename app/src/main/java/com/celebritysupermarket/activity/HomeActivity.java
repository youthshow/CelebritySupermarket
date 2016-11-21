package com.celebritysupermarket.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.celebritysupermarket.R;
import com.celebritysupermarket.adapter.HomePagerAdapter;
import com.celebritysupermarket.base.BaseActivity;
import com.celebritysupermarket.view.NoScrollViewPager;

public class HomeActivity extends BaseActivity implements View.OnClickListener {
    private NoScrollViewPager mViewPager;
    private Button mHome, mLive, mUser;
    private int mItem = -1;
    private Button mShoppingCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();
        initData();

    }

    private void initView() {
        mViewPager = (NoScrollViewPager) findViewById(R.id.homeViewpager);

        mHome = (Button) findViewById(R.id.home);
        mUser = (Button) findViewById(R.id.user);
        mLive = (Button) findViewById(R.id.MyLive);
        mShoppingCart = (Button) findViewById(R.id.ShoppingCart);
        mHome.setOnClickListener(this);
        mLive.setOnClickListener(this);
        mShoppingCart.setOnClickListener(this);
        mUser.setOnClickListener(this);

    }

    private void initData() {

        mViewPager.setAdapter(new HomePagerAdapter(getSupportFragmentManager()));

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.home:

                replaceIcon(R.drawable.home_press,R.drawable.live,R.drawable.shoppingcart,R.drawable.user);

                mItem = 0;

                break;

            case R.id.MyLive:
                replaceIcon(R.drawable.home,R.drawable.mylive,R.drawable.shoppingcart,R.drawable.user);

                mItem = 1;
                break;

            case R.id.ShoppingCart:

                replaceIcon(R.drawable.home,R.drawable.live,R.drawable.shoppingcart2,R.drawable.user);
                mItem = 2;

                break;

            case R.id.user:
                replaceIcon(R.drawable.home,R.drawable.live,R.drawable.shoppingcart,R.drawable.user_press);

                mItem = 3;

                break;

            default:

                break;
        }

        mViewPager.setCurrentItem(mItem);

    }

    private void replaceIcon(int home,int live,int shoppingCart, int user){

        Drawable drawable_home = getResources().getDrawable(home);
        drawable_home.setBounds(0, 0, drawable_home.getMinimumWidth(), drawable_home.getMinimumHeight());
        mHome.setCompoundDrawables(null, drawable_home, null, null);

        Drawable drawable_live = getResources().getDrawable(live);
        drawable_live.setBounds(0, 0, drawable_live.getMinimumWidth(), drawable_live.getMinimumHeight());
        mLive.setCompoundDrawables(null, drawable_live, null, null);

        Drawable drawable_publish = getResources().getDrawable(shoppingCart);
        drawable_publish.setBounds(0, 0, drawable_publish.getMinimumWidth(), drawable_publish.getMinimumHeight());
        mShoppingCart.setCompoundDrawables(null, drawable_publish, null, null);

        Drawable drawable_user = getResources().getDrawable(user);
        drawable_user.setBounds(0, 0, drawable_user.getMinimumWidth(), drawable_user.getMinimumHeight());
        mUser.setCompoundDrawables(null, drawable_user, null, null);

    }

}