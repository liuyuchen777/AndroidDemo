package liuyuchen.example.AndroidDemo.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import liuyuchen.example.AndroidDemo.R;

public class RecycleViewActivity extends AppCompatActivity {

    private Button mButtonLinear;
    private Button mButtonHorizontal;
    private Button mButtonGrid;
    private Button mBtnWaterFall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        mButtonLinear = (Button) findViewById(R.id.btn_linear);
        mButtonLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecycleViewActivity.this, LinearRecycleViewActivity.class);
                startActivity(intent);
            }
        });

        mButtonHorizontal = (Button) findViewById(R.id.btn_horizontal);
        mButtonHorizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecycleViewActivity.this, HorizontalRecyclerActivity.class);
                startActivity(intent);
            }
        });

        mButtonGrid = (Button) findViewById(R.id.btn_grid);
        mButtonGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecycleViewActivity.this, GridRecyclerActivity.class);
                startActivity(intent);
            }
        });

        mBtnWaterFall = (Button) findViewById(R.id.btn_waterfall);
        mBtnWaterFall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecycleViewActivity.this, WaterFallActivity.class);
                startActivity(intent);
            }
        });
    }
}