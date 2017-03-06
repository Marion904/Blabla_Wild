package com.example.wilder.blabla_wild;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wilder on 06/03/17.
 */

public class SearchRequestModel implements Parcelable{
    private String depart;
    private String destination;
    private String date;

    private SearchRequestModel(){

    }
    public SearchRequestModel(String depart, String destination, String date){
        this.depart = depart;
        this.destination=destination;
        this.date=date;
    }

    protected SearchRequestModel(Parcel in) {
        depart = in.readString();
        destination = in.readString();
        date = in.readString();
    }

    public static final Creator<SearchRequestModel> CREATOR = new Creator<SearchRequestModel>() {
        @Override
        public SearchRequestModel createFromParcel(Parcel in) {
            return new SearchRequestModel(in);
        }

        @Override
        public SearchRequestModel[] newArray(int size) {
            return new SearchRequestModel[size];
        }
    };

    public String getDepart() {
        return depart;
    }

    public String getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(depart);
        dest.writeString(destination);
        dest.writeString(date);
    }
}
