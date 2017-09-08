package patient.yilin.com.testmd;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Administrator on 2017/9/8.
 */

public class FabOnScrollListener extends RecyclerView.OnScrollListener {
    private static final int THRESHOLD = 20 ;  //差值 20  滑动距离 超过20时  才进行相应的操作
    private int distance = 0 ;
    private HideScroolistener hideScroolistener ;
    private boolean visiblew = true ;  //是否可见

    public FabOnScrollListener(HideScroolistener listener) {
            this.hideScroolistener = listener ;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        /**
         * dy ：y轴方向的增量  + , -
         *
         */

        if(distance>THRESHOLD&&visiblew){
                //隐藏动画
            visiblew =false ;
            hideScroolistener.onHide();
            distance = 0  ;

        }else if(distance<-20&&!visiblew){
                //显示动画
            visiblew = true ;
            hideScroolistener.onShow();
            distance = 0 ;


        }

        if((visiblew&&dy>0)||(!visiblew&&dy<0)){
            distance+=dy ;
        }

    }



}
