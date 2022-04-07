package com.example.week7_2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class NetState extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager=(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork=connectivityManager.getActiveNetworkInfo();
        boolean isConnected=activeNetwork!=null&&activeNetwork.isConnectedOrConnecting();

        if (activeNetwork == null)
        {
            Toast.makeText(context, "当前无网络，请检查移动设备的网络连接", Toast.LENGTH_SHORT)
                    .show();
            Log.i("NetState","网络未连接!!!");

        }
        else {
            boolean isWiFi = activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;
            if (isWiFi==true) {
                Toast.makeText(context, "已连接上WIFI数据", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(context, "已连接上移动数据", Toast.LENGTH_SHORT).show();
            }
            Log.i("NetState","网络连接成功!!!");
        }
    }
}
