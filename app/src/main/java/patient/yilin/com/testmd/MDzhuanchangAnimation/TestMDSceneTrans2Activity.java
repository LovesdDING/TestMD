package patient.yilin.com.testmd.MDzhuanchangAnimation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import patient.yilin.com.testmd.R;

public class TestMDSceneTrans2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS) ;  //设置允许使用专场动画
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_mdscene_trans2);
    }

    public void back(View view) {
//        startActivity(new Intent(TestMDSceneTrans2Activity.this,TestMDSceneTransActivity.class));
    }

    @Override
    public void onBackPressed() {  //finishAfterTransition  自带转场效果
        super.onBackPressed();
    }
}
