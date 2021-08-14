package liuyuchen.example.AndroidDemo.recycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import liuyuchen.example.AndroidDemo.R;

public class WaterFallActivity extends AppCompatActivity {

    private RecyclerView mRvWaterFall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_fall);

        mRvWaterFall = (RecyclerView) findViewById(R.id.rv_wf);
        mRvWaterFall.setLayoutManager(new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL));
        mRvWaterFall.addItemDecoration(new MyDecoration());
        mRvWaterFall.setAdapter(new WaterFallAdapter(WaterFallActivity.this, new WaterFallAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(WaterFallActivity.this, "click: "+pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }


    class MyDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view,
                                   @NonNull RecyclerView parent,
                                   @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int gap = getResources().getDimensionPixelOffset(R.dimen.dividerHeight2);
            outRect.set(gap, gap, gap, gap);
        }
    }
}