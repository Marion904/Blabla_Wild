package com.example.wilder.blabla_wild;

import java.util.Date;

/**
 * Created by wilder on 07/03/17.
 * Create regular and AFTER make it Parcelable
 */

public class TripResultModel {
    String mFirstName;
    Date mDepartureDate;
    int mPrice;

    public TripResultModel(){

    }

    public TripResultModel(String firstName, Date departureDate, int price){
        mFirstName=firstName;
        mDepartureDate= departureDate;
        mPrice=price;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public Date getmDepartureDate() {
        return mDepartureDate;
    }

    public int getmPrice() {
        return mPrice;
    }

    public void setmFirstName(String firstName){
        this.mFirstName=firstName;
    }

    public void setmPrice(int mPrice) {
        this.mPrice = mPrice;
    }

    public void setmDepartureDate(Date mDepartureDate) {
        this.mDepartureDate = mDepartureDate;
    }
}
