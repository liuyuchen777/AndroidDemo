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

public class LinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;

    public LinearAdapter(Context context, OnItemClickListener listener) {
        this.mContext = context;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new LinearViewHolder(LayoutInflater
                    .from(mContext)
                    .inflate(R.layout.layout_linear_recycler_item1, parent,false));
        } else {
            return new LinearViewHolder2(LayoutInflater
                    .from(mContext)
                    .inflate(R.layout.layout_linear_recycler_item2, parent,false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == 0) {
            ((LinearViewHolder)holder).textView.setText("This is Linear Recycler View!");
        } else {
            ((LinearViewHolder2)holder).tv.setText("This is Linear Recycler View 2!");
        }
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
    public int getItemCount() {

        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;


        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
        }
    }

    class LinearViewHolder2 extends RecyclerView.ViewHolder {

        private TextView tv;
        private ImageView iv;

        public LinearViewHolder2(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_title);
            iv = itemView.findViewById(R.id.iv_title);
        }
    }

    public interface OnItemClickListener {
        void onClick(int pos);
    }
}
