package patient.yilin.com.testmd.fab2behavior;

import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import patient.yilin.com.testmd.R;

public class TestRec2fabActivity extends AppCompatActivity implements HideScroolistener{

    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private Toolbar toolbar;

    private List<String>  datas = new ArrayList<>();

    private FabRecyAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_rec2fab2);

        recyclerView = (RecyclerView) findViewById(R.id.recy2);
        fab = (FloatingActionButton) findViewById(R.id.fab2);
        toolbar = (Toolbar) findViewById(R.id.toolbar2);

        setSupportActionBar(toolbar);
        setTitle("中华好担当");
//        recyclerView.addOnScrollListener(new FabOnScrollListener(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        for (int i = 0; i < 40; i++) {
            datas.add("item"+i) ;
        }
        adapter = new FabRecyAdapter(datas)  ;
        recyclerView.setAdapter(adapter);

        //  这里设置 fab的点击事件 根布局是使用relativelayout  这些 ，点击的时候  弹出snackbar  但是会覆盖到fab的一部分
        //如果 根布局是使用 的coordinatorlayout   点击弹出snackbar  不会覆盖fab  效果很赞。平滑上移
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(v,"天亮了", BaseTransientBottomBar.LENGTH_SHORT) ;
                snackbar.show();
            }
        });
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
