package patient.yilin.com.testmd.Testrvjava;

import android.util.Log;

import java.util.Observable;

/**
 * Created by Administrator on 2017/9/15.
 */

public class AObserver implements Observer {

    @Override
    public void update(String state) {
        Log.i("AObserver", "update: A 接收到新消息,最新状态"+state);
    }
//    java.util.Observer

//    Observable


}
