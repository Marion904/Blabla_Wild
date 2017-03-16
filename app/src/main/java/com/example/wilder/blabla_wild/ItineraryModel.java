package com.example.wilder.blabla_wild;

import java.util.Date;

/**
 * Created by wilder on 13/03/17.
 */

public class ItineraryModel {

    private int mUserId;
    private String mDriverLastName;
    private String mDriverFirstName;
    private Date mDepartureDate;
    private int mPrice;
    private String mDeparture;
    private String mDestination;
    public static int nUser;
    private ItineraryModel(){

    }

    public ItineraryModel(int userId, String driverLastName, String driverFirstName, Date departureDate, int price, String departure, String destination) {
        mUserId = userId;
        mDriverLastName = driverLastName;
        mDriverFirstName = driverFirstName;
        mDepartureDate = departureDate;
        mPrice = price;
        mDeparture = departure;
        mDestination = destination;
    }

    public ItineraryModel(Date departureDate, int price, String departure, String destination) {
        mUserId = ++nUser;
        mDriverLastName = "toto"+mUserId;
        mDriverFirstName = "LeHero"+mUserId;
        mDepartureDate = departureDate;
        mPrice = price;
        mDeparture = departure;
        mDestination = destination;
    }

    public int getmUserId() {
        return mUserId;
    }

    public String getmDriverLastName() {
        return mDriverLastName;
    }

    public String getmDriverFirstName() {
        return mDriverFirstName;
    }

    public Date getmDepartureDate() {
        return mDepartureDate;
    }

    public int getmPrice() {
        return mPrice;
    }

    public String getmDeparture() {
        return mDeparture;
    }

    public String getmDestination() {
        return mDestination;
    }

    public void setmUserId(int userId){
        mUserId = userId;
    }

    public void setmDriverLastName(String driverLastName) {
        mDriverLastName = driverLastName;
    }

    public void setmDriverFirstName(String driverFirstName) {
        mDriverFirstName = driverFirstName;
    }

    public void setmDepartureDate(Date departureDate) {
        mDepartureDate = departureDate;
    }

    public void setmPrice(int price) {
        mPrice = price;
    }

    public void setmDeparture(String departure) {
        mDeparture = departure;
    }

    public void setmDestination(String destination) {
        mDestination = destination;
    }
}
