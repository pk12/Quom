package com.example.teoflev.quom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

//Εργασια Τεχνολογιας Λογισμικου
/* Δεν καταφεραμε να συμπεριλαβουμε το Night Mode λογω προβληματων χρησης σε αλλον υπολογιστη
    Δεν προλαβαμε να συμπεριλαβουμε τα Minigames
  */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

    }

    public void toArcade( View view){
        Intent intent = new Intent(MainActivity.this, arcadeActivity.class);
        startActivity(intent);


    }

    public void toCategorySelection(View view){
        Intent intent = new Intent(MainActivity.this, CategorySelectorActivity.class);
        startActivity(intent);



    }

    public void toLeaderboards(View view){

        Intent intent = new Intent(MainActivity.this, LeaderBoard.class);

        if (view.getId() == R.id.leaderArcade) {
            intent.putExtra("filename","ArcadeLead.txt");
        }
        else {
            intent.putExtra("filename","TimeLead.txt");
        }



        startActivity(intent);


    }


    public void toSettings(View view){
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);

    }
}
