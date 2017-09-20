package patient.yilin.com.testmd.svg;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import patient.yilin.com.testmd.R;

public class TestSVGActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_svg);
    }


    public void animStar(View view) {
        ImageView iv = (ImageView) view;
        Drawable drawable = iv.getDrawable() ;
        if(drawable instanceof Animatable){
            ((Animatable) drawable).start();   //drawable  的启动
        }
    }
}
