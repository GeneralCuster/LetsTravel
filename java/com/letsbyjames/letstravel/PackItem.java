package com.letsbyjames.letstravel;

import android.location.Location;

import java.io.Serializable;

public class PackItem implements Serializable{

    //Initializing values prevents NullPointer exception
    private String name = "";
    private Location coords = new Location("");
    private boolean hasBeenVisited = false;


    public void packItem(String name, Location coords){
        this.name = name;
        this.coords = coords;
        this.hasBeenVisited = false;
    }

    public void packItem(){
        this.name = null;
        this.coords = null;
        this.hasBeenVisited = false;
    }
}
