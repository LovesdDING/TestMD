package patient.yilin.com.testmd;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2017/9/8.
 */

public class FabBehavior1 extends FloatingActionButton.Behavior {

    private boolean visible = true ;

    public FabBehavior1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        return super.layoutDependsOn(parent, child, dependency);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        return super.onDependentViewChanged(parent, child, dependency);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
        //当观察的View（RecyclerView） 发生滑动的开始的时候 回调
        //nestedScrollAxes  滑动关联轴

        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL||super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);

    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        //当观察的View滑动的时候 回调的
        //  根据滑动情况 执行动画   hide show
        // dyUnconsumed  滑动的惯性值
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        if(dyConsumed>0&&!visible){  //下拉 show
            onShow(child);

        }else if(dyConsumed<0&&visible){  //上滑  hide
            onHide(child);
        }
    }


    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
    }


    public void onHide( FloatingActionButton fab) {
        //实现 隐藏动画  --属性动画
//        toolbar.animate().translationY(-toolbar.getHeight())
//                .setInterpolator(new AccelerateInterpolator(3)) ;

        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
        //这里 要通过 RelativeLayoutParams 或者 LinearLayoutParams   如果是VIewGroup的LayoutParams  获取不到bottomMargin
        fab.animate().translationY(fab.getHeight()+params.bottomMargin)  //fab的高度 + fab的外边距
                .setInterpolator(new AccelerateInterpolator(3)) ;  //开始慢  然后快


    }


    public void onShow( FloatingActionButton fab) {
        //实现显示动画
//        toolbar.animate().translationY(0)
//                .setInterpolator(new DecelerateInterpolator(3)) ;

        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
        fab.animate().translationY(0).setInterpolator(new DecelerateInterpolator(3)) ;  //开始快 然后慢
    }

}
