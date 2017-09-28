package com.letsbyjames.letstravel;
import java.io.Serializable;
import java.util.LinkedList;

public class Pack implements Serializable {

    private String name;
    private LinkedList<PackItem> packItems;

    //Constructors
    public Pack(String name){
        this.name = name;
    }

    public Pack(String name, LinkedList<PackItem> packItems) {
        this.name = name;
        this.packItems = packItems;
    }

    public Pack(){
        this.name = null;
        this.packItems = null;
    }



    //setters
    public void setName(String newName){
        this.name = newName;
    }

    public void setItems(LinkedList<PackItem> newPack){
        this.packItems = newPack;
    }


    //getters
    public String getName(){
        return this.name;
    }

    public LinkedList<PackItem> getItems(){
        return this.packItems;
    }






}
