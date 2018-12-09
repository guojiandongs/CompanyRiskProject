package com.example.administrator.riskprojects.util;

import android.os.CountDownTimer;
import android.widget.TextView;

import com.example.administrator.riskprojects.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Administrator on 6/29/17.
 */

public class TimeCount extends CountDownTimer {


    private TextView textView;
    public long remainingTime = 0L;
    private OnTimeFinishListener listener;


    public TimeCount(long millisInFuture, long countDownInterval, TextView textView) {
        super(millisInFuture, countDownInterval);//参数依次为总时长,和计时的时间间隔
        this.textView = textView;
        textView.setSelected(true);
    }

    @Override
    public void onFinish() {//计时完毕时触发
        if (null != listener) {
            textView.setSelected(false);
            textView.setText(R.string.inspection_backspace);
            listener.onTimeFinish();
        }
    }

    @Override
    public void onTick(long millisUntilFinished) {//计时过程显示
        if (null != textView) {
            remainingTime = millisUntilFinished;
            textView.setText((new SimpleDateFormat("ss", Locale.CHINA).format(new Date(millisUntilFinished)))+"s");
        }
    }

    public void setListener(OnTimeFinishListener listener) {
        this.listener = listener;
    }

    public interface OnTimeFinishListener {

        void onTimeFinish();
    }
}