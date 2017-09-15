package patient.yilin.com.testmd.propertyAnim_safari;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import patient.yilin.com.testmd.R;

public class TestSafariAnimActivity extends AppCompatActivity {

    private View view1,view2 ;
    private TextView tv1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_safari_anim);
        view1 = findViewById(R.id.salayout) ;
        view2 = findViewById(R.id.saiv1) ;
        tv1 = (TextView) findViewById(R.id.satv1);


    }

    //开始动画
    public void startShow(View view) {
        //翻转动画  透明度动画  缩放动画
        ObjectAnimator rotationAnima = ObjectAnimator.ofFloat(view1,"rotationX",0f,25f) ;

        rotationAnima.setDuration(300) ;


        ObjectAnimator alphaAnim = ObjectAnimator.ofFloat(view1,"alpha",1f,0.5f) ;
        alphaAnim.setDuration(300) ;

        ObjectAnimator scaleXAnim =ObjectAnimator.ofFloat(view1,"scaleX",1f,0.8f) ;  //缩放为自己的80%
        scaleXAnim.setDuration(300) ;
        ObjectAnimator scaleYAnim =ObjectAnimator.ofFloat(view1,"scaleY",1f,0.8f) ;
        scaleYAnim.setDuration(300) ;
        //给正想旋转设置监听 执行完毕后 在执行反向旋转
//        scaleYAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//
//            }
//        });
        ObjectAnimator rotationResumeAnim = ObjectAnimator.ofFloat(view1,"rotationX",25f,0f) ;  //反向旋转  恢复正的
        rotationResumeAnim.setDuration(200) ;
        rotationResumeAnim.setStartDelay(200); //延迟执行



        //缩放后 图片下移了 下方图片上滑出来  为保证回到原来的效果 这里在对图片进行上移   上移10% 的高度
        ObjectAnimator translationAnim = ObjectAnimator.ofFloat(view1,"translationY",0f,-0.1f*view1.getHeight()) ;
        translationAnim.setDuration(200) ;



        //第二个View  执行平移动画
        ObjectAnimator translationTwoAnim = ObjectAnimator.ofFloat(view2,"translationY",view2.getHeight(),0f) ;
        translationTwoAnim.setDuration(200) ;
        translationAnim.addListener(new AnimatorListenerAdapter(){
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                view2.setVisibility(View.VISIBLE);  //动画开始时  让布局2可见
                tv1.setClickable(false);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

            }
        });

        AnimatorSet set = new AnimatorSet() ;
        set.playTogether(rotationAnima,alphaAnim,scaleXAnim,scaleYAnim,rotationResumeAnim,translationAnim,translationTwoAnim);   //rotationResumeAnim
        set.start();




    }


    public void startHide(View view) {
        ObjectAnimator tranlationHideAnim = ObjectAnimator.ofFloat(view2,"translationY",0f,view2.getHeight()) ;
        tranlationHideAnim.setDuration(200) ;

       tranlationHideAnim.addListener(new AnimatorListenerAdapter() {
           @Override
           public void onAnimationEnd(Animator animation) {
               super.onAnimationEnd(animation);
               view2.setVisibility(View.INVISIBLE);
               tv1.setClickable(true);
           }
       });

        ObjectAnimator rotationAnim = ObjectAnimator.ofFloat(view1,"rotationX",0f,25f) ;
        rotationAnim.setDuration(200) ;

//这里 想要放大至全屏 所以需要将刚刚的上移  恢复 向下平移一点 ，且注意 必须和刚刚的参数是相反的  虽然都是向下平移0.1fde gaodu
        // 如果参数 是0f,0.1fheight 则会有问题  如果是-0.1fheight，0f就没有问题
        ObjectAnimator translationoneResumeAnim = ObjectAnimator.ofFloat(view1,"translationY",-0.1f*view1.getHeight(),0f) ;
        translationoneResumeAnim.setDuration(200) ;
        translationoneResumeAnim.setStartDelay(200);

        ObjectAnimator rotationResumeAnim = ObjectAnimator.ofFloat(view1,"rotationX",25f,0f) ;
        rotationResumeAnim.setDuration(200) ;
        rotationResumeAnim.setStartDelay(200);

        ObjectAnimator scaleXResumeAnim = ObjectAnimator.ofFloat(view1,"scaleX",0.8f,1f) ;
        scaleXResumeAnim.setDuration(200) ;
        scaleXResumeAnim.setStartDelay(200);

        ObjectAnimator scaleYResumeAnim = ObjectAnimator.ofFloat(view1,"scaleY",0.8f,1f) ;
        scaleYResumeAnim.setDuration(200) ;
        scaleYResumeAnim.setStartDelay(200);

        ObjectAnimator alphaResumeAnim = ObjectAnimator.ofFloat(view1,"alpha",0.5f,1f) ;
        alphaResumeAnim.setDuration(200) ;
        alphaResumeAnim.setStartDelay(200);



        AnimatorSet set = new AnimatorSet() ;
        set.playTogether(tranlationHideAnim,rotationAnim,translationoneResumeAnim,rotationResumeAnim,scaleXResumeAnim,scaleYResumeAnim,alphaResumeAnim);  //
        set.start();


    }
}
