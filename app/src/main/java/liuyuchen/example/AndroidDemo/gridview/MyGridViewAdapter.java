package liuyuchen.example.AndroidDemo.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import liuyuchen.example.AndroidDemo.R;

public class MyGridViewAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater myLayoutInflater;

    MyGridViewAdapter(Context context) {
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
        ImageView imageView;
        TextView tvTitle;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;

        if (view == null) {
            view = myLayoutInflater.inflate(R.layout.layout_grid_item, null);
            holder = new ViewHolder();
            view.setTag(holder);

            holder.imageView = (ImageView) view.findViewById(R.id.iv_grid);
            holder.tvTitle = (TextView) view.findViewById(R.id.tv_title);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // set value
        holder.tvTitle.setText("Flower");
        Glide.with(mContext)
                .load("https://www.ikea.com/jp/en/images/products/smycka-artificial-flower-rose-red__0903311_pe596728_s5.jpg")
                .into(holder.imageView);

        return view;
    }
}
