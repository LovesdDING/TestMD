package patient.yilin.com.testmd.MDzhuanchangAnimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;

import patient.yilin.com.testmd.R;

public class TestMDToolBar2Activity extends AppCompatActivity {

    private Toolbar toolbar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS) ;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_mdtool_bar2);

        toolbar = (Toolbar) findViewById(R.id.mdtoolbar);
        setSupportActionBar(toolbar);
    }

    public void backFirst(View view) {
     onBackPressed();
    }
}
