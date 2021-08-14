package liuyuchen.example.AndroidDemo.recycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import liuyuchen.example.AndroidDemo.R;

public class HorizontalRecyclerActivity extends AppCompatActivity {

    private RecyclerView mRvHor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_recycler);

        mRvHor = (RecyclerView) findViewById(R.id.rv_hor);
        // set layout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HorizontalRecyclerActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRvHor.setLayoutManager(linearLayoutManager);
        // add divider
        mRvHor.addItemDecoration(new MyDecoration());
        // set adapter
        mRvHor.setAdapter(new HorizontalAdapter(HorizontalRecyclerActivity.this,
                new HorizontalAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(HorizontalRecyclerActivity.this, "out click: "+pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }

    class MyDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0, 0, getResources().getDimensionPixelOffset(R.dimen.dividerHeight), 0);
        }
    }
}