package com.example.teoflev.quom.Quom;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Oppai on 4/23/2017.
 */

public abstract class Mode {
    protected int bonus;
    protected int multip;
    protected ArrayList<Question> questions;
    protected int i;
    protected int score;
    protected boolean result;
    protected int counter;
    protected Minigame mini_g;
    protected ArrayList<Minigame> minigames;  //9a valoume ta 4 minigame mesa kai 9a ta fortwnoume ka9e fora me rand
    protected String answer; // apantisi tou xristi stin erwtisi
    // to be added if needed

    public Mode() {
        this.bonus = 4;
        counter = 0;
        score = 0;
        multip = 1;
        i=0;
        result = false;
        minigames = new ArrayList<Minigame>();
        //minigames list needs to be filled
        Collections.shuffle(minigames);
    }

    public void set_answer(String answer){
      this.answer = answer;
    }

    public int getScore() {
        return score;
    }

    public void check(){
    	
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
}
