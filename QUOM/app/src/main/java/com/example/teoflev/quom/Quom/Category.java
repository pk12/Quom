package com.example.teoflev.quom.Quom;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Oppai on 4/23/2017.
 */

public abstract class Category implements Serializable {
    protected ArrayList<Question> questions;
    protected Context myContext;

    public Category(Context myContext) {
        this.myContext = myContext;
    }

    public ArrayList<Question> GetQuestions(String filename) {       // mporei na ginei void afou idi bazei tis erwtiseis
        String Line, answer, question;                               // sto ArrayList questions stin grammi 42, ara den xreiazetai
        String[] split;                                              // na to epistrefei kiolas (pleonasmos, blepe ti kaname stis klaseis-katigories)
        ArrayList<String> possible = new ArrayList<String>();        // to problima meta einai oti stin ousia katargoume tis 4 klaseis katigories kratame
        ArrayList<Question> questions = new ArrayList<Question>();   // tin unified mono kai apla dimiourgoume 4 objects typou category 1 gia ka8e katigoria
        int i;


            //File f = new File(filename);
            try {
                InputStreamReader ir = new InputStreamReader(myContext.getAssets().open(filename));
                BufferedReader br = new BufferedReader(ir);

                Line = br.readLine();
                while (Line != null) {
                    split = Line.split(";");
                    question = split[0] + ";";
                    answer = split[1];
                    split = answer.split(",");
                    answer = split[0];
                    for (i = 1; i < split.length; i++) {
                        possible.add(split[i]);
                    }

                    Question q = new Question(question, answer, possible);
                    questions.add(q);

                    Line = br.readLine();
                    possible.clear();
                }


            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return questions;

    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
}
