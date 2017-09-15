package patient.yilin.com.testmd.Testrvjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import patient.yilin.com.testmd.R;

public class TestClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_client);


        Observer observer = new AObserver() ;   //--观察者
        MassageSubject subject = new MassageSubject() ;  // --- 行为
        subject.attach(observer);  //--关联 观察者 和被观察者

        subject.change("我在夜店嗨歌");

    }
}
