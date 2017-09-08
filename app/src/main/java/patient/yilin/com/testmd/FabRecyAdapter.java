package patient.yilin.com.testmd;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/9/8.
 */

public class FabRecyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> list  ;

    public FabRecyAdapter(List<String> list) {
        this.list = list ;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false) ;

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.tv.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv ;
        public MyViewHolder(View itemView) {

            super(itemView);
            tv  = (TextView) itemView.findViewById(R.id.item_tv);
        }
    }
}
