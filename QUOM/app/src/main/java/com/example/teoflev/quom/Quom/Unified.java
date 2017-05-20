package com.example.teoflev.quom.Quom;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Oppai on 4/23/2017.
 */

public class Unified extends Category {

    private ArrayList<Question> q;

    public Unified(Context context) {
        super(context);
        q = new ArrayList<Question>();           // to GetQuestions ka8e katigorias gemizei to questions pou gemize kai i Unified opote eixame 8ema me overwrite
        q.addAll(new Sports(context).getQuestions());   // twra kanei overwrite i ka8e katigoria tin alli mono afou exei graftei sto q (3exwristo ArrayList) opote kanena 8ema
        q.addAll(new Science(context).getQuestions());
        q.addAll(new Greece(context).getQuestions());
        q.addAll(new Showbiz(context).getQuestions());
        Collections.shuffle(q);
    }

    public ArrayList<Question> getQuestions() {
        return q;                               // overwrite tis getQuestions tou Category gia na gyrnaei to pointer tou q kai oxi tou questions


    }
}
