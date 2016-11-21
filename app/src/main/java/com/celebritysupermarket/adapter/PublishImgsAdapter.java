package com.celebritysupermarket.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.celebritysupermarket.R;
import com.celebritysupermarket.utils.Logger;

import java.util.List;

/**
 * Created by tt on 2016/7/6.
 */
public class PublishImgsAdapter extends RecyclerView.Adapter<PublishImgsAdapter.ImagsViewHolder> {

    private Context mContext;
    private List data;
    private ImageView mDelete_Image;

    public PublishImgsAdapter(Context context, List data) {

        this.mContext = context;
        this.data = data;

    }


    @Override
    public ImagsViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {

        final View view = View.inflate(mContext, R.layout.publishimgs_item, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        mDelete_Image = (ImageView) view.findViewById(R.id.delete_Image);
        mDelete_Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.removeView(view);
            }
        });

        return new ImagsViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(ImagsViewHolder holder, int position) {
        Bitmap bitmap = (Bitmap) data.get(position);
        holder.setData(bitmap);


    }

    @Override
    public int getItemCount() {
        Logger.d("tt","Recyview"+data.size());
        if (data != null) {
            return data.size();
        }
        return 0;
    }


    public class ImagsViewHolder
            extends RecyclerView.ViewHolder {
        private ImageView mPublishImageView;

        public ImagsViewHolder(View itemView, int viewType) {
            super(itemView);
            mPublishImageView = (ImageView) itemView.findViewById(R.id.publish_Image);

        }

        public void setData(Bitmap bitmap ) {
            mPublishImageView.setImageBitmap(bitmap);
        }
    }


}
