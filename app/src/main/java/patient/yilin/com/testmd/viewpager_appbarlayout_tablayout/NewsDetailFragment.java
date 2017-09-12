package patient.yilin.com.testmd.viewpager_appbarlayout_tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import patient.yilin.com.testmd.R;

/**
 * Created by Administrator on 2017/9/12.
 */

public class NewsDetailFragment extends Fragment {
    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//		TextView tv = new TextView(getContext());
//		Bundle bundle = getArguments();
//		String title = bundle.getString("title");
//		tv.setBackgroundColor(Color.rgb((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
//		tv.setText(title);
//		return tv;
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        return view;
    }
}
