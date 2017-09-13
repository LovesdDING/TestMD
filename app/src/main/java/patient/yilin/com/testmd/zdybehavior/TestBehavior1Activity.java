package patient.yilin.com.testmd.zdybehavior;

import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import patient.yilin.com.testmd.R;

public class TestBehavior1Activity extends AppCompatActivity {

    private TextView tv1 ,tv2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_behavior1);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewCompat.offsetTopAndBottom(v,3); //点击 偏移
            }
        });

    }
}
