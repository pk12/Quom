package com.example.teoflev.quom.Quom;

import android.content.Context;

import java.util.Collections;

/**
 * Created by Oppai on 4/23/2017.
 */

public class Normal extends Mode {
    private int lives;


    public Normal(Context context) {
        super();
        lives = 3;
        questions = new Unified(context).getQuestions();

    }

    public void check(Question q){
        if (!q.is_correct(answer)) {
            lives = lives - 1;      //time lost on wrong answer?
        }
        else{
            score += bonus*multip;
        }
        counter++;
        if (counter%10 == 0){
          mini_g = minigames.get(i);
          i++;                                              //after a minigame is played, next should load
          result = mini_g.start();                           //mini game procs here
          if (i==3){
            Collections.shuffle(minigames);                  //if all minigames played, reshuffle and take list from begining
            i=0;
          }
          if (result)
            multip = 2;
          else
            multip=1;
        }
        else
          multip = 1;
      }


    public int getLives() {
        return lives;
    }
}
