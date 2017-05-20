package com.example.teoflev.quom.Quom;

import android.content.Context;

import java.util.Collections;

/**
 * Created by Oppai on 4/23/2017.
 */

public class Greece extends Category {


    public Greece(Context context) {
        super(context);
        questions = this.GetQuestions("Greece.txt");
        Collections.shuffle(questions);
    }


}
