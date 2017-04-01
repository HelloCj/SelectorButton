package com.richsoft.selectorbutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.richsoft.selectorlibrary.SelectorButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private SelectorButton mSelectorButtonRed;
    private SelectorButton mSelectorButtonTeal;
    private SelectorButton mSelectorButtonBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSelectorButtonRed = (SelectorButton) findViewById(R.id.btn_red);
        mSelectorButtonTeal = (SelectorButton) findViewById(R.id.btn_teal);
        mSelectorButtonBlue = (SelectorButton) findViewById(R.id.btn_blue);

        //设置mSelectorButtonTeal按钮不可点击
        mSelectorButtonTeal.setEnabled(false);

        mSelectorButtonRed.setOnClickListener(this);
        mSelectorButtonBlue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_red:
                Toast.makeText(this, "点击了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_blue:
                Toast.makeText(this, "点击了", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
