package patient.yilin.com.testmd.MDzhuanchangAnimation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.view.Window;

import patient.yilin.com.testmd.R;

public class TestMDToolBarActivity extends AppCompatActivity {

    private Toolbar toolbar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS) ;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_mdtool_bar);
        toolbar = (Toolbar) findViewById(R.id.mdtoolbar);
        setSupportActionBar(toolbar);


    }

    @SuppressLint("NewApi")
    public void goNext(View view) {

        Slide slide = new Slide() ;
        slide.setDuration(300) ;  //滑动效果

        Explode explode = new Explode() ;
        explode.setDuration(1000) ;  //展开效果

        Fade fade = new Fade() ;
        fade.setDuration(1000) ; //渐变显示效果

        getWindow().setExitTransition(fade);  //出去的动画
        getWindow().setEnterTransition(fade);  //进入的动画
        //如果有共享元素 就设置
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this) ;

        Intent intent = new Intent(this,TestMDToolBar2Activity.class);
        startActivity(intent,activityOptionsCompat.toBundle());
    }
}
