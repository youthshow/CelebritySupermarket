package com.celebritysupermarket.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.celebritysupermarket.R;


/**
 * Created by tt on 2016/6/28.
 */
public class ScanEditText extends LinearLayout {
    private EditText etTitle;
    private ImageView ivScan;

    public ScanEditText(Context context) {
        this(context, null);
    }

    public ScanEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        View.inflate(context, R.layout.scan_edittext, this);
        etTitle = (EditText) findViewById(R.id.scan_editext_title);
        ivScan = (ImageView) findViewById(R.id.sane_image_icon);


        ivScan.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();

            }
        });

    }

    public void setText(String data) {
        etTitle.setText(data);
    }
    public String getText(){
        return etTitle.getText().toString();
    }

    public int getLength() {
        return etTitle.length();
    }

}
