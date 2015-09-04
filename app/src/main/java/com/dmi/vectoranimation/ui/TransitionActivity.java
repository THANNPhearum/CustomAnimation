package com.dmi.vectoranimation.ui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.AutoTransition;
import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import com.dmi.vectoranimation.R;
import com.dmi.vectoranimation.adapter.TransitionAdapter;

import java.util.ArrayList;
import java.util.List;

public class TransitionActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private TransitionAdapter mTransitionAdapter;
    private List<TransitionAdapter.TransitionItem> mItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        setTitle(getString(R.string.activity_transition));
        mItems = new ArrayList<>();
        initList();
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_transition);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mTransitionAdapter = new TransitionAdapter();
        mTransitionAdapter.addItems(mItems);
        mRecyclerView.setAdapter(mTransitionAdapter);
        mTransitionAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(TransitionActivity.this, " Click " + position, Toast.LENGTH_LONG).show();
                switch (position) {
                    case 0:
                        getWindow().setExitTransition(new AutoTransition());
                        break;
                    case 1:
                        getWindow().setExitTransition(new ChangeBounds());
                        break;
                    case 2:
                        getWindow().setExitTransition(new Explode());
                        break;
                    case 3:
                        getWindow().setExitTransition(new Fade());
                        break;
                    case 4:
                        getWindow().setExitTransition(new Slide());
                        break;
                }
                startActivityAnimation();

            }
        });
    }

    private void initList() {
        mItems.add(new TransitionAdapter.TransitionItem(getString(R.string.transition_auto)));
        mItems.add(new TransitionAdapter.TransitionItem(getString(R.string.transition_change_bounds)));
        mItems.add(new TransitionAdapter.TransitionItem(getString(R.string.transition_explode)));
        mItems.add(new TransitionAdapter.TransitionItem(getString(R.string.transition_fade)));
        mItems.add(new TransitionAdapter.TransitionItem(getString(R.string.transition_slide)));
    }

    public void startActivityAnimation() {
        Intent intent = new Intent(this, AnimationListActivity.class);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

}
