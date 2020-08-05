package com.example.alarmalert;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.time.DayOfWeek;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.btnRemind);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Reminder set!", Toast.LENGTH_SHORT).show();

//                Intent intent = new Intent(MainActivity.this, ReminderBroadcast.class);
//                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);
//
//                AlarmManager alarmManager =(AlarmManager) getSystemService(ALARM_SERVICE);
//
//                long timeAtButtonClick =  System.currentTimeMillis();
//                long tenSeconds = 1000*10;
//
//                alarmManager.set(AlarmManager.RTC_WAKEUP,
//                        timeAtButtonClick + tenSeconds, pendingIntent);


            }
        });
        
        createNotifyLemubit();

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void createNotifyLemubit() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "LemubitReminderChannel";
            String description = "Channel for Lemubit Reminder";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("notifyLemubit", name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

            Calendar alarmFor = Calendar.getInstance();
            alarmFor.set(Calendar.DAY_OF_WEEK, 4);
            alarmFor.set(Calendar.HOUR_OF_DAY, 11);
            alarmFor.set(Calendar.MINUTE, 28);
            alarmFor.set(Calendar.SECOND, 0);

            Intent MyIntent = new Intent(getApplicationContext(), ReminderBroadcast.class);
            PendingIntent MyPendIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, MyIntent, PendingIntent.FLAG_CANCEL_CURRENT);

            AlarmManager MyAlarm = (AlarmManager) getSystemService(ALARM_SERVICE);
            MyAlarm.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, alarmFor.getTimeInMillis(), MyPendIntent);
        }



    }
}