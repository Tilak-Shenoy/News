package com.example.tilak.headlines;

/**
 * Created by tilak on 10/8/17.
 */

public class Article {

    private String mHeadline;
    private String mImageUrl;
    private  String mContentUrl;

    public Article(String headline,String imageUrl, String contentUrl){
        mHeadline=headline;
        mImageUrl=imageUrl;
        mContentUrl=contentUrl;
    }

    public String getHeadline(){ return mHeadline;}

    public String getmImageUrl(){return  mImageUrl;}

    public String getmContentUrl(){return mContentUrl;}


}
