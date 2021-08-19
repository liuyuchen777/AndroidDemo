package liuyuchen.example.AndroidDemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PropActivity extends AppCompatActivity {

    // ch3
    private Button mBtnToast;
    private Button mBtnDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prop);

        mBtnToast = (Button) findViewById(R.id.btn_toast);
        mBtnDialog = (Button) findViewById(R.id.btn_dialog);

        setListeners();
    }

    private void setListeners() {
        PropActivity.OnClick onClick = new PropActivity.OnClick();

        mBtnToast.setOnClickListener(onClick);
        mBtnDialog.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_toast:
                    intent = new Intent(PropActivity.this, ToastActivity.class);
                    break;
                case R.id.btn_dialog:
                    intent = new Intent(PropActivity.this, DialogActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}