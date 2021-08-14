package liuyuchen.example.AndroidDemo.listview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import liuyuchen.example.AndroidDemo.R;

public class MyListAdapter extends BaseAdapter {

    private final Context mContext;
    private final LayoutInflater myLayoutInflater;

    MyListAdapter(Context context) {
        this.mContext = context;
        this.myLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {

        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    static class ViewHolder {
        public ImageView imageView;
        public TextView tvTitle, tvTime, tvContent;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;

        if (view == null) {
            view = myLayoutInflater.inflate(R.layout.layout_list_item, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) view.findViewById(R.id.iv);
            holder.tvTitle = (TextView) view.findViewById(R.id.tv_title);
            holder.tvTime = (TextView) view.findViewById(R.id.tv_time);
            holder.tvContent = (TextView) view.findViewById(R.id.tv_content);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // give value to ViewHolder
        holder.tvTitle.setText("This is Title!");
        holder.tvTime.setText("2021-08-08");
        holder.tvContent.
                setText("This is content, you need read very carefully! If this text exceed max, please tell me.");
        Glide.with(mContext)
                .load("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg")
                .into(holder.imageView);

        return view;
    }
}
