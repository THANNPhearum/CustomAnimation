package com.dmi.vectoranimation.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dmi.vectoranimation.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnAnimationList;
    private Button mBtnActivityTransition;
    private Button mBtnVectorAnimation;
    private Button mBtnShareElement;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mBtnAnimationList = (Button) findViewById(R.id.btn_animation_list);
        mBtnActivityTransition = (Button) findViewById(R.id.btn_activity_transition);
        mBtnVectorAnimation = (Button) findViewById(R.id.btn_vector_animation);
        mBtnShareElement = (Button) findViewById(R.id.btn_share_element_transition);

        mBtnAnimationList.setOnClickListener(this);
        mBtnActivityTransition.setOnClickListener(this);
        mBtnVectorAnimation.setOnClickListener(this);
        mBtnShareElement.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_activity_transition:
                intent = new Intent(this, TransitionActivity.class);
                break;
            case R.id.btn_animation_list:
                intent = new Intent(this, AnimationListActivity.class);
                break;
            case R.id.btn_vector_animation:
                intent = new Intent(this, VectorAnimationActivity.class);
                break;
            case R.id.btn_share_element_transition:
                intent = new Intent(this, ShareElementTransitionActivity.class);
                break;
        }
        startActivity(intent);

    }
}
