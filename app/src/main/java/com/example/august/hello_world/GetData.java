package com.example.august.hello_world;

public class GetData {

    private String imageUrl;
    private boolean liked;
    private String name;
    private String uid;

    public String getImageUrl(){
        return imageUrl;
    }

    public void setImageUrl(String url){
        this.imageUrl = url;
    }

    public String getName(){
        return name;
    }

    public void setName(String uname){
        this.name = uname;
    }

    public String getUid(){
        return uid;
    }

    public void setUid(String uuid){
        this.uid = uuid;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }
}
