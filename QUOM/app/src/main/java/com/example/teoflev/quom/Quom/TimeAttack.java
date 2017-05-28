package com.example.teoflev.quom.Quom;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

/**
 * Created by Oppai on 4/23/2017.
 */

public class TimeAttack extends Mode {

    private Timer timer;
    private TextView time;
    private Context context;
    private Activity activity;

                                                        // to use for the timer
    public TimeAttack(String category, Context context, TextView time, Activity activity) {
        super();
        if (category.equals("Sports"))
            this.questions = new Sports(context).getQuestions();
        else if (category.equals("Greece"))
            this.questions = new Greece(context).getQuestions();
        else if (category.equals("Showbiz"))
            this.questions = new Showbiz(context).getQuestions();
        else
            this.questions = new Science(context).getQuestions();

        this.time = time;
        this.activity = activity;
        this.context = context;
        timer = (Timer) new Timer(120000,1000,time, context,activity,this).start();
    }

    public void check(Question q) {

        if (!q.is_correct(answer)) {
//            timer.Reset(timer);
            //start new timer
            timerReset();

        }
         else {
            score += bonus * multip;
        }
        counter++;
//        if (counter % 10 == 0) {
//            mini_g = minigames.get(i); //shows error outofbounds after index i=10 because there's no minigames yet
//            i++;                                              // after a minigame is played, next should load
//            result = mini_g.start();                           // mini game procs here
//            if (i == 3) {
//                Collections.shuffle(minigames);                 //if all minigames played, reshuffle and take list from begining
//                i = 0;
//            }
//            if (result)
//                multip = 2;
//            else
//                multip = 1;
//        } else
//            multip = 1;
    }

    public void timerReset(){
        timer.cancel();
        String str = time.getText().toString();
        str = str.substring(0,str.length()-1);
        Long seconds = Long.parseLong(str);
        seconds -= 1; //to look like 2 seconds in the app
        timer = new Timer(seconds * 1000,1000,time,context,activity,this); //if i use the reset function the old one does not stop for some reason if it is cancelled in the class
        timer.start();
    }
}



