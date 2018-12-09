package com.example.administrator.riskprojects.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.riskprojects.R;


/**
 * Created by Administrator on 11/27/17.
 */

public class MyAlertDialog extends AppCompatDialog {

    private DialogListener listener;
    private String title;
    private Context context;
    private String content;
    private String ok = "确定";
    private String cancel = "取消";
    private TextView mTvContent;
    private CardView mCvCancel;
    private TextView mTvCancel;
    private CardView mCvOk;
    private TextView mTvOk;


    private MyAlertDialog(Context context, DialogListener listener) {
        super(context, R.style.myDialog);
        this.listener = listener;
        this.context = context;
    }

    public MyAlertDialog(Context context, DialogListener listener, String content) {
        this(context, listener);
        this.content = content;
    }


    public MyAlertDialog(Context context, DialogListener listener, String content
            , String ok, String cancel) {
        this(context, listener, content);
        this.ok = ok;
        this.cancel = cancel;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_alert);
        mTvContent = findViewById(R.id.tv_content);
        mCvCancel = findViewById(R.id.cv_cancel);
        mTvCancel = findViewById(R.id.tv_cancel);
        mCvOk = findViewById(R.id.cv_ok);
        mTvOk = findViewById(R.id.tv_ok);
        mTvContent.setText(content);
        mTvOk.setText(ok);
        mTvCancel.setText(cancel);
        mCvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(v);
            }
        });
        mCvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(v);
            }
        });
    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.cv_cancel://取消
                if (listener != null) {
                    listener.cancel();
                }
                dismiss();
                break;
            case R.id.cv_ok://确认
                if (listener != null) {
                    listener.affirm();
                }
                dismiss();
                break;
        }
    }



    public interface DialogListener {
        void affirm();

        void cancel();
    }
}

