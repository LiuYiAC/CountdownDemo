package com.liuyi.countdowndemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Func1;

public class Type2Activity extends AppCompatActivity {

    @BindView(R.id.tv_start)
    TextView tvStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type2);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_start)
    public void onClick() {
        Observable.interval(0, 1, TimeUnit.SECONDS)//设置延迟为0，每隔1秒发送一条数据
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<Long, Integer>() {
                    @Override
                    public Integer call(Long increaseTime) {
                        return 60 - increaseTime.intValue();
                    }
                })
                .take(61)//设置循环次数为61次
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        //开始倒计时
                        tvStart.setEnabled(false);
                    }
                })
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        //倒计时完成
                        tvStart.setEnabled(true);
                        tvStart.setText("重新发送");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        //剩余时间
                        tvStart.setText("重新发送" + integer + "s");
                    }
                });

    }
}
