package liuyuchen.example.AndroidDemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import liuyuchen.example.AndroidDemo.gridview.GridViewActivity;
import liuyuchen.example.AndroidDemo.listview.ListViewActivity;
import liuyuchen.example.AndroidDemo.recycleview.RecycleViewActivity;

public class UIActivity extends AppCompatActivity {
    // ch2
    private Button mBtnTextView;
    private Button mBtnButton;
    private Button mBtnEditText;
    private Button mBtnRadioButton;
    private Button mBtnCheckBox;
    private Button mBtnImageView;
    private Button mBtnListView;
    private Button mBtnGridView;
    private Button mBtnRecycleView;
    private Button mBtnWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);

        mBtnTextView = (Button) findViewById(R.id.btn_textview);
        mBtnButton = (Button) findViewById(R.id.btn_button);
        mBtnEditText = (Button) findViewById(R.id.btn_editText);
        mBtnRadioButton = (Button) findViewById(R.id.btn_radioButton);
        mBtnCheckBox = (Button) findViewById(R.id.btn_checkBox);
        mBtnImageView = (Button) findViewById(R.id.btn_imageView);
        mBtnListView = (Button) findViewById(R.id.btn_listview);
        mBtnGridView = (Button) findViewById(R.id.btn_gridview);
        mBtnRecycleView = (Button) findViewById(R.id.btn_recycleview);
        mBtnWebView  = (Button) findViewById(R.id.btn_webview);

        setListeners();
    }

    private void setListeners() {
        OnClick onClick = new OnClick();

        mBtnRadioButton.setOnClickListener(onClick);
        mBtnButton.setOnClickListener(onClick);
        mBtnTextView.setOnClickListener(onClick);
        mBtnEditText.setOnClickListener(onClick);
        mBtnCheckBox.setOnClickListener(onClick);
        mBtnImageView.setOnClickListener(onClick);
        mBtnListView.setOnClickListener(onClick);
        mBtnGridView.setOnClickListener(onClick);
        mBtnRecycleView.setOnClickListener(onClick);
        mBtnWebView.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_button:
                    intent = new Intent(UIActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_textview:
                    intent = new Intent(UIActivity.this, TextViewActivity.class);
                    break;
                case R.id.btn_editText:
                    intent = new Intent(UIActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn_radioButton:
                    intent = new Intent(UIActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.btn_checkBox:
                    intent = new Intent(UIActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.btn_imageView:
                    intent = new Intent(UIActivity.this, ImageViewActivity.class);
                    break;
                case R.id.btn_listview:
                    intent = new Intent(UIActivity.this, ListViewActivity.class);
                    break;
                case R.id.btn_gridview:
                    intent = new Intent(UIActivity.this, GridViewActivity.class);
                    break;
                case R.id.btn_recycleview:
                    intent = new Intent(UIActivity.this, RecycleViewActivity.class);
                    break;
                case R.id.btn_webview:
                    intent = new Intent(UIActivity.this, WebViewActivity.class);
                    break;
                case R.id.btn_toast:
                    intent = new Intent(UIActivity.this, ToastActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}