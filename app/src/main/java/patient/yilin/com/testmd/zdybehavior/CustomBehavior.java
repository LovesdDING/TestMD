package patient.yilin.com.testmd.zdybehavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * 实现了一个控件 监听另一个控件 和它一起运动
 * Created by Administrator on 2017/9/13.
 */

public class CustomBehavior extends CoordinatorLayout.Behavior<View>{
    public CustomBehavior() {
    }

    public CustomBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     *  用来决定要监听 哪些控件或容器的状态    返回值由两个因素决定 1.知道监听谁  2.什么状态改变
     * @param parent
     * @param child   子控件  --观察者
     * @param dependency  要监听的view
     * @return
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        //还可以 根据id或者tag 来判断监听的对象
        return dependency instanceof TextView ||super.layoutDependsOn(parent, child, dependency);
    }

    /**
     * 当被监听的view  发生改变的时候 回调
     * 可以在此方法里做一些相应的联动动画等效果。
     * @param parent
     * @param child
     * @param dependency
     * @return
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {

        //获取 被监听的View 的状态 --垂直方向的位置

        int offset =  dependency.getTop()-child.getTop() ;

        //让child 进行平移
        ViewCompat.offsetTopAndBottom(child,offset);
        child.animate().rotation(child.getTop()*10) ;  //旋转动画
        return true;
    }
}
