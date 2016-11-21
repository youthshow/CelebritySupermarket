package com.celebritysupermarket.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.celebritysupermarket.R;

import java.util.List;

/**
 * Created by tt on 2016/6/27.
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {
    private Context mContext;
    private List mDatas;

    public UserAdapter(Context context, List datas) {

        this.mContext = context;
        this.mDatas = datas;
    }


    @Override
    public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.user_fragment_item, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {

        holder.setData(mDatas.get(position) + "");

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }


    public class UserHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;

        public UserHolder(View itemView) {
            super(itemView);

            mTextView = (TextView) itemView.findViewById(R.id.user_text);
        }

        public void setData(String data) {
            mTextView.setText(data);
        }
    }
}
