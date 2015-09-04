package com.dmi.vectoranimation.ui;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.dmi.vectoranimation.R;

/**
 * Created by thannphearum on 9/2/15.
 */
public class AnimationListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getString(R.string.animation_list));
        setContentView(R.layout.activity_animation_drawable);

        ImageView mImageViewFilling = (ImageView) findViewById(R.id.imageview_animation_list_filling);
        ((AnimationDrawable) mImageViewFilling.getBackground()).start();

        ImageView mImageViewEmptying = (ImageView) findViewById(R.id.imageview_animation_list_emptying);
        ((AnimationDrawable) mImageViewEmptying.getBackground()).start();
        final ImageView mImageViewSelector = (ImageView) findViewById(R.id.imageview_animated_selector);
        mImageViewSelector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImageViewSelector.setActivated(!mImageViewSelector.isActivated());
            }
        });
    }
}
