package liuyuchen.example.AndroidDemo.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import liuyuchen.example.AndroidDemo.R;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;

    public HorizontalAdapter(Context context, OnItemClickListener listener) {
        this.mContext = context;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new HorizontalViewHolder(LayoutInflater
                .from(mContext)
                .inflate(R.layout.layout_horizontal_recycler_item, parent,false));
    }

    @Override
    public void onBindViewHolder(HorizontalViewHolder holder, int position) {

        holder.textView.setText("Hello!");
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

    class HorizontalViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;


        public HorizontalViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
        }
    }

    public interface OnItemClickListener {
        void onClick(int pos);
    }
}
