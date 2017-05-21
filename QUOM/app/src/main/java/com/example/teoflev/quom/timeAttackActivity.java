package com.example.teoflev.quom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.teoflev.quom.Quom.Normal;
import com.example.teoflev.quom.Quom.Question;
import com.example.teoflev.quom.Quom.TimeAttack;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class timeAttackActivity extends AppCompatActivity {

    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_time_attack);

        //Code Starts
        //Getting type of category created according to button choice
        String c = getIntent().getExtras().getString("Category");


        //finding views
        final TextView time = (TextView) findViewById(R.id.timeView);
        final Button ans1 = (Button) findViewById(R.id.answer1);
        final Button ans2 = (Button) findViewById(R.id.answer2);
        final Button ans3 = (Button) findViewById(R.id.answer3);
        final Button ans4 = (Button) findViewById(R.id.answer4);

        //creating mode
        final TimeAttack mode = new TimeAttack(c,getApplicationContext(),time,this);
        final ArrayList<Question> questions = mode.getQuestions();


        ChangeQuestion(index,mode);

        //setting listeners cause there's no way with xml connection
        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mode.set_answer((String) ans1.getText());
                mode.check(questions.get(index));
                ChangeQuestion(++index,mode);
            }
        });

        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mode.set_answer((String) ans2.getText());
                mode.check(questions.get(index));
                ChangeQuestion(++index,mode);
            }
        });

        ans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mode.set_answer((String) ans3.getText());
                mode.check(questions.get(index));
                ChangeQuestion(++index,mode);
            }
        });

        ans4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mode.set_answer((String) ans4.getText());
                mode.check(questions.get(index));
                ChangeQuestion(++index,mode);
            }
        });






    }

    public void ChangeQuestion(int index,TimeAttack mode){
        TextView scoreV = (TextView) findViewById(R.id.scoreView);
        TextView questionT = (TextView) findViewById(R.id.questionText);
        final Button ans1 = (Button) findViewById(R.id.answer1);
        final Button ans2 = (Button) findViewById(R.id.answer2);
        final Button ans3 = (Button) findViewById(R.id.answer3);
        final Button ans4 = (Button) findViewById(R.id.answer4);

        Question q = mode.getQuestions().get(index);
        List<String> possible= q.getPossible();


        questionT.setText(q.getQuestion());
        ans1.setText(possible.get(0));
        ans2.setText(possible.get(1));
        ans3.setText(possible.get(2));
        ans4.setText(possible.get(3));
        scoreV.setText(String.valueOf(mode.getScore()));



        possible.clear();

    }




    public void Savefile(String str,Normal mode){

        File f = new File(this.getApplicationContext().getFilesDir(),"TimeLead.txt");


        try {
            FileWriter fw = new FileWriter(f,true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(str + " Scored: " + mode.getScore());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
