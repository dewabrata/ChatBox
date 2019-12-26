package com.juara.chatbox;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelChat implements Parcelable {

    private String image;
    private String text;
    private String date;
    private int type;

    public ModelChat() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.image);
        dest.writeString(this.text);
        dest.writeString(this.date);
        dest.writeInt(this.type);
    }

    protected ModelChat(Parcel in) {
        this.image = in.readString();
        this.text = in.readString();
        this.date = in.readString();
        this.type = in.readInt();
    }

    public static final Parcelable.Creator<ModelChat> CREATOR = new Parcelable.Creator<ModelChat>() {
        @Override
        public ModelChat createFromParcel(Parcel source) {
            return new ModelChat(source);
        }

        @Override
        public ModelChat[] newArray(int size) {
            return new ModelChat[size];
        }
    };
}
