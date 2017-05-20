package com.example.teoflev.quom.Quom;

import android.content.Context;

import java.util.Collections;

/**
 * Created by Oppai on 4/23/2017.
 */

public class Science extends Category {


    public Science(Context context) {
        super(context);
        questions = this.GetQuestions("Science.txt");
        Collections.shuffle(questions);
    }



}
