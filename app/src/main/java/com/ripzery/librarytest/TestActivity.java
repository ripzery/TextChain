package com.ripzery.librarytest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ripzery.textchain.OnTextUpdateListener;
import com.ripzery.textchain.TextChain;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TestActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.color1)
    View color1;
    @Bind(R.id.color2)
    View color2;
    @Bind(R.id.tvHello)
    TextView tvHello;
    @Bind(R.id.rootView)
    FrameLayout rootView;
    @Bind(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ArrayList<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("Phuchit");
        words.add("Sirimongkolsathien");

        TextChain textChain = new TextChain(words, tvHello);
        textChain.setDuration(2000);
        textChain.setOnTextUpdateListener(new OnTextUpdateListener() {
            @Override
            public void onNext(int index) {
                Log.d("NextWord", "onNext: " + words.get(index));
            }

            @Override
            public void onFinish() {
                Log.d("Finish", "onFinish ");
            }
        });
        textChain.build().start();
    }

}
