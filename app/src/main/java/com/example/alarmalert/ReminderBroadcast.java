package com.example.alarmalert;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.Calendar;
import java.util.Date;

public class ReminderBroadcast extends BroadcastReceiver {

    DBAdapter mDba;
    SQLiteDatabase mDb;
    Ringtone rt;
    MediaPlayer mp;
    AlertDialog.Builder alertbox;
    Context ctx;

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "notifyLemubit")
                .setSmallIcon(R.drawable.t_ico_notification)
                .setContentTitle("Remind lemubit academy")
                .setContentText("Hey Students, Class will start soon")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(200, builder.build());

//        DBHelper mDbh = new DBHelper(context, null, null, 1);
//        mDb = mDbh.getWritableDatabase();
//        mDb.setLockingEnabled(true);
//        mDba = new DBAdapter(context);
//        mDba.open();
//        Cursor cr = mDb.query("mReminderEntry", null, null, null, null,
//                null, null);
//        if (cr.equals(null)) {
//            System.out.println("No Data Found");
//        } else {
//            Date d = new Date();
//            Calendar calendar = Calendar.getInstance();
//            int day = calendar.get(Calendar.DAY_OF_WEEK);
//            String today = null;
//            if (day == 2) {
//                today = "Monday";
//            } else if (day == 3) {
//                today = "Tuesday";
//            } else if (day == 4) {
//                today = "Wednesday";
//            } else if (day == 5) {
//                today = "Thursday";
//            } else if (day == 6) {
//                today = "Friday";
//            } else if (day == 7) {
//                today = "Saturday";
//            } else if (day == 1) {
//                today = "Sunday";
//            }
//
//            int system_hour = d.getHours();
//            int system_minute = d.getMinutes();
//            cr.moveToFirst();
//            for (int i = 0; i < cr.getCount(); i++) {
//                if (cr.getString(3).equals(system_hour + ":" + system_minute)
//                        && cr.getString(1).equals("Daily")) {
//                    Intent scheduledIntent = new Intent(context, MyScheduledActivity.class);
//                    scheduledIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(scheduledIntent);
//
//                    break;
//
//                } else if (cr.getString(3).equals(
//                        system_hour + ":" + system_minute)
//                        && cr.getString(1).equals(today)) {
//
//                    Intent scheduledIntent = new Intent(context, MyScheduledActivity.class);
//                    scheduledIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(scheduledIntent);
//
//                    break;
//                } else {
//                    System.out.println("No Matching");
//                }
//                cr.moveToNext();
//            }
//        }
//        cr.close();
//        mDba.close;

        Log.d("MyAPP", "onReceive() called");

    }
}
