package com.celebritysupermarket.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;

public class CustomDialog extends Dialog{
	private boolean isCancelOnBackClick = true;

	private Activity mAct;
	public CustomDialog(Context context, int layout, int style) {
		super(context, style);
		setContentView(layout);
		mAct=(Activity)context;
		Window window = getWindow();
		WindowManager.LayoutParams params = window.getAttributes();
		params.width = WindowManager.LayoutParams.WRAP_CONTENT;
		params.height = WindowManager.LayoutParams.WRAP_CONTENT;
	}

	public CustomDialog(Context context, double width, double height,
			int layout, int style) {
		super(context, style);

		setContentView(layout);
		mAct=(Activity)context;
		Window window = getWindow();
		WindowManager.LayoutParams params = window.getAttributes();

		params.width = (int) width;
		params.height = (int) width;
		params.gravity = Gravity.CENTER;

		window.setAttributes(params);
	}
	
	public CustomDialog(Context context, int layout, int style,boolean isFullWidth) {
		super(context, style);
		setContentView(layout);
		mAct=(Activity)context;
		Window window = getWindow();
		WindowManager.LayoutParams params = window.getAttributes();
		params.width = WindowManager.LayoutParams.MATCH_PARENT;
		params.height = WindowManager.LayoutParams.WRAP_CONTENT;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			
		}
		return super.onKeyDown(keyCode, event);
	}

	public boolean isCancelOnBackClick() {
		return isCancelOnBackClick;
	}

	public void setCancelOnBackClick(boolean isCancelOnBackClick) {
		this.isCancelOnBackClick = isCancelOnBackClick;
	}
	
	@Override
	public void dismiss() {
		// TODO Auto-generated method stub
		if (mAct != null && !mAct.isFinishing()&&this.isShowing())
        {
            super.dismiss();    //调用超类对应方法
        }
	}
}
