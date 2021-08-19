package liuyuchen.example.AndroidDemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import liuyuchen.example.AndroidDemo.util.ToastUtil;

public class ToastActivity extends AppCompatActivity {

    private Button mBtnToast1, mBtnToast2, mBtnToast3, mBtnToast4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        mBtnToast1 = (Button) findViewById(R.id.btn_toast_1);
        mBtnToast2 = (Button) findViewById(R.id.btn_toast_2);
        mBtnToast3 = (Button) findViewById(R.id.btn_toast_3);
        mBtnToast4 = (Button) findViewById(R.id.btn_toast_4);

        OnClick onClick = new OnClick();

        mBtnToast1.setOnClickListener(onClick);
        mBtnToast2.setOnClickListener(onClick);
        mBtnToast3.setOnClickListener(onClick);
        mBtnToast4.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_toast_1:
                    Toast.makeText(getApplicationContext(), "Toast", Toast.LENGTH_LONG).show();
                    break;
                case R.id.btn_toast_2:
                    // Warning: starting on Android 11 (R, API 30),
                    // you have no non-legacy way to display a centered toast on Android 11/above
                    Toast toastCenter = Toast.makeText(getApplicationContext(),
                            "Center Toast", Toast.LENGTH_LONG);
                    toastCenter.setGravity(Gravity.CENTER, 0, 0);
                    toastCenter.show();
                    // toastCenter.cancel();
                    break;
                case R.id.btn_toast_3:
                    Toast toastCustomerize = new Toast(getApplicationContext());
                    LayoutInflater inflater = LayoutInflater.from(ToastActivity.this);
                    View v = inflater.inflate(R.layout.layout_toast, null);
                    TextView tv = (TextView) v.findViewById(R.id.tv_toast);
                    ImageView iv = (ImageView) v.findViewById(R.id.iv_toast);
                    tv.setText("Toast");
                    iv.setImageResource(R.drawable.download);
                    toastCustomerize.setView(v);
                    toastCustomerize.show();
                    break;
                case R.id.btn_toast_4:
                    ToastUtil.showMsg(getApplicationContext(), "wrapped toast");
                    break;
            }
        }
    }
}