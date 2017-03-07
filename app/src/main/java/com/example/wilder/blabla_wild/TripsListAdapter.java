package com.example.wilder.blabla_wild;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by wilder on 07/03/17.
 */

public class TripsListAdapter extends BaseAdapter {
    private Context mcontext;
    private ArrayList<TripResultModel> mtripResultModels;


    private TripsListAdapter(){

    }

    public TripsListAdapter(Context context, ArrayList<TripResultModel> tripResultModels){
        mcontext = context;
        mtripResultModels=tripResultModels;
    }

    @Override
    public int getCount() {
        return mtripResultModels.size();
    }

    @Override
    public Object getItem(int position) {
        return mtripResultModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(mcontext).inflate(R.layout.trip_item,parent,false);
        }
        //Get the current tripResultModel to be displayed
        TripResultModel currentTripResultModel = (TripResultModel) getItem(position);

        //Get the textView for descriptions
        TextView textViewTripresultDepartureDate =(TextView) convertView.findViewById(R.id.textView4);
        TextView textViewTripresultFirstName =(TextView) convertView.findViewById(R.id.textView5);
        TextView textViewTripresultPrice =(TextView) convertView.findViewById(R.id.textView6);

        // Set the FirstName, Price and Date for the item description from the current TripResultModel
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");
        String dday = sdf.format(currentTripResultModel.getmDepartureDate());
        textViewTripresultDepartureDate.setText(dday);
        textViewTripresultFirstName.setText(currentTripResultModel.getmFirstName());
        String priceStr= String.valueOf(currentTripResultModel.getmPrice());
        textViewTripresultPrice.setText(priceStr);

        return convertView;
    }
}
