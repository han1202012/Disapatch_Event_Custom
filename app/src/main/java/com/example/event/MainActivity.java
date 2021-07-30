package com.example.event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 该方法是页面事件分发入口
     *
     * 针对 ACTION_DOWN 事件分析 :
     *  事件来源 :
     *      驱动层产生触摸事件, 由 WindowManagerService 传递到 Activity
     *  事件分发 :
     *      如果返回 true / false, 说明事件被消费, 停止传递
     *      如果返回 super.dispatchTouchEvent(ev), 那么继续向下传递, 按照如下顺序逐层传递 :
     *          Activity -> PhoneWindow -> DecorView -> ViewGrope
     *          最终传递到 ViewGroup, 调用 ViewGroup 的 dispatchTouchEvent 方法
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
     *      布局容器 ViewGroup 的 dispatchTouchEvent 方法返回 false
     *      布局容器 ViewGroup 的 onTouchEvent 方法返回 false / super.onTouchEvent(event)
     *   事件分发 : 这是事件传递的终点, 返回值无所谓
     *      返回 true 说明事件被消费了
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}