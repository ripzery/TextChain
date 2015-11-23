package com.ripzery.textchain;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Euro on 11/23/2015 AD.
 */
public class TextChain {
    public final long DEFAULT_DURATION = 3000; /* Init default animation duration = 3000 ms*/
    private List<String> words;
    private TextView tv;
    private OnTextUpdateListener onTextUpdateListener;
    private long duration;
    private AnimatorSet course;

    /* Initialize words to chain*/
    public TextChain(List<String> words, TextView textView) {
        this.words = words;
        tv = textView;
    }

    /* Set text update listener */
    public void setOnTextUpdateListener(OnTextUpdateListener listener) {
        this.onTextUpdateListener = listener;
    }

    /* Set duration of each animation (default : 3000) */
    public void setDuration(long duration){
        this.duration = duration;
    }

    /* Update words */
    public void setWords(List<String> words){
        this.words = words;
    }

    /* Update text view */
    public void setTextView(TextView textView){
        this.tv = textView;
    }

    /* build instance */
    public TextChain build() {
        /* contain animation of all words */
        ArrayList<AnimatorSet> allSets = new ArrayList<>();

        /* provide animation of each word fade in */
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(tv, View.ALPHA, 0, 1);
        fadeIn.setDuration(duration == 0 ? DEFAULT_DURATION : duration);

        /* provide animation of each word fade out */
        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(tv, View.ALPHA, 1, 0);
        fadeOut.setDuration(duration == 0 ? DEFAULT_DURATION : duration);

        /* bind fade in and fade out of each word to play sequentially */
        this.course = new AnimatorSet();
        this.course.playSequentially(fadeIn, fadeOut);
        this.course.addListener(new Animator.AnimatorListener() {
            int index = 0;
            int wordSize = words.size();

            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                if (index + 1 < wordSize) {
                    index++;
                    tv.setText(words.get(index));
                    if (onTextUpdateListener != null)
                        onTextUpdateListener.onNext(index);
                    animator.start();

                } else if (onTextUpdateListener != null) {
                    onTextUpdateListener.onFinish();
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        tv.setText(words.get(0));
        return this;
    }

    /* start animation */
    public void start(){
        course.start();
    }

    /* cancel animation */
    public void cancel(){
        course.cancel();
    }
}
