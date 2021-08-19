package liuyuchen.example.AndroidDemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import liuyuchen.example.AndroidDemo.util.ToastUtil;

public class DialogActivity extends AppCompatActivity {

    private Button mBtnDialog1, mBtnDialog2, mBtnDialog3, mBtnDialog4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        // find button
        mBtnDialog1 = (Button) findViewById(R.id.btn_dialog1);
        mBtnDialog2 = (Button) findViewById(R.id.btn_dialog2);
        mBtnDialog3 = (Button) findViewById(R.id.btn_dialog3);
        mBtnDialog4 = (Button) findViewById(R.id.btn_dialog4);

        OnClick onClick = new OnClick();

        mBtnDialog1.setOnClickListener(onClick);
        mBtnDialog2.setOnClickListener(onClick);
        mBtnDialog3.setOnClickListener(onClick);
        mBtnDialog4.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_dialog1:
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(DialogActivity.this);
                    builder1.setTitle("Please Answer: ").setMessage("How are you?")
                            .setIcon(R.drawable.download)
                            .setPositiveButton("Great", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    ToastUtil.showMsg(DialogActivity.this, "Great Back!");
                                }
                            }).setNeutralButton("Fine", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    ToastUtil.showMsg(DialogActivity.this, "Fine Back!");
                                }
                            }).setNegativeButton("Bad", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    ToastUtil.showMsg(DialogActivity.this, "Bad Back!");
                                }
                            }).show();
                    break;
                case R.id.btn_dialog2:
                    final String[] array = new String[] {"Male", "Female"};
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(DialogActivity.this);
                    builder2.setTitle("Choose Sexual").setItems(array, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(DialogActivity.this, array[i]);
                        }
                    }).show();
                    break;
                case R.id.btn_dialog3:
                    final String[] array2 = new String[] {"Male", "Female"};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(DialogActivity.this);
                    builder3.setTitle("Choose Sexual").setSingleChoiceItems(array2, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(DialogActivity.this, "You are " + array2[i]);
                            dialogInterface.dismiss();
                        }
                    }).setCancelable(false).show();
                    break;
                case R.id.btn_dialog4:
                    final String[] array4 = new String[] {"Sing", "Write", "Dance"};
                    boolean[] isSelected = new boolean[] {false, false, true};
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(DialogActivity.this);
                    builder4.setTitle("Choose Hobby").setMultiChoiceItems(array4, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                            ToastUtil.showMsg(DialogActivity.this, array4[i]+":"+isSelected[i]);
                        }
                    }).setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    }).show();
                    break;
            }
        }
    }
}