package net.bible;

import android.app.*;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class main extends Activity {
    /**
     * Called when the activity is first created.
     */
    static int current,interval;
    Context c;
    EditText et;
    Button btn,btn1,btn2,btn3,btn4;
    TextView tv;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    int counter;
    int count,Interval;
    static String txt;
    public Handler hand;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tv = (TextView)findViewById(R.id.textView);
        btn = (Button)findViewById(R.id.btn);
        et = (EditText)findViewById(R.id.someText);
        sp = PreferenceManager.getDefaultSharedPreferences(this);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn3);
        btn3 = (Button)findViewById(R.id.btn2);
        btn4 = (Button)findViewById(R.id.btn4);
        editor = sp.edit();
        txt = "this is the txt";
        loadPrefs();
        et.setText(Integer.toString(Interval / 1000));
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ListAll.class);
                startActivity(i);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),favlist.class);
                startActivity(i);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(getApplicationContext() , "Saved the pref",Toast.LENGTH_SHORT);
                Integer etInt = Integer.valueOf(et.getText().toString());
                setSharedPref(etInt);
                t.show();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(main.this,favlist2.class);
                startActivity(i);

            }
        });
        count = 0;
//            Handler h = new Handler();
//            h.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Toast t = Toast.makeText(getApplicationContext(),count,100);
//                t.show();
//                count++;
//            }
//        },1000);
        Handler mHandler = new Handler();
        hand = new Handler();
        counter = 0;
        startNotification();
        Context c = getApplicationContext();
        startRepeating();
        loadPrefs();
    }
    public Runnable r =new Runnable() {
        @Override
        public void run() {
            Random randomGenerator = new Random();
            int ranNum=randomGenerator.nextInt(storer.str.length);
            current = ranNum;
            createNotification(storer.str[current][0]+storer.str[current][1]);

            hand.postDelayed(r,Interval);
        }
    };

    public void startRepeating(){
       r.run();
    }
    public void stopRepeating(){
        hand.removeCallbacks(r);
    }

    public void startNotification(){
        final Handler mHandler = new Handler();
//        for (int i=0;i<100;i++){
//            mHandler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    String t1 = Integer.toString(counter);
//                    Toast t = Toast.makeText(getApplicationContext(),"someBullshit" + t1 ,100);
//                    t.show();
//                    counter++;
//                    createNotification(t1);
//                }
//            },1000+i*1000);
    }

    public void createToast(String t){
        Toast toast = Toast.makeText(c,t,Toast.LENGTH_LONG);
        toast.show();
    }
    public void createNotification(String mt){
        Context c = getApplicationContext();
        Intent fbIntent = new Intent(this,fb.class);
        PendingIntent fbPendingIntent = PendingIntent.getActivity(this,1,fbIntent,1);
        Intent favIntent = new Intent(this,fav.class);
        PendingIntent favPendingIntent = PendingIntent.getActivity(this,0,favIntent,0);
        Notification.Builder noti = new Notification.Builder(c)
                            .setContentTitle(storer.str[current][1])
                            .setContentText(storer.str[current][0])
                            .setSmallIcon(R.drawable.scripture)
                            .addAction(R.drawable.fb, "Facebook", fbPendingIntent)
                            .addAction(R.drawable.fav,"Favourite",favPendingIntent)
                            .setTicker(mt);
        Notification n = new Notification.BigTextStyle(noti).bigText(storer.str[current][0]).build();
        NotificationManager m = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        n.flags |= Notification.FLAG_AUTO_CANCEL;
        m.notify(0,n);
    }

    public void setSharedPref(int key){
        editor.putInt("Interval",key);
        editor.commit();
        loadPrefs();
        stopRepeating();
        startRepeating();
    }
    public void loadPrefs(){
        Integer a = sp.getInt("Interval",1);
        Interval = a*1000;
        String b = a.toString();
    }
}
