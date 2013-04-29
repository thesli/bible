package net.bible;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.*;
import net.bible.MyUtility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: sliversniper
 * Date: 4/18/13
 * Time: 1:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class favlist extends Activity {
    TextView tv1,tv2,tv3;
    Button delAllBtn;
    static String[] arr;
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.favlist);
//        tv1 = (TextView)findViewById(R.id.textView1);
        delAllBtn = (Button)findViewById(R.id.delAllBtn);
//        MyUtility.addFavoriteItem(this, "Sports");
//        MyUtility.addFavoriteItem(this, "Entertainment");
        delAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyUtility.deleteAllEntries(favlist.this);
                MyUtility.addFavoriteItem(favlist.this,"PreventForceClose");
                Intent inte = new Intent(getApplicationContext(),favlist.class);
                startActivity(inte);
            }
        });
        String str = storer.str_unarrayed[main.current];
        MyUtility.addFavoriteItem(this,str);
//        Integer s = getIntent().getIntExtra("move",0);
        arr = MyUtility.getFavoriteList(this);
//        MyUtility.removeOneItemInArray(arr,"this is the 0-th entry");
//        for(int i = 0;i<arr.length;i++){
//            if(arr[i]!="PreventForceClose"){
//            tv1.append(arr[i]);
//            }else{
//                tv1.setText("");
//            }
//        }


        final ArrayList<String> list = new ArrayList<String>();
        for (int i = arr.length-1; i >0; i--) {
            list.add(arr[i]);
        }
        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, list);
        final ListView listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                final Context context = favlist.this;
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setTitle("deletetheStuff")
                        .setMessage("Click Yes to Delete")
                        .setCancelable(false)
                        .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(context,"Yes Clicked" + arr[arr.length-position-1],Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("No",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                   dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
    }

    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }
    public void addPhrase(String phrase){
        MyUtility.addFavoriteItem(favlist.this,phrase);
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent i = new Intent(this,main.class);
            startActivity(i);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
