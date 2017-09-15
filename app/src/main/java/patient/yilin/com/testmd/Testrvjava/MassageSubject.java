package patient.yilin.com.testmd.Testrvjava;

/**
 * 具体的行为
 * Created by Administrator on 2017/9/15.
 */

public class MassageSubject extends Subject {


    public void change(String state){

        notifyObservers(state);
    }

}
