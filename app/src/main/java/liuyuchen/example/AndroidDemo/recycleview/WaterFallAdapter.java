package liuyuchen.example.AndroidDemo.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import liuyuchen.example.AndroidDemo.R;

public class WaterFallAdapter extends RecyclerView.Adapter<WaterFallAdapter.WaterFallViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;

    public WaterFallAdapter(Context context, OnItemClickListener listener) {
        this.mContext = context;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public WaterFallViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new WaterFallViewHolder(LayoutInflater
                .from(mContext)
                .inflate(R.layout.layout_waterfall_recycler_item, parent,false));
    }

    @Override
    public void onBindViewHolder(WaterFallViewHolder holder, int position) {
        if (position % 2 == 0)
            holder.iv.setImageResource(R.drawable.img1);
        else
            holder.iv.setImageResource(R.drawable.img2);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(mContext, "click: "+holder.getBindingAdapterPosition(),
                //      Toast.LENGTH_SHORT).show();
                mListener.onClick(holder.getBindingAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() { return 30; }

    class WaterFallViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv;


        public WaterFallViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.rv_wf_iv);
        }
    }

    public interface OnItemClickListener {
        void onClick(int pos);
    }
}
