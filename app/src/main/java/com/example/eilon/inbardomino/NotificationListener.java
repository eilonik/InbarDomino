package com.example.eilon.inbardomino;

/**
 * Created by eilon on 23/02/16.
 */
import android.annotation.TargetApi;
import android.os.Build;
import
        android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
public class NotificationListener extends
        NotificationListenerService {

    @Override
    public void onNotificationPosted(
            StatusBarNotification sbn) {
        //---show current notification---
        Log.i("","---Current Notification---");
        Log.i("","ID :" + sbn.getId() + "\t" +
                sbn.getNotification().tickerText + "\t" +
                sbn.getPackageName());
        Log.i("","--------------------------");

        //---show all active notifications---
        Log.i("","===All Notifications===");
        for (StatusBarNotification notif :
                this.getActiveNotifications()) {
            Log.i("","ID :" + notif.getId() + "\t" +
                    notif.getNotification().tickerText + "\t" +
                    notif.getPackageName());
        }
        Log.i("","=======================");
    }

    @Override
    public void onNotificationRemoved(
            StatusBarNotification sbn) {
        Log.i("","---Notification Removed---");
        Log.i("","ID :" + sbn.getId() + "\t" +
                sbn.getNotification().tickerText + "\t" +
                sbn.getPackageName());
        Log.i("","--------------------------");

    }
}
