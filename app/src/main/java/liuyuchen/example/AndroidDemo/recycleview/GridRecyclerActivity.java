package liuyuchen.example.AndroidDemo.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import liuyuchen.example.AndroidDemo.R;

public class GridRecyclerActivity extends AppCompatActivity {

    private RecyclerView mRvGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler);

        mRvGrid = (RecyclerView) findViewById(R.id.rv_grid);
        // set layout
        mRvGrid.setLayoutManager(new GridLayoutManager(GridRecyclerActivity.this, 3));
        // set adapter
        mRvGrid.setAdapter(new GridAdapter(GridRecyclerActivity.this, new GridAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(GridRecyclerActivity.this, "click: "+pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }


}