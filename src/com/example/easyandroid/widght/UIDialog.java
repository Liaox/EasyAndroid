package com.example.easyandroid.widght;

import com.example.easyandroid.R;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class UIDialog extends Dialog {
	
	private View mContentView;

	private static final int DEFAULT_WIDTH = 300; // 默认宽度
	// private static final int DEFAULT_HEIGHT = 120; // 默认高度

	public UIDialog(Context context) {
		this(context, DEFAULT_WIDTH);
	}

	public UIDialog(Context context, int width) {
		super(context, R.style.AlertDialog);
		mContentView = getLayoutInflater().inflate(R.layout.uidialog_layout, null);
		// set content
		setContentView(mContentView);
		// set window params
		Window window = getWindow();
		window.setWindowAnimations(R.style.DialogAnimation);
		WindowManager.LayoutParams params = window.getAttributes();
		// set width,height by density and gravity
		float density = getDensity(context);
		params.width = (int) (width * density);
		// params.height = (int) (height * density);
		params.gravity = Gravity.CENTER;
		window.setAttributes(params);
	}

	private float getDensity(Context context) {
		Resources resources = context.getResources();
		DisplayMetrics dm = resources.getDisplayMetrics();
		return dm.density;
	}
	
	/**
	 * 设置标题
	 */
	public void setTitle(String title) {
		TextView titleView = (TextView) mContentView.findViewById(R.id.title);
		titleView.setText(title);
	}
	
	/**
	 * 设置标题
	 */
	public void setTitle(int titleRes) {
		TextView titleView = (TextView) mContentView.findViewById(R.id.title);
		titleView.setText(titleRes);
	}
	
	/**
	 * 设置提示信息
	 * @param msgRes
	 */
	public void setMessage(int msgRes) {
		TextView messageView = (TextView) mContentView.findViewById(R.id.message);
		messageView.setText(msgRes);
	}
	
	/**
	 * 设置提示信息
	 * @param msgRes
	 */
	public void setMessage(String msg) {
		TextView messageView = (TextView) mContentView.findViewById(R.id.message);
		messageView.setText(msg);
	}
	
	/**
	 * 设置左边按钮显示文本和监听事件
	 * @param msgRes
	 */
	public void setLeftButton(int textRes, View.OnClickListener listener) {
		Button leftBtn = (Button) mContentView.findViewById(R.id.leftBtn);
		leftBtn.setVisibility(View.VISIBLE);
		leftBtn.setText(textRes);
		leftBtn.setOnClickListener(listener);
		showButtonDivider();
	}
	
	/**
	 * 设置中间按钮显示文本和监听事件
	 * @param textRes
	 * @param listener
	 */
	public void setCenterButton(int textRes, View.OnClickListener listener) {
		Button centerBtn = (Button) mContentView.findViewById(R.id.centerBtn);
		centerBtn.setVisibility(View.VISIBLE);
		centerBtn.setText(textRes);
		centerBtn.setOnClickListener(listener);
		showButtonDivider();
	}
	
	/**
	 * 设置右边按钮显示文本和监听事件
	 * @param textRes
	 * @param listener
	 */
	public void setRightButton(int textRes, View.OnClickListener listener) {
		Button rightBtn = (Button) mContentView.findViewById(R.id.rightBtn);
		rightBtn.setVisibility(View.VISIBLE);
		rightBtn.setText(textRes);
		rightBtn.setOnClickListener(listener);
		showButtonDivider();
	}
	
	/*
	 * 控制按钮之间分割线的显示
	 */
	private void showButtonDivider() {
		Button leftBtn = (Button) mContentView.findViewById(R.id.leftBtn);
		Button centerBtn = (Button) mContentView.findViewById(R.id.centerBtn);
		Button rightBtn = (Button) mContentView.findViewById(R.id.rightBtn);
		View divider1 = mContentView.findViewById(R.id.divider1);
		View divider2 = mContentView.findViewById(R.id.divider2);
		if (leftBtn.getVisibility() == View.VISIBLE && rightBtn.getVisibility() == View.VISIBLE && centerBtn.getVisibility() == View.VISIBLE) {
			divider1.setVisibility(View.VISIBLE);
			divider2.setVisibility(View.VISIBLE);
			centerBtn.setBackgroundResource(R.drawable.skin_alert_center_btn);
		}
		if (leftBtn.getVisibility() == View.VISIBLE && rightBtn.getVisibility() == View.VISIBLE && centerBtn.getVisibility() != View.VISIBLE) {
			divider1.setVisibility(View.VISIBLE);
			divider2.setVisibility(View.GONE);
		}
		if (leftBtn.getVisibility() != View.VISIBLE && rightBtn.getVisibility() != View.VISIBLE && centerBtn.getVisibility() == View.VISIBLE) {
			divider1.setVisibility(View.GONE);
			divider2.setVisibility(View.GONE);
			centerBtn.setBackgroundResource(R.drawable.skin_alert_btn);
		}
	}
	
}