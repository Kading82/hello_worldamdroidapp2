package com.example.august.hello_world;

import android.os.Parcel;
import android.os.Parcelable;

public class GetData implements Parcelable{

    public String imageUrl;
    private boolean liked;
    public String name;
    public String uid;
    private String description;

    public GetData() {}

    public GetData(String name, String imageUrl, String uid, boolean liked) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.uid = uid;
        this.liked = liked;
        this.description = "Your Stuff";
    }

    protected GetData(Parcel in) {
        name = in.readString();
        imageUrl = in.readString();
        uid = in.readString();
        description = in.readString();
        liked = in.readByte() != 0;
    }

    public static final Creator<GetData> CREATOR = new Creator<GetData>() {
        @Override
        public GetData createFromParcel(Parcel in) {
            return new GetData(in);
        }

        @Override
        public GetData[] newArray(int size) {
            return new GetData[size];
        }
    };


    public String getImageUrl(){
        return imageUrl;
    }

    public void setImageUrl(String url){
        this.imageUrl = url;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getUid(){
        return uid;
    }

    public void setUid(String uid){
        this.uid = uid;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(imageUrl);
        dest.writeString(description);
        dest.writeByte((byte) (liked ? 1 : 0));
    }
}
