package patient.yilin.com.testmd.viewpager_appbarlayout_tablayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 重用fragment
 * Created by Administrator on 2017/8/28.
 */

public class CommonFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getContext()) ;
        Bundle bundle = getArguments() ;
        String title = bundle.getString("title") ;
        textView.setText(title);
        textView.setBackgroundColor(Color.rgb((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
        return textView;
    }
}
