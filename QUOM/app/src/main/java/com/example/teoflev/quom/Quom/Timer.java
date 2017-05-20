package com.example.teoflev.quom.Quom;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Oppai on 5/8/2017.
 */

public class Timer extends CountDownTimer {
    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */

    private final TextView time;


    public Timer(long millisInFuture, long countDownInterval, View time) {
        super(millisInFuture, countDownInterval);
        this.time = (TextView) time;

    }

    @Override
    public void onTick(long millisUntilFinished) {
        Long secs = millisUntilFinished/1000;
        time.setText(secs.toString() + 's');
    }

    @Override
    public void onFinish() {

    }

    //passing timer pointer so that the timer wont be lost from the TimeAttack mode
    //not usable just leaving it to remember my mistake
    public void Reset(Timer pointer){
        this.cancel();
        String str = time.getText().toString();
        str = str.substring(0,str.length()-1);
        Long seconds = Long.parseLong(str);
        seconds -= 2;
        pointer = new Timer(seconds*1000,1000,time);
        pointer.start();
    }


}
