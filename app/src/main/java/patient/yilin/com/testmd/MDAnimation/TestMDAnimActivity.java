package patient.yilin.com.testmd.MDAnimation;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;

import patient.yilin.com.testmd.R;

public class TestMDAnimActivity extends AppCompatActivity {

    private Button  mdbtn1 ,mdbtn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_mdanim);

        mdbtn1 = (Button) findViewById(R.id.mdbtn1);
        mdbtn2 = (Button) findViewById(R.id.mdbtn2);


        mdbtn1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {
                //圆形水波纹揭露 效果
                Animator animator = ViewAnimationUtils.createCircularReveal(v,mdbtn1.getWidth()/2,mdbtn1.getHeight()/2,0,mdbtn1.getHeight()) ;
//                Math.hypot(x,y);
                animator.setDuration(1000) ;
                animator.setInterpolator(new AccelerateInterpolator(3));
                animator.start();
            }
        });

        //   Math.hypot(mdbtn2.getWidth(),mdbtn2.getHeight()) 勾股定理 计算斜边长
        //  从右上角的揭露效果
        mdbtn2.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("NewApi")
                    @Override
                    public void onClick(View v) {
                        Animator animator  = ViewAnimationUtils.createCircularReveal(mdbtn2,   //作用的View
                                0,0,  //centerX centerY  扩散的中心店
                                0,  //扩散开始的半径
                                (float) Math.hypot(mdbtn2.getWidth(),mdbtn2.getHeight())     //扩散最终的半径
                               ) ;
                        animator.setDuration(1000) ;
                        animator.setInterpolator(new AccelerateInterpolator(3));
                        animator.start();
                    }
                }
        );
    }

    /**
     * 揭露动画
     * @param view
     */
    public void reveal(View view) {

    }
}
