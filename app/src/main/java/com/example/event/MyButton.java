package com.example.event;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MyButton extends androidx.appcompat.widget.AppCompatButton {
    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 针对 ACTION_DOWN 事件分析 :
     *  事件来源 :
     *      父容器 ViewGroup 的 onInterceptTouchEvent 如果返回 false / super.onInterceptTouchEvent(ev)
     *          将事件传递到该方法
     *  事件分发 :
     *      如果返回 true, 表示事件被消费, 停止传递
     *      如果返回 false, 则传递给父控件的 onTouchEvent 方法
     *      如果返回 super.dispatchTouchEvent(ev) , 则向本类的 onTouchEvent 方法传递
     *
     * @param event
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    /**
     * 针对 ACTION_DOWN 事件分析 :
     *  事件来源 :
     *      本类的 dispatchTouchEvent 方法返回 super.dispatchTouchEvent(event)
     *   事件分发 :
     *      返回 true 说明事件被消费了, 不再向下传递
     *      返回 false / super.onTouchEvent(event) , 则需要继续向下传递
     *          向父容器的 onTouchEvent 传递
     *
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
