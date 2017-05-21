package com.example.teoflev.quom;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teoflev.quom.Quom.Normal;
import com.example.teoflev.quom.Quom.Question;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class arcadeActivity extends AppCompatActivity {
    //code starts by setting the correct info on the screen

    //IMPORTANT THE QUESTIONS ARE SHOWN MULTIPLE TIMES BECAUSE I LOAD THE SAME FILE FOR ALL 4 CATEGORIES
    //TO FIX JUST CHANGE THE GetQuestions FILENAME
    private int index = 0; // otan ginei iso me to mege9os tou pinaka tote nikaei to game


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_arcade);


        //code starts
        final Normal mode = new Normal(this.getApplicationContext());
        final ArrayList<Question> questions = mode.getQuestions();
        TextView scoreV = (TextView) findViewById(R.id.scoreView);
        TextView questionT = (TextView) findViewById(R.id.questionText);
        final Button ans1 = (Button) findViewById(R.id.answer1);
        final Button ans2 = (Button) findViewById(R.id.answer2);
        final Button ans3 = (Button) findViewById(R.id.answer3);
        final Button ans4 = (Button) findViewById(R.id.answer4);
        ImageView hear1 = (ImageView) findViewById(R.id.heart1);
        ImageView hear2 = (ImageView) findViewById(R.id.heart2);
        ImageView hear3 = (ImageView) findViewById(R.id.heart3);

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




    public void ChangeQuestion(int index,Normal mode){
        TextView scoreV = (TextView) findViewById(R.id.scoreView);
        TextView questionT = (TextView) findViewById(R.id.questionText);
        final Button ans1 = (Button) findViewById(R.id.answer1);
        final Button ans2 = (Button) findViewById(R.id.answer2);
        final Button ans3 = (Button) findViewById(R.id.answer3);
        final Button ans4 = (Button) findViewById(R.id.answer4);
        ImageView hear1 = (ImageView) findViewById(R.id.heart1);
        ImageView hear2 = (ImageView) findViewById(R.id.heart2);
        ImageView hear3 = (ImageView) findViewById(R.id.heart3);

        Question q = mode.getQuestions().get(index);
        List<String> possible= q.getPossible();

        questionT.setText(q.getQuestion());
        ans1.setText(possible.get(0));
        ans2.setText(possible.get(1));
        ans3.setText(possible.get(2));
        ans4.setText(possible.get(3));
        scoreV.setText(String.valueOf(mode.getScore()));

        //checks if game completed
        gameCheck(mode.getQuestions(),index,mode);

        if (mode.getLives() == 0){
            hear1.setVisibility(View.INVISIBLE);
        }
        else if (mode.getLives() == 2){
            hear2.setVisibility(View.INVISIBLE);
        }
        else if (mode.getLives() == 1){
            hear3.setVisibility(View.INVISIBLE);
        }

        possible.clear();

    }

    public void gameCheck(ArrayList<Question> questions, int index, final Normal mode){
        if (index == questions.size() || mode.getLives() == 0){
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
            View v = getLayoutInflater().inflate(R.layout.enter_name_dialog, null);
            final EditText Name = (EditText) v.findViewById(R.id.enter_name);
            Button save = (Button) v.findViewById(R.id.save_button);

            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Name.getText().toString().isEmpty()){
                        Toast.makeText(arcadeActivity.this,"Please Enter Your Name",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Savefile(Name.getText().toString(),mode);
                        Toast.makeText(arcadeActivity.this,"Score Saved Succesfully",Toast.LENGTH_SHORT).show();
                    }
                }
            });
            mBuilder.setView(v);
            AlertDialog dialog = mBuilder.create();
            dialog.show();

        }
    }

    public void Savefile(String str,Normal mode){

        File f = new File(this.getApplicationContext().getFilesDir(),"ArcadeLead.txt");


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



