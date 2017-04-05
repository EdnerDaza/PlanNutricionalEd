package com.ednerdaza.plannutricionaled.mvc.controllers.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.ednerdaza.plannutricionaled.R;
import com.ednerdaza.plannutricionaled.mvc.controllers.utilities.Config;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatDialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Created by edner.daza on 3/04/2017.
 */

public class CalendarDialogFragment extends DialogFragment {

    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    /* The activity that creates an instance of this dialog fragment must
        * implement this interface in order to receive event callbacks.
        * Each method passes the DialogFragment in case the host needs to query it. */
    public interface NoticeDialogListener {
        public void onDialogPositiveClick(String date);
    }

    // Use this instance of the interface to deliver action events
    NoticeDialogListener mListener;

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (NoticeDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.popup_calendar, null);

        CalendarView calendar = (CalendarView)view.findViewById(R.id.popup_calendarview);
        // sets whether to show the week number.
        //calendar.setShowWeekNumber(false);

        // sets the first day of week according to Calendar.
        // here we set Monday as the first day of the Calendar
        //calendar.setFirstDayOfWeek(2);
        if(Config.getDateCalendar().equals("")){
            try {
                String selectedDate = "01/01/2017";
                calendar.setDate(dateFormat.parse(selectedDate).getTime(), true, true);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else{
            try {
                String selectedDate = Config.getDateCalendar();
                calendar.setDate(dateFormat.parse(selectedDate).getTime(), true, true);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                GregorianCalendar calendar = new GregorianCalendar( year, month, dayOfMonth );
                Config.setDateCalendar(dateFormat.format(calendar.getTime()));
            }
        });

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view)
                .setTitle(R.string.dialog_title_calendar)
                .setMessage(R.string.dialog_message_calendar)
                .setCancelable(true)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                        // Send the positive button event back to the host activity
                        mListener.onDialogPositiveClick(Config.getDateCalendar());
                        dialog.dismiss();
                        dialog.cancel();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        dialog.cancel();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

}


