package com.letsbyjames.letstravel;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.Toast;

import java.io.File;

public class PacksActivityView extends AppCompatActivity implements HelpFuncs {

    //Creating references as instance variables
    ImageView pinPic;
    View relLayout;
    FloatingActionButton addButton;
    String name;
    String newPackName;
    AlertDialog.Builder builder;
    DBHelper packsDB;
    TableLayout myPacks;
    TableLayout PurchasedPacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_packs_view);

        pinPic = (ImageView) findViewById(R.id.pinPic);
        relLayout = findViewById(R.id.relLayout);
        name = getName();
        addButton = (FloatingActionButton) findViewById(R.id.addButton);

        //Set up the view as soon as it loads
        setView();
    }

    public void setView(){
        //If the database hasn't been created yet, make it.
        if(!checkDataBase("packs.db")){
            //create it
            packsDB = new DBHelper(this);
        }else{
            //load it


        }

        //Add listener for the floating action button
        addButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                createDialog();
                builder.show();
                addButton.setVisibility(View.GONE);
                if(newPackName != null) {
                    //The user entered a name for a new pack, add it to the database, which should already be loaded.
                    Pack newPack = new Pack(getName());
                }
            }
        });

        setTitle(getName());
        getSupportActionBar().setElevation(0);

        //Set colors for Relative Layout, set picture, and status bar/nav bar colors
        if(name.equals(getResources().getString(R.string.places))){
            //Pictures and Colors
            ColorDrawable color = new ColorDrawable(getResources().getColor(R.color.colorPlacesDark));
            getSupportActionBar().setBackgroundDrawable(color);
            pinPic.setImageResource(R.drawable.places_half);
            relLayout.setBackgroundColor(getResources().getColor(R.color.colorPlaces));
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPlaces));
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPlacesDarkest));
            addButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPlacesDark)));

        }else if(name.equals(getResources().getString(R.string.activities))){
            ColorDrawable color = new ColorDrawable(getResources().getColor(R.color.colorActivitiesDark));
            getSupportActionBar().setBackgroundDrawable(color);
            pinPic.setImageResource(R.drawable.activities_half);
            relLayout.setBackgroundColor(getResources().getColor(R.color.colorActivities));
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorActivities));
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorActivitiesDarkest));
            addButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorActivitiesDark)));

        }else if(name.equals(getResources().getString(R.string.stadiums))){
            ColorDrawable color = new ColorDrawable(getResources().getColor(R.color.colorStadiumsDark));
            getSupportActionBar().setBackgroundDrawable(color);
            pinPic.setImageResource(R.drawable.stadiums_half);
            relLayout.setBackgroundColor(getResources().getColor(R.color.colorStadiums));
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorStadiums));
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorStadiumsDarkest));
            addButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorStadiumsDark)));

        }else if(name.equals(getResources().getString(R.string.nParks))){
            ColorDrawable color = new ColorDrawable(getResources().getColor(R.color.colorNParksDark));
            getSupportActionBar().setBackgroundDrawable(color);
            pinPic.setImageResource(R.drawable.national_parks_half);
            relLayout.setBackgroundColor(getResources().getColor(R.color.colorNParks));
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorNParks));
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorNParksDarkest));
            addButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorNParksDark)));

        }else if(name.equals(getResources().getString(R.string.misc))){
            ColorDrawable color = new ColorDrawable(getResources().getColor(R.color.colorMiscDark));
            getSupportActionBar().setBackgroundDrawable(color);
            pinPic.setImageResource(R.drawable.misc_half);
            relLayout.setBackgroundColor(getResources().getColor(R.color.colorMisc));
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorMisc));
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorMiscDarkest));
            addButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorMiscDark)));

        }

    }

    public void createDialog(){
        //Setting up the alertDialog for adding a pack
        builder = new AlertDialog.Builder(this);
        builder.setTitle("New Pack");
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int imHereCauseINeedToBe) {
                newPackName = input.getText().toString();
                makeToast(newPackName);
                addButton.setVisibility(View.VISIBLE);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int imHereCauseINeedToBe) {
                dialog.cancel();
                addButton.setVisibility(View.VISIBLE);
            }
        });
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                addButton.setVisibility(View.VISIBLE);
            }
        });
    }

    public void makeToast(String myToast){
        Toast.makeText(this, myToast, Toast.LENGTH_LONG).show();
    }

    //method to make it easier to launch activities.  Just pass the class

    public void launchActivity(Class<?> cls, String category){
        Intent intent = new Intent(this, cls);
        intent.putExtra("category", category);
        startActivity(intent);
    }

    public String getName(){
        return getIntent().getSerializableExtra("category").toString();
    }

    public boolean checkDataBase(String dbName) {
        File dbFile = this.getDatabasePath(dbName);
        return dbFile.exists();
    }

}


