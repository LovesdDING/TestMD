package patient.yilin.com.testmd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import patient.yilin.com.testmd.MDAnimation.TestMDAnimActivity;
import patient.yilin.com.testmd.Testrvjava.TestClientActivity;
import patient.yilin.com.testmd.fab2behavior.TestRec2fabActivity;
import patient.yilin.com.testmd.parallel.TestparellelActivity;
import patient.yilin.com.testmd.propertyAnim_safari.TestSafariAnimActivity;
import patient.yilin.com.testmd.propertyAnimation.TestPropertyAnimaActivity;
import patient.yilin.com.testmd.viewpager_appbarlayout_tablayout.TestTab2Activity;
import patient.yilin.com.testmd.viewpager_appbarlayout_tablayout.TestTabActivity;
import patient.yilin.com.testmd.zdybehavior.TestBehavior1Activity;
import patient.yilin.com.testmd.zdybehavior.TestBehavior2Activity;

/**
 * TestMD   新特性的使用 即源码分析
 *   CoordinatorLayout
 *
 *
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TestRec2fabActivity.class));
            }
        });
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TestparellelActivity.class));
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TestTab2Activity.class));
            }
        });
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TestTabActivity.class));
            }
        });
        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TestBehavior1Activity.class));
            }
        });
        findViewById(R.id.btn5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TestBehavior2Activity.class));
            }
        });
        findViewById(R.id.btn6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TestPropertyAnimaActivity.class));
            }
        });
        findViewById(R.id.btn7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TestMDAnimActivity.class));
            }
        });
        findViewById(R.id.btn8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TestSafariAnimActivity.class));
            }
        });

        findViewById(R.id.btn9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TestClientActivity.class));
            }
        });
    }
}
