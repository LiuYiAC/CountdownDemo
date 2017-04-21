package com.liuyi.countdowndemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_type1)
    Button btnType1;
    @BindView(R.id.btn_type2)
    Button btnType2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_type1, R.id.btn_type2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_type1:
                startActivity(new Intent(this, Type1Activity.class));
                break;
            case R.id.btn_type2:
                startActivity(new Intent(this, Type2Activity.class));
                break;
        }
    }
}
