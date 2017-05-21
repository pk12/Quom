package com.example.teoflev.quom.Quom;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teoflev.quom.R;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Created by Oppai on 5/8/2017.
 */

public class Timer extends CountDownTimer {
    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */

    private final TextView time;
    private Context context;
    private Activity activity;
    private TimeAttack mode;


    public Timer(long millisInFuture, long countDownInterval, View time, Context context, Activity activity, TimeAttack mode) {
        super(millisInFuture, countDownInterval);
        this.time = (TextView) time;
        this.context = context;
        this.activity = activity;
        this.mode = mode;


    }

    @Override
    public void onTick(long millisUntilFinished) {
        Long secs = millisUntilFinished/1000;
        time.setText(secs.toString() + 's');
    }

    @Override
    public void onFinish() {


        AlertDialog.Builder mBuilder = new AlertDialog.Builder(activity);

        //gets the inflater from context !INVERTED COLOR FOR SOME REASON
        //LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = activity.getLayoutInflater().inflate(R.layout.enter_name_dialog, null);
        final EditText Name = (EditText) v.findViewById(R.id.enter_name);
        Button save = (Button) v.findViewById(R.id.save_button);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Name.getText().toString().isEmpty()){
                    Toast.makeText(activity,"Please Enter Your Name",Toast.LENGTH_SHORT).show();
                }
                else{
                    Savefile(Name.getText().toString(),mode);
                    Toast.makeText(activity,"Score Saved Succesfully",Toast.LENGTH_SHORT).show();
                }
            }
        });
        mBuilder.setView(v);
        AlertDialog dialog = mBuilder.create();
        dialog.show();

              }



    //passing timer pointer so that the timer wont be lost from the TimeAttack mode
    //not usable just leaving it to remember my mistake
    public void Reset(Timer pointer){
        this.cancel();
        String str = time.getText().toString();
        str = str.substring(0,str.length()-1);
        Long seconds = Long.parseLong(str);
        seconds -= 2;
        pointer = new Timer(seconds*1000,1000,time,context,activity,mode);
        pointer.start();
    }

    public void Savefile(String str,TimeAttack mode){

        File f = new File(context.getApplicationContext().getFilesDir(),"TimeLead.txt");


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
