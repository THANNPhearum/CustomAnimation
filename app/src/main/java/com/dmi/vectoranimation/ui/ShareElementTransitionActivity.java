package com.dmi.vectoranimation.ui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dmi.vectoranimation.R;

/**
 * Created by thannphearum on 9/4/15.
 */
public class ShareElementTransitionActivity extends AppCompatActivity {

    private ImageView mImgTop;
    private LinearLayout mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_element_transition);
        mImgTop = (ImageView) findViewById(R.id.image_small);
        mLayout = (LinearLayout) findViewById(R.id.img_container);
        mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShareElementTransitionActivity.this, ImageActivity.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(ShareElementTransitionActivity.this, mImgTop, "robot");
                startActivity(intent, options.toBundle());
            }
        });

    }
}
