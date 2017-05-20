package com.example.teoflev.quom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class CategorySelectorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_category_selector);

    }

    void toTimeAttack( View view){

        //Finds out which button is pressed and creates the proper category
        if (view.getId() == R.id.scienceCategory){
            Intent myIntent = new Intent(CategorySelectorActivity.this, timeAttackActivity.class);
            myIntent.putExtra("Category","Science");
            startActivity(myIntent);
        }
        else if (view.getId() == R.id.showbizCategory){
            Intent myIntent = new Intent(CategorySelectorActivity.this, timeAttackActivity.class);
            myIntent.putExtra("Category","Showbiz");
            startActivity(myIntent);
        }
        else if (view.getId() == R.id.greeceCategory){
            Intent myIntent = new Intent(CategorySelectorActivity.this, timeAttackActivity.class);
            myIntent.putExtra("Category","Greece");
            startActivity(myIntent);
        }
        else {
            Intent myIntent = new Intent(CategorySelectorActivity.this, timeAttackActivity.class);
            myIntent.putExtra("Category","Sports");
            startActivity(myIntent);
        }


    }

}
