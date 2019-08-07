package com.vsixty.taskapp.Connect;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by vignesh on 28/04/18.
 */

public class Utilies {


    public static String getCurrentDate() {
        Date c = Calendar.getInstance().getTime();

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = df.format(c);
        return currentDate;
    }

    public static String getCurrentTime(){

        DateFormat df = new SimpleDateFormat("HH:MM");
        String time = df.format(Calendar.getInstance().getTime());
        return time;
    }
}
