package com.liuyi.countdowndemo;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Type1Activity extends AppCompatActivity {

    @BindView(R.id.tv_start)
    TextView tvStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type1);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_start)
    public void onClick() {
        tvStart.setEnabled(false);
        new CountDownTimer(60000, 1000){
            @Override
            public void onTick(long millisUntilFinished) {
                tvStart.setText("重新发送" + millisUntilFinished / 1000 + "s");
            }

            @Override
            public void onFinish() {
                tvStart.setText("发送验证码");
                tvStart.setEnabled(true);
            }
        }.start();
    }
}
