package patient.yilin.com.testmd.Testrvjava;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;



/**
 * 观察 订阅者模式
 *
 * Created by Administrator on 2017/9/15.
 */

public abstract  class Subject {
    private static final String TAG = Subject.class.getSimpleName();
    //保存观察者对象
   private List<Observer> obeservers = new ArrayList<>() ;


    public void attach(Observer observer){
        obeservers.add(observer);
        Log.i(TAG, "addObserver");
    }


    public void dettach(Observer observer){
        obeservers.remove(observer) ;
        Log.i(TAG, "dettach");
    }

    /**
     * 通知所有观察者 状态的变化
     */
    public void notifyObservers(String state){
        for (Observer obs : obeservers) {
            obs.update(state);
        }
    }

}
