package com.letsbyjames.letstravel;

import java.util.LinkedList;

/**
 * Created by generalcuster on 4/26/17.
 */

public class InsertItem {
    private String Category = null;
    private LinkedList<Pack> purchasedPacks = new LinkedList<>();
    private LinkedList<Pack> myPacks = new LinkedList<>();

    public InsertItem(){

    }

    public InsertItem(String Category, LinkedList<Pack> purchasedPacks, LinkedList<Pack> myPacks){
        this.Category = Category;
        this.purchasedPacks = purchasedPacks;
        this.myPacks = myPacks;
    }

    public String getCategory(){
        return this.Category;
    }

    public LinkedList<Pack> getPurchasedPacks(){
        return this.purchasedPacks;
    }

    public LinkedList<Pack> getMyPacks(){
        return this.myPacks;
    }


    public void setCategory(String Category){
        this.Category = Category;
    }

    public void setPurchasedPacks(LinkedList<Pack> Packs){
        this.purchasedPacks = Packs;
    }

    public void setMyPacks(LinkedList<Pack> myPacks){
        this.myPacks = myPacks;
    }



}
