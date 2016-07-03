package org.xiangbalao.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by longtaoge on 2016/7/3.
 */
public class MTextView extends TextView {

    // 监听
    OnClickListener mClickListener;

    public MTextView(Context context) {
        super(context);
    }

    public MTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    /**
     * 继续分发点击事件
     *
     * @param ev
     * @return
     */
    public boolean dispatchTouchEvent(MotionEvent ev) {
        // 设置监听
        if (mClickListener != null) {
            mClickListener.onClick(this);
        }
        super.dispatchTouchEvent(ev);
        return false;
    }

    public OnClickListener getmClickListener() {
        return mClickListener;
    }

    public void setmClickListener(OnClickListener mClickListener) {
        this.mClickListener = mClickListener;
    }

}
