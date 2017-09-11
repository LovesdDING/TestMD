package patient.yilin.com.testmd.parallel;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import patient.yilin.com.testmd.R;

public class TestparellelActivity extends AppCompatActivity {

    private ViewPager vp ;
    private int[] layouts = {R.layout.welcome11,R.layout.welcome2,R.layout.welcome3} ;

    private WelCompagerTransformer transformer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testparellel);

        vp = (ViewPager) findViewById(R.id.vp);

        WelcomePagerAdapter adapter = new WelcomePagerAdapter(getSupportFragmentManager()) ;
        System.out.println("offset:"+vp.getOffscreenPageLimit());
        vp.setOffscreenPageLimit(3);
        vp.setAdapter(adapter);

        transformer = new WelCompagerTransformer() ;
        vp.setPageTransformer(true,transformer);
        vp.setOnPageChangeListener(transformer);
    }

    //viewPager  适配器
    class WelcomePagerAdapter extends FragmentPagerAdapter{

        public WelcomePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment f = new TranslateFragment() ; //创建一个Fragment对象 每次更换fragment 的layout布局
            Bundle bundle = new Bundle() ;
            bundle.putInt("layoutId", layouts[position]);
            bundle.putInt("pageIndex", position);
            f.setArguments(bundle);
            return f;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
