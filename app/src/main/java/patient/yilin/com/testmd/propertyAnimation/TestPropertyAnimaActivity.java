package patient.yilin.com.testmd.propertyAnimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import patient.yilin.com.testmd.R;

import static android.support.v7.appcompat.R.styleable.View;

public class TestPropertyAnimaActivity extends AppCompatActivity {

    private static final String TAG = TestPropertyAnimaActivity.class.getSimpleName();
    private Button btn1 ;
    private ImageView iv1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_property_anima);

        btn1 = (Button) findViewById(R.id.pabtn1);
//        btn1.setAnimation((Animation) getResources().getAnimation(R.anim.translatea));
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnima(btn1);
                Log.d(TAG, "点击btn");
            }
        });

        iv1 = (ImageView) findViewById(R.id.paiv1);

        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnima(iv1);
            }
        });

    }


    public void startAnima(View v){
//        补间动画

//        Animation animation = AnimationUtils.loadAnimation(this,R.anim.translatea) ;
////        animation.start();
//        v.startAnimation(animation);

        //属性动画 ------
//        v.setTranslationX(100);  //向右平移 100dp 将view的坐标定位在100dp处  因此 再点击没反应

//        ObjectAnimator animator = new ObjectAnimator() ;
//        animator.ofFloat(v,"translationX",0f,300f) ;  //平行 从0-300
        //参数1  动画作用对象  参数2： 要执行什么动画 参数3： 可变数组   A set of values that the animation will animate between over time.

        //属性动画 旋转动画
//            ObjectAnimator oa = ObjectAnimator.ofFloat(v,"rotationX",0f,360f) ;
//            oa.setDuration(500) ;
//            oa.start();



        //---------------------属性动画  多个动画同时执行------------------------
        // 方法1： 设置动画监听  开始第一个动画同时开启其他动画
//        final ObjectAnimator oa = ObjectAnimator.ofFloat(v,"haha",0f,200f) ;  //没有这个属性值 相当于 就是valueanimator的使用
//        oa.setDuration(500) ;
//
//        //设置监听
//        oa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                //  动画在执行过程中 ，不断的调用此方法
//                oa.getAnimatedFraction() ;  //完成的百分比
//                float value = (float) oa.getAnimatedValue();  //  得到duration时间内values当中的某一个中间值 0f-200f
////                iv1.setAlpha((int) (0.5+value/200));   //0-1
//                iv1.setScaleX(0.2f+value/200);  //0-1   0.2-1.2
//                iv1.setScaleY(0.2f+value/200);  //0-1
//            }
//        });
//
//        oa.start();
//
//        //方法2：  直接使用valueAnimator
//        final ValueAnimator va = ValueAnimator.ofFloat(0f,200f) ;
//        va.setDuration(500) ;
//        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                float value = (float) va.getAnimatedValue();  //  得到duration时间内values当中的某一个中间值 0f-200f
////                iv1.setAlpha((int) (0.5+value/200));   //0-1
//                iv1.setScaleX(0.2f+value/200);  //0-1   0.2-1.2
//                iv1.setScaleY(0.2f+value/200);  //0-1
//            }
//        });
//        va.start();


        //方法 3：  propertyValuesHolder
//        PropertyValuesHolder  holder1 = PropertyValuesHolder.ofFloat("alpha",1f,0.3f,1f) ;
//        PropertyValuesHolder holder2 = PropertyValuesHolder.ofFloat("scaleX",1f,0.5f,1f) ;
//        PropertyValuesHolder holder3 = PropertyValuesHolder.ofFloat("scaleY",1f,0.5f,1f) ;
//        PropertyValuesHolder holder4 = PropertyValuesHolder.ofFloat("translationY",0f,50f) ;
//        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(iv1,holder1,holder2,holder3,holder4) ;
//        animator.setDuration(500) ;
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                float value = (float) animation.getAnimatedValue();
//                float fraction = animation.getAnimatedFraction() ;
//               float time =  animation.getCurrentPlayTime() ;
//                Log.e(TAG, "onAnimationUpdate: value"+value+",fraction"+fraction+",time"+time );
//
//            }
//        });
//        animator.start();

        //方法4： 动画集合

//        ObjectAnimator animator1 = ObjectAnimator.ofFloat(iv1,"alpha",1f,0.5f,1f) ;
//        ObjectAnimator animator2 = ObjectAnimator.ofFloat(iv1,"scaleX",1f,0.5f,1f) ;
//        ObjectAnimator animator3 = ObjectAnimator.ofFloat(iv1,"scaleY",1f,0.5f,1f) ;
//
//        AnimatorSet set = new AnimatorSet() ;
//        set.setDuration(500) ;
////        set.play() ;     //执行单个动画
////        set.playTogether(animator1,animator2,animator3);  //同时执行三个
//        set.playSequentially(animator1,animator2,animator3);  //依次执行
//        set.start();


//        -------------------------实现抛物线效果 -------------------------
        /**
         *  x  匀速
         *  y  加速度  1/2*g*t^2
         *  使用 估值器实现
         */

//        ValueAnimator vanimator = new ValueAnimator() ;
//        vanimator.setDuration(4000) ;
//        vanimator.setObjectValues(new PointF(0,0)); //设置的原坐标
//        //估值器 --定义计算规则
//        vanimator.setEvaluator(new TypeEvaluator<PointF>() {
//            @Override
//            public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
//                //拿到每一个时间点的坐标
//                PointF pointf = new PointF() ;
//                pointf.x = 100*(fraction*4) ; //初始速度*执行的百分比  fraction 百分比  vt
//                pointf.y = 0.5f*9.8f*(fraction*4)*(fraction*4) ;
//                return pointf;
//            }
//        });
//
//
//
//        vanimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                //得到时间点的坐标
//                    PointF pointf = (PointF) animation.getAnimatedValue();
//
//                    iv1.setX(pointf.x);
//                    iv1.setY(pointf.y);
//            }
//        });
////        vanimator.setInterpolator(new AccelerateInterpolator(5));
//        vanimator.start();


        ObjectAnimator animator3 = ObjectAnimator.ofFloat(iv1,"translationX",10f,400f) ;
        animator3.setDuration(500) ;
//        animator3.setInterpolator(new AccelerateInterpolator(5));  //一直加速
//        animator3.setInterpolator(new AccelerateDecelerateInterpolator());  //先加速再减速
//        animator3.setInterpolator(new DecelerateInterpolator(4));  //一直减速
//        animator3.setInterpolator(new AnticipateInterpolator(3));  //荡秋千式的加速器  先回弹 在进来（卫星菜单）
//        animator3.setInterpolator(new OvershootInterpolator(3));  //  先出去很多 再回弹一点
//        animator3.setInterpolator(new CycleInterpolator(4));//来回晃动
//        animator3.setInterpolator(new AnticipateOvershootInterpolator(4));
         animator3.setInterpolator(new BounceInterpolator());//阻尼效果
        animator3.start();

    }


}
