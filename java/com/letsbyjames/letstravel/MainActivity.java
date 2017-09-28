package com.letsbyjames.letstravel;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.Serializable;

@SuppressWarnings("serial")
public class MainActivity extends AppCompatActivity implements Serializable, HelpFuncs {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Changes the name on the activity without changing the name of the app
        setTitle(getResources().getString(R.string.categories));

        //Set colors
        ColorDrawable color = new ColorDrawable(getResources().getColor(R.color.colorStadiums));
        getSupportActionBar().setBackgroundDrawable(color);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorStadiums));
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorStadiumsDark));

        //References for all the relativeLayouts, which when tapped will call packsActivityView and pass a certain intent
        RelativeLayout places = (RelativeLayout) findViewById(R.id.placesLayout);
        RelativeLayout activities = (RelativeLayout) findViewById(R.id.activitiesLayout);
        RelativeLayout stadiums = (RelativeLayout) findViewById(R.id.stadiumsLayout);
        RelativeLayout nParks = (RelativeLayout) findViewById(R.id.nParksLayout);
        RelativeLayout misc = (RelativeLayout) findViewById(R.id.miscLayout);

        //clickListeners
        places.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                launchActivity(PacksActivityView.class, getResources().getString(R.string.places));
            }
        });

        activities.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                launchActivity(PacksActivityView.class, getResources().getString(R.string.activities));
            }
        });

        stadiums.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                launchActivity(PacksActivityView.class, getResources().getString(R.string.stadiums));
            }
        });

        nParks.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                launchActivity(PacksActivityView.class, getResources().getString(R.string.nParks));
            }
        });

        misc.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                launchActivity(PacksActivityView.class, getResources().getString(R.string.misc));
            }
        });

    }

    //method to make it easier to display toasts, mostly for testing
    public void makeToast(String myToast){
        Toast.makeText(this, myToast, Toast.LENGTH_LONG).show();
    }

    //method to make it easier to launch activities.  Just pass the class

    public void launchActivity(Class<?> cls, String category){
        Intent intent = new Intent(this, cls);
        intent.putExtra("category", category);
        startActivity(intent);
    }

    public boolean checkDataBase(String dbName) {
            File dbFile = this.getDatabasePath(dbName);
            return dbFile.exists();
        }
}
