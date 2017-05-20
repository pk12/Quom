package com.example.teoflev.quom.Quom;

import android.content.Context;

import java.util.Collections;

/**
 * Created by Oppai on 4/23/2017.
 */

public class Sports extends Category {

    public Sports(Context context) {
        super(context);
        questions = this.GetQuestions("Sports.txt");
        Collections.shuffle(questions);
    }



}
