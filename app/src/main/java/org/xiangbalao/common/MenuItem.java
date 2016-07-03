package org.xiangbalao.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import org.xiangbalao.clickitem.MainActivity;

public class MenuItem extends LinearLayout {







	// 监听
	OnClickListener mClickListener;

	public MenuItem(Context context) {
		super(context);

	}

	public MenuItem(Context context, AttributeSet attrs) {
		super(context, attrs);
	}


	/*public boolean dispatchTouchEvent(MotionEvent ev) {
		// 设置监听
		if (mClickListener != null) {
			mClickListener.onClick(this);
		}

		super.dispatchTouchEvent(ev);
		return false;
	}*/


	public OnClickListener getmClickListener() {
		return mClickListener;
	}

	public void setmClickListener(OnClickListener mClickListener) {
		this.mClickListener = mClickListener;
	}




	@Override
	public boolean onTouchEvent(MotionEvent event) {

		for(int i=0;i<this.getChildCount(); i++){
			switch (event.getAction()){

				case  MotionEvent.ACTION_DOWN:

				this.getChildAt(i).setSelected(true);
				//	this.getChildAt(i).setPressed(true);

					Log.i(MainActivity.class.getSimpleName(), "ACTION_DOWN");
					break;


				case MotionEvent.ACTION_UP:
					this.getChildAt(i).setSelected(false);
				//	this.getChildAt(i).setPressed(false);
					Log.i(MainActivity.class.getSimpleName(), "ACTION_UP");
					break;
				default:
					this.getChildAt(i).setSelected(false);
					//this.getChildAt(i).setPressed(false);
					Log.i(MainActivity.class.getSimpleName(), "default");

					break;

			}




		}

		return   super.onTouchEvent(event);


	}



	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		return true;
	}
}
