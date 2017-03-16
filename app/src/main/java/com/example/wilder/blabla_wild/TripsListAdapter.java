package com.example.wilder.blabla_wild;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.Query;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by wilder on 07/03/17.
 */

/**
 * Extract from the author
 * @author greg
 * @since 6/21/13
 *
 * This class is an example of how to use FirebaseListAdapter. It uses the <code>Chat</code> class to encapsulate the
 * data for each individual chat message
 */
public class TripsListAdapter extends FirebaseListAdapter<ItineraryModel> {
    // The mUsername for this client. We use this to indicate which messages originated from this user


    public TripsListAdapter(Query ref, Activity activity, int layout) {
        super(ref, ItineraryModel.class, layout, activity);
    }



    @Override
    protected void populateView(View view, ItineraryModel model) {
        // Map an ItineraryModel object to an entry in our listview

        String FirstName = model.getmDriverFirstName();
        TextView driverFirstName = (TextView) view.findViewById(R.id.driverFirstName);
        driverFirstName.setText(FirstName);

        Date departureDay = model.getmDepartureDate();
        TextView departureDate = (TextView) view.findViewById(R.id.departure_time);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
        departureDate.setText(sdf.format(departureDay.getTime()));

        int Price = model.getmPrice();
        TextView driverPrice = (TextView) view.findViewById(R.id.driverPrice);
        driverPrice.setText(Integer.toString(Price));////Pb d'Integer
    }



}
