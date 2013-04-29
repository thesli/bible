package net.bible;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;
import java.util.logging.LogRecord;

/**
 * Created with IntelliJ IDEA.
 * User: sliversniper
 * Date: 4/18/13
 * Time: 1:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class fav extends Activity {
    TextView phrs;
    Boolean checkRepeat;
    public void onCreate(Bundle bundle){
            super.onCreate(bundle);
            setContentView(R.layout.fav);
            phrs = (TextView)findViewById(R.id.phrase);
            String str = storer.str_unarrayed[main.current];
            phrs.setText(str);
            MyUtility.addFavoriteItem(this,str);


            Toast t = Toast.makeText(getApplicationContext(),"Favourite Added",Toast.LENGTH_LONG);
            t.show();
//            phrs = (TextView)findViewById(R.id.phrase);
//            String[] arr = MyUtility.getFavoriteList(fav.this);
//            for (int i = 0;i<arr.length;i++){
//                if(arr[i]!=str){
//                    MyUtility.addFavoriteItem(this,str);
//                }
//            }

//            Intent intent = new Intent(this,favlist.class);
//            startActivity(intent);
            Handler h = new Handler();
            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(fav.this,favlist.class);
                    startActivity(i);
                }
            },1000);

    }
    public void onResume(Bundle bundle){
        super.onResume();
        Intent i = new Intent(this,fav.class);
    }
}
