package com.example.teoflev.quom.Quom;

import android.content.Context;

import java.util.Collections;

/**
 * Created by Oppai on 4/23/2017.
 */

public class Showbiz extends Category {

    public Showbiz(Context context) {
        super(context);
        questions = this.GetQuestions("Showbiz.txt");
        Collections.shuffle(questions);
    }


}
