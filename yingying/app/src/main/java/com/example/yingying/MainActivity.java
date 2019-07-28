package com.example.yingying;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.yingying.fragment.fragment_gy;
import com.example.yingying.fragment.fragment_sy;
import com.example.yingying.fragment.fragment_wd;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RadioGroup radioGroup;
    private RadioButton button_1;
    private RadioButton button_2;
    private RadioButton button_3;

    private fragment_sy fsy;
    private fragment_gy fgy;
    private fragment_wd fwd;
    private List<Fragment> list;
    private FrameLayout frameLayout;
    private Fragment current_fragment;

    private static boolean isExit = false;
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView() {

        frameLayout = (FrameLayout) findViewById(R.id.framelayout);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        //找到四个按钮
        button_1 = (RadioButton) findViewById(R.id.button_1);
        button_2 = (RadioButton) findViewById(R.id.button_2);
        button_3 = (RadioButton) findViewById(R.id.button_3);

        //创建Fragment对象及集合
        fsy = new fragment_sy();
        fgy = new fragment_gy();
        fwd = new fragment_wd();

        //将Fragment对象添加到list中
        list = new ArrayList<>();
        list.add(fsy);
        list.add(fgy);
        list.add(fwd);

        //设置RadioGroup开始时设置的按钮，设置第一个按钮为默认值
        radioGroup.check(R.id.button_1);


        //设置按钮点击监听
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);


        //初始时向容器中添加第一个Fragment对象
        addFragment(fsy);
        current_fragment = fsy;
    }

    @Override
    public void finish() {
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        viewGroup.removeAllViews();
        super.finish();
    }

    //点击事件处理
    @Override
    public void onClick(View v) {
        //我们根据参数的id区别不同按钮
        //不同按钮对应着不同的Fragment对象页面
        switch (v.getId()) {
            case R.id.button_1:
                addFragment(fsy);
                break;
            case R.id.button_2:
                addFragment(fgy);
                break;
            case R.id.button_3:
                addFragment(fwd);
                break;
            default:
                break;
        }

    }

    //向Activity中添加Fragment的方法
    public void addFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        if (current_fragment == null) {
            fragmentTransaction.add(R.id.framelayout    , fragment).commit();
            current_fragment = fragment;
        }
        if (current_fragment != fragment) {
            // 先判断是否被add过
            if (!fragment.isAdded()) {
                // 隐藏当前的fragment，add下一个到Activity中
                fragmentTransaction.hide(current_fragment)
                        .add(R.id.framelayout, fragment).commit();
            } else {
                // 隐藏当前的fragment，显示下一个
                fragmentTransaction.hide(current_fragment).show(fragment)
                        .commit();
            }
            current_fragment = fragment;
        }


    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
            System.exit(0);
        }
    }
}
