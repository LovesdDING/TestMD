package patient.yilin.com.testmd.MDzhuanchangAnimation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import patient.yilin.com.testmd.R;

/**
 *  转场动画 效果实现   5.0以上 API21以后 经常用到
 */
public class TestMDSceneTransActivity extends AppCompatActivity {

    private ImageView iv1 ;
    private Button btn ;
    private TextView tv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS) ;  //设置允许使用专场动画
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_mdscene_trans);

        iv1 = (ImageView) findViewById(R.id.mdtransiv1);
        btn = (Button) findViewById(R.id.mdtransbtn);
        tv = (TextView) findViewById(R.id.mdtranstv);



    }

    @SuppressLint("NewApi")
    public void jump(View view) {
//        startActivity(new Intent(this,TestMDSceneTrans2Activity.class));
//        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);

        //处理多个共享元素？
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this //当前activity
                ,iv1   //共享元素 哪一个view
                ,"iv_meinv3"    //共享元素的名称  android:transitionName=“iv_meinv3”
                ) ;

        ActivityOptionsCompat activityOptionsCompat1 = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this, Pair.create((View)iv1,"mdtransiv1"),Pair.create((View)btn,"mdtransbtn"),Pair.create((View) tv,"mdtranstv")
        ) ;  //Pair.create  只能匹配 View,String
        Intent intent = new Intent(TestMDSceneTransActivity.this,TestMDSceneTrans2Activity.class);
        startActivity(intent,activityOptionsCompat1.toBundle());
    }
}
