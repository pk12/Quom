package com.example.teoflev.quom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeaderBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_leader_board_arcade);

        //code starts

        String filename = (String) this.getIntent().getSerializableExtra("filename");

        //find listview
        ListView l = (ListView) findViewById(R.id.Scores);

        loadFile(filename,l);


    }

    public void loadFile(String str, ListView l){
        File f = new File(getApplicationContext().getFilesDir(),str);
        ArrayList<String> arrayList = new ArrayList<String>();

        try {

            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            //populate listview
            String tmp;
            tmp = br.readLine();
            while(tmp != null){
                arrayList.add(tmp);
                tmp = br.readLine();
            }

            ArrayAdapter<String> model = new ArrayAdapter<String>(this,R.layout.text_view,arrayList);
            l.setAdapter(model);
            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
