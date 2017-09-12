package patient.yilin.com.testmd.viewpager_appbarlayout_tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import patient.yilin.com.testmd.R;

public class TestTabActivity extends AppCompatActivity {

    private TabLayout tabLayout ;

    private String[] title = {
            "头条",
            "时事",
            "娱乐",
            "体育",
            "科技",
            "美女",
            "社会",
            "财经",
            "房子",
//            "汽车",
//            "大燕网",

    } ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_tab);


    }


    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }

        @Override
        public Fragment getItem(int position) {
            Fragment f = new CommonFragment() ;
            Bundle bundle = new Bundle() ;
            bundle.putString("title",title[position]);
            f.setArguments(bundle);
            return f;
        }

        @Override
        public int getCount() {
            return title.length;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R);
        return super.onCreateOptionsMenu(menu);
    }
}
