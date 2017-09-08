package patient.yilin.com.testmd;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class TestRec2fabActivity extends AppCompatActivity implements HideScroolistener{

    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private Toolbar toolbar;

    private List<String>  datas = new ArrayList<>();

    private FabRecyAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_rec2fab);

        recyclerView = (RecyclerView) findViewById(R.id.recy1);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        setTitle("中华好担当");
        recyclerView.addOnScrollListener(new FabOnScrollListener(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        for (int i = 0; i < 40; i++) {
            datas.add("item"+i) ;
        }
        adapter = new FabRecyAdapter(datas)  ;
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onHide() {
        //实现 隐藏动画  --属性动画
        toolbar.animate().translationY(-toolbar.getHeight())
                        .setInterpolator(new AccelerateInterpolator(3)) ;

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) fab.getLayoutParams();
        //这里 要通过 RelativeLayoutParams 或者 LinearLayoutParams   如果是VIewGroup的LayoutParams  获取不到bottomMargin
        fab.animate().translationY(fab.getHeight()+params.bottomMargin)  //fab的高度 + fab的外边距
                    .setInterpolator(new AccelerateInterpolator(3)) ;  //开始慢  然后快


    }

    @Override
    public void onShow() {
        //实现显示动画
        toolbar.animate().translationY(0)
                            .setInterpolator(new DecelerateInterpolator(3)) ;

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) fab.getLayoutParams();
        fab.animate().translationY(0).setInterpolator(new DecelerateInterpolator(3)) ;  //开始快 然后慢
    }
}
