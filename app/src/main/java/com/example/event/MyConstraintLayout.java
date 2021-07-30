package com.example.event;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MyConstraintLayout extends ConstraintLayout {

    public MyConstraintLayout(Context context) {
        super(context);
    }

    public MyConstraintLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyConstraintLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 针对 ACTION_DOWN 事件分析 :
     *  事件来源 :
     *      从 Activity 的 dispatchTouchEvent 传递而来
     *      从父容器 ViewGroup 的 dispatchTouchEvent 传递而来
     *  事件分发 :
     *      如果返回 true, 表示事件被消费, 停止传递
     *      如果返回 false, 则传递给父控件的 onTouchEvent 方法
     *      如果返回 super.dispatchTouchEvent(ev) , 则继续向下传递到 onInterceptTouchEvent 方法
     *
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 针对 ACTION_DOWN 事件分析 :
     *  事件来源 :
     *      从 本类 的 dispatchTouchEvent 方法传递而来
     *  事件分发 :
     *      返回 true, 则停止向后传递, 执行本类的 onTouchEvent 方法
     *          如果需要拦截, 返回true
     *      返回 false / super.onInterceptTouchEvent(ev),
     *          则继续向 子容器/子组件 的 dispatchTouchEvent 方法传递; ( 这里是子组件 )
     *          默认不拦截
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }

    /**
     * 针对 ACTION_DOWN 事件分析 :
     *  事件来源 :
     *      本类的 onInterceptTouchEvent 方法返回 true
     *      子组件/子容器 的 dispatchTouchEvent 方法返回 false
     *      子组件/子容器 的 onTouchEvent 方法返回 false / super.onTouchEvent(event)
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