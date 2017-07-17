package com.example.anurag_pc.shreyafinalproject;

/**
 * Created by Anurag-PC on 7/11/2017.
 */

public class RowItem {

    private String shop_name;
    private int shop_pic_id;
    private String shop_type;

    public RowItem (String shop_name,int shop_pic_id,String shop_type)
    {

        this.shop_name= shop_name;
        this.shop_pic_id= shop_pic_id;
        this.shop_type= shop_type;

    }

    public String getshop_name() {  return shop_name; }

    public void setshop_name ( String shop_name) { this.shop_name= shop_name; }


    public int getshop_pic_id() {  return shop_pic_id;}

    public void setshop_pic_id ( int shop_pic_id) { this.shop_pic_id= shop_pic_id; }


    public String getshop_type() {  return shop_type;}

    public void setshop_type ( String shop_type)  { this.shop_type= shop_type; }



}
